import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner vvod = new Scanner(System.in);
        String input = vvod.nextLine();

        System.out.println(calc(input));
    }
    static boolean arab;
    public static String calc(String input) {
        String s = "";
        String[] znaki = input.split(" ");
        if (znaki.length != 3){
            try {
                throw new Exception();

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        String x = znaki[0];
        String[] xx = ar(x);
        String y = znaki[2];
        String[] yy = ar(y);
        if (Objects.equals(xx[1], yy[1])) {
            int x1 = Integer.parseInt(ar(x)[0]);
            int y1 = Integer.parseInt(ar(y)[0]);

            int result = 0;
            switch (znaki[1]) {
                case "+" -> result = x1 + y1;
                case "-" -> result = x1 - y1;
                case "/" -> result = x1 / y1;
                case "*" -> result = x1 * y1;
                default -> {
                    try {throw new Exception();

                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            if (Objects.equals(xx[1], "true")) {
                s = IntToRoman(result);
            } else s = String.valueOf(result);


        } else {
            try {
                throw new NumberFormatException();
            }catch (Exception ignored) {
            }
        }
        if (s.equals("")) {
            try {
                throw new Exception();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }else return s;
    }
    public static String[] ar(String a) {
        String[] d = new String[2];
        Integer x = null;
        switch (a) {
            case "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" -> {arab = false; x = Integer.valueOf(a);}
            case "I"   -> {arab = true; x = 1;}
            case "II"  -> {arab = true; x = 2;}
            case "III" -> {arab = true; x = 3;}
            case "IV"  -> {arab = true; x = 4;}
            case "V"   -> {arab = true; x = 5;}
            case "VI"  -> {arab = true; x = 6;}
            case "VII" -> {arab = true; x = 7;}
            case "VIII"-> {arab = true; x = 8;}
            case "IX"  -> {arab = true; x = 9;}
            case "X"   -> {arab = true; x = 10;}
            
            default -> {
                try {
                    throw new NumberFormatException();
                } catch (Exception ignored){
                }
            }
        }
        d[0] = String.valueOf(x);
        d[1] = String.valueOf(arab);
        return d;
    }
    public static String IntToRoman(int num)
    {
        var keys = new String[] { "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
        var vals = new int[] { 100, 90, 50, 40, 10, 9, 5, 4, 1 };

        StringBuilder ret = new StringBuilder();
        int ind = 0;

        while(ind < keys.length)
        {
            while(num >= vals[ind])
            {
                var d = num / vals[ind];
                num = num % vals[ind];
                for(int i=0; i<d; i++)
                    ret.append(keys[ind]);
            }
            ind++;
        }

        return ret.toString();
    }
}