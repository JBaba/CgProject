package Test;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class TrapWater3D {

    //https://stackoverflow.com/questions/21818044/the-maximum-volume-of-trapped-rain-water-in-3d

    /*
        Let PQ be a priority-queue which always pops the cell of lowest elevation
        Let Closed be a boolean array initially set to False
        Let Volume = 0
        Add all the border cells to PQ.
        For each border cell, set the cell's entry in Closed to True.
        While PQ is not empty:
            Select the top cell from PQ, call it C.
            Pop the top cell from PQ.
            For each neighbor N of C:
                If Closed(N):
                    Continue
                If Elevation(N)<Elevation(C):
                    Volume += (Elevation(C)-Elevation(N))*Area
                    Add N to PQ, but with Elevation(C)
                Else:
                    Add N to PQ with Elevation(N)
            Set Closed(N)=True
    */

    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        int[][] a = {
                {1,3,3,1,3,1},
                {3,0,1,3,0,4},
                {3,0,1,3,0,4},
                {1,3,3,0,2,1}
        };
        run(a,"5");
    }

    static void run(int[][] a,String ex){
        int[] val = {0};
        calBorder(a);
        System.out.println(ex+":a:"+val[0]);
    }

    private static void calBorder(int[][] ary) {
        PriorityQueue<Cell> q = new PriorityQueue<Cell>();
        int row = ary.length;
        int col = ary[0].length;
        boolean[][] closed = new boolean[row][col];
        int vol = 0;
        for(int i=0;i<row;i++){
            closed[i][0] = true;
            closed[i][col-1] = true;
            q.add(new Cell(ary[i][0],i,0));
            q.add(new Cell(ary[i][col-1],i,col-1));
        }
        for(int i=0;i<col;i++){
            closed[0][i] = true;
            closed[row-1][i] = true;
            q.add(new Cell(ary[0][i],0,i));
            q.add(new Cell(ary[row-1][i],row-1,i));
        }
        printAry(ary,closed);
        while (!q.isEmpty()){
            Cell c = q.poll();
            List<Cell> ns = getNeighbors(c,ary);
            boolean change = false;
            for(Cell n:ns){
                if(closed[n.i][n.j])
                    continue;
                if(elevation(n,ary)<elevation(c,ary)){
                    vol+=elevation(c,ary)-elevation(n,ary);
                    ary[n.i][n.j]=elevation(c,ary);
                    change = true;
                }
                q.add(new Cell(ary[n.i][n.j],n.i,n.j));
                closed[n.i][n.j]=true;
                if(change) {
                    printAry(ary,closed);
                }
            }
        }
        System.out.println("vol:"+vol);
    }

    private static void printAry(int[][] ary,boolean[][] closed) {
        for(int i=0;i<ary.length;i++){
            for(int j=0;j<ary[i].length;j++){
                System.out.print(ary[i][j]+",");
            }
            System.out.print("   ");
            for(int j=0;j<ary[i].length;j++){
                if(closed[i][j])
                    System.out.print("T,");
                else
                    System.out.print("F,");
            }
            System.out.println();
        }
        System.out.println("--------------");
    }

    private static int elevation(Cell n, int[][] ary) {
        return ary[n.i][n.j];
    }

    private static List<Cell> getNeighbors(Cell c, int[][] ary) {
        List<Cell> n = new ArrayList<Cell>();
        int[] x = {0,1,0,-1};
        int[] y = {1,0,-1,0};
        int rows = ary.length;
        int cols = ary[0].length;
        for(int r=0;r<x.length;r++) {
            int _x = c.i + x[r];
            int _y = c.j + y[r];
            if (_x > -1 && _x < rows && _y > -1 && _y < cols) {
                n.add(new Cell(ary[_x][_y],_x,_y));
            }
        }
        return n;
    }

}

class Cell implements Comparable<Cell>{
    public int i,j;
    public int val;
    public Cell(int val,int i,int j){
        this.val=val;
        this.i=i;
        this.j=j;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "i=" + i +
                ", j=" + j +
                ", val=" + val +
                '}';
    }

    public int compareTo(Cell o) {
        return val-o.val;
    }
}
