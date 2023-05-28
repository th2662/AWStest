package com.ifutsalu.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class User {
    @Id
    private String email;
    private String password;
    private String name;
    private String phone;
    private Gender gender;
    private Role role;
    private LocalDate birth;

    public enum Gender {
        MAN, WOMAN
    }

    public enum Role {
        USER, MANAGER, ADMIN
    }





}
