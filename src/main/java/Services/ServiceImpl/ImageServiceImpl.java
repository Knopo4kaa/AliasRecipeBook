package Services.ServiceImpl;

import Model.ImageEntity;
import Repositories.ImageRepository;
import Services.ImageService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
 * Created by drowerik3 on 06.05.17.
 */
@Service
public class ImageServiceImpl implements ImageService {
    @Inject
    ImageRepository imageRepository;

    public void saveImage(ImageEntity imageEntity){
        imageRepository.save(imageEntity);
    }
}
