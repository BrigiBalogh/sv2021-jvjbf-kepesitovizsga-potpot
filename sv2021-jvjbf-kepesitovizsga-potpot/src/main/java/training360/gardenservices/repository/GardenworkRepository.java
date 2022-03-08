package training360.gardenservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import training360.gardenservices.domain.Gardenwork;
import training360.gardenservices.dto.NameDescriptionPairDto;

import java.util.List;

public interface GardenworkRepository extends JpaRepository<Gardenwork, Long> {



    @Query("select new training360.gardenservices.dto.NameDescriptionPairDto(g.name, gw.description)" +
            "from Gardener g inner join g.gardenWorks gw where gw.done = false order by g.name, gw.description")
    List<NameDescriptionPairDto> findPairs();
}
