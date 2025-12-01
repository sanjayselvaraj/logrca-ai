package com.logrca.service;

import com.logrca.model.RcaResult;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MockAiEngine implements AiEngine {

    @Override
    public RcaResult analyze(String logText) {
        // deterministic mock implementation for MVP UI and testing
        RcaResult r = new RcaResult();
        r.setSummary("Mock summary: Detected exception patterns and errors.");
        r.setRootCause("Mock root cause: Null pointer likely due to missing validation.");
        r.setImpact("Mock impact: Affects user request processing for /api/users.");
        r.setEvidence(List.of("java.lang.NullPointerException at com.example.UserService.process(UserService.java:123)"));
        r.setFixRecommendations(List.of("Add null-check for user", "Add unit test for UserService.process()"));
        r.setConfidence("medium");
        return r;
    }
}
