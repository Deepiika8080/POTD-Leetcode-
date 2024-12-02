class Solution { 
    boolean verifyPrefix(String word,String searchWord) {
        
        int n=searchWord.length();
        int m=word.length();
        if(m < n) {
            return false;
        }
        for(int i=0;i<n;i++) {
             char ch1 = searchWord.charAt(i);
             char ch2 = word.charAt(i);
            if(ch1 != ch2) {
                return false;
            }
        }
        return true;
    }
    public int isPrefixOfWord(String sentence, String searchWord) {
        int n=sentence.length();
        String store[] = sentence.split(" ");
        int m=store.length;
        
        char ch1 = searchWord.charAt(0);
        for(int i=0;i<m;i++) {
            String word = store[i];
            if(word.charAt(0) == ch1) {
                if(verifyPrefix(word,searchWord)) {
                    return  i+1;
                }
            }
        }
        return -1;
    }
}