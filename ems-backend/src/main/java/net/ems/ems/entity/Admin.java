package net.ems.ems.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Admin")

public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String FirstName;

    @Column(name = "last_Name", nullable = false)
    private String LastName;

    @Column(name = "email", nullable = false , unique = true)
    private String email;

    @Column(name= "password", nullable = false)
    private String password;
}
