import java.util.ArrayList;
import java.util.List;
public class kcomplexmodel {
	
	/* K-Complex Model
	 * Kyle Chua
	 * Last Changed: Oct 24, 2016
	 */

	public static void main(String[] args) {

			double[][] G = { // given chart w/ influences
								{0, 0.5, 0, 0, 1, 0.5},
								{0, 0, 0, 0.5, 0, 0.5},
								{0, 0, 0, 0, 0, 0},
								{0.5, 0, 0, 0, 0, 0},
								{0, 0.5, 0, 0, 0, 0},
								{0, 0.25, 0.5, 0, 0.5, 0}
							};
			
			int[] S = { 1, 0, 0, 0, 0, 1 }; // initial activated nodes
			
			int[] result = kcomplexSim(G, S, 1.5);
			
			for (int i=0; i<result.length; i++){
				System.out.print(result[i] + " ");
			}
			System.out.println();
		
	}
	
	// takes in a table of values (node and their friends) and initial list of activated nodes
	// returns a list of activated nodes after cascade simulation
	private static int[] kcomplexSim(double[][] graph, int[] state, double k){
		
		List<Integer> todo = new ArrayList<Integer>(); // list of nodes to look at
		List<Integer> done = new ArrayList<Integer>(); // list of nodes already tried
		
		double[] S = new double[state.length]; //copy of state

		for (int i=0; i<state.length; i++){
		
			S[i] = state[i];
			
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
						
						S[i] += graph[index][i]; // adds influence
							
						if ((!done.contains(i)) && (S[i] >= k)){ // if node hasn't been tried and node is activated
							todo.add(i);
						}
					}
				}
				
			}
			
		}
		
		for (int i=0; i<state.length; i++){
			
			if (S[i] >= k){
				state[i] = 1;
			}
			
		}
		
		return state;
	}

}