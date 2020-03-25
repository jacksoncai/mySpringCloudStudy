package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {
    @Resource
    PaymentService paymentService;
@Value("${server.port}")
private  String port;
    @PostMapping("/payment/create")
    public CommonResult create(Payment payment)
    {
        int result=paymentService.create(payment);
        log.info("create插入方法---------结果是"+result);

        if(result>0){
           return new CommonResult<>(200,"插入成功O(∩_∩)O port: "+port,result);
        }else {
            return new CommonResult<>(444,"插入失败",null);
        }
    }
    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id")Long id)
    {
        Payment pay = paymentService.getPaymentById(id);
        log.info("查询方法---------结果是热部署测试"+pay);

        if(pay!=null){
           return new CommonResult<>(200,"查询成功O(∩_∩)O哈哈当前port: "+port,pay);
        }else {
            return new CommonResult<>(444,"没有记录,id为"+id,null);
        }
    }
}
