package cipher.service;

public class ShiftCipher implements Cipher {
    private int shift;

    public ShiftCipher(int valueToShift) {
        shift = valueToShift;
    }

    @Override
    public String encode(String stringToEncode) {
        String encodedString = "";

        for (int i=0; i<stringToEncode.length(); i++) {
            encodedString += (char)shiftValue((int)stringToEncode.charAt(i));
        }
        return encodedString;
    }

    @Override
    public String decode(String stringToDecode) {
        return null;
    }

    private int shiftValue(int val) {
        return val + shift;
    }
}
