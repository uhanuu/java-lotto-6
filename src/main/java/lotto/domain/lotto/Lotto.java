package lotto.domain.lotto;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    public String lottoNumbersAsString() {
        return SupportedLotto.getLottoNumbersAsString(this);
    }

    public int lottoMatchValue(Lotto winningLotto) {
        List<Integer> winningNumbers = winningLotto.numbers;

        return (int) numbers.stream()
                .filter(number -> winningNumbers.contains(number))
                .count();
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
