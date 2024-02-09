package web.dao;

import web.models.Car;

import java.util.List;

public interface CarDAO {
   List<Car> getAllCars();

   List<Car> show(Integer count);
}
