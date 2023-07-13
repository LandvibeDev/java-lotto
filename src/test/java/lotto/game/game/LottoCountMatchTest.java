package lotto.game.game;

import lotto.game.lotto.Lotto;
import lotto.game.lotto.LottoCount;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static lotto.game.constant.WinningReward.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoCountMatchTest {

    LottoCountMatch lottoCountMatch = new LottoCountMatch();

    @ParameterizedTest(name = "[{index}] winning : {0} bonus : {1} myNum : {2} 테스트")
    @MethodSource()
    void countMatchNumber(List<Integer>winningNumber, int bonusNumber, List<Integer>numbers,
                          int expectedCnt, int expectedBonusCnt) {
        //
        Lotto lotto = new Lotto(numbers);

        //
        LottoCount lottoCount = lottoCountMatch.countMatchNumber(winningNumber, bonusNumber, lotto);

        //
        assertEquals(expectedCnt,lottoCount.getCnt(),"cnt 값이 틀립니다.");
        assertEquals(expectedBonusCnt,lottoCount.getBonusCnt(),"bonusCnt 값이 틀립니다.");
    }
    static Stream<Arguments> countMatchNumber() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6),7,Arrays.asList(1, 2, 3, 4, 5, 7),5,1),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6),7,Arrays.asList(1, 2, 3, 4, 5, 6),6,0),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6),7,Arrays.asList(4, 5, 6, 7, 8, 9),3,1)
        );
    }

    @ParameterizedTest(name = "[{index}] cnt : {0} bonusCnt : {1} expectedResult : {2} 테스트")
    @MethodSource()
    void countMatchReward(int cnt, int bonusCnt, int expectedResult) {
        //
        LottoCount lottoCount = new LottoCount(cnt,bonusCnt);

        //
        int reward = lottoCountMatch.countMatchReward(lottoCount);

        //
        assertEquals(expectedResult,reward);
    }
    static Stream<Arguments> countMatchReward() {
        return Stream.of(
                Arguments.of(6,0,SIX_RIGHT.value()),
                Arguments.of(5,1,FIVE_AND_BONUS_RIGHT.value()),
                Arguments.of(5,0,FIVE_RIGHT.value()),
                Arguments.of(4,0,FOUR_RIGHT.value()),
                Arguments.of(3,0,THREE_RIGHT.value()),
                Arguments.of(2,0,0),
                Arguments.of(1,0,0),
                Arguments.of(0,0,0)
        );
    }
}