# Cipher Exercise
To run:

```
./gradlew run --args "METHOD STRING SHIFT"

METHOD should be encode or decode
STRING is the string to be encoded/decoded
SHIFT is the number of places to shift by

e.g

./gradlew run --args "encode HELLO 3"
```

There is limited parsing of the command line arguments.

## Run tests
`./gradlew test` should run the tests with output like the following:

```
> Task :app:test

ShiftCipherTest > Z shifted by 5 rotates to E PASSED

ShiftCipherTest > Ensure KHOOR decodes to HELLO with shift of 3 PASSED

ShiftCipherTest > Z shifted by 1 rotates to A PASSED

ShiftCipherTest > Shift of mid level letter causing to move past Z rotates PASSED

ShiftCipherTest > HELLO with shift of 3 is encoded to KHOOR PASSED

ShiftCipherTest > C with a shift of 5 is decoded to X PASSED

ShiftCipherTest > A with a shift of 3 is encoded to D PASSED

ShiftCipherTest > D with a shift of 3 is decoded to A PASSED

BUILD SUCCESSFUL in 1s
3 actionable tasks: 1 executed, 2 up-to-date
```