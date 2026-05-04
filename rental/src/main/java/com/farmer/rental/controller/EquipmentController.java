package com.farmer.rental.controller;

import com.farmer.rental.entity.Equipment;
import com.farmer.rental.repository.EquipmentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/equipment")
public class EquipmentController {

    private final EquipmentRepository repo;

    public EquipmentController(EquipmentRepository repo) {
        this.repo = repo;
    }

    // GET all equipment
    @GetMapping
    public List<Equipment> getAll() {
        return repo.findAll();
    }

    // ADD equipment (for testing)
    @PostMapping
    public String add(@RequestBody Equipment e) {
        repo.save(e);
        return "Equipment '" + e.getName() + "' added successfully";
    }
    @DeleteMapping("/{id}")
    public String deleteEquipment(@PathVariable Long id) {
        repo.deleteById(id);
        return "Equipment deleted successfully";
    }
}
