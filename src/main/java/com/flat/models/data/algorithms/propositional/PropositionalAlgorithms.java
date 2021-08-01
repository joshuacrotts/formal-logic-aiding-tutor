package com.flat.models.data.algorithms.propositional;

import com.flat.models.data.algorithms.propositional.propositionalnaturaldeduction.PropositionalNaturalDeduction;
import com.flat.models.data.algorithms.propositional.propositionaltruthtreegenerator.PropositionalTruthTreeGenerator;
import com.flat.models.data.algorithms.propositional.randompropositionalformula.RandomPropositionalFormula;
import com.flat.models.data.algorithms.propositional.truthtablegenerator.TruthTableGenerator;
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
public class PropositionalAlgorithms extends Translatable implements Serializable {
    private PropositionalNaturalDeduction propositionalNaturalDeduction = new PropositionalNaturalDeduction();
    private PropositionalTruthTreeGenerator propositionalTruthTreeGenerator = new PropositionalTruthTreeGenerator();
    private RandomPropositionalFormula randomPropositionalFormula = new RandomPropositionalFormula();
    private TruthTableGenerator truthTableGenerator = new TruthTableGenerator();

    public PropositionalAlgorithms () {
    }

    // Getters for object's attributes.
    public PropositionalNaturalDeduction getPropositionalNaturalDeduction() {
        return propositionalNaturalDeduction;
    }

    public PropositionalTruthTreeGenerator getPropositionalTruthTreeGenerator() {
        return propositionalTruthTreeGenerator;
    }

    public RandomPropositionalFormula getRandomPropositionalFormula() {
        return randomPropositionalFormula;
    }

    public TruthTableGenerator getTruthTableGenerator() {
        return truthTableGenerator;
    }

    // Setters for object's attributes.
    public void setPropositionalNaturalDeduction(PropositionalNaturalDeduction propositionalNaturalDeduction) {
        this.propositionalNaturalDeduction = propositionalNaturalDeduction;
    }

    public void setPropositionalTruthTreeGenerator(PropositionalTruthTreeGenerator propositionalTruthTreeGenerator) {
        this.propositionalTruthTreeGenerator = propositionalTruthTreeGenerator;
    }

    public void setRandomPropositionalFormula(RandomPropositionalFormula randomPropositionalFormula) {
        this.randomPropositionalFormula = randomPropositionalFormula;
    }

    public void setTruthTableGenerator(TruthTableGenerator truthTableGenerator) {
        this.truthTableGenerator = truthTableGenerator;
    }

    @Override
    public String toString() {
        return "PropositionalAlgorithms{" + "propositionalNaturalDeduction=" + propositionalNaturalDeduction + ", propositionalTruthTreeGenerator=" + propositionalTruthTreeGenerator + ", randomPropositionalFormula=" + randomPropositionalFormula + ", truthTableGenerator=" + truthTableGenerator + '}';
    }

    private void writeObject (ObjectOutputStream os) {
        try {
            os.writeObject(this.propositionalNaturalDeduction);
            os.writeObject(this.propositionalTruthTreeGenerator);
            os.writeObject(this.randomPropositionalFormula);
            os.writeObject(this.truthTableGenerator);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void readObject (ObjectInputStream  is) {
        try {
            this.propositionalNaturalDeduction = (PropositionalNaturalDeduction) is.readObject();
            this.propositionalTruthTreeGenerator = (PropositionalTruthTreeGenerator) is.readObject();
            this.randomPropositionalFormula = (RandomPropositionalFormula) is.readObject();
            this.truthTableGenerator = (TruthTableGenerator) is.readObject();

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public LinkedList <TranslatableText> toTranslate() {
        return new LinkedList <TranslatableText> () {{
            addAll(propositionalNaturalDeduction.toTranslate());
            addAll(propositionalTruthTreeGenerator.toTranslate());
            addAll(randomPropositionalFormula.toTranslate());
            addAll(truthTableGenerator.toTranslate());
        }};
    }

}