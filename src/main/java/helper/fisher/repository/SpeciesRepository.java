package helper.fisher.repository;

import helper.fisher.entity.Species;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SpeciesRepository extends JpaRepository<Species, Integer> {

    Species findById(int id);

}