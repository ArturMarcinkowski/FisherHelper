package helper.fisher.service.serviceimpl;


import helper.fisher.entity.Capture;
import helper.fisher.entity.Fish;
import helper.fisher.repository.CaptureRepository;
import helper.fisher.repository.FishRepository;
import helper.fisher.service.CaptureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CaptureServiceImpl implements CaptureService {

    private final CaptureRepository captureRepository;
    private final FishRepository fishRepository;

    @Autowired
    public CaptureServiceImpl(CaptureRepository captureRepository, FishRepository fishRepository) {
        this.captureRepository = captureRepository;
        this.fishRepository = fishRepository;
    }

    @Override
    public Capture save(Capture capture){
        return captureRepository.save(capture);
    }

    @Override
    public List<Fish> getAllFishes(int captureId){
        return fishRepository.findAllByCaptureId(captureId);
    }

    @Override
    public Capture getById(int id){
        return captureRepository.findById(id).get();
    }


}
