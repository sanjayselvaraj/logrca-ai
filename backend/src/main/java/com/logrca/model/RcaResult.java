package com.logrca.model;

import java.util.List;

public class RcaResult {
    private String summary;
    private String rootCause;
    private String impact;
    private List<String> evidence;
    private List<String> fixRecommendations;
    private String confidence;

    // getters & setters
    public String getSummary() { return summary; }
    public void setSummary(String summary) { this.summary = summary; }
    public String getRootCause() { return rootCause; }
    public void setRootCause(String rootCause) { this.rootCause = rootCause; }
    public String getImpact() { return impact; }
    public void setImpact(String impact) { this.impact = impact; }
    public List<String> getEvidence() { return evidence; }
    public void setEvidence(List<String> evidence) { this.evidence = evidence; }
    public List<String> getFixRecommendations() { return fixRecommendations; }
    public void setFixRecommendations(List<String> fixRecommendations) { this.fixRecommendations = fixRecommendations; }
    public String getConfidence() { return confidence; }
    public void setConfidence(String confidence) { this.confidence = confidence; }
}
