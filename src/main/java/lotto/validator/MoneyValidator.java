package lotto.validator;

import lotto.validator.exception.ErrorMessage;
import lotto.validator.exception.LottoException;

public class MoneyValidator {

    private final static int THOUSAND = 1000;
    private final static int ZERO = 0;

    public static void validateProcess(int purchaseAmount) {
        validateIsZero(purchaseAmount);
        validateThousandUnit(purchaseAmount);
    }

    private static void validateIsZero(int convertedPurchaseAmount) {
        if (convertedPurchaseAmount == ZERO) {
            throw LottoException.from(ErrorMessage.LOTTO_PURCHASE_IS_ZERO);
        }
    }

    private static void validateThousandUnit(int convertedPurchaseAmount) {
        if (convertedPurchaseAmount % THOUSAND != ZERO) {
            throw LottoException.from(ErrorMessage.LOTTO_PURCHASE_IS_NOT_THOUSAND_UNIT);
        }
    }
}
