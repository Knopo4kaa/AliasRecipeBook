package Services.ServiceImpl;

import Model.IngridientEntity;
import Repositories.IngridientRepository;
import Services.IngredientService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by drowerik3 on 06.05.17.
 */
@Service
public class IngredientServiceImpl implements IngredientService{
    @Inject
    IngridientRepository ingridientRepository;

    public IngridientEntity getIngredient(int id) { return ingridientRepository.findById(id);}
    public IngridientEntity saveIngredient(IngridientEntity ingridientEntity) {
        return ingridientRepository.save(ingridientEntity);
    }
    public List<IngridientEntity> getIngredientsByTitle(String title){
        return ingridientRepository.findByTitle(title);
    }
}
