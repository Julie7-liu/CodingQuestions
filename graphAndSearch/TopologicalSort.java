//Given an directed graph, a topological order of the graph nodes is defined as follow:

//For each directed edge A -> B in graph, A must before B in the order list.
The first node in the order can be any node in the graph with no nodes direct to it.
Find any topological order for the given graph.

/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */    
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        if(graph == null || graph.size() == 0){
            return graph;
        }
        
        ArrayList<DirectedGraphNode> sorted = new ArrayList<DirectedGraphNode>();
        
        //calculate the number of nodes pointing to a node
        HashMap<DirectedGraphNode, Integer> map = new HashMap<DirectedGraphNode, Integer>();
        for(DirectedGraphNode node: graph){
            for(DirectedGraphNode neighbor: node.neighbors){
                if(map.containsKey(neighbor)){
                    map.put(neighbor, map.get(neighbor) + 1);
                }else{
                    map.put(neighbor, 1);
                }
            }
        }
        
        // find the next available node, which pointed to by 0 nodes
        while(graph.size() > 0){
            DirectedGraphNode cur = null;
            for(DirectedGraphNode node: graph){
                if(!map.containsKey(node)){
                    cur = node;
                    break;
                }
            }
            
            // remove all edges start with the cur node
            for(DirectedGraphNode neighbor: cur.neighbors){
                if(map.get(neighbor) > 1){
                    map.put(neighbor, map.get(neighbor) - 1);
                }else{
                    map.remove(neighbor);
                }
            }
            sorted.add(cur);
            graph.remove(cur);
        }
        
        return sorted;
    }
}

