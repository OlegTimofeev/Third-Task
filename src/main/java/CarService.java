import java.io.IOException;

public class CarService {

    private CarsDAO carsDAO;
    private Car[] findedCars;
    private Car[] cars;

    public CarService() throws IOException {
        carsDAO=new CarsDAO();
        cars=new Car[carsDAO.getCars().length];
        System.arraycopy(carsDAO.getCars(),0,cars,0,carsDAO.getCars().length);
    }

    public void sortPrice( int down) {
        Car swapCar;
        int index;
        for (int j = 0; j < cars.length; j++) {
            Car equal = cars[j];
            index=j;
            for (int i = j; i < cars.length; i++) {
                if(equal.getPrice().compareTo(cars[i].getPrice())*down<0){
                    equal=cars[i];
                    index=i;
                }
            }
            swapCar=cars[j];
            cars[j]=equal;
            cars[index]=swapCar;
        }
    }

    public Car[] findMark(String mark){
        findedCars= new Car[0];
        for(Car i:cars){
            if(i.getMark().getName().equalsIgnoreCase(mark)){
                addCar(i);
            }
        }
        return findedCars;

    }

    public Car[] findModel(String model){
        findedCars= new Car[0];
        for(Car i:cars){
            if(i.getModel().getName().equalsIgnoreCase(model)){
                addCar(i);
            }
        }
        return findedCars;
    }

    public Car[] find(String model,String mark){
        findedCars= new Car[0];
        for(Car i:cars){
            if(i.getModel().getName().equalsIgnoreCase(model)&&i.getMark().getName().equalsIgnoreCase(mark)){
                addCar(i);
            }
        }
        return findedCars;
    }

    public Car[] find(String model, String mark, String color){
        findedCars= new Car[0];
        for(Car i:cars){
            if(i.getModel().getName().equalsIgnoreCase(model)&&i.getMark().getName().equalsIgnoreCase(mark)&&i.getColor().toString().equalsIgnoreCase(color)){
                addCar(i);
            }
        }
        return findedCars;
    }

    public Car find(String code){
        Car carToReturn = null;
        for(Car i :cars){
            if(i.getCode().equalsIgnoreCase(code)){
                carToReturn=i;
            }
        }
        return carToReturn;
    }

    public void addCar(Car car){
        Car[] carNewMass= new Car[findedCars.length+1];
        int i=findedCars.length;
        System.arraycopy(findedCars,0,carNewMass,0,i);
        findedCars=carNewMass;
        findedCars[i]=car;
    }

}
