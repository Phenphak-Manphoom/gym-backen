package com.project.gym.gymbackend.controller;

import com.project.gym.gymbackend.dto.PaymentDto;
import com.project.gym.gymbackend.manager.PaymentManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = " http://localhost:4200")
public class PaymentController {

    @Autowired
    private PaymentManagerService paymentManagerService;

    @PostMapping("/addPayment/{idSportsMan}")
    PaymentDto addPayment(@RequestBody PaymentDto payment, @PathVariable Long idSportsMan) {
        return paymentManagerService.addPayment(payment, idSportsMan);
    }

    @PutMapping("/editPayment/{id}")
    PaymentDto editPayment(@RequestBody PaymentDto payment, @PathVariable Long id) {
        return paymentManagerService.editPayment(payment, id);
    }

    @DeleteMapping("/deletePayment/{id}")
    void deletePayment(@PathVariable Long id) {
        paymentManagerService.deletePayment(id);
    }

    @GetMapping("/findPaymentById/{id}")
    PaymentDto findPaymentById(@PathVariable Long id) {
        return paymentManagerService.findPaymentById(id);
    }

    @GetMapping("/findPaymentForSportsMan/{idSportsMan}")
    List<PaymentDto> findPaymentsForSportsMan(@PathVariable Long idSportsMan) {
        return paymentManagerService.findPaymentsForSportsMan(idSportsMan);
    }
}
