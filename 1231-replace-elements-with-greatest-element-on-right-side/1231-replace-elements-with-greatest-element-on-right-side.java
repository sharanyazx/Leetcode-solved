class Solution {
    public int[] replaceElements(int[] arr) {
        if(arr.length == 1){
            arr[0] = -1;
            return arr;
        }
        int max = arr[arr.length - 1];
        arr[arr.length - 1] = -1;

        for(int i = arr.length-2; i>=0; i--){
            int current = arr[i];
            arr[i] = max;
            max = Math.max(max, current);
        }
        return arr;
    }
}