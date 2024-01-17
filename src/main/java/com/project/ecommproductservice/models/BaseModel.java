package com.project.ecommproductservice.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.UUID;
@Getter
@Setter
@MappedSuperclass
public class BaseModel {
    @Id
    private UUID id;
}
