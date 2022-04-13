package com.gabrr.calculator_antlr.parser;

import com.gabrr.calculator_antlr.generated_sources.CalculatorBaseVisitor;
import com.gabrr.calculator_antlr.generated_sources.CalculatorParser;

public class CalcVisitor extends CalculatorBaseVisitor<Double> {
    @Override
    public Double visitParenth(CalculatorParser.ParenthContext ctx) {
        return this.visit(ctx.expr());
    }

    @Override
    public Double visitAddOrSub(CalculatorParser.AddOrSubContext ctx) {
        if (ctx.op.getText().equals("+")) {
            return this.visit(ctx.numb1) + this.visit(ctx.numb2);
        }

        return this.visit(ctx.numb1) - this.visit(ctx.numb2);
    }

    @Override
    public Double visitMulOrDiv(CalculatorParser.MulOrDivContext ctx) {
        if (ctx.op.getText().equals("*")) {
            return this.visit(ctx.numb1) * this.visit(ctx.numb2);
        }

        return this.visit(ctx.numb1) / this.visit(ctx.numb2);
    }

    @Override
    public Double visitNumb(CalculatorParser.NumbContext ctx) {
        return Double.parseDouble(ctx.NUMB().getText());
    }
}
