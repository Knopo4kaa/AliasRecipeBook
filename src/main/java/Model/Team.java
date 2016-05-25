package Model;

/**
 * Created by drowerik on 25.05.16.
 */
public class Team {
    private int score;
    private String title;

    public Team(String title) {
        this.title = title;
        this.score = 0;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
