package com.alg.basic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
/* For implementing prim, we need to add key and parent variable to 
 * vertex class.
*/
public class Prim {
	Comparator<Vertex> com = new Comparator<Vertex>(){               //define comparator of vertex 
		public int compare(Vertex o1, Vertex o2) {					//so that it can sort as key value
			if(o1.getKey()<o2.getKey()){
				return -1;
			}
			if(o1.getKey()>o2.getKey()){
				return 1;
			}
			return 0;
		};
	};
	private PriorityQueue<Vertex> pq = new PriorityQueue<Vertex>(11,com);
	public void MST_Prim(Graph g, String name){                      //graph,and vertex name
		Vertex start = g.getVertices().get(g.searchVertex(name));    
		start.setKey(0);                                                     
	    for(Vertex v : g.getVertices()){                             // add vertices into PQ
	    	pq.offer(v);
	    }
		while(!pq.isEmpty()){
			Vertex u = pq.poll();
			if(u.getParent()!=null){
			System.out.println(u.getParent()+"-->"+u);                
			}
			ArrayList<Vertex> adjacent = u.getNext();
			for(Vertex v : adjacent){
				int i = g.searchVertex(u.getName());
				int j = g.searchVertex(v.getName());
				int weight = g.getGra()[i][j];
				if(pq.contains(v) && weight < v.getKey()){
					v.setParent(u);
					v.setKey(weight);
					ArrayList<Vertex> t = new ArrayList<Vertex>();
	/*One problem is that the priority Queue does not have the method
	 *  described as in the book can extract the minimum value even after
	 *  you have updated the value in the Q. So I have to do codes below,
	 *  looking silly, I would make an improve after I get a better mehod.
	 */
					while(!pq.isEmpty()){                      
						t.add(pq.poll());
					}
					for(Vertex ver : t){
						pq.add(ver);
					}
					
				}
			}
		}
	}
	public static void main(String[] args){
		Graph graph = new Graph(11);		
		graph.addVertex("A");
		graph.addVertex("B");
		graph.addVertex("C");
		graph.addVertex("D");
		graph.addVertex("E");
		graph.addVertex("F");
		graph.addEdge("A", "B", 3);
		graph.addEdge("A", "E", 2);
		graph.addEdge("A", "F", 5);
		graph.addEdge("B", "F", 7);
		graph.addEdge("B", "C", 4);
		graph.addEdge("C", "D", 7);
		graph.addEdge("C", "F", 4);
		graph.addEdge("D", "F", 6);
		graph.addEdge("D", "E", 5);
		graph.addEdge("E", "F", 2);
		Prim p = new Prim();
		p.MST_Prim(graph, "A");
	}
}
