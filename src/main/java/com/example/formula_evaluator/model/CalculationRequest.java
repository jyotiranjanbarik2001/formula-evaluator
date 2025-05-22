package com.example.formula_evaluator.model;


public class CalculationRequest {

    private String calculateField;
    private String formula;

    public CalculationRequest() {
    }

    public CalculationRequest(String calculateField, String formula) {
        this.calculateField = calculateField;
        this.formula = formula;
    }

    public String getCalculateField() {
        return calculateField;
    }

    public void setCalculateField(String calculateField) {
        this.calculateField = calculateField;
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }
}