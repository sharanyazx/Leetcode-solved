class Solution {
    public boolean isNumber(String s) {
        if (s == null || s.isEmpty())  return false;
        else if(s.contains("Infinity")) return false;
        else if(s.contains("f")|| s.contains("D")) return false;
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}