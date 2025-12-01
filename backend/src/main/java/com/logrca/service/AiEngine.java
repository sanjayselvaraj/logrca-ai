package com.logrca.service;

import com.logrca.model.RcaResult;

public interface AiEngine {
    /**
     * Analyze raw log text and return RCA result
     */
    RcaResult analyze(String logText);
}
