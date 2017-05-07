package Model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by drowerik3 on 04.05.17.
 */
@Entity
@Table(name = "Category", schema = "recipebook", catalog = "")
public class CategoryEntity {
    private int id;
    private String category;
    private Set<RecipeEntity> recipes= new HashSet<RecipeEntity>(
            0);


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
    @Column(name = "category")
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CategoryEntity that = (CategoryEntity) o;

        if (id != that.id) return false;
        if (category != null ? !category.equals(that.category) : that.category != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (category != null ? category.hashCode() : 0);
        return result;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "category")
    public Set<RecipeEntity> getRecipes() {
        return this.recipes;
    }

    public void setRecipes(Set<RecipeEntity> recipes) {
        this.recipes = recipes;
    }
}
