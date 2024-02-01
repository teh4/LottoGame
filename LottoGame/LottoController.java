import java.util.*;

public class LottoController {

    private Random random;
    private LottoView view;
    private LottoService service;

    public LottoController() {
        this.view = new LottoView();
        this.service = new LottoService();
        this.random = new Random();
    }

    public void startGame() {

        while (true) {
            int amount = view.getAmount(); // 금액 입력

            int gameCount = amount / 1000; // 1000원 단위로 게임 수 

            int manualCount = view.getManualCount(gameCount); // 수동 게임 수


            // 수동 로또 번호 입력
            List<List<Integer>> manualNumbers = new ArrayList<>();
            for (int i = 0; i < manualCount; i++) {
                List<Integer> numbers = view.getManualNumbers();
                manualNumbers.add(numbers);
            }

            // 자동 로또 번호 생성
            List<List<Integer>> autoNums = service.generateAutoNums(gameCount - manualCount);

            // 나의 로또 번호에 수동 + 자동 합치기
            List<List<Integer>> totalGames = new ArrayList<>(manualNumbers);
            totalGames.addAll(autoNums);

            // 각 로또 번호 오름차순으로 정렬
            for (List<Integer> game : totalGames) {
                Collections.sort(game);
            }
            view.displayMyLottos(totalGames);


            // 게임 시작

            // 당첨 번호
            List<Integer> winningNumbers = service.generateAutoNums();
            view.displayWinningLottos(winningNumbers);

            // 보너스 볼
            int bonusNumber;
            do {
                bonusNumber = random.nextInt(LottoService.MAX_NUMBER) + 1;
            } while (winningNumbers.contains(bonusNumber));

            view.displayBonusNumber(bonusNumber);

            // 게임 결과 계산
            int totalPrize = 0;
            for (List<Integer> game : totalGames) {
                int matchCount = service.countMatchNumbers(game, winningNumbers);
                boolean hasBonusNumber = game.contains(bonusNumber);
                // 당첨 결과 공지
                LottoPrize.valueOf(matchCount, hasBonusNumber);

                // prize 구하기
                int prize = service.calculatePrize(matchCount, hasBonusNumber);
                totalPrize += prize;
            }
            view.displayTotalPrize(totalPrize);

            // 수익률 계산
            int totalAmount = totalGames.size() * 1000;
            double profitRate = (double) totalPrize / totalAmount;

            // 결과 출력
            view.displayResult(profitRate);

            // 수익률 1이상 일 때까지 게임 반복
            if (profitRate >= 1) {
                break;
            }
        }

    }
}
