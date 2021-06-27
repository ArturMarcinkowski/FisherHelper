package helper.fisher.service.serviceimpl;

import helper.fisher.entity.FishSpecies;
import helper.fisher.repository.FishSpeciesRepository;
import helper.fisher.service.FishSpeciesService;
import helper.fisher.utils.FileUploadUtil;
import helper.fisher.utils.ResizeImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;
import java.util.List;

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

    @Override
    public void savePicture(MultipartFile multipartFile, FishSpecies species) throws IOException{
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        String fileNamePng = fileName.substring(0, fileName.length() - 3) + "png";
        species.setPhotos(fileNamePng);
        FishSpecies savedSpecies = save(species);
        String uploadDir = "src/main/webapp/photos/species/" + savedSpecies.getId();
        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
        ResizeImage.resize(uploadDir + "/" + fileName);
    }

    @Override
    public List<FishSpecies> findAll(){
        return speciesRepo.findAll();
    }




}
