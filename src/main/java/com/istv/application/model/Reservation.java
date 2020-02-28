package com.istv.application.model;

import java.io.Serializable;

public class Reservation implements Serializable {
    private String reservationId;
    private int appartmentId;
    private int renterId;
    private int ownerId;
    private ReservationStatus reservationStatus;

    public Reservation(){

    }

    public Reservation(String id, int appartmentId, int renterId, int ownerId) {
        this.reservationId = id;
        this.appartmentId = appartmentId;
        this.renterId = renterId;
        this.ownerId = ownerId;
    }

    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String id) {
        this.reservationId = id;
    }

    public int getAppartmentId() {
        return appartmentId;
    }

    public void setAppartmentId(int appartmentId) {
        this.appartmentId = appartmentId;
    }

    public int getRenterId() {
        return renterId;
    }

    public void setRenterId(int renterId) {
        this.renterId = renterId;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public ReservationStatus getReservationStatus() {
        return reservationStatus;
    }

    public void setReservationStatus(ReservationStatus reservationStatus) {
        this.reservationStatus = reservationStatus;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "reservationId='" + reservationId + '\'' +
                ", appartmentId=" + appartmentId +
                ", renterId=" + renterId +
                ", ownerId=" + ownerId +
                ", reservationStatus=" + reservationStatus +
                '}';
    }
}
