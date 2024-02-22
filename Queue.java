
// Node class to represent each node in the priority queue


class Node<T> {
    T data;             // Data stored in the node
    int priority;       // Priority associated with the data
    Node<T> next;       // Reference to the next node

    // Constructor to initialize a node with data and priority
    public Node(T data, int priority) {
        this.data = data;
        this.priority = priority;
        this.next = null;    // Initially, the next reference is null
    }
}

// PriorityGenericQueue class to implement the priority queue
class PriorityGenericQueue<T> {
    private Node<T> head;   // Reference to the first node in the queue
    private Node<T> tail;   // Reference to the last node in the queue

    // Constructor to initialize an empty priority queue
    public PriorityGenericQueue() {
        head = null;    // Initially, both head and tail are null
        tail = null;
    }

    // Method to add an element to the queue with a given priority
    public void enqueue(T item, int priority) {
        Node<T> newNode = new Node<>(item, priority);  // Create a new node with the given data and priority

        // If the queue is empty or the new node has higher priority than the head
        if (isEmpty() || priority > head.priority) {
            newNode.next = head;    // Set the next reference of the new node to the current head
            head = newNode;         // Update the head to be the new node
        } else {
            Node<T> current = head;

            // Traverse the queue to find the correct position to insert the new node
            while (current.next != null && current.next.priority >= priority) {
                current = current.next;
            }

            // Insert the new node at the appropriate position
            newNode.next = current.next;
            current.next = newNode;
        }

        // If the tail is null, update it to be the head (only applicable for the first node)
        if (tail == null) {
            tail = head;
        }
    }

    // Method to remove and return the element with the highest priority from the queue
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        T item = head.data;    // Get the data from the head node
        head = head.next;      // Move the head pointer to the next node

        // If the head becomes null after dequeue, update the tail to be null as well
        if (head == null) {
            tail = null;
        }
        return item;    // Return the data of the dequeued node
    }

    // Method to return the element with the highest priority without removing it from the queue
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return head.data;   // Return the data from the head node
    }

    // Method to check if the queue is empty
    public boolean isEmpty() {
        return head == null;    // The queue is empty if the head is null
    }
}
