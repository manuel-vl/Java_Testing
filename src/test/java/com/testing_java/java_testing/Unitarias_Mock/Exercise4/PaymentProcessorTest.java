package com.testing_java.java_testing.Unitarias_Mock.Exercise4;

import com.testing_java.java_testing.Unitarias_Mock.Exercise4.PaymentGateway;
import com.testing_java.java_testing.Unitarias_Mock.Exercise4.PaymentProcessor;
import com.testing_java.java_testing.Unitarias_Mock.Exercise4.PaymentResponse;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PaymentProcessorTest {
    private PaymentGateway paymentGateway;
    private PaymentProcessor paymentProcessor;

    // Indicando que tiene que ejecutar este metodo antes de un test
    @Before
    public void setup(){
        // PaymentGateway es una interface, por ende simulamos con mockito
        paymentGateway= Mockito.mock(PaymentGateway.class);

        paymentProcessor=new PaymentProcessor(paymentGateway);
    }

    @Test
    void payment_correct() {
        // ARRANGE
        // Simulamos que al requestPayment le enviamos cualquier cosa y retorna un PaymentResponse OK
        // SIEMPRE que se ejecute requestPayment retorna OK
        Mockito.when(paymentGateway.requestPayment(Mockito.any()))
                .thenReturn(new PaymentResponse(PaymentResponse.PaymentStatus.OK));

        // ACT
        boolean result= paymentProcessor.makePayment(1000.0);

        // ASSERT
        Assertions.assertEquals(true, result);
    }

    @Test
    void payment_wrong() {
        // ARRANGE
        // SIEMPRE que se ejecute requestPayment retorna ERROR
        Mockito.when(paymentGateway.requestPayment(Mockito.any()))
                .thenReturn(new PaymentResponse(PaymentResponse.PaymentStatus.ERROR));

        // ACT
        boolean result=paymentProcessor.makePayment(1000.0);

        // ASSERT
        Assertions.assertEquals(false, result);
    }
}