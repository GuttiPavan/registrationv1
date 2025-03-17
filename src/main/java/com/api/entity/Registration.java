package com.api.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Table(name = "registration")
public class Registration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(min = 2,message = "minimum should be 2 letters")
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false, unique = true)
    @Email(message = "Invalid email format")
    private String email;

    @Column(name = "mobile",nullable = false,unique = true,length=10)
    @Size(min = 10,max =10 ,message = "mobile number shouild be 10 digits")
    @Pattern(regexp = "^[0-9]{10}$", message = "Mobile number should only contain digits")
    private String mobile;

}