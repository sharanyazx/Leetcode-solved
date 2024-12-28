class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;  
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0 && 
                (i == 0 || flowerbed[i - 1] == 0) && 
                (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                flowerbed[i] = 1; 
                count++; 
                i++; 
            }
            if (count >= n) {
                return true;
            }
        }
        return count >= n;
    }
    
}
           
           
           
           
           
            // class Solution {
//     public boolean canPlaceFlowers(int[] flowerbed, int n) {
//         int i =0;
//         int length=flowerbed.length;
//             while(n > 0 && i < length){
//                  if(flowerbed[i]==1) { 
//                     i=i+2;
//                     }
//                     else if(i==length-1 || flowerbed[i+1]==0){
//                         n--;
//                         i=i+2;
//                     }
//                     else i=1+3;

               
//                 }
//                 return n<=0;
//         }
        
//     }
    

//             // int i =0;
//             // while(n>0 && i<flowerbed.length()){
//             //      if(flowerbed[i]==1) { 
//             //         i=i+2;
//             //         }
//             //         else if(i==len-1 or flowerbed[i+1]==0){
//             //             n--;
//             //             i=i+2;
//             //         }
//             //         else i=1+3;

               
//             //     }
//             //     return n<=0;
           