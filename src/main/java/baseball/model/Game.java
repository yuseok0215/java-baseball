package baseball.model;

import java.util.List;


public class Game {
    int strike_count;
    int ball_count;
    List<Integer> game_answer; // 컴퓨터가 정한 3자리 숫자

    public Game(List<Integer> game_answer) {
        this.game_answer = game_answer;
    }

    public void resetSB() {
        strike_count = 0;
        ball_count = 0;
    }

    public int getStrike_count() {
        return strike_count;
    }

    public void setStrike_count(int strike_count) {
        this.strike_count = strike_count;
    }

    public int getBall_count() {
        return ball_count;
    }

    public void setBall_count(int ball_count) {
        this.ball_count = ball_count;
    }

    public List<Integer> getGame_answer() {
        return game_answer;
    }

    public void setGame_answer(List<Integer> game_answer) {
        this.game_answer = game_answer;
    }



}
