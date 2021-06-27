package helper.fisher.service;

import helper.fisher.entity.Species;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface SpeciesService {
    void addFish();
    Species save(Species species);
    Species findById(int id);
    void delete(int id);
    void savePicture(MultipartFile multipartFile, Species species) throws IOException;
    List<Species> findAll();
}
