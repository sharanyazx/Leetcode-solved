class Solution {
    public int sumOfTheDigitsOfHarshadNumber(int x) {
        int sum=0,n=x;
        while(n!=0){
            int rem=n%10;
            sum+=rem;
            n/=10;
        }
        return x%sum!=0 ? -1 : sum;
    }
}