package web.models;

public class Car {

   private Long id;
   private String nameOfTheCar;
   private int carNumber;

   public Car(Long id, String nameOfTheCar, int carNumber) {
      this.id = id;
      this.nameOfTheCar = nameOfTheCar;
      this.carNumber = carNumber;
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getNameOfTheCar() {
      return nameOfTheCar;
   }

   public void setNameOfTheCar(String nameOfTheCar) {
      this.nameOfTheCar = nameOfTheCar;
   }

   public int getCarNumber() {
      return carNumber;
   }

   public void setCarNumber(int carNumber) {
      this.carNumber = carNumber;
   }
}
