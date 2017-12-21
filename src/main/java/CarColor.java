import java.io.IOException;

public class CarColor extends Car {
    private enum Colors{BLACK,WHITE,GREEN,SILVER,GRAY,RED,CUSTOM}
    private Colors color;

    public Colors getColor() {
        return color;
    }

    public void setColor(String str) throws NullPointerException{
        for(Colors c:Colors.values()){
            if(c.name().equals(str.toUpperCase())){
                this.color = Colors.valueOf(str);
            }
        }
        if(color==null){
             color=Colors.CUSTOM;
        }
    }

    @Override
    public int compareTo(String str){
        return color.toString().toUpperCase().compareTo(str.toUpperCase());
    }

}
