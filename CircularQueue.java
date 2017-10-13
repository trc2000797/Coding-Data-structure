import java.util.*;

class Node {
    String data;
    Node next;

    public Node (String str) {
        this.data = str;
    }
}

class LinkedList {
     Node head,tail;
     Node current;
     int size,count;

    public LinkedList() {
        current = tail = head = null;
        size = 0;
        count = 0;
    }

    public void add(String str) {
        if ( head == null) {
            head = new Node(str);
            tail = current = head;
            size++;
            count++;
        }
        else if ( size < 12) {
            Node node = new Node(str);
            tail.next = node;
            tail = node;
            current = node;
            size++;
            count++;
        }
        else{
            count++;
            if(count == 13){
                count = 1;
                current = head;
            }
            else current = current.next;
            current.data=str;
        }
    }


    public String toString(){
        Node p = head;
        String str = "";
        while ( p != null){
            str += p.data + " ";
            p = p.next;
        }
        return str;
    }
    public void dequeue() {
        System.out.print(this);
        System.out.print("Output above!");
    }
}
public class CircularQueue {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str;
        LinkedList list = new LinkedList();
        System.out.println("Please input a string ('quit' to exit): ");
        str = input.next();
        while(!str.equals("quit")) {
            list.add(str);
            System.out.println("Please input a string ('quit' to exit): ");
            str = input.next();
        }

        list.dequeue();
    }
}
