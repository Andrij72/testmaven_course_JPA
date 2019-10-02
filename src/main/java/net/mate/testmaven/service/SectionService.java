package net.mate.testmaven.service;

import net.mate.testmaven.controller.dto.Section;
import net.mate.testmaven.model.SectionEntity;

import java.util.List;

public interface SectionService {

    void createSection(SectionEntity section);

    List<SectionEntity> findAll();

    void deleteSectionById(Long id);

    void update(Long id, Section section);

}
