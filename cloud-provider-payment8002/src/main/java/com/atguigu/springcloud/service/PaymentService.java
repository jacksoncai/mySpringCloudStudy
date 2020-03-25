package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

//接口不加注释@Service
public interface PaymentService {

   int create(Payment payment);

   Payment getPaymentById(@Param("id") Long id);
}
