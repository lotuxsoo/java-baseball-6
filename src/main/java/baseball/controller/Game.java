package baseball.controller;

import static baseball.view.Constants.RESTART_STRING;

import baseball.domain.Number;
import baseball.domain.Result;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Game {
    InputView inputView;

    public void start() {
        OutputView.printStartMessage();
        do {
            Number computerNumbers = Number.generateRandomNumbers(); // 컴퓨터 숫자
            play(computerNumbers);
        } while (askRestartOrExit());
    }

    private void play(Number computerNumbers) {
        boolean is3Strike = false;
        do {
            OutputView.printInputMessage();
            inputView = new InputView();
            String input = inputView.askPlayerNumbers();
            Number playerNumbers = new Number(input);
            Result result = new Result(playerNumbers, computerNumbers);
            OutputView.printHintString(result);
            is3Strike = result.is3Strike();
        } while (!is3Strike);
    }

    private boolean askRestartOrExit() {
        inputView = new InputView();
        String input = inputView.askRestartOrExit();
        if (input.equals(RESTART_STRING)) {
            return true;
        }
        return false;
    }
}
