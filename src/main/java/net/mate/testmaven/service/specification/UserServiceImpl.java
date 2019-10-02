package net.mate.testmaven.service.specification;

import lombok.extern.slf4j.Slf4j;
import net.mate.testmaven.cache.ListCache;
import net.mate.testmaven.controller.dto.Course;
import net.mate.testmaven.controller.dto.SpecificationRequest;
import net.mate.testmaven.exception.handler.NotFoundRuntimeException;
import net.mate.testmaven.model.CourseEntity;
import net.mate.testmaven.model.UserEntity;
import net.mate.testmaven.repository.UserRepository;
import net.mate.testmaven.service.CourseService;
import net.mate.testmaven.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;

import static net.mate.testmaven.transformer.SpecificationTransformer.buildCriteria;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserSpecificationFactory specificationFactory;

    @Override
    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public List<UserEntity> findAll(SpecificationRequest request) {
        SpecificationCriteria criteria = buildCriteria(request);
        Specification<UserEntity> specification = specificationFactory.build(criteria);
        return userRepository.findAll(specification);
    }

}
