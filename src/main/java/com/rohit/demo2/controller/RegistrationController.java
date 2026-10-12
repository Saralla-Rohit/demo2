package com.rohit.demo2.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rohit.demo2.entity.RegistrationDetail;
import com.rohit.demo2.service.RegistrationService;

@RestController
@RequestMapping("/api/registrations")
public class RegistrationController {

    private final RegistrationService service;

    public RegistrationController(RegistrationService service) {
        this.service = service;
    }

    // POST - Create a registration
    @PostMapping
    public ResponseEntity<RegistrationDetail> create(
            @RequestBody RegistrationDetail registration) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.create(registration));
    }

    // GET - Get registration by ID
    @GetMapping("/{id}")
    public ResponseEntity<RegistrationDetail> getById(
            @PathVariable int id) {

        RegistrationDetail registration = service.getById(id);

        if (registration == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(registration);
    }

    // GET - Get all registrations
    @GetMapping
    public ResponseEntity<List<RegistrationDetail>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    // PUT - Update all editable fields
    @PutMapping("/{id}")
    public ResponseEntity<RegistrationDetail> update(
            @PathVariable int id,
            @RequestBody RegistrationDetail details) {

        RegistrationDetail updated = service.update(id, details);

        if (updated == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updated);
    }

    // PATCH - Update only supplied fields
    @PatchMapping("/{id}")
    public ResponseEntity<RegistrationDetail> patch(
            @PathVariable int id,
            @RequestBody RegistrationDetail details) {

        RegistrationDetail updated = service.patch(id, details);

        if (updated == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updated);
    }

    // DELETE - Delete registration
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {

        if (!service.delete(id)) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}