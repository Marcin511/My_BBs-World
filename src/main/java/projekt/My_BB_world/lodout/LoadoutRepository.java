package projekt.My_BB_world.lodout;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface LoadoutRepository extends JpaRepository<Loadout,Long> {
    Optional<Loadout> findLoadoutById(Long loadoutId);
}
