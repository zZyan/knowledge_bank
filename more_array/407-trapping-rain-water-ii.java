/*
use a heap to save the contour 
*/

public class Solution {
    public class Point {
        int height;
        int row;
        int col;
        public Point(int h, int r,  int c){
            this.height = h;
            this.row = r;
            this.col = c;
        }
    }
    
    public int trapRainWater(int[][] heightMap) {

        // note: three condition, if pre is true, .length throws error
        // therefore cannot get the length before dealing the corner case
        if (heightMap == null || heightMap.length < 3 || heightMap[0].length<3){
            return 0;
        }
        int m = heightMap.length;
        int n = heightMap[0].length;

        PriorityQueue<Point> boundary = new PriorityQueue<Point> (1, new Comparator<Point>(){
            //create a compare method, note: return int
            public int compare(Point one, Point two){
                return one.height - two.height;
            }
        });
        
        boolean[][] visited = new boolean[m][n];
        //put outermost Points in heap
        //top bottom
        for (int i = 0; i<n; i++){
            boundary.offer(new Point(heightMap[0][i], 0, i));
            boundary.offer(new Point(heightMap[m-1][i], m-1, i));
            visited[0][i] = true;
            visited[m-1][i] = true;
        }
        System.out.println(boundary.size());
        //left right
        for (int i = 1; i<m-1; i++){
            boundary.offer(new Point(heightMap[i][0], i, 0));
            boundary.offer(new Point(heightMap[i][n-1], i, n-1));
            visited[i][0] = true;
            visited[i][n-1] = true; 
        }
        // poll from the heap one by one 
        // steps for bfs
        int[] dRow = {0, 0, -1, 1};
        int[] dCol = {-1, 1, 0, 0};
        int water = 0;
        
        while (!boundary.isEmpty()){
            Point curr = boundary.poll();
            // scan its four direction 
            for (int i = 0; i<4; i++){
                int nRow = curr.row + dRow[i];
                int nCol = curr.col + dCol[i];
                
                if(nRow>0 && nRow<m-1 && nCol>0 && nCol<n-1 && !visited[nRow][nCol]){
                    // other points along boundary >= current, if its neighbor is lower, than there is water
                    water += Math.max(0, curr.height - heightMap[nRow][nCol]);
                    // System.out.println("row: " + curr.row + " col: " + curr.col + " water: " + water);
                    boundary.offer(new Point(Math.max(heightMap[nRow][nCol], curr.height), nRow, nCol));
                    visited[nRow][nCol] = true; 
                }
            }
        }
        
        return water;
    }
}