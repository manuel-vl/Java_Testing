package com.testing_java.java_testing.Exercise4;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class PaymentProcessorTest {
    @Test
    void payment_correct() {
        // PaymentGateway es una interface, por ende simulamos con mockito
        PaymentGateway paymentGateway= Mockito.mock(PaymentGateway.class);
        // Simulamos que al requestPayment le enviamos cualquier cosa y retorna un PaymentResponse OK
        // SIEMPRE que se ejecute requestPayment retorna OK
        Mockito.when(paymentGateway.requestPayment(Mockito.any()))
                .thenReturn(new PaymentResponse(PaymentResponse.PaymentStatus.OK));

        PaymentProcessor paymentProcessor=new PaymentProcessor(paymentGateway);

        boolean result= paymentProcessor.makePayment(1000.0);

        Assertions.assertEquals(true, result);
    }

    @Test
    void payment_wrong() {
        PaymentGateway paymentGateway=Mockito.mock(PaymentGateway.class);
        // SIEMPRE que se ejecute requestPayment retorna ERROR
        Mockito.when(paymentGateway.requestPayment(Mockito.any()))
                .thenReturn(new PaymentResponse(PaymentResponse.PaymentStatus.ERROR));

        PaymentProcessor paymentProcessor=new PaymentProcessor(paymentGateway);

        boolean result=paymentProcessor.makePayment(1000.0);

        Assertions.assertEquals(false, result);
    }
}