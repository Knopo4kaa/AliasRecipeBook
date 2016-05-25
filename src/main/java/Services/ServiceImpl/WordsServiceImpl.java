package Services.ServiceImpl;

import Model.EasyEntity;
import Model.HardEntity;
import Model.MiddleEntity;
import Repositories.EasyRepository;
import Repositories.HardRepository;
import Repositories.MiddleRepository;
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
    EasyRepository easyRepository;

    @Inject
    MiddleRepository middleRepository;

    @Inject
    HardRepository hardRepository;

    public List<EasyEntity> getWordsForEasyGame() {
        return easyRepository.findAll();
    }

    public List<MiddleEntity> getWordsForMediumGame() {
        return middleRepository.findAll();
    }

    public List<HardEntity> getWordsForHardGame() {
        return hardRepository.findAll();
    }

    public void addWord(String word) {
        EasyEntity easyEntity = new EasyEntity();
        easyEntity.setWord(word);
        easyRepository.save(easyEntity);
    }
}
