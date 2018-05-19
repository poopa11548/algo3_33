package algo3_3;

import java.util.LinkedList;


public class Graph {
	class edge{
		int dest;
		int whight;
		edge(int d,int w){
			dest=d;
			whight=w;
		}
	};
	    int v; 
	    int e;
	    int[] d;
	    int [] p;
	    String color[];
	    LinkedList<edge> adj[];
	    Graph(int v_,int e_)
	    {
	    	e=e_;
	        v= v_;
	        d=new int[v];
	        p=new int [v];
	        color=new String[v];
	        adj = new LinkedList[v];
	        for (int i=0; i<v; ++i){
	            adj[i] = new LinkedList<edge>();
	        }
	       
	        
	    }
	    void addEdge(int v_, int u,int w)
	    {
	    	edge T=new edge(u,w);
	        adj[v_].add(T);
	    }
}
