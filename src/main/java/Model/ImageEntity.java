package Model;

import javax.persistence.*;

/**
 * Created by drowerik3 on 04.05.17.
 */
@Entity
@Table(name = "Image", schema = "recipebook", catalog = "")
public class ImageEntity {
    private int id;
    private String url;
    private RecipeEntity recipe;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recipe_id", nullable = false)
    public RecipeEntity getRecipe() {
        return this.recipe;
    }

    public void setRecipe(RecipeEntity recipe) {
        this.recipe = recipe;
    }


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ImageEntity that = (ImageEntity) o;

        if (id != that.id) return false;
        if (url != null ? !url.equals(that.url) : that.url != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (url != null ? url.hashCode() : 0);
        return result;
    }
}
