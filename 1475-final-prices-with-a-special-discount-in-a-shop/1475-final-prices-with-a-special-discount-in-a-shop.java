class Solution {
    public int[] finalPrices(int[] prices) {
                int n=prices.length;
        int[] result = new int[n];
        
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++) {
            result[i] = prices[i];
        }
        for(int i=0;i<n;i++) {
            while(!st.isEmpty() && prices[i] <= prices[st.peek()]) {
                result[st.peek()] -= prices[i];
                st.pop();
            }
            st.push(i);
        }
        
        return result;
    }
}