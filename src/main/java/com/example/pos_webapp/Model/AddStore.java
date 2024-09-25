package com.example.pos_webapp.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Stores_Data")
public class AddStore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int store_id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "manager", nullable = false)
    private String manager;

    @Column(name = "location", nullable = false)
    private String location;

    @Column(name = "storephoneno", nullable = false)
    private String storephoneno;

    @Column(name = "status", nullable = false)
    private String status;
}
