import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LibClassTest {

    @Test
    void isPrimeSingleDataPoint() {
        int number = 3;
        boolean gt = true;

        // create an instance of LibClass
        LibClass libClass = new LibClass();
        boolean result = libClass.isPrime(number);

        // testing with a single data point using the assertEquals method
        assertEquals(gt, result); // this test will pass by chance
    }

    @Test
    void isPrimeMultipleDataPoints() {
        // create an instance of LibClass
        LibClass libClass = new LibClass();

        // testing with two data points <3, gt: true> and <4, gt: false>
        assertEquals(true, libClass.isPrime(3));
        assertEquals(false, libClass.isPrime(4));
    }

    @Test
    void isPrimeMultipleDataPointsArray() {

        // create an instance of LibClass
        LibClass libClass = new LibClass();

        // TODO: complete this step: test with multiple data points in an array
        // 1. create an array of int with these numbers: [2, 3, 5, 11, 19, 20, 28]; name it numbers
        // 2. create an array of boolean with gts: [true, true, true, true, true, false, false]; name it gts
        // 3. create an array of output from the isPrime(.) function; name it outputs
        // 4. finally compare the gts against the outputs using assertArrayEquals(gts, outputs)

        // implementation (worked out)
        int[] numbers = new int[]{2, 3, 5, 11, 19, 20, 28}; // step 1
        boolean[] gts = new boolean[]{true, true, true, true, true, false, false}; // step 2

        // create an array for storing the outputs
        boolean[] outputs = new boolean[numbers.length]; // step 3

        // continuing step 3
        for(int i = 0; i < outputs.length; i++){
            outputs[i] = libClass.isPrime(numbers[i]);
        }

        // step 4
        assertArrayEquals(gts, outputs);
    }


    /**
     * Create a ParameterizedTest with ValueSource to replace arrays
     * with all prime numbers (gts)
     */

    @ParameterizedTest
    @ValueSource(ints = {2, 3, 5, 11, 19}) // filtering only prime numbers from the previous array {2, 3, 5, 11, 19, 20, 28}
    void allPrimes(int number) {
        LibClass libClass = new LibClass();
        assertEquals(true, libClass.isPrime(number));
    }

    /**
     * Add a third test using ParameterizedTest and ValueSource, with all non-prime numbers (gts)
     */
    @ParameterizedTest
    @ValueSource(ints = {20, 28})  // filtering only non-prime numbers from the previous array {2, 3, 5, 11, 19, 20, 28}
    void allNotPrimes(int number) {
        LibClass libClass = new LibClass();
        assertEquals(false, libClass.isPrime(number));
    }


    /** Documentation
     * * Available data types for @ValueSource are as follows:
     *      * short (shorts attribute)
     *      * byte (bytes attribute)
     *      * int (ints attribute)
     *      * long (longs attribute)
     *      * float (floats attribute)
     *      * double (doubles attribute)
     *      * char (chars attribute)
     *      * String (strings attribute)
     *      * Class (classes attribute)
     */

    /** Documentation
     * CSV (comma separated values) Literals
     * ground truth and actual values are separated by a comma(,)
     * E.g., value = {"true,3", "false,4", "true,5", "false,6"}
     */

    @ParameterizedTest
    @CsvSource(value = {"3, true", "4, false", "5, true", "6, false"})
    void isPrimeGTfromCSV(int input, boolean gt) {
        LibClass libClass = new LibClass();
        assertEquals(gt, libClass.isPrime(input));
    }



    @ParameterizedTest
    @CsvFileSource(resources = "/data/data_test.csv", numLinesToSkip = 1)
    void isPrimeGTfromCSVFile(int input, boolean gt) {
        LibClass libClass = new LibClass();
        assertEquals(gt, libClass.isPrime(input));
    }

        // task 1
    @ParameterizedTest
    @CsvSource(value = {"3, 3, 6", "4, 3, 7"})
    void anArbitraryFunctionTestfromCSV(int param1, int param2, int gt) {
        // instantiate the class
        // use assert equals assertEquals(gt, instance.functionToTest(param1, param2));
    }

    // task 2
    @ParameterizedTest
    @CsvFileSource(resources = "/data_test.csv", numLinesToSkip = 1)
    void anArbitraryFunctionTestfromCSVFile(int param1, int param2, int gt) {
        // instantiate the class
        // use assert equals assertEquals(gt, instance.functionToTest(param1, param2));
    }
}






















