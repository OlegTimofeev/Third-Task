
public class Mark extends Car {
    private String code;
    private String name;


    public Mark(String name,String code) {
        this.name = name;
        this.code=code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(String str){
        return name.toUpperCase().compareTo(str.toUpperCase());
    }

}
