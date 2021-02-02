/*
 * Q2583.java
 * Author : 박찬형
 * Created Date : 2021-02-02
 */
package BOJ.graph;

import java.util.*;

public class Q2583 {
    static int[][] graph;
    static List<Rect> rects = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int height = scanner.nextInt();
        int width = scanner.nextInt();
        int rect = scanner.nextInt();
        scanner.nextLine();
        graph = new int[height][width];
        for(int i = 0; i < rect; i++){
            String[] input = scanner.nextLine().split(" ");
            Integer[] start = new Integer[]{Integer.parseInt(input[0]), Integer.parseInt(input[1])};
            Integer[] end = new Integer[]{Integer.parseInt(input[2]) - 1, Integer.parseInt(input[3]) - 1};
            rects.add(new Rect(start, end));
        }
        paint();

        Queue<Integer> results = new PriorityQueue<>();
        int count = 0;
        for(int i = 0; i < graph.length; i++){
            for(int j = 0; j < graph[0].length; j++){
                if(graph[i][j] == 0){
                    results.add(visit(j, i));
                    count++;
                }
            }
        }

        System.out.println(count);
        while(!results.isEmpty()){
            System.out.print(results.poll() + " ");
        }
    }

    static void paint(){
        for(int i = 0; i < graph.length; i++){
            for(int j = 0; j < graph[0].length; j++){
                if(graph[i][j] != -1 && !paintCheck(j, i)){
                    graph[i][j] = -1;
                }
            }
        }
    }

    static boolean paintCheck(int x, int y){
        for(Rect r : rects){
            if(!r.check(x, y)){
                return false;
            }
        }
        return true;
    }

    static int visit(int x, int y){
        Queue<Integer[]> queue = new LinkedList<>();
        queue.add(new Integer[]{x, y});
        graph[y][x] = -1;
        int area = 0;
        while(!queue.isEmpty()){
            Integer[] cur = queue.poll();
            area++;
            if(check(cur[0] + 1, cur[1])){
                queue.add(new Integer[]{cur[0] + 1, cur[1]});
                graph[cur[1]][cur[0] + 1] = -1;
            }
            if(check(cur[0] - 1, cur[1])){
                queue.add(new Integer[]{cur[0] - 1, cur[1]});
                graph[cur[1]][cur[0] - 1] = -1;
            }
            if(check(cur[0], cur[1] + 1)){
                queue.add(new Integer[]{cur[0], cur[1] + 1});
                graph[cur[1] + 1][cur[0]] = -1;
            }
            if(check(cur[0], cur[1] - 1)){
                queue.add(new Integer[]{cur[0], cur[1] - 1});
                graph[cur[1] - 1][cur[0]] = -1;
            }
        }

        return area;
    }

    static boolean check(int x, int y){
        if(x < 0 || y < 0 || x >= graph[0].length || y >= graph.length){
            return false;
        }
        return graph[y][x] == 0;
    }

    static class Rect{
        private Integer[] start;
        private Integer[] end;

        public Rect(Integer[] start, Integer[] end){
            this.start = start;
            this.end = end;
        }

        public boolean check(int x, int y){
            boolean xResult = true;
            boolean yResult = true;
            if(x >= start[0] && x <= end[0]){
                xResult = false;
            }
            if(y >= start[1] && y <= end[1]){
                yResult = false;
            }
            return xResult || yResult;
        }
    }
}
