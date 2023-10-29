package baseball.validator;

import static baseball.view.Constants.EXIT_STRING;
import static baseball.view.Constants.NUMBER_LENGTH;
import static baseball.view.Constants.RESTART_STRING;

import java.util.HashSet;
import java.util.Set;

public class Validator {
    public static void validateNumberLength(String numbers) {
        if (numbers.length() != NUMBER_LENGTH) {
            throw new IllegalArgumentException("숫자길이가 3이 아님");
        }
    }

    public static void validateNumberDuplicated(String numbers) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < numbers.length(); i++) {
            set.add(numbers.charAt(i));
        }
        if (set.size() != numbers.length()) {
            throw new IllegalArgumentException("중복된 숫자 입력");
        }
    }

    public static void validateNumberIsNumeric(String numbers) {
        for (int i = 0; i < numbers.length(); i++) {
            if (!('0' <= numbers.charAt(i) && numbers.charAt(i) <= '9')) {
                throw new IllegalArgumentException("잘못된 값 입력");
            }
        }
    }

    public static void validateIsRestartOrExit(String number) {
        if (!(number.equals(RESTART_STRING) || number.equals(EXIT_STRING))) {
            throw new IllegalArgumentException("1 또는 2 이외의 값 입력");
        }
    }
}