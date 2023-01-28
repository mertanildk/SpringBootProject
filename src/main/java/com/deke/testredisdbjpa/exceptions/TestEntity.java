package com.deke.testredisdbjpa.exceptions;


import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

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
