class NeedleInHayStack {
    public int strStr(String haystack, String needle) {
        
        if(needle == null || needle.isEmpty())
            return 0;
        int hashOfneedle = needle.hashCode();
        for(int i=0;i<haystack.length()-needle.length()+1;i++) {
            if(hashOfneedle == haystack.substring(i,i+needle.length()).hashCode()){
                boolean equal = true;
                for(int j=i,k=0;k<needle.length();j++,k++){
                   if(haystack.charAt(j) != needle.charAt(k)){
                       equal = false;
                       break;
                   }
                }
                if(equal)
                    return i;
            }
                
        }
        return -1;
    }
}
