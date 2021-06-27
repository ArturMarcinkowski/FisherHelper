package helper.fisher.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Fish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "fish_species_id")
    private FishSpecies fishSpecies;
    @ManyToOne
    @JoinColumn(name = "catch_id")
    private Capture Capture;
    private double size;
    private double weight;



}
