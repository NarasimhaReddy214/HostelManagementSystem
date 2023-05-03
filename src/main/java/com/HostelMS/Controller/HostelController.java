package com.HostelMS.Controller;

import com.HostelMS.HMSRepo.HostelRepository;
import com.HostelMS.Entity.Hostels;
import com.HostelMS.ResourceNotFoundException;
import com.HostelMS.Service.HostelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/hms/api")
public class HostelController {
    @Autowired
    private HostelService hostelService;

    @Autowired
    private HostelRepository hostelRepository;

    @GetMapping("/hostels")
    @PreAuthorize("hasRole('NORMAL')")
    public List<Hostels> getAllDetails() {
        return hostelService.getAllDetails();
    }

    @GetMapping("/getHostels/{id}")
    @PreAuthorize("hasRole('NORMAL')")
    public Hostels findDetailsById(@PathVariable int id){
        return hostelService.findDetailsById(id);
    }

    @PostMapping("/addHostel")
    @PreAuthorize("hasRole('ADMIN')")
    public Hostels saveHostelDetails(@RequestBody Hostels hostels){
        return hostelService.saveDetails(hostels);
    }

    @PutMapping("/hostel/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Hostels> updateHostel(@RequestBody Hostels hostels,@PathVariable int id){
        Hostels updatedHostel=hostelRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("hostel does not exist with the id :" +id));
        updatedHostel.setHostelname(hostels.getHostelname());
        updatedHostel.setAddress(hostels.getAddress());
        updatedHostel.setContactno(hostels.getContactno());
        hostelRepository.save(updatedHostel);
        return ResponseEntity.ok(updatedHostel);
    }

    @DeleteMapping("/hostel/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Hostels> deleteDetails(@PathVariable int id){
        Hostels deletingHostel=hostelRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Hostel does not exist with the id :" +id));
        hostelRepository.delete(deletingHostel);
        return ResponseEntity.ok(deletingHostel);
    }

}

