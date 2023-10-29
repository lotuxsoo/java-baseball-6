package baseball.domain;

public class Result {
    private final int ballCount;
    private final int strikeCount;

    public Result(Number playerNumber, Number computerNumber) {
        strikeCount = playerNumber.countStrikeCount(computerNumber);
        ballCount = playerNumber.countBallCount(computerNumber) - strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public boolean isNothing() {
        return !hasBall() && !hasStrike();
    }

    public boolean hasBallAndStrike() {
        return hasBall() && hasStrike();
    }

    public boolean hasBall() {
        return ballCount > 0;
    }

    public boolean hasStrike() {
        return strikeCount > 0;
    }

    public boolean is3Strike() {
        if (strikeCount == 3) {
            return true;
        }
        return false;
    }
}