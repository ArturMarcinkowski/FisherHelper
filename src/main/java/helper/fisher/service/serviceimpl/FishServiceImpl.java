package helper.fisher.service.serviceimpl;

import helper.fisher.entity.Fish;
import helper.fisher.repository.FishRepository;
import helper.fisher.service.FishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FishServiceImpl implements FishService {

    private final FishRepository fishRepository;



    @Autowired
    public FishServiceImpl(FishRepository fishRepository) {
        this.fishRepository = fishRepository;
    }

    @Override
    public void addFish(){
        Fish fish = new Fish();
        fish.setName("Stefan");
        fishRepository.save(fish);
    }


}
