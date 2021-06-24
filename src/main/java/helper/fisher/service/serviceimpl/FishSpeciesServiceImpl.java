package helper.fisher.service.serviceimpl;

import helper.fisher.entity.FishSpecies;
import helper.fisher.repository.FishSpeciesRepository;
import helper.fisher.service.FishSpeciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FishSpeciesServiceImpl implements FishSpeciesService {

    private final FishSpeciesRepository fishSpeciesRepository;



    @Autowired
    public FishSpeciesServiceImpl(FishSpeciesRepository fishSpeciesRepository) {
        this.fishSpeciesRepository = fishSpeciesRepository;
    }

    @Override
    public void addFish(){
        FishSpecies fishSpecies = new FishSpecies();
        fishSpecies.setName("Stefan");
        fishSpeciesRepository.save(fishSpecies);
    }


}
