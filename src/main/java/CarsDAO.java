import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Scanner;

public class CarsDAO {
    private Car[] carsCatalog;

    public int countOfCars(Scanner sc){
        String str=" ";
        int i=0;
        while(sc.hasNext()){
            str= sc.nextLine();
            i++;
        }
        return i;
    }

    public Car fromStringToCar(String str) {
        Car car = new Car();
        String[] carPart = str.split("[;]+");
        car.setCode(carPart[1]);
        car.setCc(carPart[2].trim());
        car.setMark(new Mark(carPart[3].trim(),carPart[1]));
        car.setModel(new Model(carPart[4].trim(),carPart[1]));
        car.setYear(Integer.parseInt(carPart[5]));
        car.setPrice(BigDecimal.valueOf(Long.parseLong(carPart[6])));
        return car;
    }

    public Car[] getAllCars() throws IOException {
        FileReader fr= new FileReader("cars.dat");
        Scanner sc= new Scanner(fr);
        int count=countOfCars(sc);
        Car[] allCars = new Car[count];
        sc.close();
        fr.close();
        FileReader fr1= new FileReader("cars.dat");
        Scanner sc1 = new Scanner(fr1);
        for(int i=0;i<count;i++){
            allCars[i]=fromStringToCar(sc1.nextLine());
        }
        sc.close();
        fr.close();
        return allCars;
    }
}
