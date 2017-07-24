/**
 * Find the next lucky number.
 * Lucky number is sum of first 3 digit = last 3 digit in 6 digit number.
 */
package com.hackerrank;

public class NextLuckyNumber {
    public static  void main(String args[]){
        int n = 555555;
        findNextLucky(n);
    }

    public static int findNextLucky(int input){
        boolean result = false;
        int lenght = 6;
        while(!result && lenght == 6){
            result = checkLuckyNess(++input);
            lenght = String.valueOf(input).length();
        }
        return input;
    }

    public static boolean checkLuckyNess(int input){
        boolean result = false;
        int[] digits = new int[6];
        int i = 5;
        while(input > 0){
            digits[i] = input%10;
            input = input/10;
            i--;
        }
        int sumL = digits[0] + digits[1] + digits[2];
        int sumR = digits[3] + digits[4] + digits[5];
        if(sumL == sumR){
            result = true;
        }

        return result;
    }
}
