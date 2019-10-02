package net.mate.testmaven.repository;

import net.mate.testmaven.model.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<CourseEntity, Long>, JpaSpecificationExecutor<CourseEntity> {
    Optional<CourseEntity> findByName(String name);

    /*@Query("select c from CourseEntity c where c.name = :name")
    List<CourseEntity> findByName(@Param("name") String name);

     */

    @Query("select c from CourseEntity c where c.name like ?1%")
    CourseEntity NameCorseStartsWith(String fname);

}