package baseball.view;

import baseball.validator.Validator;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private Validator validator = new Validator();

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
        validator.validateNumberLength(input);
        validator.validateNumberDuplicated(input);
        validator.validateNumberIsNumeric(input);
    }

    private void checkNumberValidation(String input) {
        validator.validateIsRestartOrExit(input);
    }
}