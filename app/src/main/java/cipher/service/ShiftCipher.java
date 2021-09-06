package cipher.service;

public class ShiftCipher implements Cipher {
    private int shift;

    public ShiftCipher(int valueToShift) {
        shift = valueToShift;
    }

    @Override
    public String encode(String stringToEncode) {
        return null;
    }

    @Override
    public String decode(String stringToDecode) {
        return null;
    }
}
