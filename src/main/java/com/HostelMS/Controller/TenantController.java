package com.HostelMS.Controller;

import com.HostelMS.Entity.Hostels;
import com.HostelMS.Entity.Tenants;
import com.HostelMS.HMSRepo.TenantRepository;
import com.HostelMS.ResourceNotFoundException;
import com.HostelMS.Service.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/hms/api")
public class TenantController {

    @Autowired
    private TenantRepository tenantRepository;
    @Autowired
    private TenantService tenantService;

    @GetMapping("/tenants")
    @PreAuthorize("hasRole('NORMAL')")
    public List<Tenants> getAllTenants(){
        return tenantService.getAllTenants();
    }

    @GetMapping("/getTenants/{id}")
    @PreAuthorize("hasRole('NORMAL')")
    public Tenants getTenantById(@PathVariable int id){
        return tenantService.getTenantById(id);
    }

    @PostMapping("/addTenant")
    @PreAuthorize("hasRole('ADMIN')")
    public Tenants addTenants(@RequestBody Tenants tenants){
        return tenantService.saveTenants(tenants);
    }

    @PutMapping("/tenant/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Tenants> updateTenant(@RequestBody Tenants tenants,@PathVariable int id){
        Tenants updatedTenant=tenantRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Tenant does not exist with the id :" +id));
        updatedTenant.setHostelname(tenants.getHostelname());
        updatedTenant.setTenantname(tenants.getTenantname());
        updatedTenant.setOwner(tenants.getOwner());
        updatedTenant.setRoomno(tenants.getRoomno());
        updatedTenant.setPayamount(tenants.getPayamount());
        tenantRepository.save(updatedTenant);
        return ResponseEntity.ok(updatedTenant);

    }

    @DeleteMapping("/tenant/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Tenants> deleteDetailsTenant(@PathVariable int id){
        Tenants deletingTenant=tenantRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Hostel does not exist with the id :" +id));
        tenantRepository.delete(deletingTenant);
        return ResponseEntity.ok(deletingTenant);
    }



}
