import java.util.ArrayList;
import java.util.List;
public class continuoustime {
	
	/* Continuous Time Model
	 * Kyle Chua
	 * Last Changed: Nov 17, 2016
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
			
			int[] result = ctSim(G, S, 100);
			
			for (int i=0; i<result.length; i++){
				System.out.print(result[i] + " ");
			}
			System.out.println();
		
	}
	
	// takes in a table of values (node and their friends) and initial list of activated nodes
	// returns a list of activated nodes after continuous time simulation
	private static int[] ctSim(double[][] graph, int[] state, int time){
		
		List<Integer> active = new ArrayList<Integer>(); // list of activated nodes
		List<Integer> done = new ArrayList<Integer>(); // list of nodes already tried
		
		int curTime = 0;
		
		while (curTime < time){
			
			
			curTime++;
		}
		
		return state;
	}

}