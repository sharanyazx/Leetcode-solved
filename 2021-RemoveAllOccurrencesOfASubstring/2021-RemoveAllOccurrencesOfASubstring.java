// Last updated: 9/3/2025, 10:47:10 AM
class Solution {
    public String removeOccurrences(String s, String part) {
        while (s.contains(part)) s = s.replaceFirst(part, "");
        return s;
    }
}