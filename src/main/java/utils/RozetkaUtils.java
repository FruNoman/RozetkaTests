package utils;

public class RozetkaUtils {
    public static int formatPriceToInteger(String cost){
        String formatCost="";
        char[]charCost=cost.toCharArray();
        for(int i=0;i<charCost.length;i++){
            if(Character.isDigit(charCost[i])){
                formatCost=formatCost+charCost[i];
            }
        }
        return Integer.valueOf(formatCost);
    }
}
