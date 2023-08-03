package com.validation.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Data
@Table(name="user_entity")
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Size(min = 3, message = "Name should have at least 3 characters")
    @Pattern(regexp = "^[A-Z a-z]*$",message="Name should contain only alphabets")
    private String name;

    @NotEmpty
    @Pattern(regexp="^[56789][0-9]{9}$", message = "Mobile number is invalid")
    private String mobileNumber;

    @NotEmpty
    @Email(regexp = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$", message = "Email is invalid")
    private String email;

    @NotEmpty
    @Size(min = 3, message = "Father's name should have at least 3 characters")
    @Pattern(regexp="^[a-z A-Z]*$", message = "Father's name should contain only alphabets")
    private String fathersName;

    @NotEmpty
    @Pattern(regexp="[A-Z]{3}[P]{1}[A-Z]{1}[0-9]{4}[A-Z]{1}", message = "PAN number is invalid")
    private String panNumber;

    // getter and setters
}
