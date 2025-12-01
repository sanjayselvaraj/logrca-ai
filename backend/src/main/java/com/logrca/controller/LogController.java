package com.logrca.controller;

import com.logrca.model.RcaResult;
import com.logrca.service.AiEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;
import java.io.BufferedReader;
import java.io.InputStreamReader;

@Controller
public class LogController {

    private final AiEngine aiEngine;

    @Autowired
    public LogController(AiEngine aiEngine) {
        this.aiEngine = aiEngine;
    }

    @GetMapping({"/", "/upload"})
    public String uploadPage() {
        return "upload";
    }

    @PostMapping("/analyze")
    public String analyze(@RequestParam("logfile") MultipartFile logfile, Model model) {
        try {
            // read uploaded file into string (careful with huge files; add limits later)
            String content;
            try (BufferedReader br = new BufferedReader(new InputStreamReader(logfile.getInputStream(), StandardCharsets.UTF_8))) {
                content = br.lines().collect(Collectors.joining("\n"));
            }

            // call AI engine (mock for now)
            RcaResult result = aiEngine.analyze(content);

            model.addAttribute("result", result);
            model.addAttribute("raw", content.length() > 4000 ? content.substring(0, 4000) + "\n\n...truncated..." : content);
            return "result";
        } catch (Exception ex) {
            model.addAttribute("error", "Failed to analyze log: " + ex.getMessage());
            return "upload";
        }
    }
}
