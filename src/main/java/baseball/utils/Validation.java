package baseball.utils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validation {
    private static final int INPUT_SIZE = 3;

    public List<Integer> validationInput(List<Integer> input_number) {

        if (input_number.size() != INPUT_SIZE) {
            throw new IllegalArgumentException("입력한 숫자의 길이는 3이어야 합니다.");
        }

        if (hasDuplicates(input_number)) {
            throw new IllegalArgumentException("입력한 숫자에 중복된 숫자가 있습니다.");
        }

        return input_number;
    }

    public static boolean hasDuplicates(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>();

        for (Integer number : numbers) {
            if (uniqueNumbers.contains(number)) {
                return true; // 중복된 숫자를 찾으면 true 반환
            }
            uniqueNumbers.add(number);
        }
        return false; // 중복된 숫자가 없으면 false 반환
    }
}
