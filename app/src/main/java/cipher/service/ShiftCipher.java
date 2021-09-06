package cipher.service;

import java.util.HashMap;
import java.util.Map;

public class ShiftCipher implements Cipher {
    private int shiftValue;

    // maps to switch between character and associated number
    static Map<Character, Integer> charToNum = new HashMap<>();
    static Map<Integer, Character> numToChar = new HashMap<>();

    static {
        for (int i=0; i<26; i++) {
            int asciiCode = 65+i;
            Character charCode = (char) asciiCode;
            System.out.println("setting up maps for " + charCode.toString());

            charToNum.put(charCode, i);
            numToChar.put(Integer.valueOf(i), charCode);
        }
    }

    public ShiftCipher(int amountToShiftBy) {
        shiftValue = amountToShiftBy;
    }

    @Override
    public String encode(String stringToEncode) {
        String encoded = "";

        for (int i=0; i<stringToEncode.length(); i++) {
            int currentCode = charToNum.get(stringToEncode.charAt(i));
            int shiftedCode = shiftCharacter(currentCode);
            Character newChar = numToChar.get(shiftedCode);
            encoded += newChar;
        }

        return encoded;
    }

    @Override

    public String decode(String val) {
        String decoded = "";

        for (int i=0; i<val.length(); i++) {
            int currentCode = charToNum.get(val.charAt(i));
            int shiftedCode = unShiftCharacter(currentCode);
            Character newChar = numToChar.get(shiftedCode);
            decoded += newChar;
        }
        return decoded;
    }

    private int shiftCharacter(int code) {
        int shiftedValue = code + shiftValue;
        if (shiftedValue > 25) {
            shiftedValue = shiftedValue - 25 - 1;
        }

        return shiftedValue;
    }

    private int unShiftCharacter(int code) {
        int shiftedValue = code - shiftValue;
        if (shiftedValue < 0) {
            shiftedValue = 25 + shiftedValue + 1;
        }

        return shiftedValue;
    }
}
