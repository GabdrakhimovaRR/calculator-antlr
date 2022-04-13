package com.gabrr.calculator_antlr.infrastructure;

import com.gabrr.calculator_antlr.exception.ThrowingErrorListener;
import com.gabrr.calculator_antlr.generated_sources.CalculatorLexer;
import com.gabrr.calculator_antlr.generated_sources.CalculatorParser;
import com.gabrr.calculator_antlr.parser.CalcVisitor;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.Scanner;

public class Calculator {
    public void run() {
        Scanner in = new Scanner(System.in);
        boolean correctInput = false;
        double result = 0.0;

        while (!correctInput) {
            System.out.print("Input evaluated expression: ");
            String str = in.nextLine();

            try {
                result = calculate(str);
                correctInput = true;
            } catch(ParseCancellationException e) {
                System.out.println(e.getMessage());
                System.out.println("Please enter correct expression!");
            }
        }

        System.out.println("Result of expression: " + result);
        in.close();
    }

    public double calculate(String str) throws ParseCancellationException {
        CharStream chars = CharStreams.fromString(str);
        Lexer lexer = new CalculatorLexer(chars);
        lexer.removeErrorListeners();
        lexer.addErrorListener(ThrowingErrorListener.INSTANCE);

        CommonTokenStream tokens = new CommonTokenStream(lexer);
        CalculatorParser parser = new CalculatorParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(ThrowingErrorListener.INSTANCE);

        ParseTree tree = parser.prog();
        CalcVisitor calculator = new CalcVisitor();

        return calculator.visit(tree);
    }
}
