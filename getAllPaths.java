**
 * @author Simir Cooper 
 * @since 5/3/21
 * This program takes in a two dimensional array and finds all of the paths from 0 to N-1 using the
 * DFS approach.
 */
import java.util.*;
public class getAllPaths {
	/**
	 * allPaths function takes in a 2d array and returns a 2d array with the desired outcome  
	 * @param int [][] graph 
	 * @return int [][] with all of the paths 
	 */
	public int[][] allPaths(int [][] graph){
		List<List<Integer>> list = new ArrayList<>(); //creating two dimensional list to store paths temporarily.
		List<Integer> path = new ArrayList<>(); //creating list to store individual paths
		getpath(graph, 0, list, path); //call get path to find all paths 
		int res [][] = new int [list.size()][1];
		for(int i=0; i< list.size(); i++) { //for loop converts 2d list into 2d array
			res[i] = new int [list.get(i).size()];
			for(int j=0; j<list.get(i).size();j++) {
				res[i][j]=list.get(i).get(j);
			}
				
		}
		return res;
		
		
	}
	/**
	 * getpath function traverses the graph from the starting vertex and adds each path to a list.
	 * @param graph
	 * @param start
	 * @param list
	 * @param path
	 * 
	 */
	private void getpath(int [][] graph,int v,List<List<Integer>> list, List<Integer> path){
		path.add(v); //path starts at a designated vertex each time
		 if(v == graph.length-1){ //add the path to the temporary 2d list
			 list.add(new ArrayList(path));
		 }
		 else {
			 for(int v: graph[start]){ //construct the path/traverse the graph until start = N-1
				 getpath(graph, v, list, path);
			 }
	                
	                
		 }
		 path.remove(path.size()-1);
		
	}
	

	public static void main(String[] args) {
		//test
		getAllPaths ob = new getAllPaths();
		int [] [] sample_graph = {{1,2},{3}, {3}, {}};
		System.out.println(Arrays.deepToString(ob.allPaths(sample_graph)));

	}

}
