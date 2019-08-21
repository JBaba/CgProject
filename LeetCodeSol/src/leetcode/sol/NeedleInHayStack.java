class NeedleInHayStack {
    
    //there is a small possibility that two strings' hashes are equal but they are not same. 
    //There is no perfect hashing. So we need to check they are equal.
    //Since the test cases do not include such a scenario it works.
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
