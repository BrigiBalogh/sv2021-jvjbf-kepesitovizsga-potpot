package training360.gardenservices.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import training360.gardenservices.domain.Gardener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "gardenworks")
public class Gardenwork {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean done = true;

    private String description;

    private String answer;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    private LocalDateTime answeredAt;

    @ManyToOne
    private Gardener gardener;


    public Gardenwork(String description, Gardener gardener) {
        this.description = description;
        createdAt = LocalDateTime.now();
        this.gardener = gardener;
        gardener.getGardenWorks().add(this);
    }
}


