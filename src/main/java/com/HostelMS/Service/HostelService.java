package com.HostelMS.Service;

import com.HostelMS.HMSRepo.HostelRepository;
import com.HostelMS.Entity.Hostels;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HostelService {

    @Autowired
    private HostelRepository hostelRepository;

    public List<Hostels> getAllDetails() {
        return hostelRepository.findAll();
    }

    public Hostels findDetailsById(int id){
        return hostelRepository.findById(id).orElse(null);
    }

    public Hostels saveDetails(Hostels hostels){
        return hostelRepository.save(hostels);
    }




}
