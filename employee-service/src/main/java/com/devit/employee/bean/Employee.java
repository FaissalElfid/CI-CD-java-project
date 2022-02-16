package com.devit.employee.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.checkerframework.common.aliasing.qual.Unique;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Employee {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String email;
    @Unique
    private String username;
    @NonNull
    private Long departement_libelle;
}
