package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class WinningLottoTest {
    public static WinningLotto actual = WinningLotto.createWinningLotto(IntStream.rangeClosed(1, 6)
            .mapToObj(number -> Integer.parseInt(String.valueOf(number)))
            .collect(Collectors.toList()));

    @Test
    void null_check() {
        assertThrows(NullPointerException.class, () -> {
            WinningLotto.createWinningLotto(null);
        });
    }
}