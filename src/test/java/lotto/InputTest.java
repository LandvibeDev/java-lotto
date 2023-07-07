package lotto;

import lotto.input.Input;
import lotto.input.InputImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class InputTest {

    @DisplayName("Input 클래스의 객체가 맞는지 확인")
    @Test
    void 객체_리턴_테스트() {
        Assertions.assertThat(InputImpl.getInstance()).isInstanceOf(Input.class);
    }

    @Test
    void 구입_가격_입력_테스트() {
        //given
        Input input = InputImpl.getInstance();
        String inputNumber = "8000";

        //when
        System.setIn(new ByteArrayInputStream(inputNumber.getBytes()));
        int result = input.getPurchasePrice();

        //then
        Assertions.assertThat(result).isEqualTo(Integer.parseInt(inputNumber));
    }

    @Test
    @DisplayName("입력값에 숫자가 아닌 문자가 들어가면 예외 테스트")
    void 구입_가격_입력_숫자_아닐때_테스트() {
        //given
        Input input = InputImpl.getInstance();
        String inputNumber = "1000j";

        //when
        System.setIn(new ByteArrayInputStream(inputNumber.getBytes()));

        //then
        org.junit.jupiter.api.Assertions.assertThrows(IllegalArgumentException.class, () -> {
            input.getPurchasePrice();
        });

    }

    @Test
    @DisplayName("입력값을 입력했을때, 출력값이 정상인지 테스트")
    void 당첨_번호_입력_테스트() {
        //given
        Input input = InputImpl.getInstance();
        String inputNumber = "1,2,3,4,5,6\n7";


        //when
        System.setIn(new ByteArrayInputStream(inputNumber.getBytes()));
        List<Integer> result = input.getWiningNumber();

        //then
        List<Integer> expectedList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        Assertions.assertThat(result).isEqualTo(expectedList);
    }
}