// Generated from /Users/joshuacrotts/Desktop/Files/Programming/Formal-Logic-Aiding-Tutor/main/antlr4/com/llat/FLAT.g4 by ANTLR 4.9.1
package com.flat;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link FLATParser}.
 */
public interface FLATListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link FLATParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(FLATParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link FLATParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(FLATParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link FLATParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterAtom(FLATParser.AtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link FLATParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitAtom(FLATParser.AtomContext ctx);
	/**
	 * Enter a parse tree produced by {@link FLATParser#propositionalWff}.
	 * @param ctx the parse tree
	 */
	void enterPropositionalWff(FLATParser.PropositionalWffContext ctx);
	/**
	 * Exit a parse tree produced by {@link FLATParser#propositionalWff}.
	 * @param ctx the parse tree
	 */
	void exitPropositionalWff(FLATParser.PropositionalWffContext ctx);
	/**
	 * Enter a parse tree produced by {@link FLATParser#propWff}.
	 * @param ctx the parse tree
	 */
	void enterPropWff(FLATParser.PropWffContext ctx);
	/**
	 * Exit a parse tree produced by {@link FLATParser#propWff}.
	 * @param ctx the parse tree
	 */
	void exitPropWff(FLATParser.PropWffContext ctx);
	/**
	 * Enter a parse tree produced by {@link FLATParser#propNegRule}.
	 * @param ctx the parse tree
	 */
	void enterPropNegRule(FLATParser.PropNegRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link FLATParser#propNegRule}.
	 * @param ctx the parse tree
	 */
	void exitPropNegRule(FLATParser.PropNegRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link FLATParser#propAndRule}.
	 * @param ctx the parse tree
	 */
	void enterPropAndRule(FLATParser.PropAndRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link FLATParser#propAndRule}.
	 * @param ctx the parse tree
	 */
	void exitPropAndRule(FLATParser.PropAndRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link FLATParser#propOrRule}.
	 * @param ctx the parse tree
	 */
	void enterPropOrRule(FLATParser.PropOrRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link FLATParser#propOrRule}.
	 * @param ctx the parse tree
	 */
	void exitPropOrRule(FLATParser.PropOrRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link FLATParser#propImpRule}.
	 * @param ctx the parse tree
	 */
	void enterPropImpRule(FLATParser.PropImpRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link FLATParser#propImpRule}.
	 * @param ctx the parse tree
	 */
	void exitPropImpRule(FLATParser.PropImpRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link FLATParser#propBicondRule}.
	 * @param ctx the parse tree
	 */
	void enterPropBicondRule(FLATParser.PropBicondRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link FLATParser#propBicondRule}.
	 * @param ctx the parse tree
	 */
	void exitPropBicondRule(FLATParser.PropBicondRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link FLATParser#propExclusiveOrRule}.
	 * @param ctx the parse tree
	 */
	void enterPropExclusiveOrRule(FLATParser.PropExclusiveOrRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link FLATParser#propExclusiveOrRule}.
	 * @param ctx the parse tree
	 */
	void exitPropExclusiveOrRule(FLATParser.PropExclusiveOrRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link FLATParser#constant}.
	 * @param ctx the parse tree
	 */
	void enterConstant(FLATParser.ConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link FLATParser#constant}.
	 * @param ctx the parse tree
	 */
	void exitConstant(FLATParser.ConstantContext ctx);
	/**
	 * Enter a parse tree produced by {@link FLATParser#variable}.
	 * @param ctx the parse tree
	 */
	void enterVariable(FLATParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link FLATParser#variable}.
	 * @param ctx the parse tree
	 */
	void exitVariable(FLATParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link FLATParser#universal}.
	 * @param ctx the parse tree
	 */
	void enterUniversal(FLATParser.UniversalContext ctx);
	/**
	 * Exit a parse tree produced by {@link FLATParser#universal}.
	 * @param ctx the parse tree
	 */
	void exitUniversal(FLATParser.UniversalContext ctx);
	/**
	 * Enter a parse tree produced by {@link FLATParser#existential}.
	 * @param ctx the parse tree
	 */
	void enterExistential(FLATParser.ExistentialContext ctx);
	/**
	 * Exit a parse tree produced by {@link FLATParser#existential}.
	 * @param ctx the parse tree
	 */
	void exitExistential(FLATParser.ExistentialContext ctx);
	/**
	 * Enter a parse tree produced by {@link FLATParser#predicate}.
	 * @param ctx the parse tree
	 */
	void enterPredicate(FLATParser.PredicateContext ctx);
	/**
	 * Exit a parse tree produced by {@link FLATParser#predicate}.
	 * @param ctx the parse tree
	 */
	void exitPredicate(FLATParser.PredicateContext ctx);
	/**
	 * Enter a parse tree produced by {@link FLATParser#predicateWff}.
	 * @param ctx the parse tree
	 */
	void enterPredicateWff(FLATParser.PredicateWffContext ctx);
	/**
	 * Exit a parse tree produced by {@link FLATParser#predicateWff}.
	 * @param ctx the parse tree
	 */
	void exitPredicateWff(FLATParser.PredicateWffContext ctx);
	/**
	 * Enter a parse tree produced by {@link FLATParser#predWff}.
	 * @param ctx the parse tree
	 */
	void enterPredWff(FLATParser.PredWffContext ctx);
	/**
	 * Exit a parse tree produced by {@link FLATParser#predWff}.
	 * @param ctx the parse tree
	 */
	void exitPredWff(FLATParser.PredWffContext ctx);
	/**
	 * Enter a parse tree produced by {@link FLATParser#predQuantifier}.
	 * @param ctx the parse tree
	 */
	void enterPredQuantifier(FLATParser.PredQuantifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link FLATParser#predQuantifier}.
	 * @param ctx the parse tree
	 */
	void exitPredQuantifier(FLATParser.PredQuantifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link FLATParser#predNegRule}.
	 * @param ctx the parse tree
	 */
	void enterPredNegRule(FLATParser.PredNegRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link FLATParser#predNegRule}.
	 * @param ctx the parse tree
	 */
	void exitPredNegRule(FLATParser.PredNegRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link FLATParser#predAndRule}.
	 * @param ctx the parse tree
	 */
	void enterPredAndRule(FLATParser.PredAndRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link FLATParser#predAndRule}.
	 * @param ctx the parse tree
	 */
	void exitPredAndRule(FLATParser.PredAndRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link FLATParser#predOrRule}.
	 * @param ctx the parse tree
	 */
	void enterPredOrRule(FLATParser.PredOrRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link FLATParser#predOrRule}.
	 * @param ctx the parse tree
	 */
	void exitPredOrRule(FLATParser.PredOrRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link FLATParser#predImpRule}.
	 * @param ctx the parse tree
	 */
	void enterPredImpRule(FLATParser.PredImpRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link FLATParser#predImpRule}.
	 * @param ctx the parse tree
	 */
	void exitPredImpRule(FLATParser.PredImpRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link FLATParser#predBicondRule}.
	 * @param ctx the parse tree
	 */
	void enterPredBicondRule(FLATParser.PredBicondRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link FLATParser#predBicondRule}.
	 * @param ctx the parse tree
	 */
	void exitPredBicondRule(FLATParser.PredBicondRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link FLATParser#predExclusiveOrRule}.
	 * @param ctx the parse tree
	 */
	void enterPredExclusiveOrRule(FLATParser.PredExclusiveOrRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link FLATParser#predExclusiveOrRule}.
	 * @param ctx the parse tree
	 */
	void exitPredExclusiveOrRule(FLATParser.PredExclusiveOrRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link FLATParser#predIdentityRule}.
	 * @param ctx the parse tree
	 */
	void enterPredIdentityRule(FLATParser.PredIdentityRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link FLATParser#predIdentityRule}.
	 * @param ctx the parse tree
	 */
	void exitPredIdentityRule(FLATParser.PredIdentityRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link FLATParser#predPremise}.
	 * @param ctx the parse tree
	 */
	void enterPredPremise(FLATParser.PredPremiseContext ctx);
	/**
	 * Exit a parse tree produced by {@link FLATParser#predPremise}.
	 * @param ctx the parse tree
	 */
	void exitPredPremise(FLATParser.PredPremiseContext ctx);
	/**
	 * Enter a parse tree produced by {@link FLATParser#predConclusion}.
	 * @param ctx the parse tree
	 */
	void enterPredConclusion(FLATParser.PredConclusionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FLATParser#predConclusion}.
	 * @param ctx the parse tree
	 */
	void exitPredConclusion(FLATParser.PredConclusionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FLATParser#predProof}.
	 * @param ctx the parse tree
	 */
	void enterPredProof(FLATParser.PredProofContext ctx);
	/**
	 * Exit a parse tree produced by {@link FLATParser#predProof}.
	 * @param ctx the parse tree
	 */
	void exitPredProof(FLATParser.PredProofContext ctx);
	/**
	 * Enter a parse tree produced by {@link FLATParser#propPremise}.
	 * @param ctx the parse tree
	 */
	void enterPropPremise(FLATParser.PropPremiseContext ctx);
	/**
	 * Exit a parse tree produced by {@link FLATParser#propPremise}.
	 * @param ctx the parse tree
	 */
	void exitPropPremise(FLATParser.PropPremiseContext ctx);
	/**
	 * Enter a parse tree produced by {@link FLATParser#propConclusion}.
	 * @param ctx the parse tree
	 */
	void enterPropConclusion(FLATParser.PropConclusionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FLATParser#propConclusion}.
	 * @param ctx the parse tree
	 */
	void exitPropConclusion(FLATParser.PropConclusionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FLATParser#propProof}.
	 * @param ctx the parse tree
	 */
	void enterPropProof(FLATParser.PropProofContext ctx);
	/**
	 * Exit a parse tree produced by {@link FLATParser#propProof}.
	 * @param ctx the parse tree
	 */
	void exitPropProof(FLATParser.PropProofContext ctx);
	/**
	 * Enter a parse tree produced by {@link FLATParser#predSemanticEntailment}.
	 * @param ctx the parse tree
	 */
	void enterPredSemanticEntailment(FLATParser.PredSemanticEntailmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link FLATParser#predSemanticEntailment}.
	 * @param ctx the parse tree
	 */
	void exitPredSemanticEntailment(FLATParser.PredSemanticEntailmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link FLATParser#propSemanticEntailment}.
	 * @param ctx the parse tree
	 */
	void enterPropSemanticEntailment(FLATParser.PropSemanticEntailmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link FLATParser#propSemanticEntailment}.
	 * @param ctx the parse tree
	 */
	void exitPropSemanticEntailment(FLATParser.PropSemanticEntailmentContext ctx);
}