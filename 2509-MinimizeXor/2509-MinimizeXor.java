// Last updated: 9/3/2025, 10:46:41 AM
class Solution {
    
    public int findSetBits(int num2) {
        int counter = 0;
        while (num2 != 0) {
            num2 = (num2 & (num2 - 1));
            counter++;
        }
        return counter;
    }

    public int minimizeXor(int num1, int num2) {
        int numSetBits = findSetBits(num2);
        int result = 0;
        
        for (int i = 31; i >= 0; i--) {
            if ((num1 & (1 << i)) != 0 && numSetBits > 0) {
                result |= (1 << i);
                numSetBits--;
            }
        }
        
        int index = 0;
        while (numSetBits > 0) {
            if ((result & (1 << index)) == 0) {
                result |= (1 << index);
                numSetBits--;
            }
            index++;
        }
        
        return result;
    }
}