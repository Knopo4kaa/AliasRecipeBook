package Model;

import javax.persistence.*;

/**
 * Created by drowerik3 on 04.05.17.
 */
@Entity
@Table(name = "Ingridient", schema = "recipebook", catalog = "")
public class IngridientEntity {
    private int id;
    private String title;
    private String count;
    private RecipeEntity recipe;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "recipe_id", nullable = false)
    public RecipeEntity getRecipe() {
        return this.recipe;
    }

    public void setRecipe(RecipeEntity recipe) {
        this.recipe = recipe;
    }



    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "count")
    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IngridientEntity that = (IngridientEntity) o;

        if (id != that.id) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        return result;
    }


}
