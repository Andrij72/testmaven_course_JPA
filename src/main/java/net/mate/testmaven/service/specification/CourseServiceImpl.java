package net.mate.testmaven.service.specification;

import lombok.extern.slf4j.Slf4j;
import net.mate.testmaven.cache.ListCache;
import net.mate.testmaven.controller.dto.Course;
import net.mate.testmaven.controller.dto.SpecificationRequest;
import net.mate.testmaven.exception.handler.NotFoundRuntimeException;
import net.mate.testmaven.model.CourseEntity;

import net.mate.testmaven.repository.CourseRepository;
import net.mate.testmaven.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;

import static net.mate.testmaven.transformer.SpecificationTransformer.buildCriteria;

@Service
@Slf4j
public class CourseServiceImpl implements CourseService {

   private static final ListCache<CourseEntity, SpecificationRequest> CACHE = new ListCache<>();

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CourseSpecificationFactory specificationFactory;

    @Override
    public void  createCourse(CourseEntity course) {
        courseRepository.save(course);
    }

    @Override
    public List<CourseEntity> findAll() {
        return courseRepository.findAll();
    }

    @Override
    public List<CourseEntity> findAllByIds(List<Long> ids) {
        return courseRepository.findAll();
    }

    @Override
    public void deleteCourseById(Long id) {
        courseRepository.deleteById(id);
    }

    @Override
    public void update(Long id, Course course) {
        CourseEntity courseEntity = courseRepository.findById(id).orElseThrow(RuntimeException::new);
        courseEntity.setName(course.getName());
        courseEntity.setCost(course.getCost());
        //courseEntity.setSections(course.getSections());
        courseRepository.save(courseEntity);
    }

    @Override
    public CourseEntity findCourseById(Long id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new NotFoundRuntimeException(id, "Course can't be found!"));
    }

    @Override
    public CourseEntity getByName(String name) {
        return courseRepository.findByName(name)
                .orElseThrow(RuntimeException::new);
    }

    @Override
    @Transactional
    public List<CourseEntity> findAllByCriteria(SpecificationRequest request) {

        SpecificationCriteria criteria = buildCriteria(request);
       Specification<CourseEntity> specification = specificationFactory.build(criteria);
        return courseRepository.findAll(specification);
    }

    @PostConstruct
    public void init() {
        CACHE.initFunctions(this::findAllByCriteria, this::findAllByIds);
    }

}
