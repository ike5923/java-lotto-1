package lotto.domain.lottomanager;

import lotto.domain.lottomanager.shufflerule.FixShuffle;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertThrows;

class LottoCreatorTest {
    private static List<LottoNumber> actual;

    @BeforeEach
    void setUp() {
        actual = IntStream.rangeClosed(1, 6)
                .mapToObj(LottoNumber::createLottoNumber)
                .collect(Collectors.toList());
    }
    @Test
    void null_check() {
        assertThrows(NullPointerException.class, () -> {
            LottoCreator.createManualTickets(null);
        });
    }

    @Test
    void 로또_티켓_생성() {
        Assertions.assertThat(LottoTicket.createLottoTicket(actual))
                .isEqualTo(LottoCreator.createAutoTickets(new FixShuffle()));
    }
}