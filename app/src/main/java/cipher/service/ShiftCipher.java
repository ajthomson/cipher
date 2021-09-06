package cipher.service;

import com.google.common.base.Joiner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ShiftCipher implements Cipher {
    private int shiftValue;

    // maps to switch between character and associated number
    static Map<Character, Integer> charToNum = new HashMap<>();
    static Map<Integer, Character> numToChar = new HashMap<>();

    static {
        for (int i=0; i<26; i++) {
            int asciiCode = 65+i;
            Character charCode = (char) asciiCode;
            charToNum.put(charCode, i);
            numToChar.put(Integer.valueOf(i), charCode);
        }
    }

    public ShiftCipher(int amountToShiftBy) {
        shiftValue = amountToShiftBy;
    }

    @Override
    public String encode(String stringToEncode) {
        List<Character> res = stringToEncode.chars().boxed()  // stream
                .map(ch -> charToNum.get((char)ch.intValue()))
                .map(code -> shiftCharacter(code))
                .map(code -> numToChar.get(code))
                .collect(Collectors.toList());

        return Joiner.on("").join(res);
    }

    @Override
    public String decode(String stringToDecode) {
        List<Character> res = stringToDecode.chars().boxed()  // stream
                .map(ch -> charToNum.get((char)ch.intValue()))
                .map(code -> unShiftCharacter(code))
                .map(code -> numToChar.get(code))
                .collect(Collectors.toList());

        return Joiner.on("").join(res);
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
