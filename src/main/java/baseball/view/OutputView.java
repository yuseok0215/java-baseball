package baseball.view;

import baseball.model.Game;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class OutputView {

    private OutputView() {
    }

    // 게임 시작을 알리는 기능
    public static void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    // 3 스트라이크시에 재시작에 대한 여부를 확인 후 구문 출력해주는 기능
    public static void checkRestart() {
        System.out.println("3스트라이크");
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    // 볼, 스트라이크에 대한 검증 후 구문 출력해주는 기능
    public static void checkBallAndStrike(Game game) {
        if (game.getStrike_count() == 0 && game.getBall_count() != 0) { // 볼만 있는 경우
            System.out.println(game.getBall_count() + "볼");
        } else if(game.getStrike_count() != 0 && game.getBall_count() == 0) { // 스트라이크만 있는 경우
            System.out.println(game.getStrike_count() + "스트라이크");
        } else if(game.getStrike_count() == 0 && game.getBall_count() == 0) { // 하나도 없는 경우
            System.out.println("낫싱");
        } else { // 스트라이크 볼 둘다 있는 경우
            System.out.println(game.getBall_count() + "볼 " + game.getStrike_count() + "스트라이크");
        }
    }
}
