package com.project.gym.gymbackend.manager;

import com.project.gym.gymbackend.dto.PaymentDto;

import java.util.List;

public interface PaymentManagerService {
    PaymentDto addPayment(PaymentDto paymentDto, Long idSportsMan);

    PaymentDto editPayment(PaymentDto paymentDto, Long id);

    void deletePayment(Long id);

    PaymentDto findPaymentById(Long id);

    List<PaymentDto> findPaymentsForSportsMan(Long idSportsMan);
}
