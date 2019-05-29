package lotto.view.inputview;

import lotto.utils.InputUtils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WinningNumbersParser extends AbstractParser{
    private static final String ERROR_INVALID_NUMBERS_COUNT = "유효한 번호의 개수가 6개가 아닙니다.";
    private static final String ERROR_HAS_DUPLICATED_NUMBER = "중복된 번호가 존재합니다.";
    private static final int LIMIT_MINIMUM_NUMBER = 1;
    private static final int LIMIT_MAXIMUM_NUMBER = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;

    public static List<Integer> getWinningNumbers(String inputNumbers) {
        List<Integer> winningNumbers = getValidInputNumbers(inputNumbers);
        verifyValidWinningNumbers(winningNumbers);

        return winningNumbers;
    }

    private static List<Integer> getValidInputNumbers(String inputNumbers) {
        checkNullEmpty(inputNumbers);

        return getSeparatedNumbers(inputNumbers);
    }

    private static List<Integer> getSeparatedNumbers(String input) {
        return Arrays.stream(InputUtils.split(input))
                .map(Integer::parseInt)
                .filter(number -> InputUtils.isValidRange(number, LIMIT_MINIMUM_NUMBER, LIMIT_MAXIMUM_NUMBER))
                .collect(Collectors.toList());
    }

    private static void verifyValidWinningNumbers(List<Integer> winningNumbers) {
        checkNumbersCount(winningNumbers);
        checkDuplicateNumber(winningNumbers);
    }

    private static void checkNumbersCount(List<Integer> winningNumbers) {
        if (isInsufficientNumbers(winningNumbers)) {
            throw new IllegalArgumentException(ERROR_INVALID_NUMBERS_COUNT);
        }
    }

    private static boolean isInsufficientNumbers(List<Integer> winningNumbers) {
        return winningNumbers.size() != LOTTO_NUMBER_COUNT;
    }

    private static void checkDuplicateNumber(List<Integer> winningNumbers) {
        if (hasDuplicatedNumber(winningNumbers)) {
            throw new IllegalArgumentException(ERROR_HAS_DUPLICATED_NUMBER);
        }
    }

    private static boolean hasDuplicatedNumber(List<Integer> winningNumbers) {
        Set<Integer> copyWinningNumbers = new HashSet<>(winningNumbers);

        return winningNumbers.size() != copyWinningNumbers.size();
    }
}
