package com.data.connection;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="emp_db")
public class EmpEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;

}
