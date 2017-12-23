public class CarService {

    public void sortPrice(Car[] cars, int down) {
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

    public Car[] find(Car[] cars,Mark mark){
        int count=0;
        for(Car i:cars){
            if(i.getMark().getName().equals(mark.getName())){
                count++;
            }
        }
        int j=0;
        Car[] carAllFindedMarks= new Car[count];
        for(int i=0;i<cars.length;i++){
            if(cars[i].getMark().getName().equals(mark.getName())){
                carAllFindedMarks[j]=cars[i];
                j++;
            }
        }
        return carAllFindedMarks;
    }

    public Car[] find(Car[] cars,Model model){
        int count=0;
        for(Car i:cars){
            if(i.getModel().getName().equals(model.getName())){
                count++;
            }
        }
        int j=0;
        Car[] carAllFindedMarks= new Car[count];
        for(int i=0;i<cars.length;i++){
            if(cars[i].getModel().getName().equals(model.getName())){
                carAllFindedMarks[j]=cars[i];
                j++;
            }
        }
        return carAllFindedMarks;
    }

    public Car[] find(Car[] cars,Model model,Mark mark){
        int count=0;
        for(Car i:cars){
            if(i.getModel().getName().equals(model.getName())&&i.getMark().getName().equals(mark.getName())){
                count++;
            }
        }
        int j=0;
        Car[] carAllFindedMarks= new Car[count];
        for(int i=0;i<cars.length;i++){
            if(cars[i].getModel().getName().equals(model.getName())&&cars[i].getMark().getName().equals(mark.getName())){
                carAllFindedMarks[j]=cars[i];
                j++;
            }
        }
        return carAllFindedMarks;
    }

    public Car[] find(Car[] cars, Model model, Mark mark, Car.Color color){
        int count=0;
        for(Car i:cars){
            if(i.getModel().getName().equals(model.getName())&&i.getMark().getName().equals(mark.getName())&&i.getColor().equals(color)){
                count++;
            }
        }
        int j=0;
        Car[] carAllFindedMarks= new Car[count];
        for(int i=0;i<cars.length;i++){
            if(cars[i].getModel().equals(model)&&cars[i].getMark().equals(mark)&&cars[i].getColor().equals(color)){
                carAllFindedMarks[j]=cars[i];
                j++;
            }
        }
        return carAllFindedMarks;
    }

    public Car find(Car[] cars,Car car){
        Car carToReturn = null;
        for(Car i :cars){
            if(i.getCode().equals(car.getCode())){
                carToReturn=i;
            }
        }
        return carToReturn;
    }

}
