package baseball.controller;

import baseball.model.Game;
import baseball.model.User;
import baseball.utils.Validation;
import baseball.view.InputView;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

/*
 * Model을 어떻게 사용할 것인가..?
 * -> Model이라는 것은 곧 서버가 가지고 있는 데이터에 접근할때 이용되는 클래스이다..
 * 그렇다면 이 프로그램에서는 어느 부분이?
 * -> 1. 사용자가 입력하는 숫자 3자리   2. 컴퓨터가 생각하는 숫자 3자리  3. 볼과 스트라이크의 관리는 컴퓨터가 담당..!
 * 입력에 대한 Validation은?
 * -> 1. 3자리인가? 2. 각자리 수마다 다 다른 숫자인가? 3.
 * */
public class GameController {

    private static final int SIZE = 3;
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 9;

    Game game;
    User user = new User();
    Validation validation =  new Validation();

    public void run() {
        OutputView.startGame(); // 게임 시작을 알리는 기능

        game = new Game(makeGameAnswer(SIZE, START_NUMBER, END_NUMBER)); // 새로운 게임 생성(3자리를 만들면서)

        while (true) {
            user.setUser_number(validation.validationInput(convertInput(InputView.inputNumber())));
            updateSB(user, game);
            String validation_result = gameResult(game);

            if (Objects.equals(validation_result, "2")) break;
            else if (Objects.equals(validation_result, "1")) {
                game = new Game(makeGameAnswer(SIZE, START_NUMBER, END_NUMBER)); // 새로운 게임 생성
            }
        }
    }

    // 컴퓨터가 만든 숫자 3자리
    public List<Integer> makeGameAnswer(int answer_size, int start, int end) {
        List<Integer> game_answer = new ArrayList<>();

        while (game_answer.size() < answer_size) {
            int randomNumber = Randoms.pickNumberInRange(start, end);
            if (!game_answer.contains(randomNumber)) {
                game_answer.add(randomNumber);
            }
        }
        return game_answer;
    }

    // 볼과 스트라이크을 업데이트 하는 기능
    public void updateSB(User user, Game game) {
        game.resetSB();
        if (checkSB(user, game)) { // 일치하는 숫자가 하나라도 있는 경우
            countSB(user, game);
        }
    }

    // 결과값이 낫싱인지 아닌지 확인하는 기능
    public boolean checkSB(User user, Game game) {
        List<Integer> game_answer = game.getGame_answer();
        List<Integer> user_number = user.getUser_number();

        for (int answer_index = 0; answer_index < SIZE; answer_index++) {
            if (user_number.contains(game_answer.get(answer_index))) {
                return true;
            }
        }
        return false;
    }

    // 볼, 스트라이크 횟수를 확인하는 기능
    public void countSB(User user, Game game) {
        List<Integer> game_answer = game.getGame_answer();
        List<Integer> user_number = user.getUser_number();

        for (int answer_index = 0; answer_index < SIZE; answer_index++) {
            for (int user_index = 0; user_index < SIZE; user_index++) {
                updateSB(game, game_answer, user_number, answer_index, user_index);
            }
        }
    }

    // 현재 Game에 볼과 스트라이크를 엡데이트 하는 기능
    private void updateSB(Game game, List<Integer> game_answer, List<Integer> user_number, int answer_index, int user_index) {
        if (game_answer.get(answer_index) == user_number.get(user_index)) {
            if (answer_index == user_index) {
                game.plusStrike_count();
            } else {
                game.plusBall_count();
            }
        }
    }

    // 볼과 스트라이크의 결과에 따른 구문을 출력하는 기능
    public String gameResult(Game game) {
        String validation_result = "";

        if (game.getStrike_count() == SIZE) {
            OutputView.checkRestart();
            validation_result = Console.readLine();
        } else { // 특이사항 없이 계속 게임이 진행되는 경우라서 반환값을 제외함.
            OutputView.checkBallAndStrike(game);
        }
        return validation_result;
    }

    // String타입으로 입력받은 문자열을 List<Integer>타입으로 변환하는 기능
    public List<Integer> convertInput(String user_number) {
        List<Integer> converted_user_number = new ArrayList<>();

        for (int i = 0; i < user_number.length(); i++) {
            int int_number = Character.getNumericValue(user_number.charAt(i));
            converted_user_number.add(int_number);
        }

        return converted_user_number;
    }
}
