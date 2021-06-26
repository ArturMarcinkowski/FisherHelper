package helper.fisher.service.serviceimpl;

import helper.fisher.entity.FishSpecies;
import helper.fisher.repository.FishSpeciesRepository;
import helper.fisher.service.FishSpeciesService;
import helper.fisher.utils.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;

@Service
public class FishSpeciesServiceImpl implements FishSpeciesService {

    private final FishSpeciesRepository speciesRepo;



    @Autowired
    public FishSpeciesServiceImpl(FishSpeciesRepository speciesRepo) {
        this.speciesRepo = speciesRepo;
    }

    @Override
    public void addFish(){
        FishSpecies fishSpecies = new FishSpecies();
        fishSpecies.setName("Stefan");
        speciesRepo.save(fishSpecies);
    }

    @Override
    public FishSpecies save(FishSpecies species){
        speciesRepo.save(species);
        return species;
    }

    @Override
    public FishSpecies findById(int id){
        return speciesRepo.findById(id);
    }

    @Override
    public void delete(int id){
        speciesRepo.delete(findById(id));
    }

    public void savePicture(MultipartFile multipartFile, FishSpecies species) throws IOException{
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        species.setPhotos(fileName);
        FishSpecies savedSpecies = save(species);
        String uploadDir = "src/main/resources/static/photos/species/" + savedSpecies.getId();
        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
    }


}
