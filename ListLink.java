public class ListLink {
    Node head;
    Node tail;

public void dell(Node node){
    Node previous = node.previous;
    Node next =node.next;
    if (previous == null) {
        next.previous = null;
        head = next;
    } else { if (next == null) {
        previous.next = null;
        tail = previous;
    } else {
        previous.next = next;
        next.previous = previous;
    }
    }
}

public  Node find(int value){
       Node curentNode = head;
       while (curentNode != null){
           if (curentNode.value == value){
               return curentNode;
           }
           curentNode = curentNode.next;
       }
       return  null;
    }
public  void add(int value){
        Node node = new Node();
        node.value = value;
        if (head == null){
            head = node;
            tail = node;
        }
        else {
            tail.next = node;
            node.previous = tail;
            tail = node;
        }
    }
public  void add(int value, Node node){

    Node next = node.next;
    Node newNode = new Node();
    newNode.value = value;
    node.next = newNode;
    newNode.previous = node;
    if (next == null){
        tail = newNode;
    }else {
        next.previous = newNode;
        newNode.next = next;
    }      }
    public void revert(){

         Node currentNode = head;
         while (currentNode == null){
        Node next = currentNode.next;
        Node previos = currentNode.previous;
        currentNode.next = previos;
        currentNode.previous = next;
        if (previos == null){
            tail = currentNode;
        }
        if (next == null) {
            head = currentNode;
        }
        currentNode = next;
        }
}
public class Node {

    int value;
    Node next;
    Node previous;

    public Node(int value, Node next, Node previous) {
        value =this.value;
        next = this.next;
        previous = this.previous;
    }
    public Node (int value) {

        value = this.value;
        next = null;
        previous = null;
    }
    public Node () {

    }
}



}
