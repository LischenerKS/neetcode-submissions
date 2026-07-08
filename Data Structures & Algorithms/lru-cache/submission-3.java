class LRUCache {
    private Map<Integer, Node> nodeByKey = new HashMap<>();
    private int capacity;
    private int size;
    private Node head; //less used
    private Node end; //more used

    public LRUCache(int capacity) {
        this.capacity = capacity;
        size = 0;
    }
    
    public int get(int key) {
        if (nodeByKey.containsKey(key)) {
            Node node = nodeByKey.get(key);
            Node last = node.last;
            Node next = node.next;

            if (size == 1 || node == end) return node.value;

            if (node == head) {
                next.last = null;
                head = next;
                node.last = end;
                end.next = node;
                end = node;
                return node.value;
            }

            if (last != null) last.next = next;
            if (next != null) next.last = last;
            node.last = end;
            end.next = node;
            end = node;
            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (nodeByKey.containsKey(key)) {
            Node node = nodeByKey.get(key);
            Node last = node.last;
            Node next = node.next;
            node.value = value;

            if (size == 1 || node == end) return;

            if (node == head) {
                next.last = null;
                head = next;
                node.last = end;
                end.next = node;
                end = node;
                return;
            }

            if (last != null) last.next = next;
            if (next != null) next.last = last;
            node.last = end;
            end.next = node;
            end = node;
        }
        else if (size == 0) {
            head = new Node(key, value, null, null);
            nodeByKey.put(key, head);
            end = head;
            size++;
        }
        else if (size < capacity) {
            Node newNode = new Node(key, value, null, null);
            nodeByKey.put(key, newNode);
            end.next = newNode;
            newNode.last = end;

            end = newNode;
            size++;
        }
        else {
            nodeByKey.remove(head.key);
            head = head.next;
            if (head != null) head.last = null;

            Node newNode = new Node(key, value, null, null);
            nodeByKey.put(key, newNode);
            end.next = newNode;
            newNode.last = end;

            end = newNode;
        }
        
    }
}

public class Node {
    int value;
    int key;
    Node next;
    Node last;


    Node(int key, int value, Node next, Node last) {
        this.key = key;
        this.value = value;
        this.next = next;
        this.last = last;
    }
}
