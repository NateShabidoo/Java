import java.util.*;

// build a graph/tree (each link has a weight and each node has a letter) based off a graphic provided by the Professor
public class OurGraphInList3 {

    // internal class used to create a node in the grade list representation
    private static class ourEdgeNode {
        int ID;
        int weigh;

        public ourEdgeNode(int ID, int weigh) {
            this.ID = ID;
            this.weigh = weigh;
        }

        public int getID() { return ID; }

        public int getWeigh() { return weigh; }
    }


    public static void main(String[] args) {
       
        // ourVertexNode is an array of linked list:
        //      -> each linked list object reference represents a vertex in the graph
        //      -> e.g. the first reference represents node A, the 2nd reference represents node B, etc...
        //
        //      -> each linked list object reference links all ourEdgeNode objects that are reachable by the current node
        //      -> e.g. the first reference links all nodes that are reachable by node A, etc...
        // to code it out, we use ArrayList class and integrate LinkedList class in it

        // FigureX has 5 nodes, so that the size of the arrayList is 5
        ArrayList<LinkedList<ourEdgeNode>> ourVertexNode = new ArrayList<>(7);
        for(int i = 0; i < 7; ++i) {
            ourVertexNode.add(new LinkedList<ourEdgeNode>());
        }

        // to represent node A, B, C, D...., we use its ASCII integer for convenient representation
        // e.g. node A's ID is 0 (because letter 'A' + 0 = 'A'), node B's ID is 1, node C's ID is 2, etc.

        // from the view of vertex A
        LinkedList<ourEdgeNode> tmp = ourVertexNode.get(0);
        tmp.addLast(new ourEdgeNode(1, 3));
        tmp.addLast(new ourEdgeNode(2, 5));
        tmp.addLast(new ourEdgeNode(3, 8));

        // from the view of vertex B
        tmp = ourVertexNode.get(1);
        tmp.addLast(new ourEdgeNode(0, 3));
        tmp.addLast(new ourEdgeNode(4, 9));
        tmp.addLast(new ourEdgeNode(6, 7));

        // from the view of vertex C
        tmp = ourVertexNode.get(2);
        tmp.addLast(new ourEdgeNode(0, 5));
        tmp.addLast(new ourEdgeNode(5, 1));

        // from the view of vertex D
        tmp = ourVertexNode.get(3);
        tmp.addLast(new ourEdgeNode(0, 8));
        tmp.addLast(new ourEdgeNode(5, 4));
        tmp.addLast(new ourEdgeNode(6, 10));

        // from the view of vertex E
        tmp = ourVertexNode.get(4);
        tmp.addLast(new ourEdgeNode(1, 9));
        tmp.addLast(new ourEdgeNode(6, 2));

        // from the view of vertex F
        tmp = ourVertexNode.get(5);
        tmp.addLast(new ourEdgeNode(2, 1));
        tmp.addLast(new ourEdgeNode(3, 4));
        tmp.addLast(new ourEdgeNode(6, 6));

        // from the view of vertex G
        tmp = ourVertexNode.get(6);
        tmp.addLast(new ourEdgeNode(1, 7));
        tmp.addLast(new ourEdgeNode(3, 10));
        tmp.addLast(new ourEdgeNode(4, 2));
        tmp.addLast(new ourEdgeNode(5, 6));

        // this prints the graph from the list representation we built
        for(int i = 0; i < ourVertexNode.size(); ++i) {
            // get the current linked list in order to print its linked nodes
            tmp = ourVertexNode.get(i);

            // print linked nodes one by one
            for(int j = 0; j < tmp.size(); ++j) {
                System.out.format("%c to %c (%d), ", (char)('A' + i), (char)('A' + tmp.get(j).getID()), tmp.get(j).getWeigh());
            }

            System.out.println();
        }

    }
}
