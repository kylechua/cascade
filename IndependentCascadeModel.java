import java.util.ArrayList;
import java.util.List;
public class IndependentCascadeModel {
	
	/* Independent Cascade Model
	 * Kyle Chua
	 * Last Changed: Oct 11, 2016
	 */

	public static void main(String[] args) {

			double[][] G = { // given chart w/ probabilities
								{0, 0.5, 0, 0, 0, 0},
								{0, 0, 0, 0.5, 0, 0.5},
								{0, 0, 0, 0, 0, 0},
								{0.5, 0, 0, 0, 0, 0},
								{0, 0, 0, 0, 0, 0},
								{0, 0, 0.5, 0, 0.5, 0}
							};
			
			int[] S = { 1, 0, 0, 0, 0, 1 }; // initial activated nodes
			
			int[] result = icmSim(G, S);
			
			for (int i=0; i<result.length; i++){
				System.out.print(result[i] + " ");
			}
			System.out.println();
		
	}
	
	// takes in a table of values (node and their friends) and initial list of activated nodes
	// returns a list of activated nodes after cascade simulation
	private static int[] icmSim(double[][] graph, int[] state){
		
		List<Integer> todo = new ArrayList<Integer>(); // list of nodes to look at
		List<Integer> done = new ArrayList<Integer>(); // list of nodes already tried
		
		//double[][] graph = G; //copy of graph
		//int[] state = S; //copy of state

		for (int i=0; i<state.length; i++){
			
			if (state[i] != 0){ // if node is activated, add node to todo list
				todo.add(i);
			}
			
		}
		
		while (!todo.isEmpty()){ // while todo isn't empty
			
			int index = todo.get(0); // retrieves next element todo
			todo.remove(0); // shifts all elements left by 1
			if (!done.contains(index)){ // if node hasn't been tried
				done.add(index); // adds to list of attempted nodes
			} else continue; // if node has been tried, don't try again
			
			for (int i=0; i<graph[index].length; i++){ // for every "friend"
				
				if (i == index) continue; // skips check if it's friends with itself
				
				else{
					if (graph[index][i] != 0){ // found a friend
						if (attemptSuccess(graph[index][i])){ // if attempt worked
							state[i] = 1; // activates node
						}
						if (!done.contains(i)){ // if node hasn't been tried
							todo.add(i);
						}
					}
				}
				
			}
			
		}
		
		return state;
	}
	
	// returns true if node is successfully activated
	private static boolean attemptSuccess(double p){ 
		if (Math.random() <= p) return true;
		else return false;
	}

}