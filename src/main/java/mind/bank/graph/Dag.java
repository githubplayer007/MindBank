package mind.bank.graph;

import java.util.ArrayList;
import java.util.List;

public class Dag {
	Node startNode;

	public Dag(Node startNode) {
		this.startNode = startNode;
	}

	// find the longest distance among all paths
	// No paths tracing
	public Long findAllPathDistances() {
		List<Long> resultList = new ArrayList<>();
		findTheLongestPathWorker(resultList, 0L, this.startNode);
		return resultList.get(0);
	}

	public void findTheLongestPathWorker(List<Long> resultList, Long currentDistance, Node node) {
		if (node.getEdgeList().isEmpty()) {
			if (resultList.isEmpty()) {
				resultList.add(currentDistance);
			} else {
				if (resultList.get(0) < currentDistance) {
					resultList.remove(0);
					resultList.add(currentDistance);
				}
			}
		} else {
			for (Edge edge : node.getEdgeList()) {
				findTheLongestPathWorker(resultList, currentDistance + edge.getEdgeLength(), edge.getNextNode());
			}
		}
	}

	// Find the longest distance among all paths and trace paths.
	public Path findAllPathsUsingNodeListToTracePaths() {
		List<Path> pathList = new ArrayList<>();
		findAllPathsUsingNodeListToTracePathsWorker(pathList, 0L, new ArrayList<Node>(List.of(startNode)), this.startNode);
		return pathList.get(0);
	}

	public void findAllPathsUsingNodeListToTracePathsWorker(List<Path> pathList, Long currentDistance, List<Node> nodeList, Node node) {
		if (node.getEdgeList().isEmpty()) {
			Path path = new Path(currentDistance, nodeList);
			if (pathList.isEmpty()) {
				pathList.add(path);
			} else {
				if (pathList.get(0).getTotalDistance() < currentDistance) {
					pathList.remove(0);
					pathList.add(path);
				}
			}
		} else {
			for (Edge edge : node.getEdgeList()) {
				List<Node> tmpNodeList = new ArrayList<>(nodeList);
				tmpNodeList.add(edge.getNextNode());
				findAllPathsUsingNodeListToTracePathsWorker(pathList, currentDistance + edge.getEdgeLength(), tmpNodeList, edge.getNextNode());
			}
		}
	}

}
