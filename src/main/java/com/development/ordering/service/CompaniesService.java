package com.development.ordering.service;

import com.development.ordering.model.Company;
import com.development.ordering.repository.CompanyRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompaniesService {
    @Autowired
    private CompanyRepository companyRepository;

    public List<Company> getAllCompanies() {

        List<Company> companies = new ArrayList<>();
        companyRepository.findAll().forEach(companies::add);
        return companies;
    }

    public Company getCompany(Long id) throws ResourceNotFoundException {
        try{
            Company company = companyRepository.findCompaniesById(id);
            return company;
        }
        catch (ResourceNotFoundException e){
            throw new ResourceNotFoundException("Company not found for this id :: " + id);
        }
    }

    public Company addOrUpdateCompany(Company company) {
        return companyRepository.save(company);
    }

    public boolean deleteCompany(long id) throws ResourceNotFoundException {
        try{
            companyRepository.deleteById(id);
            return true;
        }catch (Exception e){
            throw new ResourceNotFoundException("Company not found with id :: " + id);
        }
    }
}
