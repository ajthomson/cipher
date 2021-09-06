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
            encodedString += (char)shiftValue(stringToEncode.charAt(i));
        }
        return encodedString;
    }

    @Override
    public String decode(String stringToDecode) {
        String decodedString = "";

        for (int i=0; i<stringToDecode.length(); i++) {
            decodedString += (char)unshiftValue(stringToDecode.charAt(i));
        }
        return decodedString;
    }

    private int shiftValue(int val) {
        // shift letter by configured value
        int shiftedValue = val + shift;

        // if we go past Z, rotate and add remaining
        if (shiftedValue > 'Z') {
            shiftedValue = ('A' - 1) + (shiftedValue - 'Z');
        }

        return shiftedValue;
    }

    private int unshiftValue(int val) {
        // shift letter back by configured value
        int shiftedValue = val - shift;

        // if we go past A, go back from Z
        if (shiftedValue < 'A') {
            shiftedValue = ('Z' + 1) - ('A' - shiftedValue);
        }

        return shiftedValue;
    }

}
