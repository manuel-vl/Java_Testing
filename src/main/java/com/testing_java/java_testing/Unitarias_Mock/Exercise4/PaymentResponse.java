package com.testing_java.java_testing.Unitarias_Mock.Exercise4;

public class PaymentResponse {
    enum PaymentStatus{
        OK, ERROR
    }

    private PaymentStatus status;

    public PaymentResponse(PaymentStatus status) {
        this.status = status;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }
}
