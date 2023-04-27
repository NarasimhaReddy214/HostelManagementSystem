package com.HostelMS.Service;

import com.HostelMS.Entity.Tenants;
import com.HostelMS.HMSRepo.TenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TenantService {

    @Autowired
    private TenantRepository tenantRepository;

    public List<Tenants> getAllTenants(){
        return tenantRepository.findAll();
}

    public Tenants getTenantById(int id){
        return tenantRepository.findById(id).orElse(null);
    }

    public Tenants saveTenants(Tenants tenants){
        return tenantRepository.save(tenants);
    }

}
