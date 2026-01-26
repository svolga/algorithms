package codewars.mumbling;

// https://www.codewars.com/kata/5667e8f4e3f572a8f2000039/train/java

public class Accumul {

    public static void main(String[] args) {
        //   testing("AbC", "A-Bb-Ccc");

        String str = "EvidjUnokmM";
        String result = accum(str); //  "A-Bb-Ccc"
        System.out.println(result);
    }

    public static String accum(String s) {

        char[] chars = s.toCharArray();
        StringBuilder accum = new StringBuilder();

        for (int i = 0; i < chars.length; i++) {
            if (i > 0) {
                accum.append("-");
            }

            String str = String.valueOf(chars[i]).repeat(i + 1);
            accum.append(str.substring(0, 1).toUpperCase() + (str.substring(1)).toLowerCase());

        }

        return accum.toString();
    }

}
