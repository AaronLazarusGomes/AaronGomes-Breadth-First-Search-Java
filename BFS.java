/*
Implementation of the Breadth First Search Algorithm in java
In this we make 2 classes
class Node
class BreadthFirstSearch

The class Node remains the same as the Depth First Search algorithm (check it's implementation out on my GitHub)

the only difference is that we have the constructor initializing the Queue and then we add elements to the queue
and pop them off one by one and check for it's neighbours 
and then add them to the queue
*/

import java.util.*;

class Node {
    int value;
    List<Node> neighbours;
    boolean visited;

    public Node(int value) {
        this.value = value;
        this.neighbours = new ArrayList<Node>();
    }

    public void putNeighbours(Node neighbour) {
        this.neighbours.add(neighbour);
    }

    public List<Node> getNeighbours() {
        return neighbours;
    }
}

class BreadthFirstSearch {

    // this is only for implementing BFS
    Queue<Node> queue;

    public BreadthFirstSearch() {
    //initializing it to a linked list 
    //a Queue can be initialized to a linkedlist as LinkedList is a child of Queue (heirachy of Java)
    //parent = child (fundamental of java)
        queue = new LinkedList<Node>();
    }

    public void BFS(Node node) {
    //adding the node to the queue
        queue.add(node);
        node.visited = true; //marking it as visited

        while (!queue.isEmpty()) {
        // popping the Node from the queue
            Node poppedNode = queue.remove();
            // printing the value
            System.out.println(poppedNode.value);
            
            //each node that is popped from the queue has a list of neighbours
            //so we get those neighbours
            List<Node> elementsOfPoppedNode = poppedNode.getNeighbours();

            //accessing each node from that list of neighbours that we just got
            for (int i = 0; i < elementsOfPoppedNode.size(); i++) {
                Node n = elementsOfPoppedNode.get(i);
                if (n != null && !n.visited) {
                    queue.add(n);     //adding to the queue
                    n.visited = true; //making it visited
                }
            }
        }
    }

    public static void main(String[] args) {
        Node node2 = new Node(2);
        Node node0 = new Node(0);
        Node node1 = new Node(1);
        Node node3 = new Node(3);

        node2.putNeighbours(node0);
        node2.putNeighbours(node3);
        node2.putNeighbours(node1);
        node0.putNeighbours(node2);
        node0.putNeighbours(node1);
        node1.putNeighbours(node0);
        node1.putNeighbours(node2);
        node3.putNeighbours(node3);
        node3.putNeighbours(node2);

        node0.visited = false;
        node1.visited = false;
        node2.visited = false;
        node3.visited = false;

        BreadthFirstSearch df = new BreadthFirstSearch();

        df.BFS(node2);

    }
}
