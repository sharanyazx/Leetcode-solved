class Solution {
    public boolean isPerfectSquare(int num) {
     
     double decimalval= Math.sqrt(num);
     int roundfig =(int) Math.sqrt(num);
     
     if(roundfig<decimalval  || roundfig>decimalval)
     {
        return false;
     }  

  return true;  }
}