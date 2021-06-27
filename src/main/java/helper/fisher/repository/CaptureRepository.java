package helper.fisher.repository;

import helper.fisher.entity.Capture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaptureRepository extends JpaRepository<Capture, Integer> {


}