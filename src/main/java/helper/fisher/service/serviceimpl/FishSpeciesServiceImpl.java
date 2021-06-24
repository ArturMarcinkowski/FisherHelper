package helper.fisher.service.serviceimpl;

import helper.fisher.entity.FishSpecies;
import helper.fisher.repository.FishSpeciesRepository;
import helper.fisher.service.FishSpeciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


}
