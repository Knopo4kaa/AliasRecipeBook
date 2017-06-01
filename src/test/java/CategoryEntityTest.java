import Model.CategoryEntity;
import Repositories.CategoryRepository;
import Services.CategoriesService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/root.xml",
        "/view-resolver.xml" })
public class CategoryEntityTest {

    @Autowired
    CategoriesService categoriesService;

    @Autowired
    CategoryRepository categoryRepository;


    @Test
    public void testCategoryWhenCreating(){
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setCategory("test");
        CategoryEntity savedCategory = categoriesService.saveCategory(categoryEntity);
        CategoryEntity categoryFromDB = categoriesService.getCategory(savedCategory.getId());
        categoryRepository.delete(savedCategory);
        Assert.assertEquals(savedCategory, categoryFromDB);
    }
}
