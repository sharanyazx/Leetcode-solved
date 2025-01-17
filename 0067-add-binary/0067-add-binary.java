import java.math.BigInteger;

class Solution {
    public String addBinary(String a, String b) {
        BigInteger first = new BigInteger(a, 2);
        BigInteger second = new BigInteger(b, 2);
        var result = first.add(second);
        return result.toString(2);
    }
}