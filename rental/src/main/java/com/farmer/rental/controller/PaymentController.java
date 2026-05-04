package com.farmer.rental.controller;

import com.farmer.rental.entity.Payment;
import com.farmer.rental.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
@CrossOrigin(origins = "*")
public class PaymentController {

    @Autowired
    private PaymentRepository repo;

    // SAVE PAYMENT
    @PostMapping
    public String savePayment(@RequestBody Payment payment) {

        payment.setPaymentStatus("Success");
        repo.save(payment);

        return "Payment Successful";
    }

    // GET ALL PAYMENTS
    @GetMapping
    public List<Payment> getAllPayments() {
        return repo.findAll();
    }

    // DELETE PAYMENT
    @DeleteMapping("/{id}")
    public String deletePayment(@PathVariable Long id) {
        repo.deleteById(id);
        return "Payment Deleted";
    }
}