// Last updated: 9/3/2025, 10:47:38 AM
class Solution {
    public double average(int[] salary) {
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        int sum=0;
        for(int sal:salary){
            if(sal>max) max=sal;
            if(sal<min)  min=sal;
             sum+=sal;
        }
        return (double)(sum-min-max)/(salary.length-2);
        
    }
}