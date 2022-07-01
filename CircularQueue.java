// import java.util.Scanner;

// class CircularQueue {

//     Scanner sc = new Scanner(System.in);
    

//     Ticket [] businessTickets;
//     Ticket [] economyTickets;
//     int front = -1;
//     int rear = -1;

//     void enqueue(Ticket n){
//        if(front == -1 && rear == -1){
//            front = rear = 0;
//            tickets[rear] = n;
//        }
//        else if((rear+1)%size == front){
//            System.out.println("The queue is full");
//            return;
//        }
//        else{
//            rear = (rear+1)%size;
//            tickets[rear] = n;
//        }
//     }

//     void dequeue(){
//         if(rear == -1){
//             System.out.println("The queue is empty");
//         }
//         else if((front+1)%size == rear){
//             System.out.println("The element deleted is : "+tickets[front]);
//             front = rear = -1;
//         }
//         else{
//             System.out.println("The element deleted is : "+tickets[front]);
//             front = (front+1)%size;
//         }
//     }

//     void print(){
//         int i = front;
//         while(i!=rear){
//             System.out.print(tickets[i] + " ");
//             i = (i+1)%size;
//         }
//         System.out.println(tickets[rear]);

//     }
// }
