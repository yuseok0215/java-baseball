package baseball.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {
    int strike_count;
    int ball_count;
    List<Integer> game_number; // 컴퓨터가 정한 3자리 숫자

    public void resetSB() {
        this.game_number = new ArrayList<>(Arrays.asList(0, 0));
    }


}
