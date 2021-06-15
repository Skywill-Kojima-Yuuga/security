package com.example.demosecurity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name="users")
@Data
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "role")
    private String role;
    @Column(name = "generated_date")
    private Date generatedDate;
    @Column(name = "updated_date")
    private Date updatedDate;
    @Column(name = "delete_flg")
    private boolean delete_flg;
}
