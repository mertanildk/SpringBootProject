package com.deke.testredisdbjpa.entity;


import com.deke.testredisdbjpa.entity.baseEntity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Entity
@Getter
@Setter
@Table(name = "periods")
public class Period extends BaseEntity {

    private String periodName;
    private Date startDate;
    private Date endDate;
}
