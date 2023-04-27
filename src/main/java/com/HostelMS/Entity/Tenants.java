package com.HostelMS.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "tenant")
public class Tenants {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column
    private String hostelname;

    @Column
    private String tenantname;

    @Column
    private String owner;

    @Column
    private int roomno;

    @Column
    private int payamount;

}
