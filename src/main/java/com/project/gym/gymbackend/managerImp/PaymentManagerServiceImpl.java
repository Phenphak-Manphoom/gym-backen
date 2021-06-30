package com.project.gym.gymbackend.managerImp;

import com.project.gym.gymbackend.dao.PaymentDao;
import com.project.gym.gymbackend.dao.SportsManDao;
import com.project.gym.gymbackend.dto.PaymentDto;
import com.project.gym.gymbackend.manager.PaymentManagerService;
import com.project.gym.gymbackend.model.OrikaBeanMapper;
import com.project.gym.gymbackend.model.Payment;
import com.project.gym.gymbackend.model.SportsMan;
import com.project.gym.gymbackend.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class PaymentManagerServiceImpl implements PaymentManagerService {
    @Autowired
    private OrikaBeanMapper orikaBeanMapper;

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private PaymentDao paymentDao;

    @Autowired
    private SportsManDao sportsManDao;


    @Override
    public PaymentDto addPayment(PaymentDto paymentDto, Long idSportsMan) {
        SportsMan sportsMan =sportsManDao.findById(idSportsMan).orElse(null);
        Payment payment =orikaBeanMapper.map(paymentDto,Payment.class);
        return orikaBeanMapper.convertDTO(paymentService.addPayment(payment,sportsMan),PaymentDto.class);
    }

    @Override
    public PaymentDto editPayment(PaymentDto paymentDto, Long id) {
        Payment payment = orikaBeanMapper.map(paymentDto,Payment.class);
        Payment existsPayment = paymentDao.findById(id).orElse(null);
        return orikaBeanMapper.convertDTO(paymentService.editPayment(payment,existsPayment),PaymentDto.class);
    }

    @Override
    public void deletePayment(Long id) {
        Payment payment = paymentDao.findById(id).orElse(null);
        paymentDao.delete(payment);
    }

    @Override
    public PaymentDto findPaymentById(Long id) {
        return orikaBeanMapper.convertDTO(paymentDao.findById(id).orElse(null),PaymentDto.class);
    }

    @Override
    public List<PaymentDto> findPaymentsForSportsMan(Long idSportsMan) {
        SportsMan sportsMan = sportsManDao.findById(idSportsMan).orElse(null);
        List<Payment>payments=sportsMan.getPayments();
        return orikaBeanMapper.convertListDTO(payments,PaymentDto.class);
    }
}
