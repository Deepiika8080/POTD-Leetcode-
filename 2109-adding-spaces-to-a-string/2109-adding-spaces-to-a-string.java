class Solution {
    public String addSpaces(String s, int[] spaces) {
        int m=s.length();
        int n=spaces.length;        
        int j=0;
      
        StringBuilder ans = new StringBuilder();
        
        for(int i=0;i<m;i++) {
            char ch = s.charAt(i);
            
            if(j < n && i == spaces[j]) {
                j++;
                ans.append(" ");
             }
            ans.append(ch);   
         
        }
        return ans.toString();
    }
}