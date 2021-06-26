package helper.fisher.service;

import helper.fisher.entity.FishSpecies;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FishSpeciesService {
    void addFish();
    FishSpecies save(FishSpecies species);
    FishSpecies findById(int id);
    void delete(int id);
    void savePicture(MultipartFile multipartFile, FishSpecies species) throws IOException;
}
