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

    public Car[] findMark(Car[] cars,String markName){
        int count=0;
        for(Car i:cars){
            if(i.getMark().compareTo(markName)==0){
                count++;
            }
        }
        int j=0;
        Car[] carAllFindedMarks= new Car[count];
        for(int i=0;i<cars.length;i++){
            if(cars[i].getMark().compareTo(markName)==0){
                carAllFindedMarks[j]=cars[i];
                j++;
            }
        }
        return carAllFindedMarks;
    }

    public Car[] findModel(Car[] cars,String modelName){
        int count=0;
        for(Car i:cars){
            if(i.getModel().compareTo(modelName)==0){
                count++;
            }
        }
        int j=0;
        Car[] carAllFindedModels= new Car[count];
        for(int i=0;i<cars.length;i++){
            if(cars[i].getModel().compareTo(modelName)==0){
                carAllFindedModels[j]=cars[i];
                j++;
            }
        }
        return carAllFindedModels;
    }

    public Car[] findColor(Car[] cars,String color){
        int count=0;
        for(Car i:cars){
            if(i.getCc().compareTo(color)==0){
                count++;
            }
        }
        int j=0;
        Car[] carAllFindedModels= new Car[count];
        for(int i=0;i<cars.length;i++){
            if(cars[i].getCc().compareTo(color)==0){
                carAllFindedModels[j]=cars[i];
                j++;
            }
        }
        return carAllFindedModels;
    }

    public Car findCode(Car[] cars,String code){
        Car car= new Car();
        for(Car i:cars){
            if(i.compareTo(code)==0){
                car=i;
            }
        }
        return car;
    }

}
