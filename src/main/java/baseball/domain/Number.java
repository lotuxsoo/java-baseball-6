package baseball.domain;

import static baseball.view.Constants.END_RANGE;
import static baseball.view.Constants.NUMBER_LENGTH;
import static baseball.view.Constants.START_RANGE;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.ArrayList;
import java.util.List;

public class Number {
    private final List<Integer> numbers;

    public Number(String input) { // playerNumber Constructor
        this.numbers = convertInputNumber(input);
    }

    public static Number generateRandomNumbers() {
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < NUMBER_LENGTH) {
            int number = pickNumberInRange(START_RANGE, END_RANGE);
            if (!hasDuplicateNumber(randomNumbers, number)) {
                randomNumbers.add(number);
            }
        }
        return new Number(randomNumbers);
    }

    private Number(List<Integer> randomNumbers) { // computerNumber Constructor
        this.numbers = randomNumbers;
        System.out.println(numbers);
    }

    private static boolean hasDuplicateNumber(List<Integer> randomNumbers, int number) {
        return randomNumbers.contains(number);
    }

    private List<Integer> convertInputNumber(String input) {
        List<Integer> inputNumbers = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            inputNumbers.add(Integer.valueOf(input.substring(i, i + 1)));
        }
        return inputNumbers;
    }

    // List<Integer>과 List<Integer>의 비교
    public int countBallCount(Number computerNumber) {
        int ballCount = 0;
        for (int i = 0; i < computerNumber.numbers.size(); i++) {
            if (this.numbers.contains(computerNumber.numbers.get(i))) {
                ballCount++;
            }
        }
        return ballCount;
    }

    public int countStrikeCount(Number computerNumber) {
        int strikeCount = 0;
        for (int i = 0; i < computerNumber.numbers.size(); i++) {
            if (this.numbers.get(i).equals(computerNumber.numbers.get(i))) {
                strikeCount++;
            }
        }
        return strikeCount;
    }
}
