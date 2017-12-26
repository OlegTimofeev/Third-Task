import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Scanner;

public class CarsDAO {

    private Car[] cars;

    public CarsDAO() throws IOException {
        cars=new Car[0];
        getAllCars();
    }
    public Car[] getCars() {
        return cars;
    }

    public void setCars(Car[] cars) {
        this.cars = cars;
    }

    public String countOfCars(Scanner sc) {
        String str = "";
        while (sc.hasNext()) {
            str = str.concat(sc.nextLine());
        }
        return str;
    }

    public void addCar(Car car){
        Car[] carNewMass= new Car[cars.length+1];
        int i=cars.length;
        System.arraycopy(cars,0,carNewMass,0,i);
        cars=carNewMass;
        cars[i]=car;
    }

    public void fromStringToCars(String str) {

        String[] carPart = str.split("[;]+");
        int carNow = 0;
        for (int j = carPart.length / 7; j > -1; j--) {
            Car car = new Car();
            boolean carHasNoErrors = true;
            car.setCode(carPart[1 + 6 * j]);
            for (int i = 0; i < j - 1; i++) {
                if (car.getCode().equalsIgnoreCase(carPart[1 + 6 * i])) {
                    carHasNoErrors = false;
                    System.out.println("Car has equal code. Car number " + j + " not added to carList");
                    break;
                }
            }
            if(!carHasNoErrors){
                continue;
            }
            for (CarColor i : CarColor.values()) {
                if (carPart[2+6*j].equalsIgnoreCase(i.toString())) {
                    car.setColor(carPart[2+6*j].trim().toUpperCase());
                }
            }
            if (car.getColor() == null) {
                carHasNoErrors = false;
                System.out.println("There no color " + carPart[2+6*j].trim() + ". Car number " + j + " not added to carList");
                continue;
            }
            car.setMark(new Mark(carPart[3 + 6 * j].trim(), carPart[1 + 6 * j]));
            car.setModel(new Model(carPart[4 + 6 * j].trim(), carPart[1 + 6 * j]));
            car.setYear(Integer.parseInt(carPart[5 + 6 * j]));
            car.setPrice(BigDecimal.valueOf(Double.parseDouble(carPart[6 + 6 * j])));
            addCar(car);
        }
    }

    public void getAllCars() throws IOException {
        FileReader fr = new FileReader("cars.dat");
        Scanner sc = new Scanner(fr);
        String str;
        int count = 0;
        str = countOfCars(sc);
        sc.close();
        try {
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        fromStringToCars(str);
    }
}
