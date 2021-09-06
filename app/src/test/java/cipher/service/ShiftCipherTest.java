package cipher.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class ShiftCipherTest {

    @Test
    @DisplayName("A with a shift of 3 is encoded to D")
    public void encodeAWithGivenShift() {

        final String expected = "D";
        Cipher cipher = new ShiftCipher(3);

        assertThat(cipher.encode("A")).isEqualTo(expected);
    }

    @Test
    @DisplayName("HELLO with shift of 3 is encoded to KHOOR")
    public void helloEncodedMatchesSpecWithGivenShift() {
        final String expected = "KHOOR";
        Cipher cipher = new ShiftCipher(3);

        assertThat(cipher.encode("HELLO")).isEqualTo(expected);

    }
}