package com.project.ecommproductservice.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@Entity
public class Category extends BaseModel {
    private String description;
}
