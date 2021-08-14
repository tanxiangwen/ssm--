package utils;
public class BeanUtils {
    public static int parsint(int str, int wrong){

            if(str!=0){
                return str;
            }

        return wrong;
    }
    public static int parsins(String str,int wrong){
        try {
            return Integer.parseInt(str);
        }catch (Exception e){

        }
        return wrong;
    }


}
