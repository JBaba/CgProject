public class ShortestPalindrome {

    /**
    
    shortestPalindrome("bubble")
    // "elbbubble"
    
    shortestPalindrome(poppa)
    // appoppa
    
    01. We can look to find the existing palindrome, in this case pop.
    02. Notice the last line, that'll give us the ending of the palindrome that already exists. Once we know that, 
        the next step is easy-- just recursively add the remaining letters to the front!
        
    // recursively rebuild palindrome
    palindromeEnd.split().reverse().join()   // the end reversed
      + shortestPalindrome(s.substr(0, j))   // just the existing palindrome
      + palindromeEnd;   // leave the end
    
    **/

    public static void main(String[] args) {
        String s = "bubble";
        System.out.println(shortestPalindrome(s));
    }

    static String shortestPalindrome(String s){

        int j=0;

        for(int i=s.length()-1;i>=0;i--){
            char c1 = s.charAt(i);
            char c2 = s.charAt(j);
            if(c1==c2)
                j++;
        }

        System.out.println(s.substring(0,j));

        if(j == s.length())
            return s;

        String end = s.substring(j);

        System.out.println(end);

        return new StringBuilder(end).reverse().toString() + shortestPalindrome(s.substring(0,j)) + end;
    }

}
