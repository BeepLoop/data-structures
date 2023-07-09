import java.util.NoSuchElementException;

public class LinkedList {
    Node head;

    public LinkedList() {
        this.head = null;
    }

    public LinkedList insertFront(int n) {
        Node node = new Node(n);

        if (this.head == null) {
            this.head = node;
        } else {
            node.next = this.head;
            this.head = node;
        }

        return this;
    }

    public LinkedList insertEnd(int n) {
        Node node = new Node(n);

        if (this.head == null) {
            this.head = node;
        } else {
            Node curr = this.head;

            while (curr.next != null) {
                curr = curr.next;
            }

            curr.next = node;
        }

        return this;
    }

    public LinkedList insertAt(int pos, int n) {
        if (this.head == null) {
            throw new NoSuchElementException("List is empty");
        } else {
            Node curr = this.head;
            Node prev = null;
            int currPos = 0;

            while (curr.next != null) {
                if (currPos == pos) {
                    Node node = new Node(n);
                    prev.next = node;
                    node.next = curr;
                    break;
                }
                prev = curr;
                curr = curr.next;
                currPos++;
            }
        }

        return this;
    }

    public LinkedList removeFront() {
        if (this.head == null) {
            throw new NoSuchElementException("List is empty");
        } else {
            this.head = this.head.next;
        }

        return this;
    }

    public LinkedList removeEnd() {
        if (this.head == null) {
            throw new NoSuchElementException("List is empty");
        } else {
            Node curr = this.head;
            Node prev = null;

            while (curr.next != null) {
                prev = curr;
                curr = curr.next;
            }

            prev.next = null;
        }

        return this;
    }

    public void printList() {
        if (this.head == null) {
            System.out.println("List is empty");
        } else {
            Node curr = this.head;

            while (true) {
                System.out.print(curr.value + " -> ");
                if (curr.next == null) {
                    System.out.println("null");
                    break;
                } else {
                    curr = curr.next;
                }
            }
        }
    }

    public void printList(LinkedList list) {
        if (this.head == null) {
            System.out.println("List is empty");
        } else {
            Node curr = list.head;

            while (curr.next != null) {
                System.out.print(curr.value + " -> ");
                curr = curr.next;
            }
        }
    }
}

class Node {
    int value;
    Node next;

    public Node(int v) {
        this.value = v;
        this.next = null;
    }
}