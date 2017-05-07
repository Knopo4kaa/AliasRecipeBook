package Model;

import javax.persistence.*;
import java.awt.*;
import java.sql.Time;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by drowerik3 on 04.05.17.
 */
@Entity
@Table(name = "Recipe", schema = "recipebook", catalog = "")
public class RecipeEntity {
    private int id;
    private String title;
    private String url;
    private String author;
    private Integer time;
    private String description;
    private Integer count;
    private CategoryEntity category;
    private Set<IngridientEntity> ingredients = new HashSet<IngridientEntity>(0);
    private Set<ImageEntity> images = new HashSet<ImageEntity>(0);


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
    @JoinColumn(name = "category_id", nullable = false)
    public CategoryEntity getCategory() {
        return this.category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
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
    @Column(name = "url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url= url;
    }


    @Basic
    @Column(name = "author")
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Basic
    @Column(name = "time")
    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "count")
    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RecipeEntity that = (RecipeEntity) o;

        if (id != that.id) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (url != null ? !url.equals(that.url) : that.url!= null) return false;
        if (author != null ? !author.equals(that.author) : that.author != null) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (count != null ? !count.equals(that.count) : that.count != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (count != null ? count.hashCode() : 0);
        return result;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "recipe")
    public Set<IngridientEntity> getIngredients() {
        return this.ingredients;
    }

    public void setIngredients(Set<IngridientEntity> ingredients) {
        this.ingredients = ingredients;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "recipe")
    public Set<ImageEntity> getImages() {
        return this.images;
    }

    public void setImages(Set<ImageEntity> images) {
        this.images = images;
    }
}
