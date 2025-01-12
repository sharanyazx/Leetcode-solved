class Solution {
    public String defangIPaddr(String address) {
        String aa = address.replace(".","[.]");
        return aa;
    }
}