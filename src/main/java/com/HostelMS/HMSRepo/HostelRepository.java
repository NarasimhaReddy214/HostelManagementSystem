package com.HostelMS.HMSRepo;
import com.HostelMS.Entity.Hostels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HostelRepository extends JpaRepository<Hostels,Integer> {

}
