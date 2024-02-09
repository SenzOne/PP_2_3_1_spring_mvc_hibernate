package web.service;

import org.springframework.stereotype.Service;
import web.dao.CarDAOImp;
import web.models.Car;

import java.util.List;

@Service
public class CarServiceImp implements CarService {

   private final CarDAOImp carDAO;


   public CarServiceImp(CarDAOImp carDAO) {
      this.carDAO = carDAO;
   }


   @Override
   public List<Car> getAllCars() {
      return carDAO.getAllCars();
   }

   @Override
   public List<Car> show(Integer count) {
      return carDAO.show(count);
   }
}