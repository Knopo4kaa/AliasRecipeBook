package Services;

import Model.EasyEntity;
import Model.MiddleEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by drowerik on 22.05.16.
 */
public interface WordsService {
    List<EasyEntity> getWordsForEasyGame();
    List<MiddleEntity> getWordsForMediumGame();
    void addWord(String word);
}
