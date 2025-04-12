class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> a = new HashMap<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            if (!a.containsKey(key)) {
                a.put(key, new ArrayList<>());
            }
            a.get(key).add(s);
        }

        return new ArrayList<>(a.values());        
    }
}