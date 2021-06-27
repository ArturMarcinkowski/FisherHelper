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
    @JoinColumn(name = "species_id")
    private Species species;
    @ManyToOne
    @JoinColumn(name = "capture_id")
    private Capture capture;
    private double size;
    private double weight;

    @Column(nullable = true, length = 64)
    private String photos;
    @Transient
    public String getPhotosImagePath() {
        if (photos == null) return null;
        return "/src/main/resources/static/photos/fish/" + id + "/" + photos;
    }
    @Transient
    public String getPhotosImagePathForHTML() {
        if (photos == null) return null;
        return "\\photos\\fish\\" + id + "\\" + photos;
    }



}
