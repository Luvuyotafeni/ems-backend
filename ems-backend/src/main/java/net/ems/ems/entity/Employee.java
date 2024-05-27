package net.ems.ems.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employees")

public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_Name")
    private String lastName;

    @Column(name = "email", nullable = false , unique = true)
    private String email;

    @Column(name = "Physical_Address")
    private String Physical_Address;

    @Column(name = "IdNo", unique = true)
    private String  IdNo;

    @Column(name= "Status")
    private String status;

    @Column(name = "Position")
    private String position;

    @Column(name = "Gender")
    private String gender;

}
