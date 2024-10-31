package lotto.view.output;

import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.User;
import lotto.validator.exception.LottoException;

public class OutputView {
    public void displayMessage(String message) {
        System.out.println(message);
    }
    public void displayLottos(User user) {
        int lottosCount = user.getLottos().getLottoCount();
        System.out.printf(OutputMessage.PURCHASED_COUNT_MESSAGE.getOutputMessage(), lottosCount);
        for (Lotto lotto : user.getLottos().getLottos()) {
            System.out.println(lotto.getNumbers());
        }
    }
    public void displayStatistics(List<Integer> statistics) {
        List<OutputMessage> messages = Arrays.asList(
                OutputMessage.THREE_MATCHES,
                OutputMessage.FOUR_MATCHES,
                OutputMessage.FIVE_MATCHES,
                OutputMessage.FIVE_MATCHES_PLUS_BONUS,
                OutputMessage.SIX_MATCHES
        );
        for (int i = 0; i < messages.size(); i++) {
            System.out.printf(messages.get(i).getOutputMessage(), statistics.get(i));
        }
    }
    public void displayErrorMessage(LottoException lottoException) {
        System.out.println(lottoException.getMessage());
    }
}
