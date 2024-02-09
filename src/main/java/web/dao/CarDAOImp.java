package web.dao;

import org.springframework.stereotype.Component;
import web.models.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Component
public class CarDAOImp implements CarDAO {
   private static Long CARS_COUNT = 0L;
   private final List<Car> cars;

   {
      cars = new ArrayList<>();
      cars.add(new Car(++CARS_COUNT, "Mercedes-Benz", 234));
      cars.add(new Car(++CARS_COUNT, "Toyota", 234));
      cars.add(new Car(++CARS_COUNT, "BMW", 234));
      cars.add(new Car(++CARS_COUNT, "Honda", 235));
      cars.add(new Car(++CARS_COUNT, "Volkswagen", 345));
      cars.add(new Car(++CARS_COUNT, "Volkswagen", 345));
      cars.add(new Car(++CARS_COUNT, "Volkswagen", 345));
   }

   @Override
   public List<Car> getAllCars() {
      return cars;
   }

   @Override
   public List<Car> show(Integer count) {
      return cars.stream().limit(count).collect(Collectors.toList());
   }
}
