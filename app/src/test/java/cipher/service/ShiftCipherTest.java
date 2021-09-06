package cipher.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class ShiftCipherTest {

    @Test
    @DisplayName("A with a shift of 3 is encoded to D")
    public void encodeAWithGivenShift() {
        Cipher cipher = new ShiftCipher(3);
        assertThat(cipher.encode("A")).isEqualTo("D");
    }

    @Test
    @DisplayName("HELLO with shift of 3 is encoded to KHOOR")
    public void helloEncodedMatchesSpecWithGivenShift() {
        final String expected = "KHOOR";
        Cipher cipher = new ShiftCipher(3);

        assertThat(cipher.encode("HELLO")).isEqualTo(expected);
    }

    @Test
    @DisplayName("Z shifted by 1 rotates to A")
    public void shiftOf1WithZRotates() {
        Cipher cipher = new ShiftCipher(1);
        assertThat(cipher.encode("Z")).isEqualTo("A");
    }

    @Test
    @DisplayName("Z shifted by 5 rotates to E")
    public void shiftRotatesUsingLargerShiftValue() {
        Cipher cipher = new ShiftCipher(5);
        assertThat(cipher.encode("Z")).isEqualTo("E");
    }

    @Test
    @DisplayName("Shift of mid level letter causing to move past Z rotates")
    public void shiftFromMidLevelLetterRotates() {
        Cipher cipher = new ShiftCipher(10);
        assertThat(cipher.encode("W")).isEqualTo("G");
    }

    @Test
    @DisplayName("D with a shift of 3 is decoded to A")
    public void basicDecodeWithGivenShift() {
        Cipher cipher = new ShiftCipher(3);
        assertThat(cipher.decode("D")).isEqualTo("A");
    }

    @Test
    @DisplayName("C with a shift of 5 is decoded to X")
    public void decodeWithRotate() {
        Cipher cipher = new ShiftCipher(5);
        assertThat(cipher.decode("C")).isEqualTo("X");
    }

    @Test
    @DisplayName("Ensure KHOOR decodes to HELLO with shift of 3")
    public void decodeReferenceString() {
        Cipher cipher = new ShiftCipher(3);
        assertThat(cipher.decode("KHOOR")).isEqualTo("HELLO");
    }

}