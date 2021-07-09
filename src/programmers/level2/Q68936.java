/*
 * Q68936.java
 * Author : 박찬형
 * Created Date : 2021-07-09
 */
package programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

public class Q68936 {
    static class Point{
        private final int x;
        private final int y;

        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    private int[] result;
    private boolean[][] visited;

    public int[] solution(int[][] arr) {
        result = new int[2];
        compress(arr, new Point(0, 0), new Point(arr.length - 1, arr.length - 1));
        return result;
    }

    private void compress(int[][] arr, Point start, Point end){
        if(end.x - start.x == 0){
            result[arr[start.y][start.x]]++;
            return;
        }

        int width = end.x - start.x + 1;
        int height = end.y - start.y + 1;
        int check = arr[start.y][start.x];
        visited = new boolean[arr.length][arr.length];
        if(visit(arr, start, end, check)){
            result[check]++;
        }
        else{
            Point[] startPoints = getStartPoints(start, width, height);
            Point[] endPoints = getEndPoints(start, end, width, height);

            for(int i = 0; i < startPoints.length; i++){
                compress(arr, startPoints[i], endPoints[i]);
            }
        }
    }

    private boolean visit(int[][] arr, Point start, Point end, int check){
        Queue<Point> queue = new LinkedList<>();
        queue.add(start);
        visited[start.y][start.x] = true;

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        while(!queue.isEmpty()){
            Point cur = queue.poll();

            for(int i = 0; i < dx.length; i++){
                Point next = new Point(cur.x + dx[i], cur.y + dy[i]);
                if (next.x >= start.x && next.x <= end.x && next.y >= start.y && next.y <= end.y &&
                        !visited[next.y][next.x]){
                    if(arr[next.y][next.x] != check){
                        return false;
                    }
                    queue.add(next);
                    visited[next.y][next.x] = true;
                }
            }
        }

        return true;
    }

    private Point[] getStartPoints(Point start, int width, int height){
        Point[] startPoints = new Point[4];
        startPoints[0] = new Point(start.x, start.y);
        startPoints[3] = new Point(start.x + width / 2, start.y + height / 2);
        startPoints[1] = new Point(startPoints[3].x, start.y);
        startPoints[2] = new Point(start.x, startPoints[3].y);

        return startPoints;
    }

    private Point[] getEndPoints(Point start, Point end, int width, int height){
        Point[] endPoints = new Point[4];
        endPoints[0] = new Point(start.x + (width / 2 - 1), start.y + (height / 2 - 1));
        endPoints[1] = new Point(end.x, endPoints[0].y);
        endPoints[2] = new Point(endPoints[0].x, end.y);
        endPoints[3] = new Point(end.x, end.y);
        return endPoints;
    }
}
