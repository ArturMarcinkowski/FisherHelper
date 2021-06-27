package helper.fisher.service.serviceimpl;

import helper.fisher.entity.Species;
import helper.fisher.repository.SpeciesRepository;
import helper.fisher.service.SpeciesService;
import helper.fisher.utils.FileUploadUtil;
import helper.fisher.utils.ResizeImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class SpeciesServiceImpl implements SpeciesService {

    private final SpeciesRepository speciesRepo;



    @Autowired
    public SpeciesServiceImpl(SpeciesRepository speciesRepo) {
        this.speciesRepo = speciesRepo;
    }

    @Override
    public void addFish(){
        Species species = new Species();
        species.setName("Stefan");
        speciesRepo.save(species);
    }

    @Override
    public Species save(Species species){
        speciesRepo.save(species);
        return species;
    }

    @Override
    public Species findById(int id){
        return speciesRepo.findById(id);
    }

    @Override
    public void delete(int id){
        speciesRepo.delete(findById(id));
    }

    @Override
    public void savePicture(MultipartFile multipartFile, Species species) throws IOException{
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        String fileNamePng = fileName.substring(0, fileName.length() - 3) + "png";
        species.setPhotos(fileNamePng);
        Species savedSpecies = save(species);
        String uploadDir = "src/main/webapp/photos/species/" + savedSpecies.getId();
        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
        ResizeImage.resize(uploadDir + "/" + fileName);
    }

    @Override
    public List<Species> findAll(){
        return speciesRepo.findAll();
    }




}
