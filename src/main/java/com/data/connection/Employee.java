package com.data.connection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;

}
