package com.flat.models.algorithms;

import com.flat.models.algorithms.attributes.LogicReturn;
import com.flat.models.algorithms.attributes.ApplicableAlgorithms;
import com.flat.algorithms.ArgumentTruthTreeValidator;
import com.flat.algorithms.ClosedTreeDeterminer;
import com.flat.algorithms.LogicalFalsehoodDeterminer;
import com.flat.algorithms.LogicalTautologyDeterminer;
import com.flat.algorithms.LogicallyConsistentDeterminer;
import com.flat.algorithms.LogicallyContingentDeterminer;
import com.flat.algorithms.LogicallyContradictoryDeterminer;
import com.flat.algorithms.LogicallyContraryDeterminer;
import com.flat.algorithms.LogicallyEquivalentDeterminer;
import com.flat.algorithms.LogicallyImpliedDeterminer;
import com.flat.algorithms.MainOperatorDetector;
import com.flat.algorithms.OpenTreeDeterminer;
import com.flat.algorithms.SemanticEntailmentDeterminer;
import com.flat.algorithms.models.ProofType;
import com.flat.algorithms.predicate.BoundVariableDetector;
import com.flat.algorithms.predicate.ClosedSentenceDeterminer;
import com.flat.algorithms.predicate.FreeVariableDetector;
import com.flat.algorithms.predicate.GroundSentenceDeterminer;
import com.flat.algorithms.predicate.OpenSentenceDeterminer;
import com.flat.algorithms.predicate.PredicateNaturalDeductionValidator;
import com.flat.algorithms.predicate.PredicateTruthTreeGenerator;
import com.flat.algorithms.predicate.RandomPredicateFormulaGenerator;
import com.flat.algorithms.predicate.VacuousQuantifierDetector;
import com.flat.algorithms.propositional.PropositionalNaturalDeductionValidator;
import com.flat.algorithms.propositional.PropositionalTruthTreeGenerator;
import com.flat.algorithms.propositional.RandomPropositionalFormulaGenerator;
import com.flat.algorithms.propositional.TruthTableGenerator;
import com.flat.models.data.algorithms.Algorithms;
import com.flat.models.data.algorithms.base.Algorithm;
import com.flat.models.treenode.WffTree;
import java.util.ArrayList;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class ApplyAlgorithm {
    private ArrayList <WffTree> wffTree = new ArrayList();
    private Algorithms algorithms = null;
    private ApplicableAlgorithms applicableAlgorithms = new ApplicableAlgorithms();

    public ApplyAlgorithm (Algorithms _algorithm) {
        this.setAlgorithms(_algorithm);
    }

    public LogicReturn apply (Algorithm _algorithm) {
        this.resetHighlights();
        switch (_algorithm.getType()) {
            // General Algorithms.
            case ARGUMENT_TRUTH_TREE_VALIDATOR:
                ArgumentTruthTreeValidator attv = new ArgumentTruthTreeValidator(this.wffTree);
                return new LogicReturn(attv.isValid(), attv.getTruthTree(), attv.getCombinedTree());
            case CLOSED_TREE_DETERMINER:
                return new LogicReturn(new ClosedTreeDeterminer(this.wffTree.get(0)).hasAllClosed(), this.wffTree.get(0));
            case LOGICAL_FALSEHOOD_DETERMINER:
                LogicalFalsehoodDeterminer lfd = new LogicalFalsehoodDeterminer(this.wffTree.get(0));
                return new LogicReturn(lfd.isFalsehood(), lfd.getTruthTree(), lfd.getWffTree());
            case LOGICALLY_CONSISTENT_DETERMINER:
                LogicallyConsistentDeterminer lcd3 = new LogicallyConsistentDeterminer(this.wffTree.get(0), this.wffTree.get(1));
                return new LogicReturn(lcd3.isConsistent(), lcd3.getCombinedTruthTree(), lcd3.getCombinedTree());
            case LOGICALLY_CONTINGENT_DETERMINER:
                LogicallyContingentDeterminer lcd = new LogicallyContingentDeterminer(this.wffTree.get(0));
                return new LogicReturn(lcd.isContingent(), lcd.getWffTree());
            case LOGICALLY_CONTRADICTORY_DETERMINER:
                LogicallyContradictoryDeterminer lcd2 = new LogicallyContradictoryDeterminer(this.wffTree.get(0), this.wffTree.get(1));
                return new LogicReturn(lcd2.isContradictory(), lcd2.getTruthTree(), lcd2.getCombinedTree());
            case LOGICALLY_CONTRARY_DETERMINER:
                LogicallyContraryDeterminer lcd4 = new LogicallyContraryDeterminer(this.wffTree.get(0), this.wffTree.get(1));
                return new LogicReturn(lcd4.isContrary(), lcd4.getCombinedTruthTree(), lcd4.getCombinedTree());
            case LOGICALLY_EQUIVALENT_DETERMINER:
                LogicallyEquivalentDeterminer led = new LogicallyEquivalentDeterminer(this.wffTree.get(0), this.wffTree.get(1));
                return new LogicReturn(led.isEquivalent(), led.getTruthTree(), led.getCombinedTree());
            case LOGICALLY_IMPLIED_DETERMINER:
                LogicallyImpliedDeterminer lid = new LogicallyImpliedDeterminer(this.wffTree.get(0), this.wffTree.get(1));
                return new LogicReturn(lid.isImplied(), lid.getTruthTree(), lid.getCombinedTree());
            case LOGICAL_TAUTOLOGY_DETERMINER:
                LogicalTautologyDeterminer ltd = new LogicalTautologyDeterminer(this.wffTree.get(0));
                return new LogicReturn(ltd.isTautology(), ltd.getTruthTree(), ltd.getWffTree());
            case MAIN_OPERATOR_DETECTOR:
                MainOperatorDetector mod = new MainOperatorDetector(this.wffTree.get(0));
                mod.getMainOperator().setHighlighted(true);
                return new LogicReturn(this.wffTree.get(0));
            case OPEN_TREE_DETERMINER:
                return new LogicReturn(new OpenTreeDeterminer(this.wffTree.get(0)).hasSomeOpen(), this.wffTree.get(0));
            case SEMANTIC_ENTAILMENT_DETERMINER:
                SemanticEntailmentDeterminer sed = new SemanticEntailmentDeterminer(this.wffTree);
                return new LogicReturn(sed.isSemanticallyEntailing(), sed.getTruthTree(), sed.getCombinedTree());

            // Propositional Algorithms.
            case PROPOSITIONAL_NATURAL_DEDUCTION:
                PropositionalNaturalDeductionValidator pndv = new PropositionalNaturalDeductionValidator(this.wffTree, ProofType.DIRECT);
                return new LogicReturn(pndv.getNaturalDeductionProof());
            case PROPOSITIONAL_TRUTH_TREE_GENERATOR:
                PropositionalTruthTreeGenerator pttg = new PropositionalTruthTreeGenerator(this.wffTree.get(0));
                return new LogicReturn(pttg.getTruthTree(), pttg.getWffTree());
            case RANDOM_PROPOSITIONAL_FORMULA:
                return new LogicReturn(new RandomPropositionalFormulaGenerator().genRandomPropositionalFormula());
            case TRUTH_TABLE_GENERATOR:
                return new LogicReturn(new TruthTableGenerator(this.wffTree.get(0)).getTruthTable(), this.wffTree.get(0));

            // Predicate Algorithms.
            case BOUND_VARIABLE_DETECTOR:
                BoundVariableDetector bvd = new BoundVariableDetector(this.wffTree.get(0));
                this.highlightTrees(bvd.getBoundVariables());
                return new LogicReturn(this.wffTree.get(0));
            case CLOSED_SENTENCE_DETERMINER:
                return new LogicReturn(new ClosedSentenceDeterminer(this.wffTree.get(0)).isClosedSentence(), this.wffTree.get(0));
            case FREE_VARIABLE_DETECTOR:
                this.highlightTrees(new FreeVariableDetector(this.wffTree.get(0)).getFreeVariables());
                return new LogicReturn(this.wffTree.get(0));
            case GROUND_SENTENCE_DETERMINER:
                return new LogicReturn(new GroundSentenceDeterminer(this.wffTree.get(0)).isGroundSentence(), this.wffTree.get(0));
            case OPEN_SENTENCE_DETERMINER:
                return new LogicReturn(new OpenSentenceDeterminer(this.wffTree.get(0)).isOpenSentence(), this.wffTree.get(0));
            case PREDICATE_NATURAL_DEDUCTION:
                PredicateNaturalDeductionValidator pndv2 = new PredicateNaturalDeductionValidator(this.wffTree, ProofType.DIRECT);
                return new LogicReturn(pndv2.getNaturalDeductionProof());
            case PREDICATE_TRUTH_TREE_GENERATOR:
                PredicateTruthTreeGenerator pttg2 = new PredicateTruthTreeGenerator(this.wffTree.get(0));
                return new LogicReturn(pttg2.getTruthTree(), pttg2.getWffTree());
            case RANDOM_PREDICATE_FORMULA:
                return new LogicReturn(new RandomPredicateFormulaGenerator().genRandomPredicateFormula());
            case VACCUOUS_QUANTIFIER_DETECTOR:
                VacuousQuantifierDetector vqd = new VacuousQuantifierDetector(this.wffTree.get(0));
                this.highlightTrees(vqd.getVacuousQuantifiers());
                return new LogicReturn(this.wffTree.get(0));
            default:
                return new LogicReturn();
        }
    }

    private void resetHighlights () {
        if (!this.wffTree.isEmpty())
            this.wffTree.get(0).clearHighlighting();
    }

    private void highlightTrees (ArrayList <WffTree> _trees) {
        _trees.forEach(tree -> {
            tree.setHighlighted(true);
        });
    }

    // Getters for object's attributes
    public ArrayList <WffTree> getWffTree() {
        return wffTree;
    }

    public Algorithms getAlgorithms() {
        return algorithms;
    }

    public ApplicableAlgorithms getApplicableAlgorithms () {
        return applicableAlgorithms;
    }

    // Setters for object's attributes.
    public void setWffTree(ArrayList <WffTree> wffTree) {
        this.wffTree = wffTree;
        this.setApplicableAlgorithms();
    }

    public final void setAlgorithms(Algorithms _algorithms) {
        this.algorithms = _algorithms;
        this.setApplicableAlgorithms();
    }

    private void setApplicableAlgorithms() {
        this.applicableAlgorithms.clearAllAlgorithms();
        this.setPredicateAlgorithms();
        this.setPropositionalAlgorithms();
        System.out.println(this.wffTree.size());
        switch (this.wffTree.size()) {
            case 0:
                break;
            case 1:
                this.setGeneralOneAlgorithms();
                if (this.wffTree.get(0).isPredicateWff())
                    this.setPredicateOneAlgorithms();
                else
                    this.setPropositionalOneAlgorithms();
                break;
            case 2:
                this.setGeneralTwoAlgorithms();
                this.setGeneralMoreAlgorithms();
                if (this.wffTree.get(0).isPredicateWff())
                    this.setPredicateMoreAlgorithms();
                else
                    this.setPropositionalMoreAlgorithms();
                break;
            default:
                this.setGeneralMoreAlgorithms();
                if (this.wffTree.get(0).isPredicateWff())
                    this.setPredicateMoreAlgorithms();
                else
                    this.setPropositionalMoreAlgorithms();
        }
    }

    private void setGeneralOneAlgorithms () {
        applicableAlgorithms.getGeneral().add(algorithms.getGeneralAlgorithms().getMainOperatorDetector());
        applicableAlgorithms.getGeneral().add(algorithms.getGeneralAlgorithms().getClosedTreeDeterminer());
        applicableAlgorithms.getGeneral().add(algorithms.getGeneralAlgorithms().getOpenTreeDeterminer());
        applicableAlgorithms.getGeneral().add(algorithms.getGeneralAlgorithms().getLogicalFalsehoodDeterminer());
        applicableAlgorithms.getGeneral().add(algorithms.getGeneralAlgorithms().getLogicallyContingentDeterminer());
        applicableAlgorithms.getGeneral().add(algorithms.getGeneralAlgorithms().getLogicalTautologyDeterminer());
    }

    private void setGeneralTwoAlgorithms () {
        applicableAlgorithms.getGeneral().add(algorithms.getGeneralAlgorithms().getLogicallyContradictoryDeterminer());
        applicableAlgorithms.getGeneral().add(algorithms.getGeneralAlgorithms().getLogicallyConsistentDeterminer());
        applicableAlgorithms.getGeneral().add(algorithms.getGeneralAlgorithms().getLogicallyContraryDeterminer());
        applicableAlgorithms.getGeneral().add(algorithms.getGeneralAlgorithms().getLogicallyEquivalentDeterminer());
        applicableAlgorithms.getGeneral().add(algorithms.getGeneralAlgorithms().getLogicallyImpliedDeterminer());
    }

    private void setGeneralMoreAlgorithms () {
        applicableAlgorithms.getGeneral().add(algorithms.getGeneralAlgorithms().getArgumentTruthTreeValidator());
        applicableAlgorithms.getGeneral().add(algorithms.getGeneralAlgorithms().getSemanticEntailmentDeterminer());
    }

    private void setPredicateAlgorithms () {
        applicableAlgorithms.getPredicate().add(algorithms.getPredicateAlgorithms().getRandomPredicateFormula());
    }

    private void setPredicateOneAlgorithms () {
        applicableAlgorithms.getPredicate().add(algorithms.getPredicateAlgorithms().getBoundVariableDetector());
        applicableAlgorithms.getPredicate().add(algorithms.getPredicateAlgorithms().getClosedSentenceDeterminer());
        applicableAlgorithms.getPredicate().add(algorithms.getPredicateAlgorithms().getFreeVariableDetector());
        applicableAlgorithms.getPredicate().add(algorithms.getPredicateAlgorithms().getGroundSentenceDeterminer());
        applicableAlgorithms.getPredicate().add(algorithms.getPredicateAlgorithms().getOpenSentenceDeterminer());
        applicableAlgorithms.getPredicate().add(algorithms.getPredicateAlgorithms().getPredicateTruthTreeGenerator());
        applicableAlgorithms.getPredicate().add(algorithms.getPredicateAlgorithms().getVacuousQuantifierDetector());
    }

    private void setPredicateMoreAlgorithms () {
        applicableAlgorithms.getPredicate().add(algorithms.getPredicateAlgorithms().getPredicateNaturalDeduction());
    }

    private void setPropositionalAlgorithms () {
        applicableAlgorithms.getPropositional().add(algorithms.getPropositionalAlgorithms().getRandomPropositionalFormula());
    }

    private void setPropositionalOneAlgorithms () {
        applicableAlgorithms.getPropositional().add(algorithms.getPropositionalAlgorithms().getPropositionalTruthTreeGenerator());
        applicableAlgorithms.getPropositional().add(algorithms.getPropositionalAlgorithms().getTruthTableGenerator());
    }

    private void setPropositionalMoreAlgorithms () {
        applicableAlgorithms.getPropositional().add(algorithms.getPropositionalAlgorithms().getPropositionalNaturalDeduction());
    }

}