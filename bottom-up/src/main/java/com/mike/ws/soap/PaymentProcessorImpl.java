package com.mike.ws.soap;

import com.mike.ws.soap.dto.PaymentProcessorRequest;
import com.mike.ws.soap.dto.PaymentProcessorResponse;

public class PaymentProcessorImpl implements PaymentProcessor {

    public PaymentProcessorResponse processPayment(PaymentProcessorRequest paymentProcessorRequest) {
        PaymentProcessorResponse paymentProcessorResponse = new PaymentProcessorResponse();
        // TODO Auto-generated method stub
        paymentProcessorResponse.setResult(true);
        return paymentProcessorResponse;
    }

}
