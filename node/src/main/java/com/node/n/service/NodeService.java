package com.node.n.service;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class NodeService {

    private Map<Integer, Integer> nodeConnections;

    public NodeService() {
        nodeConnections = new HashMap<>();
    }

    public void joinNodes(int node1, int node2) {
        nodeConnections.put(node1, node2);
    }

    public boolean areNodesConnected(int node1, int node2) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        visited.add(node1);
        queue.add(node1);

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();

            if (currentNode == node2) {
                return true;
            }

            Integer connectedNode = nodeConnections.get(currentNode);
            if (connectedNode != null && !visited.contains(connectedNode)) {
                visited.add(connectedNode);
                queue.add(connectedNode);
            }
        }

        return false;
    }
}
