class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String str1=strs[0];
        String str2=strs[strs.length-1];
        int left=0,right=str1.length();
        while(left<right)
        {
          if (str1.charAt(left)==str2.charAt(left))
          {
              
              left++;
          }
            else
            {
                break;
            } 
            
        }
    
        return left==0?"":str1.substring(0,left);
    }
}