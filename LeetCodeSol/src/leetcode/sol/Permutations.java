public class Permutations {

    public static void main(String[] args) {

        String a = "abc";

        combo(a.toCharArray(),0);

    }

    private static void combo(char[] a, int s) {
        if(s==a.length) {
            System.out.println(new String(a));
            return;
        }
        for(int i=s;i<a.length;i++){
            swap(a,s,i);
            combo(a,s+1);
            swap(a,s,i);
        }
    }

    private static void swap(char[] a, int s, int i) {
        char c = a[s];
        a[s] = a[i];
        a[i] = c;
    }

}
