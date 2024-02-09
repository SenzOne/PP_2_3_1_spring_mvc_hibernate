package web.service;

import org.springframework.stereotype.Component;
import web.models.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarService {
   private static Long CARS_COUNT = 1L;
   private final List<Car> cars;

   public List<Car> getCars() {
      return cars;
   }


   {
      cars = new ArrayList<>();
      cars.add(new Car(++CARS_COUNT, "Mercedes-Benz", 234));
      cars.add(new Car(++CARS_COUNT, "Toyota", 234));
      cars.add(new Car(++CARS_COUNT, "BMW", 234));
      cars.add(new Car(++CARS_COUNT, "Honda", 235));
      cars.add(new Car(++CARS_COUNT, "Volkswagen", 345));
   }


   public List<Car> show(int count) {
      return cars.stream().limit(count).collect(Collectors.toList());
   }
}