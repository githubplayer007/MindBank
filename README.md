__Assumption:__

	1). Each Node has a unique node id 
  
	2). "The longest directed path from that vertex" means the sum of the length of all edges leading from
        that vertex to an end Node. 
      
	3). If more than one path with the same max distance are found, any one can be returned as the result. 
  
	4). For simplicity, assume that Dag has at least one node.

__Due to potential ambiguity, two versions of the same program are implemented:__ 

	1). Find the longest distance without path tracing. 
  
	2). Find the longest distance and trace path 
  
__How to clone, build and run__

	Clone this github repository to your local drive: https://github.com/githubplayer007/MindBank.git

	Suppose that this project is located at: .../MindBank/ on your local drive, follow the below 
 	instructions to build and run.

__Build__

	cd MindBank/
	mvn clean package

__Run__

	java -jar ./target/mind.bank-0.0.1-SNAPSHOT.jar
 
 	The running result is printed out in your console.

__QUESTIONS to be answered with the PROGRAMMING EXERCISE__ 

• __Does the solution work for larger graphs?__

	I think so. 
  
• __Can you think of any optimizations?__ 

	Yes. In a Dag, each node represents either the whole graph or a subgraph. Once a subgraph is visited, we have 
 	already collected its path information. So there should be no need to revisit it, especially when the subgraph 
  	is huge. We should collect and save the path info for each node once it is visited and reuse the info that we 
   	have collected if we need to revisit it later.
    

• __What’s the computational complexity of your solution?__ 

	I believe it is O(n log n) (not linear O( a n) nor O(n x n)
  
• __Are there any unusual cases that aren't handled?__ 

	I don't feel so, however I don't check Node or Edge info.
