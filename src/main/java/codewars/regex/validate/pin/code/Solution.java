package codewars.regex.validate.pin.code;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// https://www.codewars.com/kata/55f8a9c06c018a0d6e000132/train/java

// ATM machines allow 4 or 6 digit PIN codes and PIN codes cannot contain anything but exactly 4 digits or exactly 6 digits.
//
//If the function is passed a valid PIN string, return true, else return false.

public class Solution {

    public static boolean validatePin(String pin) {
        if (!(pin.length() == 4 || pin.length() == 6)) {
            return false;
        }
        return pin.matches("\\d+");
    }

    @Test
    public void validPins() {
        assertEquals(true, Solution.validatePin("1234"));
        assertEquals(true, Solution.validatePin("0000"));
        assertEquals(true, Solution.validatePin("1111"));
        assertEquals(true, Solution.validatePin("123456"));
        assertEquals(true, Solution.validatePin("098765"));
        assertEquals(true, Solution.validatePin("000000"));
        assertEquals(true, Solution.validatePin("090909"));
    }

    @Test
    public void nonDigitCharacters() {
        assertEquals(false, Solution.validatePin("a234"));
        assertEquals(false, Solution.validatePin(".234"));
    }

    @Test
    public void invalidLengths() {
        assertEquals(false, Solution.validatePin("1"));
        assertEquals(false, Solution.validatePin("12"));
        assertEquals(false, Solution.validatePin("123"));
        assertEquals(false, Solution.validatePin("12345"));
        assertEquals(false, Solution.validatePin("1234567"));
        assertEquals(false, Solution.validatePin("-1234"));
        assertEquals(false, Solution.validatePin("1.234"));
        assertEquals(false, Solution.validatePin("00000000"));
    }

}
