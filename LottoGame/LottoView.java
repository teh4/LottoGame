import java.util.*;

public class LottoView {
    private Scanner scanner;

    public LottoView() {
        this.scanner = new Scanner(System.in);
    }

    public int getAmount() {
        System.out.println();
        System.out.println("======= 로또 게임을 시작합니다! ======= ");
        System.out.println();

        System.out.println("로또 게임을 진행할 금액을 입력하세요.");

        while (true) {
            int amount = scanner.nextInt();
            if (amount % 1000 == 0 && amount >= 1000) {
                return amount;
            } else {
                displayErrorMessage("금액은 1000원 단위로 입력해야 합니다. 다시 입력해주세요.");
            }
        }
    }

    public int getManualCount(int gameCount) {
        System.out.println("수동 진행할 로또 게임 수를 입력하세요. 0을 입력하면 전체 자동으로 진행됩니다.");


        while (true) {
            int manualCount = scanner.nextInt();
            if (manualCount <= gameCount) {
                return manualCount;
            } else {
                displayErrorMessage("수동으로 진행할 로또 게임 수는 총 게임 수 " + gameCount + "개 를 초과할 수 없습니다.");
            }
        }
    }

    public List<Integer> getManualNumbers() {
        List<Integer> numbers = new ArrayList<>();
        System.out.println("로또 번호 6개를 1 ~ 45 사이 숫자로 입력하세요.");
        for (int i = 0; i < 6; i++) {
            int number = 0;
            while (true) {
                System.out.print("번호 " + (i + 1) + " : ");
                number = scanner.nextInt();
                if (numbers.contains(number)) {
                    System.out.println("이미 입력한 숫자는 입력할 수 없습니다.");
                } else if (number >= 1 && number <= 45) {
                    break; // 1부터 45 사이의 값이면 반복문 종료
                } else {
                    System.out.println("1부터 45 사이의 숫자를 입력해주세요.");
                }
            }
            numbers.add(number);
        }
        return numbers;
    }

    public void displayResult(double profitRate) {
        System.out.print("수익률은 " + profitRate + "%로 ");
        if (profitRate < 1) {
            System.out.println("손해입니다ㅜㅜ");
        } else if (profitRate == 1) {
            System.out.println("본전입니다!");
        } else {
            System.out.println("이득입니다^^");
        }
    }

    public void displayErrorMessage(String message) {
        System.out.println("오류 : " + message);
    }

    public void displayMyLottos(List<List<Integer>> allGames) {
        System.out.println();
        System.out.println("========== 나의 로또 번호 ==========");
        for (List<Integer> game : allGames) {
            for (int number : game) {
                System.out.print(number + " ");
            }
            System.out.println();
        }
        System.out.println("=================================");
        System.out.println();
    }

    public void displayWinningLottos(List<Integer> winningNumbers) {
        Collections.sort(winningNumbers);
        System.out.println("당첨 번호 : " + winningNumbers);
    }

    public void displayBonusNumber(int bonusNumber) {

        System.out.println("보너스 번호 : " + bonusNumber);
        System.out.println();
        System.out.println("=================================");
    }


    public static void displayPrize(LottoPrize prize) {
        System.out.println();
        System.out.println(prize.getRank() + "등 당첨! " + "상금 " + prize.getPrizeAmount() + "원을 획득하셨습니다.");

    }

    public void displayTotalPrize(int prize) {
        System.out.println();
        System.out.println("총 상금은 " + prize + "원 입니다!");
    }
}

