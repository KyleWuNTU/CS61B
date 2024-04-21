package Data_Structures.LinkedList;

public class SLList {
    private class IntNode {
        private int data;
        private IntNode next;

        private IntNode(int i, IntNode n) {
            data = i;
            next = n;
        }    
    }
    
    private IntNode first;
    public SLList(int x){
        first = new IntNode(x, null);
    }

    public void addFirst(int num){
        first = new IntNode(num, first);
    }

    public void addLast(int num){
        IntNode currIntNode = first;
        while(currIntNode.next != null){
            currIntNode = currIntNode.next;
        }
        currIntNode.next = new IntNode(num, null);
    }

    public int getFirst(){
        return first.data;
    }

    public int getLast(){
        IntNode currIntNode = first;
        while(currIntNode.next != null){
            currIntNode = currIntNode.next;
        }
        return currIntNode.data;
    }

    public int getNext(){
        return first.next.data;
    }

    public static void main(String[] args) {
        SLList head = new SLList(10);
        head.addLast(1);
        head.addLast(4);
        head.addLast(3);
        head.addLast(2);
        head.addLast(5);
        head.addLast(2);
        int x = 3;

        SLList dummy_1 = new SLList(-1);
        SLList dummy_2 = new SLList(-1);
        SLList p1 = dummy_1;
        SLList p2 = dummy_2;

        System.out.println(p1.getFirst());
        System.out.println(p1.getNext());
        System.out.println(dummy_1.getFirst());
        System.out.println(dummy_1.getNext());
    }
}
