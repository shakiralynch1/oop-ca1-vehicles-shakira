package org.example;

import java.util.Comparator;

public class CarMileageComparator implements Comparator<Car> {

        public int compare(Car car1, Car car2)
        {
            return Integer.compare(car1.getMileage(), car2.getMileage());
        }
    }


