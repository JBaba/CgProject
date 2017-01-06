package leetcode.sol.One_1_to_20;

public class N_14 {

	public static String findLongestCommonPrefix(String... values) {
        if (values == null) {
            return null;
        }
        //find shortest string
        int shortestIndex = 0, len = Integer.MAX_VALUE;
        for (int i = 0; i < values.length; i++) {
            if (values[i].length() < len) {
                len = values[i].length();
                shortestIndex = i;
            }
        }
        //iterate thru shortest string and try to find prefixes in the rest of the array
        for (int i = 0; i < values.length; i++) {
            if (i == shortestIndex) {
                continue; //skip same
            }
            int newLength = len;
            while (!values[i].startsWith(values[shortestIndex].substring(0, newLength)) && newLength > 0) {
                newLength--;
                len = newLength;
            }
        }
        return values[shortestIndex].substring(0, len);
    }
	
	public static String findLongestCommonSufix(String... values) {
        if (values == null) {
            return null;
        }
        //find shortest string
        int shortestIndex = 0, len = Integer.MAX_VALUE;
        for (int i = 0; i < values.length; i++) {
            if (values[i].length() < len) {
                len = values[i].length();
                shortestIndex = i;
            }
        }
        //iterate thru shortest string and try to find prefixes in the rest of the array
        for (int i = 0; i < values.length; i++) {
            if (i == shortestIndex) {
                continue; //skip same
            }
            int newLength = len;
            while (!values[i].endsWith(values[shortestIndex].substring(values[shortestIndex].length()-newLength, values[shortestIndex].length())) && newLength > 0) {
                newLength--;
                len = newLength;
            }
        }
        return values[shortestIndex].substring(values[shortestIndex].length()-len, values[shortestIndex].length());
    }
	
	public static void main(String[]  args){
		 System.out.println(N_14.findLongestCommonPrefix("Hello", "HelloMan", "Hellio", "Hellan","Hellooooou"));
		 System.out.println(N_14.findLongestCommonPrefix("Monterrey", "MonteOlivos", "Montgomery", "Montreal","Montar"));
		 System.out.println("--------------");
		 System.out.println(N_14.findLongestCommonSufix("olleh", "namolleh", "oilleh", "anolleh","uooooolleh"));
		 System.out.println(N_14.findLongestCommonSufix("Monterrey", "MonteOlivos", "Montgomery", "Montreal","Montar"));
	}
	
}
