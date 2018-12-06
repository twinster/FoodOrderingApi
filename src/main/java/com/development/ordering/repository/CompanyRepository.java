package com.development.ordering.repository;

import com.development.ordering.model.Company;
import com.development.ordering.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends CrudRepository<Company, Long> {
    public Company findCompaniesById(Long id);
}
