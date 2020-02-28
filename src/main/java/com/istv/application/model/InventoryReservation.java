package com.istv.application.model;

import java.io.Serializable;

public class InventoryReservation implements Serializable {
    private String reservationId;
    private int returnCode;
    private String comment;

    public InventoryReservation() {

    }

    public InventoryReservation(String reservationId, int returnCode, String comment) {
        this.reservationId = reservationId;
        this.returnCode = returnCode;
        this.comment = comment;
    }

    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }

    public int getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(int returnCode) {
        this.returnCode = returnCode;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
