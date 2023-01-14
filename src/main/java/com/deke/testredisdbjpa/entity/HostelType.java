package com.deke.testredisdbjpa.entity;

import com.deke.testredisdbjpa.entity.baseEntity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Entity
@Getter
@Setter
@Table(name = "hostel_types")
@NoArgsConstructor
public class HostelType extends BaseEntity {

    public HostelType(String hostelTypeName) {
        this.hostelTypeName = hostelTypeName;
    }
    @Column(name = "hostel_type_name")
    private String hostelTypeName;


}
