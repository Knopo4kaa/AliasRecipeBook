package Model;

/**
 * Created by drowerik on 25.05.16.
 */
public class Team {
    private int id;
    private int score;
    private String title;

    public Team(){}

    public Team(String title, int id) {
        this.id = id;
        this.title = title;
        this.score = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
