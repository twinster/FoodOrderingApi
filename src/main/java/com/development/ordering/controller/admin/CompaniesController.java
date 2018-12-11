package com.development.ordering.controller.admin;

import com.development.ordering.model.Company;
import com.development.ordering.service.CompaniesService;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/admin/companies")
@PreAuthorize("hasAuthority('ADMIN')")
public class CompaniesController {
    @Autowired
    private CompaniesService companyService;

    //@Secured("ROLE_USER")
    //@PreAuthorize("hasAuthority('USER')")
    ////@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @RequestMapping(method= RequestMethod.GET, value="/list")
    public List<Company> getAllCompanies() {
        return companyService.getAllCompanies();
    }

    //@Secured("USER")
    @RequestMapping(method=RequestMethod.POST, value="/")
    public ResponseEntity<Company> createCompany(@Valid @RequestBody Company company) {
        return ResponseEntity.ok().body(companyService.addOrUpdateCompany(company));
    }

    //@PreAuthorize("hasAnyRole('ADMIN', 'USER', 'Jemali')")
    @RequestMapping(method=RequestMethod.GET, value="/{id}/edit")
    public Company getCompany(@PathVariable long id) throws ResourceNotFoundException {
        return companyService.getCompany(id);
    }

    //@PreAuthorize("hasRole('Jemali')")
    @RequestMapping(method=RequestMethod.PUT, value="/{id}")
    public ResponseEntity<Company> updateCompany(@RequestBody Company company, @PathVariable(value = "id") long id) {
        return  ResponseEntity.ok().body(companyService.addOrUpdateCompany(company));
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/{id}")
    public ResponseEntity<?> deleteCompany(@PathVariable(value = "id") long id) throws ResourceNotFoundException {
        companyService.deleteCompany(id);
        return ResponseEntity.ok().build();
    }
}
