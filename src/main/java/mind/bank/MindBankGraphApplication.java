package mind.bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import mind.bank.graph.*;

@SpringBootApplication
public class MindBankGraphApplication {

	/****************************************************************************************************************
	 * Assume: 
	 *   1). Each Node has a unique node id 
	 *   2). "The longest directed path from that vertex" refers to the sum of the length of all edges leading from
	 *       that vertex to an end Node. 
	 *   3). If more than one path with the same max distance are found, any one can be returned as the result. 
	 *   4). For simplicity, assume that Dag has at least one node.
	 * 
	 * Due to potential ambiguity, two versions of the same program are implemented: 
	 *   1). Find the longest distance without path tracing. 
	 *   2). Find the longest distance and trace path 
	 * 
	 ****************************************************************************************************************/
	
	public static void main(String[] args) {
		
		System.out.println("_____Test set 1_____(graph with one node)");
		Dag dag = createTestDag1();

		Long longestPathDistance = dag.findAllPathDistances();
		System.out.println("Caculate the longest distance only (no path tracing) : " + longestPathDistance);

		Path longestPath = dag.findAllPathsUsingNodeListToTracePaths();
		System.out.println("Caculate the longest distance and trace path : " + longestPath.toString());

		System.out.println("_____Test set 2_____(graph with more than one node)");
		dag = createTestDag();

		longestPathDistance = dag.findAllPathDistances();
		System.out.println("Caculate the longest distance only (no path tracing) : " + longestPathDistance);

		longestPath = dag.findAllPathsUsingNodeListToTracePaths();
		System.out.println("Caculate the longest distance and trace path : " + longestPath.toString());
	}

	// test data 
	private static Dag createTestDag1() {
		Node node1 = new Node(1);
		return new Dag(node1);
	}

   // test data 
	private static Dag createTestDag() {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		node1.addEdge(new Edge(1, node2));
		node1.addEdge(new Edge(1, node3));

		Node node4 = new Node(4);
		Node node5 = new Node(5);
		node2.addEdge(new Edge(2, node4));
		node2.addEdge(new Edge(2, node5));

		Node node6 = new Node(6);
		node3.addEdge(new Edge(3, node6));
		node3.addEdge(new Edge(3, node5));

		Node node7 = new Node(7);
		node5.addEdge(new Edge(5, node7));

		Node node8 = new Node(8);
		node7.addEdge(new Edge(5, node8));

		Node node9 = new Node(9);
		node7.addEdge(new Edge(6, node9));

		return new Dag(node1);
	}
}
