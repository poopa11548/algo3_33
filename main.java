package algo3_3;

import java.util.LinkedList;
public class main {
	public static LinkedList<Integer> topolog(Graph G){
		LinkedList<Integer> L=new LinkedList<Integer>();
		for(int i=0;i<G.v;i++){
			G.color[i]="white";
			G.p[i]=-1;
		}
		for(int i=0;i<G.v;i++){
			if(G.color[i]=="white")
				dfs(i,G,L);
		}
		return L;
	}
	public static void dfs(int i,Graph G,LinkedList<Integer> L){
		G.color[i]="gray";
		for(int j=0;j<G.adj[i].size();j++){
			if(G.color[G.adj[i].get(j).dest]=="white"){
				G.p[G.adj[i].get(j).dest]=i;
				dfs(G.adj[i].get(j).dest,G,L);
			}
		}
		G.color[i]="black";
		L.addFirst(i);
	}
	public static void init(Graph G){
		for(int i=0;i<G.v;i++){
			if(G.p[i]==-1)
				G.d[i]=0;
			else
				G.d[i]=Integer.MIN_VALUE;
		}
	}
	public static void dej(Graph G){
		LinkedList<Integer> L=topolog(G);
		init(G);
		for(int i=0;i<L.size();i++){
			int u=L.get(i);
			for(int j=0;j<G.adj[u].size();j++){
				if(G.d[G.adj[u].get(j).dest]<G.d[u]+G.adj[u].get(j).whight){
					G.d[G.adj[u].get(j).dest]=G.d[u]+G.adj[u].get(j).whight;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Graph G=new Graph(7,7);
		G.addEdge(0, 1,15);
		G.addEdge(0, 2,5);
		G.addEdge(2, 3,5);
		G.addEdge(3, 1,6);
		G.addEdge(3, 4,8);
		G.addEdge(1, 4,10);
		G.addEdge(5, 6, 15);
		//LinkedList<Integer> L=topologi(G);
		dej(G);
		for(int i=0;i<G.v;i++){
			System.out.println(i+"="+G.d[i]);
		}
	}
}


