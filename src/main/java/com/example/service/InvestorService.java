package com.example.service;

import com.example.model.Investor;
import com.example.repository.InvestorRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class InvestorService {

    @Inject
    InvestorRepository investorRepository;

    public List<Investor> getAllInvestors() {
        return investorRepository.listAll();
    }

    public Investor getInvestor(Long id) {
        return investorRepository.findById(id);
    }

    public void createInvestor(Investor investor) {
        investorRepository.persist(investor);
    }

    public void updateInvestor(Long id, Investor updatedInvestor) {
        Investor investor = investorRepository.findById(id);
        investor.name = updatedInvestor.name;
        investor.email = updatedInvestor.email;
        investorRepository.persist(investor);
    }

    public void deleteInvestor(Long id) {
        investorRepository.deleteById(id);
    }
}