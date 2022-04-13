package com.gabrr.calculator_antlr.generated_sources;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CalculatorParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CalculatorVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link CalculatorParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(CalculatorParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Parenth}
	 * labeled alternative in {@link CalculatorParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenth(CalculatorParser.ParenthContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AddOrSub}
	 * labeled alternative in {@link CalculatorParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddOrSub(CalculatorParser.AddOrSubContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MulOrDiv}
	 * labeled alternative in {@link CalculatorParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulOrDiv(CalculatorParser.MulOrDivContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Numb}
	 * labeled alternative in {@link CalculatorParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumb(CalculatorParser.NumbContext ctx);
}