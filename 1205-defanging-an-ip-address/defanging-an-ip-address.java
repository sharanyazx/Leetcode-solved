class Solution {
    public String defangIPaddr(String address) {
        StringBuilder res = new StringBuilder();
        res.append("");
        for (int i = 0; i < address.length(); i++) {
            if (address.charAt(i) == '.')
                res.append("[.]");
            else
                res.append(address.charAt(i));
        }
        return res.toString();
    }
}
// class Solution {
//     public String defangIPaddr(String address) {
//         String aa = address.replace(".","[.]");
//         return aa;
//     }
// }
