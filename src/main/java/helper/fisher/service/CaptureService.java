package helper.fisher.service;


import helper.fisher.entity.Capture;
import helper.fisher.entity.Fish;

import java.util.List;

public interface CaptureService {

    Capture save(Capture capture);

    List<Fish> getAllFishes(int captureId);

    Capture getById(int id);


}
