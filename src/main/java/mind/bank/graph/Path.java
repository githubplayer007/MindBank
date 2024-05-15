package mind.bank.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Path {
	Long totalDistance = 0L;
	List<Node> nodeList = new ArrayList<>();

	public Path(Long totalDistance, List<Node> nodeList) {
		this.totalDistance = totalDistance;
		this.nodeList = nodeList;
	}

	public Long getTotalDistance() {
		return this.totalDistance;
	}

	public String toString() {
		return this.totalDistance + " : " + nodeList.stream().map(node -> String.valueOf(node.getNodeId())).collect(Collectors.joining(" > "));
	}
}
