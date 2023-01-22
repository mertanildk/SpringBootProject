package com.deke.testredisdbjpa.entity;

import com.deke.testredisdbjpa.constants.QueryConstants;
import com.deke.testredisdbjpa.entity.baseEntity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "customer")
@Getter @Setter
@Where(clause = QueryConstants.GENERAL_WHERE_CLAUSE)
public class Customer extends BaseEntity {
    private String name;
    private String surname;
    private String email;
}

//müşteriye oda kiralanacak ve oda kiralama bilgileri tutulacak
//kiralama esnasında müşteri bilgileri alınacak
//hotelin geliri ayrı bir ekranda olacak, oda kiralama bilgileri ile hesaplanacak
//hoteli kiralayan firmanın komisyonu da ayrı bir ekranda olacak

//bu entityde sadece müşteri bilgileri tutulacak