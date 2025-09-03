// Last updated: 9/3/2025, 10:46:15 AM
class Solution {
    public int minOperations(int[] nums, int k) {
        Queue<Long> pq = new PriorityQueue<>();
        int count = 0;
        for(int i = 0; i < nums.length; i++)
            pq.add((long)nums[i]);
        while(pq.size() >= 2 && pq.peek() < k){
            long s1 = pq.poll();
            long s2 = pq.poll();
            pq.add(Math.min(s1,s2) * 2 + Math.max(s1,s2));
            count++;
        }
        return count;
    }
}