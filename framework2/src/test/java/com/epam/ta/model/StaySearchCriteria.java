package com.epam.ta.model;

import java.util.Objects;

public class StaySearchCriteria {

    private String destination;
    private String checkIn;
    private String checkOut;
    private int numberOfGuests;


    public StaySearchCriteria(String destination, String checkIn, String checkOut) {
        this.destination = destination;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }

    @Override
    public String toString() {
        return "StaySearchCriteria{" +
                "destination='" + destination + '\'' +
                ", checkIn='" + checkIn + '\'' +
                ", checkOut='" + checkOut +
                '}';
    }


    public int getNumberOfGuests() {
        return numberOfGuests;
    }


    @Override
    public int hashCode() {
        return Objects.hash(destination, checkIn, checkOut);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        StaySearchCriteria that = (StaySearchCriteria) obj;
        return
                Objects.equals(destination, that.destination) &&
                        Objects.equals(checkIn, that.checkIn) &&
                        Objects.equals(checkOut, that.checkOut);
    }
}
