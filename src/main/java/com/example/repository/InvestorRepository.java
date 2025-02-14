package com.example.repository;

import com.example.model.Investor;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class InvestorRepository implements PanacheRepository<Investor> {
    // Custom queries can be added here
}