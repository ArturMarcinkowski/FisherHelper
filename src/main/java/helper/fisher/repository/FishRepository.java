package helper.fisher.repository;

import helper.fisher.entity.Fish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FishRepository extends JpaRepository<Fish, Integer> {

    List<Fish> findAllByCaptureId(int id);


}