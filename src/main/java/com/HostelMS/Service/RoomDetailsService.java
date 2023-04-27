package com.HostelMS.Service;

import com.HostelMS.Entity.RoomDetails;
import com.HostelMS.HMSRepo.RoomDetailsRepository;
import com.HostelMS.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomDetailsService {

    @Autowired
    private RoomDetailsRepository roomDetailsRepository;

    public RoomDetails getRoomDetailsById(int id){
        return roomDetailsRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Room details does not exist with the id :"+id));

    }

}
