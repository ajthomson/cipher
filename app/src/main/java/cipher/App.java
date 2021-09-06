
package cipher;

import cipher.service.Cipher;
import cipher.service.ShiftCipher;

public class App {
    public static void main(String[] args) {
        // with more time would have used a command line argument parser
        if (args.length < 3) {
            System.err.println("Usage: App <method> <string> <shift>");
            System.err.println("  e.g. App encode HELLO 4");
            System.exit(1);
        }

        final String method = args[0];
        final String value = args[1];
        final int shift = Integer.parseInt(args[2]);

        Cipher cipher = new ShiftCipher(shift);
        if ("encode".equals(method)) {
            System.out.println(cipher.encode(value));
        }
        else if ("decode".equals(method)) {
            System.out.println(cipher.decode(value));
        }
        else {
            System.err.println("Method should be encode or decode");
            System.exit(1);
        }
    }
}
