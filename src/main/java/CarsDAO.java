import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Scanner;

public class CarsDAO {

    public String countOfCars(Scanner sc) {
        String str = "";
        while (sc.hasNext()) {
            str = str.concat(sc.nextLine());
        }
        return str;
    }

    public Car[] fromStringToCars(String str) throws Exception {
        String[] carPart = str.split("[;]+");
        Car[] cars = new Car[carPart.length / 7 + 1];
        int carNow = 0;
        for (int j = carPart.length / 7; j > -1; j--) {
            Car car = new Car();
            boolean carHasNoErrors = true;
            car.setCode(carPart[1 + 6 * j]);
            for (int i = 0; i < j - 1; i++) {
                if (car.getCode().equals(carPart[1 + 6 * i])) {
                    carHasNoErrors = false;
                    System.out.println("Car has equal code. Car number " + j + " not added to carList");
                    break;
                }
            }
            for (Car.Color i : Car.Color.values()) {
                if (carPart[2+6*j].equals(i.toString())) {
                    car.setColor(carPart[2].trim());
                }
            }
            if (car.getColor() == null) {
                carHasNoErrors = false;
                System.out.println("There no color " + carPart[2].trim() + ". Car number " + j + " not added to carList");
            }
            car.setMark(new Mark(carPart[3 + 6 * j].trim(), carPart[1 + 6 * j]));
            car.setModel(new Model(carPart[4 + 6 * j].trim(), carPart[1 + 6 * j]));
            car.setYear(Integer.parseInt(carPart[5 + 6 * j]));
            car.setPrice(BigDecimal.valueOf(Long.parseLong(carPart[6 + 6 * j])));
            if (carHasNoErrors) {
                cars[carNow] = car;
                carNow++;
            }
        }
        Car[] carsWithoutNull= new Car[carNow];
        for(int i=0;i<carNow;i++){
            carsWithoutNull[i]=cars[i];
        }
        return carsWithoutNull;
    }

    public Car[] getAllCars() throws IOException {
        FileReader fr = new FileReader("cars.dat");
        Scanner sc = new Scanner(fr);
        String str;
        int count = 0;
        str = countOfCars(sc);
        Car[] allCars = new Car[str.length() / 7 + 1];
        sc.close();
        fr.close();
        try {
            allCars = fromStringToCars(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allCars;
    }
}
