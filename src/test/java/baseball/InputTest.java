package baseball;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.validator.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputTest {
    @Test
    @DisplayName("입력된 숫자길이가 3이다")
    void validateNumberLength_입력된숫자길이_3아니면_예외반환() {
        assertThatThrownBy(() -> Validator.validateNumberLength("1234"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("중복된 숫자가 존재하지 않는다")
    void validateNumberDuplicated_중복된숫자가있으면_예외반환() {
        assertThatThrownBy(() -> Validator.validateNumberDuplicated("122"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("1~9까지의 숫자를 입력받는다")
    void validateNumberIsNumberic_1_9까지의숫자아니면_예외반환() {
        assertThatThrownBy(() -> Validator.validateNumberIsNumeric("1ab"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("1 또는 2만 입력 가능하다")
    void validateIRestartOrExit_1_2이아니면_예외반환() {
        assertThatThrownBy(() -> Validator.validateIsRestartOrExit("3"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
