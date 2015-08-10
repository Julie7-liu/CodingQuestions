//Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.

/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node){
        if(node == null){
            return null;
        }
        
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        
        // BFS, using ArrayList as queue:
        // 1. add new nodes to visit in the future
        // 2. know which nodes have been visited
        // ps: no need to poll(), because we want to tell which are visited, just move the index
        ArrayList<UndirectedGraphNode> nodes = new ArrayList<UndirectedGraphNode>();
        nodes.add(node);
        UndirectedGraphNode curNode, newNode;
        int visited = 0;
        while(visited < nodes.size()){
            curNode = nodes.get(visited ++);
            newNode = new UndirectedGraphNode(curNode.label);
            map.put(curNode, newNode);
            
            for(UndirectedGraphNode neighbor: curNode.neighbors){
                // do not copy the neighbor if a visited node
                if(nodes.contains(neighbor)){
                    continue;
                }
                
                nodes.add(neighbor);
                newNode = new UndirectedGraphNode(neighbor.label);
                map.put(neighbor, newNode);
            }
        }
        
        for(UndirectedGraphNode cur: nodes){
            for(UndirectedGraphNode neighbor: cur.neighbors){
                map.get(cur).neighbors.add(map.get(neighbor));
            }
        }
        
        return map.get(node);
    } 
}

