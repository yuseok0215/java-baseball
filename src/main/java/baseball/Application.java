package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    // 게임 시작을 알리는 기능
    public void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    // 숫자를 입력하는 기능(문자 길이에 따른 예외처리 필요)
    public String inputNumber() {
        System.out.println("숫자를 입력해주세요 : ");
        String input_number = Console.readLine();

        if (input_number.length() != 3) {
            throw new IllegalArgumentException("입력한 숫자의 길이는 3이어야 합니다.");
        }

        return input_number;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

     /* 필요한 기능(역할)
    1. 게임 시작을 알리는 기능
    2. 숫자를 입력하는 기능(문자 길이에 따른 예외처리 필요)
    3. 컴퓨터가 생각하는 숫자 3자리 무작위 선정 기능
    4. 볼과 스트라이크의 유무를 확인하는 기능
    5. 볼과 스트라이크의 결과에 따른 구문 출력하는 기능
    */

}
