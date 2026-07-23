package com.skillfirstlab.distributionservice.exception;

public class DistributionNotFoundException extends RuntimeException {

    public DistributionNotFoundException(String message) {
        super(message);
    }
}