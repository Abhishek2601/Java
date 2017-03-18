package ex.abhi;

import java.math.BigInteger;
import java.util.*;

class HelloWorld {
    static BigInteger d(BigInteger n){
        BigInteger sum = BigInteger.ZERO;
        String s = String.valueOf(n);
        for(char c : s.toCharArray()){
            int a =(int)c-48;
            sum = sum.add(BigInteger.valueOf(a));
            //System.out.println(sum);
        }
        return sum;
    }
    public static void main(String args[] ) throws Exception {
        final long b = (long) Math.pow(10, 9) + 7;

        //Scanner
        Scanner s = new Scanner(System.in);
        BigInteger MOD = BigInteger.valueOf(b);
        int N = s.nextInt();
        BigInteger []a= new BigInteger[N];
        for(int i= 0; i<N; i++){
            a[i]= s.nextBigInteger();
        }
        Arrays.sort(a);
        BigInteger sum = BigInteger.valueOf(4);
        BigInteger result = BigInteger.valueOf(0);

        result = BigInteger.ONE.multiply(d(a[0])).add(BigInteger.valueOf(2).multiply(d(a[1])));
        result = result.mod(MOD);
        for(int i = 2; i<N; i++){

            result = (result.mod(MOD).add(sum.multiply(d(a[i]).mod(MOD)).mod(MOD)));
            sum = BigInteger.valueOf(2).multiply(sum).add(BigInteger.ONE);
            System.out.println("result = "+result);
        }
        System.out.print(result);
    }

}
