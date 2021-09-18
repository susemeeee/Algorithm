/*
 * Q9205.java
 * Author : 박찬형
 * Created Date : 2021-09-18
 */
package BOJ.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q9205 {
    static class Point{
        int x;
        int y;
        boolean isDest;

        public Point(int x, int y, boolean isDest){
            this.x = x;
            this.y = y;
            this.isDest = isDest;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int loop = Integer.parseInt(br.readLine());

        for(int i = 0; i < loop; i++){
            int store = Integer.parseInt(br.readLine());
            String[] d = br.readLine().split(" ");
            Point start = new Point(Integer.parseInt(d[0]), Integer.parseInt(d[1]), false);
            List<Point> points = new ArrayList<>();
            for(int j = 0; j < store; j++) {
                d = br.readLine().split(" ");
                points.add(new Point(Integer.parseInt(d[0]), Integer.parseInt(d[1]), false));
            }
            d = br.readLine().split(" ");
            points.add(new Point(Integer.parseInt(d[0]), Integer.parseInt(d[1]), true));

            if(dfs(start, points, new boolean[points.size()])){
                System.out.println("happy");
            }
            else{
                System.out.println("sad");
            }
        }
    }

    static boolean dfs(Point cur, List<Point> points, boolean[] visited){
        if(cur.isDest){
            return true;
        }

        for(int i = 0; i < points.size(); i++){
            if(visited[i]){
                continue;
            }
            Point next = points.get(i);
            if(Math.abs(cur.y - next.y) + Math.abs(cur.x - next.x) > 1000){
                continue;
            }
            visited[i] = true;
            if(dfs(next, points, visited)){
                return true;
            }
            visited[i] = false;
        }

        return false;
    }
}
