class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        int count=0;
        for(int i=0;i<stones.length();i++){
            for(int j=0;j<jewels.length();j++){
                if(stones.charAt(i)==jewels.charAt(j)) count++;
                }
                
            }
            return count;
        }
}

        /*HashSet <Character> set=new HashSet<>();
        for(char j : jewels.toCharArray()){
            set.add(j);
        }
        int count = 0;
        for(char s: stones.toCharArray()){
            if(set.contains(s)){
                count++;
            }
        }
        return count;
    }
}*/

