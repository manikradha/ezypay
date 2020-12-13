package com.ezypay.sub.exception;

import com.ezypay.sub.model.Subscription;

import javax.validation.ConstraintViolation;
import java.util.Set;
import java.util.stream.Collectors;

public class SubscriptionException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private String msg;

    public SubscriptionException(String msg) {
        this.msg = msg;
    }

    public SubscriptionException(Set<ConstraintViolation<Subscription>> violations) {
        this.msg = String.join(", ", violations.stream().map(violation -> violation.getMessage()).collect(Collectors.toList()));
    }

    public String getMsg() {
        return msg;
    }
}
