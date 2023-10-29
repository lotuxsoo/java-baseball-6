package baseball.view;

import static baseball.validator.Validator.validateIsRestartOrExit;
import static baseball.validator.Validator.validateNumberDuplicated;
import static baseball.validator.Validator.validateNumberIsNumeric;
import static baseball.validator.Validator.validateNumberLength;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String askPlayerNumbers() {
        String input = Console.readLine();
        checkNumbersValidation(input);
        return input;
    }

    public String askRestartOrExit() {
        String input = Console.readLine();
        checkNumberValidation(input);
        return input;
    }

    //사용자 인풋 예외처리 여기서
    private void checkNumbersValidation(String input) {
        validateNumberLength(input);
        validateNumberDuplicated(input);
        validateNumberIsNumeric(input);
    }

    private void checkNumberValidation(String input) {
        validateIsRestartOrExit(input);
    }
}