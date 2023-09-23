package baseball;

import baseball.controller.GameController;


public class Application {

    public static void main(String[] args) {
        GameController controller = new GameController();
        controller.run();
    }

     /* 필요한 기능(역할)
    1. 게임 시작을 알리는 기능
    2. 숫자를 입력하는 기능(문자 길이에 따른 예외처리 필요)
    3. 컴퓨터가 생각하는 숫자 3자리 무작위 선정 기능
    4. 볼과 스트라이크의 유무를 확인하는 기능
    5. 볼과 스트라이크의 결과에 따른 구문을 출력하는 기능
    6. main문 작성

    -> 그럼 이 객체들을 mvc패턴으로 바꿔야하는 이유가 뭔지 생각해보자

    1. Model: 도메인으로도 생각 가능 -> 숫자 야구에서는 숫자 3자리가 될 수 있나?
    2. View: View는 클라이언트에 전달시켜주는 역할이기때문에 여기서는 출력값과 출력문들을 얘기해주는 것 같다..
    3. Controller: Controller는 작동 플로우에서 하나의 절차 또는 기능을 담당하는 부분이라고 할 수 있다.

    어떻게 코드를 리팩토링해야할지 감이 잡히지 않아 블로그를 좀 찾아봤다.
    1. 역할에 맞게 MVC 패턴으로 리팩토링해보자.
    2. 이제 드는 생각은 현재 코드의 상수로 배치되어있는 값들을 모두 변수로 바꿔줘야겠다. 왜냐하면 상수로 고정해두면 재사용성 자체가 사라지기 떄문이다.
    */

}
