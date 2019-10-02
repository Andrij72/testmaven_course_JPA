package net.mate.testmaven.service;

import net.mate.testmaven.controller.dto.SpecificationRequest;
import net.mate.testmaven.model.UserEntity;

import java.util.List;

public interface UserService {

    List<UserEntity> findAll();

    List<UserEntity> findAll(SpecificationRequest request);
}
