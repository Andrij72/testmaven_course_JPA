package net.mate.testmaven.model;

import lombok.Getter;
import lombok.Setter;
import net.mate.testmaven.listener.CreatableEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(value = CreatableEntityListener.class)
public class CreatableEntity extends BaseEntity {

    @Column(name = "created_date")
    private Long createdDate;

}