// Last updated: 9/3/2025, 10:47:47 AM
class ProductOfNumbers {

    List<Integer> list;

    public ProductOfNumbers() {
        list = new ArrayList<>();
    }
    
    public void add(int num) {
        if (num == 0) {
            list.clear();
        } else {
            if (list.size() == 0) {
                list.add(num);
            } else {
                list.add(list.get(list.size() - 1) * num);
            }
        }
    }
    
    public int getProduct(int k) {
        int size = list.size();
        if (k > size) {
            return 0;
        } else if (k == size) {
            return list.get(size - 1);
        } else {
            return list.get(size - 1) / list.get(size - 1 - k);
        }
    }
}