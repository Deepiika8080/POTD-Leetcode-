class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] count = new int[26];
        
        int n=s.length();
        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }
        
        StringBuilder result = new StringBuilder();
        PriorityQueue<Character> pq = new PriorityQueue<>((a,b) -> b-a);
        
        for(int i=0;i<26;i++) {
            if(count[i] > 0) {
               pq.offer((char)('a'+i));
            }       
        }
        
        while(!pq.isEmpty()) {
           char ch =  pq.poll();
            
            int freq = Math.min(count[ch-'a'] , repeatLimit);
            
            for(int i=0;i<freq;i++) {
                result.append(ch);
            }
            
            count[ch-'a'] -= freq;
            
            if( count[ch-'a'] > 0 && !pq.isEmpty()) {
                char nextChar = pq.poll();
                 result.append(nextChar);
                 count[nextChar-'a']--;
                if(count[nextChar-'a'] > 0) {
                   
                    pq.offer(nextChar);
                }
                  pq.offer(ch);
            }
           
        }
        return result.toString();
    }
}