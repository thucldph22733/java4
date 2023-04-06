package utils;

public class Validate {
    public static String checkValues(String value,String ten){
        if (value.isEmpty()){
            return ten +" không được để trống!";
        }
        return "";
    }
}
