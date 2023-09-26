package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public InputView() {
    }

    // 숫자를 입력하는 기능(문자 길이에 따른 예외처리 필요)
    public static String inputNumber() {
        System.out.println("숫자를 입력해주세요 : ");
        String input_number = Console.readLine();

        return input_number;
    }
}
