public class FindPathInTheArrayUsingAllFourDirection {

    static int[] x = {0,1,0,-1};
    static int[] y = {1,0,-1,0};

    public static void main(String[] args) {

        test1();
        test2();
        test3();
        test4();
    }

    private static void test1() {
        int[][] a = {
                {1,1,0,1,1,1},
                {1,0,1,1,0,1},
                {1,1,1,0,1,1},
                {1,1,1,0,1,0},
                {1,1,1,0,1,1}
        };
        run(a,"16");
    }

    private static void test2() {
        int[][] a = {
                {1,1,0,1,1,1},
                {0,0,1,1,0,1},
                {1,1,1,0,1,1},
                {1,1,1,0,1,0},
                {1,1,1,0,1,1}
        };
        run(a,"No");
    }

    private static void test3() {
        int[][] a = {
                {1,0,1,1,1,0},
                {1,0,1,0,1,0},
                {1,0,1,0,1,0},
                {1,0,1,0,1,0},
                {1,1,1,0,1,1}
        };
        run(a,"18");
    }

    private static void test4() {
        int[][] a = {
                {1,1,0,1,1,1},
                {1,0,1,1,0,1},
                {1,10,1,0,1,1},
                {1,1,1,0,1,0},
                {1,1,1,0,1,1}
        };
        run(a,"18");
    }

    static void run(int[][] a,String ex){
        int[] minVal = {Integer.MAX_VALUE};
        boolean[][] visited = new boolean[a.length][a[0].length];
        int[][] memory = new int[a.length][a[0].length];
        initMaxMemory(memory);
        visited[0][0] = true;
        memory[0][0]=a[0][0];
        cal(a,visited,memory,0,0,4,5,minVal);
        System.out.println(ex+":a:"+minVal[0]);
    }

    static void cal(int[][] a,boolean[][] visited,int[][] memory,int i,int j,int p,int q,int[] minVal){

//        printMatrix(a,visited);
        printMatrix(memory,visited);

        if(i==p && j==q){
            visited[p][q]=true;
            a[p][q] = findMin(a,visited,p,q);
//            minVal[0] = Math.min(a[p][q]+1,minVal[0]);
            minVal[0] = Math.min(memory[i][j],minVal[0]);
        }
        int rows = a.length;
        int cols = a[0].length;

        for(int r=0;r<x.length;r++){
            int _x = i+x[r];
            int _y = j+y[r];
            if(_x>-1 && _x<rows && _y>-1 && _y<cols){
                if(!visited[_x][_y] && a[_x][_y]>0){
                    visited[_x][_y] = true;
//                    a[_x][_y] += a[i][j];
                    memory[_x][_y] = Math.min(memory[i][j]+a[_x][_y],memory[_x][_y]);
//                    a[_x][_y] += findMin(a,visited,_x,_y);
                    cal(a,visited,memory,_x,_y,p,q,minVal);
                    visited[_x][_y] = false;
                }
            }
        }

//        int right = j+1;
//        if(right<cols && !visited[i][right] && a[i][right]>0){
//            visited[i][right]=true;
//            a[i][right]+=findMin(a,visited,i,right);
//            cal(a,visited,i,right,p,q,minVal);
//            visited[i][right]=false;
//        }
//
//        int down = i+1;
//        if(down<rows && !visited[down][j] && a[down][j]>0){
//            visited[down][j]=true;
//            a[down][j]+=findMin(a,visited,down,j);
//            cal(a,visited,down,j,p,q,minVal);
//            visited[down][j]=false;
//        }
//
//        int up = i-1;
//        if(up>-1 && !visited[up][j] && a[up][j]>0){
//            visited[up][j]=true;
//            a[up][j]+=findMin(a,visited,up,j);
//            cal(a,visited,up,j,p,q,minVal);
//            visited[up][j]=false;
//        }
//
//        int left = j-1;
//        if(left>-1 && !visited[i][left] && a[i][left]>0){
//            visited[i][left]=true;
//            a[i][left]+=findMin(a,visited,i,left);
//            cal(a,visited,i,left,p,q,minVal);
//            visited[i][left]=false;
//        }
    }

    static void initMaxMemory(int[][] a){
        for(int i=0;i<a.length;i++) {
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = Integer.MAX_VALUE;
            }
        }
    }
    static void printMatrix(int[][] a,boolean[][] v){
        StringBuffer sb = new StringBuffer();
        boolean _morethenX = false;
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[i].length;j++){
                if(a[i][j]>99)
                    _morethenX = true;
                sb.append(String.format("%3d",a[i][j]));
                sb.append(String.format("%2s",(v[i][j]?":T":":F")));
//                System.out.printf("%5d",a[i][j]);
//                System.out.printf("%2s",(v[i][j]?":T":":F"));
            }
            sb.append("\n");
//            System.out.println();
        }
        sb.append("\n--------------");
        if(!_morethenX)
            System.out.println(sb.toString());
    }

    static int findMin(int[][] a,boolean[][] visited,int p,int q){
        boolean wayfound = false;
        int rows = a.length;
        int cols = a[0].length;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<x.length;i++){
            if((p+x[i])<rows && (p+x[i])>-1 && (q+y[i])<cols && (q+y[i])>-1
                    && visited[p+x[i]][q+y[i]]){
                wayfound = true;
                min = Math.min(min,a[p+x[i]][q+y[i]]);
            }
        }
        if(!wayfound)
            throw new RuntimeException("Not reachable");
        return min;
    }
}
