import java.util.*;

public class LottoService {
    public static final int NUMBER_COUNT = 6;
    public static final int MAX_NUMBER = 45;

    private Random random;

    public LottoService() {
        this.random = new Random();
    }


    public List<List<Integer>> generateAutoNums(int count) {
        List<List<Integer>> autoNums = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> autoNum = generateAutoNums();
            autoNums.add(autoNum);
        }

        return autoNums;
    } // 자동으로 진행할 로또들 생성

    public List<Integer> generateAutoNums() {
        List<Integer> autoNum = new ArrayList<>();
        while (autoNum.size() < NUMBER_COUNT) {
            int number = random.nextInt(MAX_NUMBER) + 1;
            if (!autoNum.contains(number)) {
                autoNum.add(number);
            }
        }
        Collections.sort(autoNum);
        return autoNum;
    } // 로또 자동 한 줄 생성

    public int countMatchNumbers(List<Integer> Num, List<Integer> winningNumbers) {
        int count = 0;
        for (int number : Num) {
            if (winningNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    } // 내 로또와 당첨 번호 비교

    public int calculatePrize(int matchCount, boolean hasBonusNumber) {
        // 당첨 결과 공지

        if (matchCount == 3) {
            return 5000;
        } else if (matchCount == 4) {
            return 50000;
        } else if (matchCount == 5) {
            if (hasBonusNumber) {
                return 30000000;
            } else {
                return 1500000;
            }
        } else if (matchCount == 6) {
            return 2000000000;
        } else {
            return 0;
        }


    } // 맞는 번호, 보너스 번호 유무에 따라 등수, 상금 나누기
}
