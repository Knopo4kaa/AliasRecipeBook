package Services.ServiceImpl;

import Model.EasyEntity;
import Model.MiddleEntity;
import Repositories.EasyRepository;
import Services.WordsService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.List;

/**
 * Created by drowerik on 22.05.16.
 */
@Service
public class WordsServiceImpl implements WordsService {

   @Inject
   EasyRepository repository;

    public List<EasyEntity> getWordsForEasyGame() {
        return repository.findAll();
    }

    public List<MiddleEntity> getWordsForMediumGame() {
        return null;
    }

    public void addWord(String word) {
        EasyEntity easyEntity = new EasyEntity();
        easyEntity.setWord(word);
        repository.save(easyEntity);
    }
}
