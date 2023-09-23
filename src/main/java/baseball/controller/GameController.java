package baseball.controller;

import baseball.model.Game;
import baseball.view.InputView;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/*
 * Model을 어떻게 사용할 것인가..?
 * -> Model이라는 것은 곧 서버가 가지고 있는 데이터에 접근할때 이용되는 클래스이다..
 * 그렇다면 이 프로그램에서는 어느 부분이?
 * -> 1. 사용자가 입력하는 숫자 3자리   2. 컴퓨터가 생각하는 숫자 3자리  3. 볼과 스트라이크의 관리는 컴퓨터가 담당..!
 *
 * */
public class GameController {

    final int SIZE = 3;
    final int START_NUMBER = 1;
    final int END_NUMBER = 9;

    public void run() {
        OutputView.startGame(); // 게임 시작을 알리는 기능
//        List<Integer> answer_score = makeGameAnswer(SIZE, START_NUMBER, END_NUMBER); // 정답 숫자 만들기

        Game game = new Game(makeGameAnswer(SIZE, START_NUMBER, END_NUMBER)); // 새로운 게임 생성(3자리를 만들면서)

        while (true) {
            String input_number = InputView.inputNumber();
            List<Integer> number_sb = checkSB(input_number, game.getGame_answer());
            String validation_result = validationSB(number_sb);

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

    // 볼과 스트라이크의 유무를 확인하는 기능
    public List<Integer> checkSB(String input_number, List<Integer> computer_answer) {

        List<Integer> number_sb = new ArrayList<>(Arrays.asList(0, 0));

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                int input_num = Character.getNumericValue(input_number.charAt(j));
                number_sb = updateSB(computer_answer, number_sb, input_num, j, i);
            }
        }
        return number_sb;
    }

    // 스트라이크, 볼을 판독하는 기능
    public List<Integer> updateSB(List<Integer> computer_answer, List<Integer> number_sb, int input_num, int input_index, int answer_index) {
        if (computer_answer.get(answer_index) == input_num) { // 일단 동일한 숫자가 존재(스트라이크인지 볼인지는 모르는 상태)
            if (input_index == answer_index) { // 스트라이크
                number_sb.set(0, number_sb.get(0) + 1);
            } else { // 볼
                number_sb.set(1, number_sb.get(1) + 1);
            }
        }
        return number_sb;
    }

    // 볼과 스트라이크의 결과에 따른 구문을 출력하는 기능
    public String validationSB(List<Integer> number_sb) {
        String validation_result = "";

        if (number_sb.get(0) == SIZE) {
            validation_result = OutputView.checkRestart(number_sb);
        } else { // 특이사항 없이 계속 게임이 진행되는 경우라서 반환값을 제외함.
            OutputView.checkBallAndStrike(number_sb);
        }
        return validation_result;
    }


}
