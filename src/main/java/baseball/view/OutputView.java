package baseball.view;

import static baseball.view.Constants.INPUT_MESSAGE;
import static baseball.view.Constants.RESTART_MESSAGE;
import static baseball.view.Constants.START_MESSAGE;
import static baseball.view.Constants.SUCCESS_MESSAGE;

import baseball.domain.Result;

public class OutputView {
    public static void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public static void printInputMessage() {
        System.out.println(INPUT_MESSAGE);
    }

    public static void printHintString(Result result) {
        if (result.isNothing()) {
            System.out.println("낫싱");
        } else if (result.hasBallAndStrike()) {
            System.out.printf("%d볼 %d스트라이크\n", result.getBallCount(), result.getStrikeCount());
        } else if (result.hasBall()) {
            System.out.printf("%d볼\n", result.getBallCount());
        } else if (result.hasStrike()) {
            System.out.printf("%d스트라이크\n", result.getStrikeCount());
            if (result.getStrikeCount() == 3) {
                OutputView.printSuccessMessage();
                OutputView.printRestartMessage();
            }
        }
    }

    public static void printSuccessMessage() {
        System.out.println(SUCCESS_MESSAGE);
    }

    public static void printRestartMessage() {
        System.out.println(RESTART_MESSAGE);
    }
}