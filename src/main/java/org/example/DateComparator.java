package org.example;

import java.time.LocalDateTime;
import java.util.Comparator;

public class DateComparator implements Comparator<Booking> {

    public int compare(Booking booking1, Booking booking2)
    {
        return booking1.getBookingDateTime().compareTo(booking2.getBookingDateTime());
    }
}
