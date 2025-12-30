package com.birbalkr.firstjobAppliction.company.impl;

import com.birbalkr.firstjobAppliction.Job.Job;
import com.birbalkr.firstjobAppliction.company.Company;
import com.birbalkr.firstjobAppliction.company.CompanyRepository;
import com.birbalkr.firstjobAppliction.company.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CompanyServiceImpl implements CompanyService {

private CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }


    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public boolean updateCompany(Company company, Long id) {
        Optional<Company> companyOptional = companyRepository.findById(id);
        if (companyOptional.isPresent()){
            Company companyToUpdate = companyOptional.get();
            companyToUpdate.setDescription(company.getDescription());
            companyToUpdate.setJobs(company.getJobs());
            companyToUpdate.setName(company.getName());
            companyRepository.save(companyToUpdate);
            return true;
        }
        return false;
    }
}
