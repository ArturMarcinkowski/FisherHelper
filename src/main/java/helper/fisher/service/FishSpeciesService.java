package helper.fisher.service;

import helper.fisher.entity.FishSpecies;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface FishSpeciesService {
    void addFish();
    FishSpecies save(FishSpecies species);
    FishSpecies findById(int id);
    void delete(int id);
    void savePicture(MultipartFile multipartFile, FishSpecies species) throws IOException;
    List<FishSpecies> findAll();
}
