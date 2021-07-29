package com.flat.models.data.algorithms.predicate;

import com.flat.models.data.algorithms.predicate.boundvariabledetector.BoundVariableDetector;
import com.flat.models.data.algorithms.predicate.closedsentencedeterminer.ClosedSentenceDeterminer;
import com.flat.models.data.algorithms.predicate.freevariabledetector.FreeVariableDetector;
import com.flat.models.data.algorithms.predicate.groundsentencedeterminer.GroundSentenceDeterminer;
import com.flat.models.data.algorithms.predicate.opensentencedeterminer.OpenSentenceDeterminer;
import com.flat.models.data.algorithms.predicate.predicatenaturaldeduction.PredicateNaturalDeduction;
import com.flat.models.data.algorithms.predicate.predicatetruthtreegenerator.PredicateTruthTreeGenerator;
import com.flat.models.data.algorithms.predicate.randompredicateformula.RandomPredicateFormula;
import com.flat.models.data.algorithms.predicate.vacuousquantifierdetector.VacuousQuantifierDetector;
import com.flat.models.data.base.text.translate.TranslatableText;
import com.flat.tools.translation.base.Translatable;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedList;

/**
 *
 * @author christopherbrantley
 */
public class PredicateAlgorithms extends Translatable implements Serializable {

    private BoundVariableDetector boundVariableDetector = new BoundVariableDetector();
    private ClosedSentenceDeterminer closedSentenceDeterminer = new ClosedSentenceDeterminer();
    private FreeVariableDetector freeVariableDetector = new FreeVariableDetector();
    private GroundSentenceDeterminer groundSentenceDeterminer = new GroundSentenceDeterminer();
    private OpenSentenceDeterminer openSentenceDeterminer = new OpenSentenceDeterminer();
    private PredicateNaturalDeduction predicateNaturalDeduction = new PredicateNaturalDeduction();
    private PredicateTruthTreeGenerator predicateTruthTreeGenerator = new PredicateTruthTreeGenerator();
    private RandomPredicateFormula randomPredicateFormula = new RandomPredicateFormula();
    private VacuousQuantifierDetector vacuousQuantifierDetector = new VacuousQuantifierDetector();

    public PredicateAlgorithms () {
    }

    // Getters for object's attributes.
    public BoundVariableDetector getBoundVariableDetector() {
        return boundVariableDetector;
    }

    public ClosedSentenceDeterminer getClosedSentenceDeterminer() {
        return closedSentenceDeterminer;
    }

    public FreeVariableDetector getFreeVariableDetector() {
        return freeVariableDetector;
    }

    public GroundSentenceDeterminer getGroundSentenceDeterminer() {
        return groundSentenceDeterminer;
    }

    public OpenSentenceDeterminer getOpenSentenceDeterminer() {
        return openSentenceDeterminer;
    }

    public PredicateNaturalDeduction getPredicateNaturalDeduction() {
        return predicateNaturalDeduction;
    }

    public PredicateTruthTreeGenerator getPredicateTruthTreeGenerator() {
        return predicateTruthTreeGenerator;
    }

    public RandomPredicateFormula getRandomPredicateFormula() {
        return randomPredicateFormula;
    }

    public VacuousQuantifierDetector getVacuousQuantifierDetector() {
        return vacuousQuantifierDetector;
    }

    // Setters for object's attributes.
    public void setBoundVariableDetector(BoundVariableDetector boundVariableDetector) {
        this.boundVariableDetector = boundVariableDetector;
    }

    public void setClosedSentenceDeterminer(ClosedSentenceDeterminer closedSentenceDeterminer) {
        this.closedSentenceDeterminer = closedSentenceDeterminer;
    }

    public void setFreeVariableDetector(FreeVariableDetector freeVariableDetector) {
        this.freeVariableDetector = freeVariableDetector;
    }

    public void setGroundSentenceDeterminer(GroundSentenceDeterminer groundSentenceDeterminer) {
        this.groundSentenceDeterminer = groundSentenceDeterminer;
    }

    public void setOpenSentenceDeterminer(OpenSentenceDeterminer openSentenceDeterminer) {
        this.openSentenceDeterminer = openSentenceDeterminer;
    }

    public void setPredicateNaturalDeduction(PredicateNaturalDeduction predicateNaturalDeduction) {
        this.predicateNaturalDeduction = predicateNaturalDeduction;
    }

    public void setPredicateTruthTreeGenerator(PredicateTruthTreeGenerator predicateTruthTreeGenerator) {
        this.predicateTruthTreeGenerator = predicateTruthTreeGenerator;
    }

    public void setRandomPredicateFormula(RandomPredicateFormula randomPredicateFormula) {
        this.randomPredicateFormula = randomPredicateFormula;
    }

    public void setVacuousQuantifierDetector(VacuousQuantifierDetector vacuousQuantifierDetector) {
        this.vacuousQuantifierDetector = vacuousQuantifierDetector;
    }

    @Override
    public String toString() {
        return "PredicateAlgorithms{" + "boundVariableDetector=" + boundVariableDetector + ", closedSentenceDeterminer=" + closedSentenceDeterminer + ", freeVariableDetector=" + freeVariableDetector + ", groundSentenceDeterminer=" + groundSentenceDeterminer + ", openSentenceDeterminer=" + openSentenceDeterminer + ", predicateNaturalDeduction=" + predicateNaturalDeduction + ", predicateTruthTreeGenerator=" + predicateTruthTreeGenerator + ", randomPredicateFormula=" + randomPredicateFormula + ", VacuousQuantifierDetector=" + vacuousQuantifierDetector + '}';
    }

    private void writeObject (ObjectOutputStream os) {
        try {
            os.writeObject(this.boundVariableDetector);
            os.writeObject(this.closedSentenceDeterminer);
            os.writeObject(this.freeVariableDetector);
            os.writeObject(this.groundSentenceDeterminer);
            os.writeObject(this.openSentenceDeterminer);
            os.writeObject(this.predicateNaturalDeduction);
            os.writeObject(this.predicateTruthTreeGenerator);
            os.writeObject(this.randomPredicateFormula);
            os.writeObject(this.vacuousQuantifierDetector);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void readObject (ObjectInputStream  is) {
        try {
            this.boundVariableDetector = (BoundVariableDetector) is.readObject();
            this.closedSentenceDeterminer = (ClosedSentenceDeterminer) is.readObject();
            this.freeVariableDetector = (FreeVariableDetector) is.readObject();
            this.groundSentenceDeterminer = (GroundSentenceDeterminer) is.readObject();
            this.openSentenceDeterminer = (OpenSentenceDeterminer) is.readObject();
            this.predicateNaturalDeduction = (PredicateNaturalDeduction) is.readObject();
            this.predicateTruthTreeGenerator = (PredicateTruthTreeGenerator) is.readObject();
            this.randomPredicateFormula = (RandomPredicateFormula) is.readObject();
            this.vacuousQuantifierDetector = (VacuousQuantifierDetector) is.readObject();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public LinkedList <TranslatableText> toTranslate() {
        return new LinkedList <TranslatableText> () {{
            addAll(boundVariableDetector.toTranslate());
            addAll(closedSentenceDeterminer.toTranslate());
            addAll(freeVariableDetector.toTranslate());
            addAll(groundSentenceDeterminer.toTranslate());
            addAll(openSentenceDeterminer.toTranslate());
            addAll(predicateNaturalDeduction.toTranslate());
            addAll(predicateTruthTreeGenerator.toTranslate());
            addAll(randomPredicateFormula.toTranslate());
            addAll(vacuousQuantifierDetector.toTranslate());
        }};
    }

}