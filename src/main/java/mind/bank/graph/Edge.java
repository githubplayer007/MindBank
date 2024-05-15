package mind.bank.graph;

public class Edge {
	Integer edgeLength;
	Node nextNode;

	public Edge(Integer edgeLength, Node nextNode) {
		this.edgeLength = edgeLength;
		this.nextNode = nextNode;
	}

	public Integer getEdgeLength() {
		return edgeLength;
	}

	public Node getNextNode() {
		return nextNode;
	}

}
