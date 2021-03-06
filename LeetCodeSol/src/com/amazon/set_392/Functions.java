package com.amazon.set_392;

public class Functions {

    /**
     * Checks if given number is a power of two using bitwise and
     *
     * @param number
     *            The number
     * @throws IllegalArgumentException
     *             Thrown if given number is negative
     * @return True if number is power of 2 otherwise false
     */
    public static boolean isPowerOfTwo(long number) {
        if (number < 0) {
            throw new IllegalArgumentException("number: " + number
                                               + ". Number cannot be nea" + "gative.");
        }
        if ((number & -number) == number) {
            return true;
        }
        return false;
    }

    /**
     * Computes the log base 2 of a number
     *
     * @param num
     *            The number
     * @return The log base 2 of a number
     */
    public static int log2(long num) {
        return (int) (Math.log(num) / Math.log(2));
    }

    /**
     * Gets the long value of a text field
     *
     * @param textField
     *            a text field
     * @return a long representation of the value of the text field
     */
    public static long getLongValue(String textField) {
        return Long.parseLong(textField);
    }
}