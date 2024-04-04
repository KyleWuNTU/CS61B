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

    public static void main(String[] args) {
        SLList newlist = new SLList(10);
        newlist.addLast(20);
        System.out.println(newlist.getLast());
    }
}
