import java.io.FileNotFoundException;
import java.io.IOException;

public class test {
    public final static void main(String []args) throws IOException {
        CarService carService= new CarService();
        carService.sortPrice(1);
        carService.sortPrice(-1);
        carService.findMark("lada");
        carService.findModel("diablo");
    }
}
