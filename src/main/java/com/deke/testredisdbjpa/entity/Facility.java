package com.deke.testredisdbjpa.entity;

import com.deke.testredisdbjpa.constants.QueryConstants;
import com.deke.testredisdbjpa.entity.baseEntity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;


@Entity
@Getter
@Setter
@Table(name = "facilities")
@AllArgsConstructor
@NoArgsConstructor
@Where(clause = QueryConstants.GENERAL_WHERE_CLAUSE)
public class Facility extends BaseEntity {

    @Column(name = "specifications")
    private String specifications;

}
