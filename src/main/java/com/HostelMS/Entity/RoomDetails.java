package com.HostelMS.Entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "hostelrooms")
public class RoomDetails {



    @Id
    @Column
    private int id;
    @Column
    private int rooms;
    @Column
    private int availability;
    @Column
    private int occupied;
    @Column
    private int floor;
    @Column
    private int hostelid;
}
