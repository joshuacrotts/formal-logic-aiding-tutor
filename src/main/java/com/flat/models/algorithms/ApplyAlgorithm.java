package com.flat.models.algorithms;

import com.flat.models.json.algorithm.JsonAlgorithms;
import com.flat.models.treenode.WffTree;
import java.util.ArrayList;

/**
 *
 * @author Christopher Brantley <c_brantl@uncg.edu>
 */
public class ApplyAlgorithm {
    private ArrayList <WffTree> wffTree = new ArrayList();
    private JsonAlgorithms jsonAlgorithms = null;
    private ApplicableAlgorithms applicableAlgorithms = new ApplicableAlgorithms();

    public ApplyAlgorithm () {
    }

    // Getters for object's attributes
    public ArrayList <WffTree> getWffTree() {
        return wffTree;
    }

    public JsonAlgorithms getJsonAlgorithms() {
        return jsonAlgorithms;
    }

    public ApplicableAlgorithms getApplicableAlgorithms () {
        return applicableAlgorithms;
    }

    // Setters for object's attributes.
    public void setWffTree(ArrayList <WffTree> wffTree) {
        this.wffTree = wffTree;
        this.setApplicableAlgorithms();
    }

    public void setJsonAlgorithms(JsonAlgorithms jsonAlgorithms) {
        this.jsonAlgorithms = jsonAlgorithms;
        setApplicableAlgorithms();
    }

    private void setApplicableAlgorithms() {
        applicableAlgorithms.clearAllAlgorithms();
        this.setPredicateAlgorithms();
        this.setPropositionalAlgorithms();
        switch (this.wffTree.size()) {
            case 0:
                break;
            case 1:
                this.setGeneralOneAlgorithms();
                if (this.wffTree.get(0).isPredicate())
                    this.setPredicateOneAlgorithms();
                else
                    this.setPropositionalOneAlgorithms();
                break;
            case 2:
                this.setGeneralTwoAlgorithms();
                this.setGeneralMoreAlgorithms();
                break;
            default:
                this.setGeneralMoreAlgorithms();
        }
    }

    private void setGeneralOneAlgorithms () {
        applicableAlgorithms.getGeneral().add(jsonAlgorithms.getGeneralAlgorithms().getMainOperatorDetector());
        applicableAlgorithms.getGeneral().add(jsonAlgorithms.getGeneralAlgorithms().getClosedTreeDeterminer());
        applicableAlgorithms.getGeneral().add(jsonAlgorithms.getGeneralAlgorithms().getOpenTreeDeterminer());
        applicableAlgorithms.getGeneral().add(jsonAlgorithms.getGeneralAlgorithms().getLogicalFalsehoodDeterminer());
        applicableAlgorithms.getGeneral().add(jsonAlgorithms.getGeneralAlgorithms().getLogicallyContingentDeterminer());
        applicableAlgorithms.getGeneral().add(jsonAlgorithms.getGeneralAlgorithms().getLogicalTautologyDeterminer());
    }

    private void setGeneralTwoAlgorithms () {
        applicableAlgorithms.getGeneral().add(jsonAlgorithms.getGeneralAlgorithms().getLogicallyContradictoryDeterminer());
        applicableAlgorithms.getGeneral().add(jsonAlgorithms.getGeneralAlgorithms().getLogicallyConsistentDeterminer());
        applicableAlgorithms.getGeneral().add(jsonAlgorithms.getGeneralAlgorithms().getLogicallyContraryDeterminer());
        applicableAlgorithms.getGeneral().add(jsonAlgorithms.getGeneralAlgorithms().getLogicallyEquivalentDeterminer());
        applicableAlgorithms.getGeneral().add(jsonAlgorithms.getGeneralAlgorithms().getLogicallyImpliedDeterminer());
    }

    private void setGeneralMoreAlgorithms () {
        applicableAlgorithms.getGeneral().add(jsonAlgorithms.getGeneralAlgorithms().getArgumentTruthTreeValidator());
        applicableAlgorithms.getGeneral().add(jsonAlgorithms.getGeneralAlgorithms().getSemanticEntailmentDeterminer());
    }

    private void setPredicateAlgorithms () {
        applicableAlgorithms.getPredicate().add(jsonAlgorithms.getPredicateAlgorithms().getRandomFormulaGenerator());
    }

    private void setPredicateOneAlgorithms () {
        applicableAlgorithms.getPredicate().add(jsonAlgorithms.getPredicateAlgorithms().getBoundVariableDetector());
        applicableAlgorithms.getPredicate().add(jsonAlgorithms.getPredicateAlgorithms().getClosedSentenceDeterminer());
        applicableAlgorithms.getPredicate().add(jsonAlgorithms.getPredicateAlgorithms().getFreeVariableDetector());
        applicableAlgorithms.getPredicate().add(jsonAlgorithms.getPredicateAlgorithms().getGroundSentenceDeterminer());
        applicableAlgorithms.getPredicate().add(jsonAlgorithms.getPredicateAlgorithms().getOpenSentenceDeterminer());
        applicableAlgorithms.getPredicate().add(jsonAlgorithms.getPredicateAlgorithms().getPredicatetruthTreeGenerator());
    }

    private void setPropositionalAlgorithms () {
        applicableAlgorithms.getPropositional().add(jsonAlgorithms.getPropositionalAlgorithms().getRandomFormulaGenerator());
    }

    private void setPropositionalOneAlgorithms () {
        applicableAlgorithms.getPropositional().add(jsonAlgorithms.getPropositionalAlgorithms().getPropositionalTruthTreeGenerator());
        applicableAlgorithms.getPropositional().add(jsonAlgorithms.getPropositionalAlgorithms().getTruthTableGenerator());
    }

}