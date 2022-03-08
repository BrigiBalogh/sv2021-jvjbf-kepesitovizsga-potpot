package training360.gardenservices.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "gardeners")
public class Gardener {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "gardener")
    private List<Gardenwork> gardenWorks;

    public Gardener(String name) {
        this.name = name;
    }
}
