package com.HostelMS.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.math.BigInteger;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="hostel")
public class Hostels {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String hostelname;

    @Column
    private String address;

    @Column
    private BigInteger contactno;

}
