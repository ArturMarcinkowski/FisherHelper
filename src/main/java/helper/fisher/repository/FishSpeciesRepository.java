package helper.fisher.repository;

import helper.fisher.entity.FishSpecies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FishSpeciesRepository extends JpaRepository<FishSpecies, Integer> {

    FishSpecies findById(int id);

}