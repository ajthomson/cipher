package cipher.service;

public interface Cipher {

    String encode(String stringToEncode);
    String decode(String stringToDecode);
}
