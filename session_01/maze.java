/**
 * A Maze is represented by a 0-1 matrix 𝑁 × 𝑀 in which 𝐴 𝑖, 𝑗 = 1 means that cell
 * (𝑖, 𝑗) is an obstacle, and 𝐴 𝑖, 𝑗 = 0 means that cell 𝑖, 𝑗 is an empty cell. At an empty
 * cell, we can move to one of the 4 neighboring cells if this cell is an empty cell (move
 * UP, DOWN, LEFT, RIGHT).
 * ➢ Input
 * • Line 1: contains 4 positive integers 𝑛, 𝑚, 𝑟, 𝑐 in which 𝑛 and 𝑚 are respectively
 * the number of rows and columns of 𝐴 (1 <= 𝑛, 𝑚 <= 999), 𝑟, 𝑐 are the
 * indices of row and column of the starting cell.
 * • Line 𝑖 + 1 (𝑖 = 1, … , 𝑛): contains the 𝑖𝑡ℎ of the matrix 𝐴.
 * ➢ Output
 * • Write the number of movements of the shortest path from the starting cell to
 * a cell outside the Maze (write -1 if no solution found).
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class maze {
    public static int N = 1000;
    public static int n, m, r, c ;
    public static int[][] curr = new int[N][N];
    public static int[] dx = { 0, 0, -1, 1 };
    public static int[] dy = { 1, -1, 0, 0 };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        n = Integer.parseInt(line[0]);
        m = Integer.parseInt(line[1]);
        r = Integer.parseInt(line[2])-1;
        c = Integer.parseInt(line[3])-1;
        curr = new int[n][m];
        for(int i = 0; i < n; i++){
            line = br.readLine().split(" ");
            for(int j = 0; j < m; j++){
                curr[i][j] = Integer.parseInt(line[j]);
            }
        }
        System.out.println(move());
    }

    public static int move(){
        curr[r][c] = 1;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {r, c, 0});
        while(!q.isEmpty()){
            int[] u = q.poll();
            int steps = u[2];
            for(int i = 0; i < 4; i++){
                int x = u[0] + dx[i];
                int y = u[1] + dy[i];

                if (x < 0 || x >= n || y < 0 || y >= m) {
                    return steps + 1;
                }
                if (curr[x][y] == 0) {
                    curr[x][y] = 1;
                    q.add(new int[]{x, y, steps + 1});
                }
            }
        }
        return -1;
    }
}