// Last updated: 9/3/2025, 10:47:44 AM
class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxcandy=0;
        for(int candy:candies){
            maxcandy=Math.max(maxcandy,candy);
        }
       List  <Boolean> result = new ArrayList<>();
        for (int candy : candies) {
            if (candy + extraCandies >= maxcandy) {
                result.add(true);
            } else {
                result.add(false);
            }
        }
            return result;
        
    }
    }