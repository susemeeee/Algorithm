/*
 * Q42628.java
 * Author : 박찬형
 * Created Date : 2021-07-23
 */
package programmers.level3;

public class Q42628 {
    static class Node{
        private final int value;
        private Node next;
        private Node prev;

        public Node(int value){
            this.value = value;
        }

        public void setNext(Node next){
            this.next = next;
        }

        public void setPrev(Node prev){
            this.prev = prev;
        }
    }

    static class NodeList{
        private Node first;
        private Node last;
        private int size;

        public NodeList(){
            size = 0;
        }

        public void insert(Node node){
            if(size == 0){
                first = node;
                last = node;
                size++;
                return;
            }

            if(node.value > last.value){
                last.setNext(node);
                node.setPrev(last);
                last = node;
                size++;
                return;
            }
            else if(node.value < first.value){
                node.setNext(first);
                first.setPrev(node);
                first = node;
                size++;
                return;
            }

            Node cur = first;
            Node prev = null;
            while(node.value > cur.value){
                cur = cur.next;
                prev = cur.prev;
            }

            prev.setNext(node);
            node.setNext(cur);
            node.setPrev(prev);
            cur.setPrev(node);
            size++;
        }

        public void delete(int pos){
            if(size == 0){
                return;
            }

            if(pos == 1){
                last = last.prev;
                if(last == null){
                    first = null;
                    size = 0;
                    return;
                }
                last.setNext(null);
            }
            else{
                first = first.next;
                if(first == null){
                    last = null;
                    size = 0;
                    return;
                }
                first.setPrev(null);
            }

            size--;
        }
    }

    private NodeList list;

    public int[] solution(String[] operations) {
        list = new NodeList();

        for(String operation : operations){
            String[] data = operation.split(" ");

            if(data[0].charAt(0) == 'I'){
                insert(Integer.parseInt(data[1]));
            }
            else{
                delete(Integer.parseInt(data[1]));
            }
        }

        if(list.size == 0){
            return new int[]{0, 0};
        }
        return new int[]{list.last.value, list.first.value};
    }

    private void insert(int num){
        list.insert(new Node(num));
    }

    private void delete(int pos){
        list.delete(pos);
    }
}
