public class ReJaxPatternMatch {

    public static void main(String[] args) {

        System.out.println(isMatch("c*a*b","aab"));
        System.out.println(isMatch("a","aa"));
        System.out.println(isMatch("a*","aa"));
        System.out.println(isMatch(".*","ab"));
        System.out.println(isMatch("mis*is*p*.","mississippi"));

    }

    private static boolean isMatch(String p, String s) {

        if(p.isEmpty()){
            return s.isEmpty();
        }

        boolean isMatch = (!s.isEmpty() && ((s.charAt(0)==p.charAt(0)) || p.charAt(0) == '.'));

        if(p.length() >= 2 && p.charAt(1) == '*'){
            return (isMatch(p.substring(2),s)) || (isMatch && isMatch(p,s.substring(1)));
        }else {
            return isMatch && isMatch(p.substring(1),s.substring(1));
        }

    }


}
