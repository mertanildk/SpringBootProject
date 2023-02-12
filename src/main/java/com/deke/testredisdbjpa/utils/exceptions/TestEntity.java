package com.deke.testredisdbjpa.utils.exceptions;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TestEntity {
    @Id
    private int id;

    @NotNull(message = "name is required")
    @NotEmpty(message = "name is required")
    private String name;

    @Past(message = "age must be in the past")
    @Temporal(TemporalType.DATE)
    private LocalDate age;


}
