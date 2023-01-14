package com.deke.testredisdbjpa.entity;

import com.deke.testredisdbjpa.entity.baseEntity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@Table(name = "facilities")
@AllArgsConstructor
@NoArgsConstructor
public class Facility extends BaseEntity {

    @Column(name = "specifications")
    private String specifications;



}
