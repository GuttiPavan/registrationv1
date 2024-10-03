package com.api.entity;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data

public class RegistrationDto {
@NotEmpty
@Size(min = 2,message = "minimum should be 2 letters")
    private String name;

@Email
    private String email;

@Size(min = 10,max =10 ,message = "shouild be 10 digits")
    private String mobile;

}
