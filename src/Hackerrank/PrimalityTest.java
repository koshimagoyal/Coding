package Hackerrank;

import java.math.BigInteger;
import java.util.Scanner;

public class PrimalityTest {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        BigInteger a = sc.nextBigInteger();
        System.out.println(a.isProbablePrime(1)?"prime":"not prime");
    }
}
