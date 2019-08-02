package Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ShortestPathBfs {

	static int r = 0;
	static int c = 0;

	public static void main(String[] args) {
// TODO Auto-generated method stub
		int[][] path = { { 0, 1, 1, 1, 1 }, { 0, 1, 1, 0, 1 }, { 0, 0, 1, 0, 1 }, { 0, 0, 1, 1, 1 } };

		r = path.length;
		c = path[0].length;

		MNode[][] mem = new MNode[r][c];

		MNode root = new MNode(0, 1, true);
// root.path.add(root);
		mem[0][1] = root;

// MNode listpath = findSP(path,0,1,3,3,mem);
		MNode listpath = findSpBfs(path, 0, 1, 3, 3);
		System.out.println("Ans:");
		System.out.println(listpath);

		test2();
	}

	private static void test2() {
		int[][] path = { { 1, 1, 1, 1, 1 }, { 0, 1, 1, 0, 1 }, { 0, 0, 5, 0, 1 }, { 0, 0, 1, 1, 1 } };

// System.out.println(shortestPath(path, 4, 5));

		MNode listpath = findSpBfsWeighted(path, 0, 1, 3, 3);
		System.out.println("Ans2:");
		System.out.println(listpath);
		int[][] path1 = { { 0, 0, 1, 1, 1, 1 }, { 1, 1, 1, 0, 0, 1 }, { 9, 0, 5, 0, 1, 1 }, { 9, 9, 5, 1, 1, 0 },
				{ 9, 9, 5, 1, 0, 1 } };
		listpath = findSpBfsWeighted(path1, 1, 0, 3, 3);
		System.out.println("Ans2:");
		System.out.println(listpath);
	}

	private static MNode findSpBfsWeighted(int[][] m, int i, int j, int d, int e) {
		r = m.length;
		c = m[0].length;
		MNode[][] dist = new MNode[r][c];
		for (int i1 = 0; i1 < r; i1++)
			for (int j1 = 0; j1 < c; j1++) {
				dist[i1][j1] = new MNode(i1, j1, true);
				dist[i1][j1].dis = Integer.MAX_VALUE;
			}

		dist[i][j].dis = m[i][j];

		int[] xd = { -1, 0, 1, 0 };
		int[] yd = { 0, 1, 0, -1 };

		List<MNode> q = new LinkedList<>();
		q.add(dist[i][j]);

		while (!q.isEmpty()) {
			MNode top = q.remove(0);
			for (int l = 0; l < 4; l++) {
				int x = top.x + xd[l];
				int y = top.y + yd[l];

				if (!isInside(x, y, r, c) || m[x][y] == 0)
					continue;

				int dis = top.dis + m[x][y];

				if (dist[x][y].dis > dis) {
					dist[x][y].dis = dis;
					dist[x][y].path = top;
					q.add(dist[x][y]);
				}
			}
		}

		return dist[d][e];
	}

	private static MNode findSpBfs(int[][] m, int i, int j, int d, int e) {

		MNode root = new MNode(i, j, true);
		LinkedList<MNode> q = new LinkedList<>();
		q.add(root);

		while (!q.isEmpty()) {
			MNode top = q.remove(0);

			int[] dx = { 0, 0, 1, -1 };
			int[] dy = { 1, -1, 0, 0 };

			for (int l = 0; l < 4; l++) {
				int x = top.x + dx[l];
				int y = top.y + dy[l];

				if (x == d && y == e) {
					MNode end = new MNode(d, e, true);
					end.dis += top.dis;
					end.path = top;
					return end;
				}

				if (x > -1 && y > -1 && x < r && y < c && m[x][y] != 0) {
					MNode neigh = new MNode(x, y, true);
					neigh.dis += top.dis;
					neigh.path = top;
					q.add(neigh);
				}
			}

		}

		return null;
	}

	private static MNode findSP(int[][] m, int i, int j, int d, int e, MNode[][] mem) {

		if (i == d && j == e) {
			mem[i][j].isVisited = false;
			return mem[i][j].path;
		} else if (m == null) {
			return null;
		}

		int[] dx = { 0, 0, 1, -1 };
		int[] dy = { 1, -1, 0, 0 };

		for (int l = 0; l < 4; l++) {
			int x = i + dx[l];
			int y = j + dy[l];

			if (x > -1 && y > -1 && x < r && y < c && m[x][y] != 0
					&& (mem[x][y] == null || (mem[x][y].dis > mem[i][j].dis && !mem[x][y].isVisited))) {
				MNode dirnode = new MNode(x, y, true);
				dirnode.dis = 1 + mem[i][j].dis;
				dirnode.path = mem[i][j];
				System.out.println(dirnode.toString());
				mem[x][y] = dirnode;
				mem[x][y] = findSP(m, x, y, d, e, mem);
				dirnode.isVisited = false;
			}

		}

		return null;
	}

	static boolean isInside(int x, int y, int r, int c) {
		return (x >= 0 && x < r && y >= 0 && y < c);
	}

	static int shortestPath(int[][] grid, int r, int c) {
//follow similar to dijsktra's
		int[][] dist = new int[r][c];
		for (int i = 0; i < r; i++)
			for (int j = 0; j < c; j++)
				dist[i][j] = Integer.MAX_VALUE;

		dist[0][0] = grid[0][0];

		int[] xd = { -1, 0, 1, 0 };
		int[] yd = { 0, 1, 0, -1 };

		List<Cell> q = new LinkedList<>();

		q.add(new Cell(0, 0, dist[0][0]));

		while (!q.isEmpty()) {
			Cell temp = q.remove(0);

			for (int i = 0; i < 4; i++) {
				int x = temp.x + xd[i];
				int y = temp.y + yd[i];

				if (!isInside(x, y, r, c) || grid[x][y] == 0)
					continue;

				int dis = grid[x][y] + dist[temp.x][temp.y];
// System.out.println(dis);

				if (dist[x][y] > dis) {

					if (dist[x][y] != Integer.MAX_VALUE) {
						for (int z = 0; z < q.size(); z++)
							if (q.get(z).dist == dist[x][y])
								q.remove(z);
					}

					dist[x][y] = dis;
					q.add(new Cell(x, y, dist[x][y]));
				}
			}
		}

		return dist[r - 1][c - 1];
	}

}

class MNode {
	int x, y;
	int dis = 0;
	boolean isVisited;
	MNode path = null;

	public MNode(int i, int j, boolean b) {
		x = i;
		y = j;
		isVisited = true;
		dis = 1;
	}

	@Override
	public String toString() {
		return "[" + x + "," + y + ":" + dis + "]->{" + path + "}";
	}
}

class Cell {
	int x, y, dist;

	Cell(int x, int y, int d) {
		this.x = x;
		this.y = y;
		dist = d;
	}
}
