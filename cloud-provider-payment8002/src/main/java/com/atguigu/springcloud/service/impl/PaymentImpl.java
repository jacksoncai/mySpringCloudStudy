package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.mapper.PaymentMapper;
import com.atguigu.springcloud.service.PaymentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service// ?????
public class PaymentImpl implements PaymentService
{
    @Resource
    PaymentMapper paymentMapper;


    public int create(Payment payment){
        int i = paymentMapper.create(payment);
        return i;
    }

    public Payment getPaymentById(@Param("id") Long id){

        Payment paymentById = paymentMapper.getPaymentById(id);

        return paymentById;
    }

}
