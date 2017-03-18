package ex.abhi.HackerEarthChallengbe;

import java.util.*;

/*

Alice and Bob are playing a game in which Bob gives a string
S
S of length
N
N consisting of lowercase English alphabets to Alice and ask her to calculate the number of sub-strings of this string which contains exactly
3
3 vowels.

There will be
T
T test cases in the input and output the answer for each test case in a new line.

Sample Input:

The first line contains a single integer
T
T. Each test case will consist of two lines, first line containing length of string and second line will contain the string.

Sample Output: :

Print the answer for each test case in a new line.

 */



class VowelsCount {
    static boolean vowel(char c){
        switch(c){
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                return true;
            default:
                return false;
        }
    }
    public static void generateSubString(String s,int n){
        int count =0;
        for(int c = 0; c<n; c++){
            int noOfVowles = 0;
            for(int i = 1; i<=n-c; i++){
                //System.out.println(count);
                //String sub = s.substring(c,c+i);
                if(vowel(s.charAt(c+i-1))){
                    noOfVowles ++;
                }
                if(noOfVowles == 3)
                    count ++;
                if(noOfVowles > 3){
                    break;
                }
            }
        }
        System.out.println(count);
    }
    public static void main(String args[] ) throws Exception {
        //Scanner
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        for (int i = 0; i < T; i++) {
            int N = s.nextInt();
            String st = s.next();
            generateSubString(st,N);
        }
    }
}
