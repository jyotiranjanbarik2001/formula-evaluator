package com.example.formula_evaluator.controller;


import com.example.formula_evaluator.model.CalculationRequest;
import com.example.formula_evaluator.service.FormulaEvaluatorService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.script.ScriptException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/formula")
public class FormulaEvaluatorController {

    private FormulaEvaluatorService evaluatorService;

    public FormulaEvaluatorController(FormulaEvaluatorService evaluatorService) {
        this.evaluatorService = evaluatorService;
    }

    @PostMapping("/evaluate")
    public Map<String, Double> evaluateFormulas(@RequestBody List<CalculationRequest> requests) throws ScriptException {
        return evaluatorService.evaluateFormulas(requests);
    }

}
