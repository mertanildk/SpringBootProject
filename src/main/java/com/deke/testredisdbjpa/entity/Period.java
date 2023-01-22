package com.deke.testredisdbjpa.entity;


import com.deke.testredisdbjpa.constants.QueryConstants;
import com.deke.testredisdbjpa.entity.baseEntity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import java.util.Date;


@Entity
@Getter
@Setter
@Table(name = "periods")
@Where(clause = QueryConstants.GENERAL_WHERE_CLAUSE)
public class Period extends BaseEntity {

    private String periodName;
    private Date startDate;
    private Date endDate;
}
