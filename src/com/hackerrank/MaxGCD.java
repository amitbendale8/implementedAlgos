package  com.hackerrank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MaxGCD {
    public static int maxSoFar = 1000000;


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String nStr = in.nextLine();
        int n = Integer.parseInt(nStr);
        String input1 = in.nextLine();
        String[] input1Str = input1.split(" ");
        String input2 = in.nextLine();
        String[] input2Str = input1.split(" ");
        int[] A = new int[n];
        for(int i=0;i<n;i++){
            A[i] = Integer.parseInt(input1Str[i]);

        }

        int[] B = new int[n];
        for(int i=0;i<n;i++){
            B[i] = Integer.parseInt(input1Str[i]);

        }
        int res = maximumGcdAndSum(A, B);
        System.out.println(res);

    }

    public static int maximumGcdAndSum(int[] input1,int[] input2){
        int result = 0;
        int gcd1 = 0;
        int gcd2 = 0;
        Arrays.sort(input1);
        Arrays.sort(input2);
        int[] gcds = new int[maxSoFar];
        for(int i=maxSoFar;i>1;i--){

            gcd1 = getMaxMultiplier(input1,0,input1.length-1,i-1);

            gcd2 = getMaxMultiplier(input1,0,input2.length-1,i-1);

            if(gcd1 > 0 && gcd2 > 0){
                result = gcd1+gcd2;
                break;
            }
            gcd1 = 0;
            gcd2 = 0;

        }
        return result;
    }
    public static int getMaxMultiplier(int[] input,int start,int end,int n){
        int result = 0;
        int current = 0;
        if(start > end){

                result = 0;

        }else{
            int m = (start+end)/2;
            int r = 0;
            int l = 0;
            if(input[m]%n == 0 ){
                    current = input[m];
            }
            l = getMaxMultiplier(input, start, m - 1, n);
            r = getMaxMultiplier(input, m + 1, end, n);
            result= maxOf(l,r,current);


        }
        return result;
    }


    public static int maxOf(int a,int b,int c){
        int max = a;
        if(b>max){
            max = b;
        }
        if(c>max){
            max=c;
        }

        return max;
    }
}
