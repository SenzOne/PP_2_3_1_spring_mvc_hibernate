package web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarServiceImp;


@Controller
@RequestMapping(value = "/cars")
public class CarController {
   private CarServiceImp carService;

   @Autowired
   public CarController(CarServiceImp carService) {
      this.carService = carService;
   }

   @GetMapping()
   public String showCars(@RequestParam(value = "count", required = false) Integer count, Model model) {
      if (count == null || count >= 5) {
         model.addAttribute("cars", carService.getAllCars());
      } else {
         model.addAttribute("cars", carService.show(count));
      }
      return "cars";
   }
}