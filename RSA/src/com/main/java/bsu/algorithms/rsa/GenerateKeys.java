package com.main.java.bsu.algorithms.rsa;

import java.math.BigInteger;
import java.util.Random;

public class GenerateKeys {

    private BigInteger p,q;
    private BigInteger m,n;
    private BigInteger e,d;

    public BigInteger getP() {
        return this.p;
    }

    public BigInteger getQ() {
        return this.q;
    }

    public BigInteger getM() {
        return this.m;
    }

    public BigInteger getN() {
        return this.n;
    }

    public BigInteger getE() {
        return this.e;
    }

    public BigInteger getD() {
        return this.d;
    }

    public GenerateKeys(int bits) {
        this.p = PrimeNumber.genPrime(bits);
        do
            this.q = PrimeNumber.genPrime(bits);
        while(this.q.compareTo(this.p) == 0);

        this.m = this.p.multiply(this.q);
        this.n = this.p.subtract(BigInteger.ONE).multiply(this.q.subtract(BigInteger.ONE));

        do
            this.e = new BigInteger(bits-4, new Random());
        while(this.e.compareTo(this.n) != -1 || this.e.gcd(this.n).compareTo(BigInteger.ONE) != 0);

        this.d = e.modInverse(this.n);
    }

    public GenerateKeys(BigInteger p, BigInteger q) {
        this.p = p;
        this.q = q;
        this.m = this.p.multiply(this.q);
        this.n = this.p.subtract(BigInteger.ONE).multiply(this.q.subtract(BigInteger.ONE));

        do
            this.e = new BigInteger(15, new Random());
        while(this.e.compareTo(this.n) != -1 || this.e.gcd(this.n).compareTo(BigInteger.ONE) != 0);

        this.d = e.modInverse(this.n);
    }

    public GenerateKeys(BigInteger p, BigInteger q, BigInteger e) {
        this.p = p;
        this.q = q;
        this.e = e;
        this.m = this.p.multiply(this.q);
        this.n = this.p.subtract(BigInteger.ONE).multiply(this.q.subtract(BigInteger.ONE));
        this.d = e.modInverse(this.n);
    }
}

