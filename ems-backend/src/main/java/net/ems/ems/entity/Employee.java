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

    @Column(name = "IdNo", unique = true)
    private String  IdNo;

    @Column(name = "first_name")
    private String FirstName;

    @Column(name = "last_Name")
    private String LastName;

    @Column(name = "email", nullable = false , unique = true)
    private String email;

    @Column(name = "Gender")
    private String gender;

    @Column(name= "Status")
    private String status;

    @Column(name = "Position")
    private String position;

    @Column(name = "Physical_Address")
    private String PhysicalAddress;

}
