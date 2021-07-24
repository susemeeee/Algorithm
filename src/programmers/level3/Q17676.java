/*
 * Q17676.java
 * Author : 박찬형
 * Created Date : 2021-07-23
 */
package programmers.level3;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Q17676 {
    static class Log{
        private final LocalDateTime start;
        private final LocalDateTime end;

        public Log(LocalDateTime start, LocalDateTime end){
            this.start = start;
            this.end = end;
        }
    }

    public int solution(String[] lines) {
        if(lines.length == 1){
            return 1;
        }

        List<Log> logs = new LinkedList<>();
        Queue<LocalDateTime> times = new PriorityQueue<>();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        DateTimeFormatter midnightFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        for(String line : lines){
            String[] data = line.split(" ");
            boolean midnight = true;
            for(int i = 0; i < data[1].length(); i++){
                char c = data[1].charAt(i);
                if(c == ':' || c == '.'){
                    continue;
                }

                if(c >= '1' && c <= '9'){
                    midnight = false;
                    break;
                }
            }

            LocalDateTime end;
            if(midnight){
                end = LocalDateTime.of(LocalDate.parse(data[0], midnightFormatter), LocalTime.MIN);
            }
            else{
                end = LocalDateTime.parse(data[0] + " " + data[1], formatter);
            }
            LocalDateTime start = end.minusNanos((long) (Double.parseDouble(data[2].substring(0, data[2].length() - 1)) * 1000000000));
            start = start.plusNanos(1000000);

            logs.add(new Log(start, end));
            times.add(start);
            times.add(end);
        }

        logs.sort((o1, o2) -> {
            if(o1.start.isBefore(o2.start)){
                return -1;
            }
            else if(o1.start.isAfter(o2.start)){
                return 1;
            }

            return 0;
        });
        Queue<Log> queue = new PriorityQueue<>((o1, o2) -> {
            if (o1.end.isBefore(o2.end)) {
                return -1;
            } else if (o1.end.isAfter(o2.end)) {
                return 1;
            }

            return 0;
        });

        int maxCount = 0;
        int curIndex = 0;
        while(!times.isEmpty()) {
            LocalDateTime time = times.poll();
            LocalDateTime endTime = time.plusSeconds(1);

            while (!queue.isEmpty() && (queue.peek().start.isAfter(endTime) || queue.peek().end.isBefore(time))) {
                queue.poll();
            }

            while (curIndex < logs.size() &&
                    logs.get(curIndex).start.isBefore(endTime) && !logs.get(curIndex).end.isBefore(time)) {
                queue.add(logs.get(curIndex++));
            }

            if (queue.size() > maxCount) {
                maxCount = queue.size();
            }
        }

        return maxCount;
    }
}
