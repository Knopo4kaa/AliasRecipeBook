package Services;

import Model.IngridientEntity;

import java.util.List;


/**
 * Created by drowerik3 on 06.05.17.
 */
public interface IngredientService {
    IngridientEntity getIngredient(int id);
    IngridientEntity saveIngredient(IngridientEntity ingridientEntity);
    List<IngridientEntity> getIngredientsByTitle(String title);
}
