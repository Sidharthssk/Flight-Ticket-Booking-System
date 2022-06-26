import java.util.Date;

public class SortedPriorityQueue {

    class Node {
        Date priority;
        Ticket data;
        Node next;

        Node(Date priority, Ticket data) {
            this.priority = priority;
            this.data = data;
            this.next = null;
        }
    }

    Node head = null;
    Node tail = null;
    int size = 0;

    void add(Date priority, Ticket data) {
        Node newNode = new Node(priority, data);

        if (head == null) {
            head = newNode;
            tail = newNode;
            size++;
        } else if (newNode.priority.before(head.priority)) {
            newNode.next = head;
            head = newNode;
            size++;
        } else {
            Node currentNode = head;
            Node temp = head;
            int flag = 0;
            while (currentNode != tail) {
                currentNode = temp;
                temp = temp.next;
                if (temp != null && temp.priority.after(currentNode.priority)) {
                    newNode.next = temp;
                    currentNode.next = newNode;
                    size++;
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                tail.next = newNode;
                tail = newNode;
                size++;
            }
        }
    }

    void printList() {
        Node current = head;

        while (current != null) {
            if (current == head) {
                System.out.print("(" + current.priority + "," + current.data + ")");
            } else {
                System.out.print(" -> " + "(" + current.priority + "," + current.data + ")");
            }
            current = current.next;
        }
        System.out.println();
    }

    // int len(){
    // return size;
    // }

    // int [] min(){
    // int [] array = new int[2];

    // array[0] = head.priority;
    // array[1] = head.data;

    // return array;
    // }

    // int [] remove_min(){
    // int [] array = new int[2];

    // array[0] = head.priority;
    // array[1] = head.data;

    // head = head.next;

    // size--;

    // return array;
    // }

    // boolean is_empty(){
    // if(size == 0){
    // return true;
    // }
    // return false;
    // }

}
