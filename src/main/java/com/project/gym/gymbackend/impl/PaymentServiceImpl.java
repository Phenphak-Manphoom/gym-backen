package com.project.gym.gymbackend.impl;

import com.project.gym.gymbackend.dao.PaymentDao;
import com.project.gym.gymbackend.model.Payment;
import com.project.gym.gymbackend.model.SportsMan;
import com.project.gym.gymbackend.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentDao paymentDao;

    @Override
    public Payment addPayment(Payment payment, SportsMan sportsMan) {
        sportsMan.addPayment(payment);
        return paymentDao.save(payment);
    }

    @Override
    public Payment editPayment(Payment payment, Payment existPayment) {
        existPayment.setCost(payment.getCost());
        existPayment.setDate(payment.getDate());
        existPayment.setDuration(payment.getDuration());
        return paymentDao.save(existPayment);
    }
}
