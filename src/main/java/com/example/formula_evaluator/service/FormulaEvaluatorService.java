package com.example.formula_evaluator.service;

import com.example.formula_evaluator.model.CalculationRequest;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FormulaEvaluatorService {

    public Map<String, Double> evaluateFormulas(List<CalculationRequest> requests) {
        Map<String, Double> fieldValues = new HashMap<>();

        while (fieldValues.size() < requests.size()) {
            for (CalculationRequest request : requests) {
                String fieldName = request.getCalculateField();
                String formula = request.getFormula();

                if (fieldValues.containsKey(fieldName)) continue;

                try {
                    // Identify variables in the formula
                    ExpressionBuilder builder = new ExpressionBuilder(formula);
                    for (String var : fieldValues.keySet()) {
                        builder = builder.variable(var);
                    }

                    Expression expression = builder.build();

                    // Set variable values
                    for (Map.Entry<String, Double> entry : fieldValues.entrySet()) {
                        expression.setVariable(entry.getKey(), entry.getValue());
                    }

                    double result = expression.evaluate();
                    fieldValues.put(fieldName, result);

                } catch (Exception e) {
                    // Skip and try again later when dependent variables are available
                    // Could log this if needed
                }
            }
        }

        return fieldValues;
    }
}
