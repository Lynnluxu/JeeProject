package com.istv.application.model;

public enum ReservationStatus {

    CREATED("Created"),
    PENDING("Pending"),
    ACCEPTED("Accepted"),
    CONFIRMED("Confirmed"),
    FAILED("Failed"),
    REFUSED("Refused");


    private String status;

    private ReservationStatus(final String status){
        this.status = status;
    }

    public String getStatus(){
        return this.status;
    }

    @Override
    public String toString(){
        return this.status;
    }


    public String getName(){
        return this.name();
    }
}
