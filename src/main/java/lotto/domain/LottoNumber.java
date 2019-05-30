package lotto.domain;

import java.util.Objects;

public class LottoNumber {
    private static final String ERROR_NULL_NUMBER = "입력된 번호가 null 입니다.";
    private static final int LIMIT_MINIMUM_NUMBER = 1;
    private static final int LIMIT_MAXIMUM_NUMBER = 45;
    private static final String ERROR_OUT_RANGE = "1부터 45사이의 수가 아닙니다.";

    private Integer lottoNumber;

    private LottoNumber(Integer number) {
        checkNullInteger(number);
        checkValidRange(number);
        this.lottoNumber = number;
    }

    public static LottoNumber createLottoNumber(Integer number) {
        return new LottoNumber(number);
    }

    private void checkNullInteger(Integer number) {
        if (number == null) {
            throw new NullPointerException(ERROR_NULL_NUMBER);
        }
    }

    private void checkValidRange(Integer number) {
        if(isOutRangeNumber(number)){
            throw new IllegalArgumentException(ERROR_OUT_RANGE);
        }
    }

    private boolean isOutRangeNumber(Integer number) {
        return LIMIT_MINIMUM_NUMBER > number || LIMIT_MAXIMUM_NUMBER < number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final LottoNumber that = (LottoNumber) o;
        return Objects.equals(lottoNumber, that.lottoNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }
}
