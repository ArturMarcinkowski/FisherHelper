package helper.fisher.service.serviceimpl;


import helper.fisher.entity.Capture;
import helper.fisher.repository.CaptureRepository;
import helper.fisher.service.CaptureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CaptureServiceImpl implements CaptureService {

    private final CaptureRepository captureRepository;

    @Autowired
    public CaptureServiceImpl(CaptureRepository captureRepository) {
        this.captureRepository = captureRepository;
    }

    @Override
    public Capture save(Capture capture){
        return captureRepository.save(capture);
    }


}
