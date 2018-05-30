package com.main.java.bsu.algorithms.rsa;

import java.math.BigInteger;
import java.util.Random;

public class PrimeNumber{

    public static BigInteger genPrime(int bits) {
        BigInteger primeNumber;

        do
            primeNumber = new BigInteger(bits, 10, new Random());
        while(!PrimeNumber.isPrime(primeNumber));

        return primeNumber;
    }

    public static boolean isPrime(int n) {
        if(n == 2){
            return true;
        }
        else if(n % 2 == 0){
            return false;
        }

        for(int i = 3; i*i <= n; i+=2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPrime(BigInteger n) {
        long value = n.longValue();

        if(value == 2) {
            return true;
        }
        else if(value % 2 == 0) {
            return false;
        }

        for(int i = 3; i*i <= value; i+=2) {
            if (value % i == 0) {
                return false;
            }
        }
        return true;
    }
}


