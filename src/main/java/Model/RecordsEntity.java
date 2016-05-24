package Model;

import javax.persistence.*;

/**
 * Created by drowerik on 23.05.16.
 */
@Entity
@Table(name = "Records", schema = "aliasdb", catalog = "")
public class RecordsEntity {
    private int id;
    private String team;
    private Integer score;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "team")
    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    @Basic
    @Column(name = "score")
    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RecordsEntity that = (RecordsEntity) o;

        if (id != that.id) return false;
        if (team != null ? !team.equals(that.team) : that.team != null) return false;
        if (score != null ? !score.equals(that.score) : that.score != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (team != null ? team.hashCode() : 0);
        result = 31 * result + (score != null ? score.hashCode() : 0);
        return result;
    }
}
