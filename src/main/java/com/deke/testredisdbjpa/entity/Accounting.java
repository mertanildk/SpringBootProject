package com.deke.testredisdbjpa.entity;

import com.deke.testredisdbjpa.constants.QueryConstants;
import com.deke.testredisdbjpa.entity.baseEntity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import java.util.Date;


@Entity
@Table(name = "accounting")
@Getter
@Setter
@Where(clause = QueryConstants.GENERAL_WHERE_CLAUSE)
public class Accounting extends BaseEntity {

    @Column(name = "accounting_date")
    private Date accountDate;

    @JoinColumn(name = "customer_id")
    @ManyToOne
    private Customer customer;

    @Column(name = "amount")
    private Double amount;

}
