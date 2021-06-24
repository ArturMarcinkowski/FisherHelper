package helper.fisher.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class FishSpecies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @Column(nullable = true, length = 64)
    private String photos;


    @Transient
    public String getPhotosImagePath() {
        if (photos == null) return null;
//        if (photos == null || id == null) return null;

        return "/user-photos/" + id + "/" + photos;
    }

}
