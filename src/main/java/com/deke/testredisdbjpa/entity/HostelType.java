package com.deke.testredisdbjpa.entity;

import com.deke.testredisdbjpa.constants.QueryConstants;
import com.deke.testredisdbjpa.entity.baseEntity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;

import java.util.List;


@Entity
@Getter
@Setter
@Table(name = "hostel_types")
@NoArgsConstructor
@Where(clause = QueryConstants.GENERAL_WHERE_CLAUSE)
public class HostelType extends BaseEntity {

    public HostelType(String hostelTypeName) {
        this.hostelTypeName = hostelTypeName;
    }
    @Column(name = "hostel_type_name")
    private String hostelTypeName;


}
