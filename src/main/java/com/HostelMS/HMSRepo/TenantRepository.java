package com.HostelMS.HMSRepo;

import com.HostelMS.Entity.Tenants;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TenantRepository extends JpaRepository<Tenants,Integer> {
}
