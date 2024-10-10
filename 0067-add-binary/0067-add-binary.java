import java.math. BigInteger;
import java.util.Scanner;
class Solution {
    public  String addBinary(String a, String b) {
   BigInteger num1 =  new BigInteger(a,2);
     BigInteger num2=new BigInteger(b,2);
      BigInteger sum=num1.add(num2);
    
   return sum.toString(2);
        
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
         String binary1=sc.nextLine();
              String binary2=sc.nextLine();
        Solution op=new Solution();
       String sum = op.addBinary(binary1,binary2);
        sc.close();
    }
}