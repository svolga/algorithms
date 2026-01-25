package codewars.strings.jaden.casing.strings;

// https://www.codewars.com/kata/5390bac347d09b7da40006f6/train/java

public class JadenCase {

    public static void main(String[] args) {
        String phrase = "How can mirrors be real if our eyes aren't real";
//        String phrase = "most trees are blue";
        System.out.println(phrase);
        String result = new JadenCase().toJadenCase(phrase);
        System.out.println(result);
    }

    public String toJadenCase(String phrase) {

        if (phrase == null || phrase.isEmpty()){
            return null;
        }

        int start = 0;
        StringBuilder result = new StringBuilder(phrase);

        for (int i = 0; i < phrase.length(); i++) {
            char c = phrase.charAt(i);

            if (c == ' ' || i == phrase.length() - 1) {
                result.setCharAt(start, Character.toUpperCase(phrase.charAt(start)));
                start = i + 1;
            }
        }
        return result.toString();
    }

}

