package net.mate.testmaven.repository;

import net.mate.testmaven.model.SectionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SectionRepository extends JpaRepository<SectionEntity, Long> {
    Optional<SectionEntity> findByName(String name);
}
