package helper.fisher.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class Catch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate catchDate;
    private int hours;
    private boolean visibility;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;




}
