package training360.gardenservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import training360.gardenservices.domain.Gardener;

public interface GardenerRepository extends JpaRepository<Gardener, Long> {
}
