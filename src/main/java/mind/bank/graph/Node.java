package mind.bank.graph;

import java.util.ArrayList;
import java.util.List;

// Assume each node has a unique nodeId
public class Node {
	Integer nodeId;
	List<Edge> edgeList = new ArrayList<>();

	public Node(Integer nodeId, List<Edge> edgeList) {
		super();
		this.nodeId = nodeId;
		this.edgeList = edgeList;
	}

	public Node(Integer nodeId) {
		this.nodeId = nodeId;
	}

	public Integer getNodeId() {
		return nodeId;
	}

	public void addEdge(Edge edge) {
		edgeList.add(edge);
	}

	public List<Edge> getEdgeList() {
		return edgeList;
	}
}
