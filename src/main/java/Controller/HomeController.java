package Controller;

import Model.*;
import Repositories.IngridientRepository;
import Services.CategoriesService;
import Services.ImageService;
import Services.IngredientService;
import Services.RecipesService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.inject.Inject;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by drowerik on 22.05.16.
 */

@Controller
@RequestMapping("/")
public class HomeController {
    @Inject
    RecipesService recipesService;
    @Inject
    CategoriesService categoriesService;
    @Inject
    IngredientService ingredientService;
    @Inject
    ImageService imageService;


    @RequestMapping(value = "", method = RequestMethod.GET)
    public String homepage(ModelMap mav){
        mav.put("recipes", recipesService.getAllRecipes());
        mav.put("categories", categoriesService.getAllCategories());
        return "homepage";
    }

    @RequestMapping(value = "/category/{categoryId}", method = RequestMethod.GET)
    public String categoryrecipes(ModelMap mav,
                         @PathVariable int categoryId){
        CategoryEntity categoryEntity = categoriesService.getCategory(categoryId);
        mav.put("recipes", categoryEntity.getRecipes());
        mav.put("categories", categoriesService.getAllCategories());
        return "homepage";
    }


    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String searchByIngr(ModelMap mav,
                                  @RequestParam(value = "title")String title){
        List<IngridientEntity> ingridientEntities = ingredientService.getIngredientsByTitle(title);
        List<RecipeEntity> recipeEntities = new ArrayList<RecipeEntity>();

        for (int i = 0; i < ingridientEntities.size(); i++){
            RecipeEntity recipeEntity = ingridientEntities.get(i).getRecipe();
            if (!recipeEntities.contains(recipeEntity)){
                recipeEntities.add(recipeEntity);
            }
        }
        mav.put("recipes", recipeEntities);
        mav.put("categories", categoriesService.getAllCategories());
        return "homepage";
    }

    @RequestMapping(value = "/recipe/{recipeId}", method = RequestMethod.GET)
    public String recipe(ModelMap mav,
                             @PathVariable int recipeId){
        RecipeEntity recipeEntity = recipesService.getRecipe(recipeId);
        mav.put("recipe", recipesService.getRecipe(recipeId));
        mav.put("categories", categoriesService.getAllCategories());
        return "recipe";
    }

    @RequestMapping(value = "/newrecipe", method = RequestMethod.GET)
    public String newrecipe(ModelMap mav){

        mav.put("categories", categoriesService.getAllCategories());
        return "newrecipe";
    }

    @RequestMapping(value = "/createrecipe", method = RequestMethod.POST)
    public String createrecipe(ModelMap mav,
                               @RequestParam(value = "author")String author,
                               @RequestParam(value = "title")String title,
                               @RequestParam(value = "description")String description,
                               @RequestParam(value = "portCount")Integer count,
                               @RequestParam(value = "time")Integer time,
                               @RequestParam(value = "category")Integer category,
                               @RequestParam(value = "ingname[]")List<String> ingnames,
                               @RequestParam(value = "ingval[]")List<String> ingval,
                               @RequestParam(value = "images") List<MultipartFile> images) throws IOException {
        CategoryEntity categoryEntity = categoriesService.getCategory(category);

        RecipeEntity recipeEntity = new RecipeEntity();
        recipeEntity.setAuthor(author);
        recipeEntity.setCount(count);
        recipeEntity.setDescription(description);
        recipeEntity.setTime(time);
        recipeEntity.setTitle(title);
        recipeEntity.setCategory(categoryEntity);

        RecipeEntity savedRecipe = recipesService.saveRecipe(recipeEntity);

        for(int i = 0; i < ingnames.size(); i++){
            IngridientEntity ingridientEntity = new IngridientEntity();
            ingridientEntity.setCount(ingval.get(i));
            ingridientEntity.setTitle(ingnames.get(i));
            ingridientEntity.setRecipe(savedRecipe);
            ingredientService.saveIngredient(ingridientEntity);
        }

        String imagesFolder = "/home/drowerik3/JavaProjects/AliasGame/src/main/webapp/resources/images/";

        for (int i = 0; i < images.size(); i++){
            MultipartFile file = images.get(i);
            File newFile = new File(imagesFolder + file.getOriginalFilename());
            InputStream inputStream = null;
            OutputStream outputStream = null;

            inputStream = file.getInputStream();

            if (!newFile.exists()) {
                newFile.createNewFile();
            }
            outputStream = new FileOutputStream(newFile);
            int read = 0;
            byte[] bytes = new byte[1024];

            while ((read = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }

            ImageEntity imageEntity = new ImageEntity();
            imageEntity.setUrl("/resources/images/" + newFile.getName());
            imageEntity.setRecipe(recipeEntity);
            imageService.saveImage(imageEntity);
        }


        mav.put("categories", categoriesService.getAllCategories());
        return "redirect:/";
    }

    private  <E> List<E> permutation(List<E> list){
        List<E> output = new ArrayList<E>();


        while(output.size() != list.size())
        {
            int r = (int)(Math.random()*(list.size()));
            if(!output.contains( list.get( r   )))
                output.add( list.get( r   ));

        }
        return output;
    }
}
