package com.testing_java.java_testing.Unitarias_Mock.Exercise4;

public class PaymentProcessor {
    private PaymentGateway paymentGateway;

    public PaymentProcessor(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public boolean makePayment(Double amount){
        PaymentResponse paymentResponse= paymentGateway.requestPayment(new PaymentRequest(amount));

        if(paymentResponse.getStatus()==PaymentResponse.PaymentStatus.OK){
            return true;
        }else{
            return false;
        }
    }
}
