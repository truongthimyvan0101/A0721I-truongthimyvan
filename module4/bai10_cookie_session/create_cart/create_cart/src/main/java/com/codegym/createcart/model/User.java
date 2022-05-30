package com.codegym.createcart.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
public class User {
    @Id
    @NotEmpty
    Long id;
    @NotEmpty
    @Length(min=6)
    String password;
    @NotEmpty
    String fullname;
    @NotEmpty
    String telephone;
    @NotEmpty
    @Email
    String email;
    String photo;
    Boolean activated;
    Boolean admin;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    List<Order> orders;

}
