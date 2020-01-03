package mmf.piskunou.model;

import java.util.Objects;

public class HotelSearchOption {

    private String destination;



    public HotelSearchOption(String destination) {
        this.destination = destination;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }



    @Override
    public String toString() {
        return "HotelSearchOption{" +
                "destination='" + destination + '\''+
                '}';
    }


    @Override
    public int hashCode() {
        return Objects.hash(destination);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        HotelSearchOption that = (HotelSearchOption) obj;
        return
                Objects.equals(destination, that.destination);
    }
}
