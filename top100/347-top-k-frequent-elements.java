/*
save to a frequency map

if sort:nlogn
if min heap: nlogk
if partial sort: amortized n
if extra space : n 
*/
class Pair{
    int num;
    int count;
    public Pair(int num, int count){
        this.num = num;
        this.count = count;
    }
}

public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        int length = nums.length;
        if (length == 0 || k == 0 || length < k) return null;
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        //frequency map
        for (int n: nums){
            frequencyMap.put(n, frequencyMap.getOrDefault(n,0)+1);
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>(new Comparator<Pair>(){
            // compare the two elements for order
            public int compare(Pair a, Pair b){
                return a.count-b.count;
            }
        });
        
        for (Map.Entry<Integer, Integer> entry: frequencyMap.entrySet()){
            Pair p = new Pair(entry.getKey(), entry.getValue());
            pq.offer(p);
            if (pq.size()>k){
                pq.poll();
            }
        }

        List<Integer> res = new ArrayList<Integer>();
        while (pq.size()>0){
            res.add(pq.poll().num);
        }
        Collections.reverse(res);
        return res;
    }
}