package com.node.n.controller;


import com.node.n.service.NodeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class NodeController {

    private final NodeService nodeService;

    public NodeController(NodeService nodeService) {
        this.nodeService = nodeService;
    }

    @PostMapping("/join")
    public <JoinRequest> ResponseEntity<String> joinNodes(@RequestBody JoinRequest joinRequest) {
        int node1 = joinRequest.getClass().getModifiers();
        int node2 = joinRequest.getClass().getModifiers();

        nodeService.joinNodes(node1, node2);

        return ResponseEntity.ok("Nodes joined successfully");
    }

    @GetMapping ("/isConnected")
    public ResponseEntity<Boolean> areNodesConnected(@RequestParam("node1") int node1, @RequestParam("node2") int node2) {
        boolean isConnected = nodeService.areNodesConnected(node1, node2);

        return ResponseEntity.ok(isConnected);
    }
}
