package com.project.gym.gymbackend.service;

import com.project.gym.gymbackend.model.Payment;
import com.project.gym.gymbackend.model.SportsMan;

public interface PaymentService {
    Payment addPayment(Payment payment, SportsMan sportsMan);
    Payment editPayment(Payment payment,Payment existsPayment);
}
