package com.mike.ws.soap;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import com.mike.ws.soap.dto.PaymentProcessorRequest;
import com.mike.ws.soap.dto.PaymentProcessorResponse;

@WebService(name = "PaymentProcessor")
public interface PaymentProcessor {

   public @WebResult(name="response")PaymentProcessorResponse processPayment(
         @WebParam(name = "paymentProcessorRequest") PaymentProcessorRequest paymentProcessorRequest);

}
