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
@Table(name = "Company_Data")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int company_id;

    @Column(name = "companyname", nullable = false)
    private String company_name;

    @Column(name = "companyaddress", nullable = false)
    private String company_address;

    @Column(name = "companylogo", nullable = false)
    private String company_logo;

    @Column(name = "companyemail", nullable = false)
    private String company_email;

    @Column(name = "companyphoneno", nullable = false)
    private String company_phoneno;
}
