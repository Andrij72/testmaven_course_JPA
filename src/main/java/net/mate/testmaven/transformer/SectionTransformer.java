package net.mate.testmaven.transformer;

import net.mate.testmaven.controller.dto.Section;
import net.mate.testmaven.model.SectionEntity;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
public class SectionTransformer {

    public List<Section> buildSections(List<SectionEntity> sections) {
        return sections.stream()
                .map(this::buildSection)
                .collect(toList());
    }

    public Section buildSection(SectionEntity sectionEntity) {
        return Section.builder()
                .name(sectionEntity.getName())
                .comment(sectionEntity.getComment())
                .build();
    }

    public List<SectionEntity> buildSectionsEntities(List<Section> sections) {
        return sections.stream()
                .map(this::buildSectionEntity)
                .collect(toList());
    }

    public SectionEntity buildSectionEntity(Section section) {

        SectionEntity sectionEntity = new SectionEntity();
        sectionEntity.setName(section.getName());
        sectionEntity.setComment(section.getComment());
        //sectionEntity.setCourseId(section.getCourseId());
        return sectionEntity;
    }
}