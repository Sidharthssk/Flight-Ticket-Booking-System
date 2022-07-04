import java.time.LocalDate;
public class SortedPriorityQueue {

    class Node {
        LocalDate priority;
        Ticket data;
        Node next;

        Node(LocalDate priority, Ticket data) {
            this.priority = priority;
            this.data = data;
            this.next = null;
        }
    }

    static Node head = null;
    static Node tail = null;
    static int size = 0;

    void add(LocalDate priority, Ticket data) {
        Node newNode = new Node(priority, data);

        if (head == null) {
            head = newNode;
            tail = newNode;
            size++;
        } else if (newNode.priority.isBefore(head.priority)) {
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
                if (temp != null && temp.priority.isAfter(newNode.priority)) {
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

    static void remove(){
        Node current = head;
        while(current!=null){
            if(LocalDate.now().isAfter(current.priority)){
                head = head.next;
                size--;
            }
        }
    }

    void printList() {
        remove();

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

}
