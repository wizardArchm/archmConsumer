package ren.wizard.archm.consumer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ren.wizard.archm.consumer.entity.ArchmTestEntityOneEntity;

/**
 * @author uyangjie
 */
@Repository
public interface ArchmTestEntityOneRepository extends JpaRepository<ArchmTestEntityOneEntity, Integer> {
}
