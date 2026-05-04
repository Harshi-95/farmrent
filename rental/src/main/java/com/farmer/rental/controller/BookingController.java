package com.farmer.rental.controller;

import com.farmer.rental.entity.Booking;
import com.farmer.rental.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
@CrossOrigin
public class BookingController {

    @Autowired
    private BookingRepository repo;

    // ✅ SAVE
    @PostMapping
    public String save(@RequestBody Booking b) {
        repo.save(b);
        return "Booking Saved";
    }

    // ✅ GET ALL
    @GetMapping
    public List<Booking> getAll() {
        return repo.findAll();
    }

    // ✅ DELETE
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        repo.deleteById(id);
        return "Booking Cancelled";
    }
}