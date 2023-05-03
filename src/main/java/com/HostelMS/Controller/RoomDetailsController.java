package com.HostelMS.Controller;

import com.HostelMS.Entity.Hostels;
import com.HostelMS.Entity.RoomDetails;
import com.HostelMS.Service.RoomDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hms/api")
public class RoomDetailsController {

    @Autowired
    private RoomDetailsService roomDetailsService;




    @GetMapping("/roomDetails/{}")
    @PreAuthorize("hasRole('NORMAL')")
    public RoomDetails getRoomDetails(@PathVariable int id){
        return roomDetailsService.getRoomDetailsById(id);
    }

    @GetMapping("/roomDetails")
    @PreAuthorize("hasRole('NORMAL')")
    public List<RoomDetails> getAllRoomDetails(){
        return roomDetailsService.getAllRoomDetails();
    }

}
