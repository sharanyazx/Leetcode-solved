class Solution {
    public String frequencySort(String s) {
        int freqC[] = new int[128];
        for(char ch : s.toCharArray()){
            freqC[ch]++;
        }

        StringBuilder st = new StringBuilder();
        for(int i=0;i<s.length();i++){
            int max=freqC[0];
            int max_I=0;
            for(int j=1;j<128;j++){
                if(max < freqC[j]){
                    max=freqC[j];
                    max_I=j;
                }
            }
            for(int k=0; k<max; k++){
                st.append((char)max_I);
            }
            freqC[max_I]=0;
        }
        return st.toString();
    }
}


