package com.rohit.demo2.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rohit.demo2.entity.RegistrationDetail;
import com.rohit.demo2.repository.RegistrationRepository;


@Service
public class RegistrationService {


    private final RegistrationRepository repository;

    public RegistrationService(RegistrationRepository repository) {
        this.repository = repository;
    }

    // POST - Create registration
    public RegistrationDetail create(RegistrationDetail registration) {
        return repository.save(registration);
    }

    // GET - Find registration by ID
    public RegistrationDetail getById(int id) {
        return repository.findById(id).orElse(null);
    }

    // GET - Find all registrations
    public List<RegistrationDetail> getAll() {
        return repository.findAll();
    }

    // PUT - Replace registration details
    public RegistrationDetail update(int id, RegistrationDetail details) {
        return repository.findById(id).map(registration -> {
            registration.setEmail(details.getEmail());
            registration.setUsername(details.getUsername());
            registration.setPassword(details.getPassword());
            return repository.save(registration);
        }).orElse(null);
    }

    // PATCH - Update only provided fields
    public RegistrationDetail patch(int id, RegistrationDetail details) {
        return repository.findById(id).map(registration -> {
            if (details.getEmail() != null) {
                registration.setEmail(details.getEmail());
            }
            if (details.getUsername() != null) {
                registration.setUsername(details.getUsername());
            }
            if (details.getPassword() != null) {
                registration.setPassword(details.getPassword());
            }
            return repository.save(registration);
        }).orElse(null);
    }

    // DELETE - Delete registration
    public boolean delete(int id) {
        if (!repository.existsById(id)) {
            return false;
        }
        repository.deleteById(id);
        return true;
    }
}