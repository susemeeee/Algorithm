/*
 * Q17686.java
 * Author : 박찬형
 * Created Date : 2021-07-19
 */
package programmers.level2;

import java.util.Locale;
import java.util.PriorityQueue;
import java.util.Queue;

public class Q17686 {
    static class File{
        private final String fileName;
        private final String head;
        private final int number;
        private final String tail;
        private final int index;

        public File(String fileName, int index){
            this.fileName = fileName;
            this.index = index;

            int start = 0;
            for(int i = 0; i < fileName.length(); i++){
                if(fileName.charAt(i) >= '0' && fileName.charAt(i) <= '9'){
                    start = i;
                    break;
                }
            }
            head = fileName.substring(0, start).toLowerCase(Locale.ROOT);

            int end = start + 1;
            while(end < fileName.length()){
                if(fileName.charAt(end) < '0' || fileName.charAt(end) > '9'){
                    break;
                }
                end++;
            }
            number = Integer.parseInt(fileName.substring(start, end));
            tail = fileName.substring(end);
        }

        public int compare(File other){
            int compare = head.compareTo(other.head);

            if(compare == 0){
                if(other.number == number){
                    return index - other.index;
                }

                return number - other.number;
            }

            return compare;
        }
    }

    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        Queue<File> queue = new PriorityQueue<>(File::compare);

        for(int i = 0; i < files.length; i++){
            queue.add(new File(files[i], i));
        }

        for(int i = 0; i < files.length; i++){
            answer[i] = queue.poll().fileName;
        }

        return answer;
    }
}
