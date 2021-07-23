package com.flat.models.data.algorithms.general;

import com.flat.models.data.algorithms.general.argumenttruthtreevalidator.ArgumentTruthTreeValidator;
import com.flat.models.data.algorithms.general.closedtreedeterminer.ClosedTreeDeterminer;
import com.flat.models.data.algorithms.general.logicalfalsehooddeterminer.LogicalFalsehoodDeterminer;
import com.flat.models.data.algorithms.general.logicallyconsistentdeterminer.LogicallyConsistentDeterminer;
import com.flat.models.data.algorithms.general.logicallycontingentdeterminer.LogicallyContingentDeterminer;
import com.flat.models.data.algorithms.general.logicallycontradictorydeterminer.LogicallyContradictoryDeterminer;
import com.flat.models.data.algorithms.general.logicallycontrarydeterminer.LogicallyContraryDeterminer;
import com.flat.models.data.algorithms.general.logicallyequivalentdeterminer.LogicallyEquivalentDeterminer;
import com.flat.models.data.algorithms.general.logicallyimplieddeterminer.LogicallyImpliedDeterminer;
import com.flat.models.data.algorithms.general.logicaltautologydeterminer.LogicalTautologyDeterminer;
import com.flat.models.data.algorithms.general.mainoperatordetector.MainOperatorDetector;
import com.flat.models.data.algorithms.general.opentreedeterminer.OpenTreeDeterminer;
import com.flat.models.data.algorithms.general.semanticentailmentdeterminer.SemanticEntailmentDeterminer;
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
public class GeneralAlgorithms extends Translatable implements Serializable {

    private ArgumentTruthTreeValidator argumentTruthTreeValidator = new ArgumentTruthTreeValidator();
    private ClosedTreeDeterminer closedTreeDeterminer = new ClosedTreeDeterminer();
    private LogicalFalsehoodDeterminer logicalFalsehoodDeterminer = new LogicalFalsehoodDeterminer();
    private LogicallyConsistentDeterminer logicallyConsistentDeterminer = new LogicallyConsistentDeterminer();
    private LogicallyContingentDeterminer logicallyContingentDeterminer = new LogicallyContingentDeterminer();
    private LogicallyContradictoryDeterminer logicallyContradictoryDeterminer = new LogicallyContradictoryDeterminer();
    private LogicallyContraryDeterminer logicallyContraryDeterminer = new LogicallyContraryDeterminer();
    private LogicallyEquivalentDeterminer logicallyEquivalentDeterminer = new LogicallyEquivalentDeterminer();
    private LogicallyImpliedDeterminer logicallyImpliedDeterminer = new LogicallyImpliedDeterminer();
    private LogicalTautologyDeterminer logicalTautologyDeterminer = new LogicalTautologyDeterminer();
    private MainOperatorDetector mainOperatorDetector = new MainOperatorDetector();
    private OpenTreeDeterminer openTreeDeterminer = new OpenTreeDeterminer();
    private SemanticEntailmentDeterminer semanticEntailmentDeterminer = new SemanticEntailmentDeterminer();

    public GeneralAlgorithms () {
    }

    // Getters for object's attributes.
    public ArgumentTruthTreeValidator getArgumentTruthTreeValidator() {
        return argumentTruthTreeValidator;
    }

    public ClosedTreeDeterminer getClosedTreeDeterminer() {
        return closedTreeDeterminer;
    }

    public LogicalFalsehoodDeterminer getLogicalFalsehoodDeterminer() {
        return logicalFalsehoodDeterminer;
    }

    public LogicallyConsistentDeterminer getLogicallyConsistentDeterminer() {
        return logicallyConsistentDeterminer;
    }

    public LogicallyContingentDeterminer getLogicallyContingentDeterminer() {
        return logicallyContingentDeterminer;
    }

    public LogicallyContradictoryDeterminer getLogicallyContradictoryDeterminer() {
        return logicallyContradictoryDeterminer;
    }

    public LogicallyContraryDeterminer getLogicallyContraryDeterminer() {
        return logicallyContraryDeterminer;
    }

    public LogicallyEquivalentDeterminer getLogicallyEquivalentDeterminer() {
        return logicallyEquivalentDeterminer;
    }

    public LogicallyImpliedDeterminer getLogicallyImpliedDeterminer() {
        return logicallyImpliedDeterminer;
    }

    public LogicalTautologyDeterminer getLogicalTautologyDeterminer() {
        return logicalTautologyDeterminer;
    }

    public MainOperatorDetector getMainOperatorDetector() {
        return mainOperatorDetector;
    }

    public OpenTreeDeterminer getOpenTreeDeterminer() {
        return openTreeDeterminer;
    }

    public SemanticEntailmentDeterminer getSemanticEntailmentDeterminer() {
        return semanticEntailmentDeterminer;
    }

    // Setters for object's attributes.
    public void setArgumentTruthTreeValidator(ArgumentTruthTreeValidator argumentTruthTreeValidator) {
        this.argumentTruthTreeValidator = argumentTruthTreeValidator;
    }

    public void setClosedTreeDeterminer(ClosedTreeDeterminer closedTreeDeterminer) {
        this.closedTreeDeterminer = closedTreeDeterminer;
    }

    public void setLogicalFalsehoodDeterminer(LogicalFalsehoodDeterminer logicalFalsehoodDeterminer) {
        this.logicalFalsehoodDeterminer = logicalFalsehoodDeterminer;
    }

    public void setLogicallyConsistentDeterminer(LogicallyConsistentDeterminer logicallyConsistentDeterminer) {
        this.logicallyConsistentDeterminer = logicallyConsistentDeterminer;
    }

    public void setLogicallyContingentDeterminer(LogicallyContingentDeterminer logicallyContingentDeterminer) {
        this.logicallyContingentDeterminer = logicallyContingentDeterminer;
    }

    public void setLogicallyContradictoryDeterminer(LogicallyContradictoryDeterminer logicallyContradictoryDeterminer) {
        this.logicallyContradictoryDeterminer = logicallyContradictoryDeterminer;
    }

    public void setLogicallyContraryDeterminer(LogicallyContraryDeterminer logicallyContraryDeterminer) {
        this.logicallyContraryDeterminer = logicallyContraryDeterminer;
    }

    public void setLogicallyEquivalentDeterminer(LogicallyEquivalentDeterminer logicallyEquivalentDeterminer) {
        this.logicallyEquivalentDeterminer = logicallyEquivalentDeterminer;
    }

    public void setLogicallyImpliedDeterminer(LogicallyImpliedDeterminer logicallyImpliedDeterminer) {
        this.logicallyImpliedDeterminer = logicallyImpliedDeterminer;
    }

    public void setLogicalTautologyDeterminer(LogicalTautologyDeterminer logicalTautologyDeterminer) {
        this.logicalTautologyDeterminer = logicalTautologyDeterminer;
    }

    public void setMainOperatorDetector(MainOperatorDetector mainOperatorDetector) {
        this.mainOperatorDetector = mainOperatorDetector;
    }

    public void setOpenTreeDeterminer(OpenTreeDeterminer openTreeDeterminer) {
        this.openTreeDeterminer = openTreeDeterminer;
    }

    public void setSemanticEntailmentDeterminer(SemanticEntailmentDeterminer semanticEntailmentDeterminer) {
        this.semanticEntailmentDeterminer = semanticEntailmentDeterminer;
    }

    @Override
    public String toString() {
        return "GeneralAlgorithms{" + "argumentTruthTreeValidator=" + argumentTruthTreeValidator + ", closedTreeDeterminer=" + closedTreeDeterminer + ", logicalFalsehoodDeterminer=" + logicalFalsehoodDeterminer + ", logicallyConsistentDeterminer=" + logicallyConsistentDeterminer + ", logicallyContingentDeterminer=" + logicallyContingentDeterminer + ", logicallyContradictoryDeterminer=" + logicallyContradictoryDeterminer + ", logicallyContraryDeterminer=" + logicallyContraryDeterminer + ", logicallyEquivalentDeterminer=" + logicallyEquivalentDeterminer + ", logicallyImpliedDeterminer=" + logicallyImpliedDeterminer + ", logicalTautologyDeterminer=" + logicalTautologyDeterminer + ", mainOperatorDetector=" + mainOperatorDetector + ", openTreeDeterminer=" + openTreeDeterminer + ", semanticEntailmentDeterminer=" + semanticEntailmentDeterminer + '}';
    }

    private void writeObject (ObjectOutputStream os) {
        try {
            os.writeObject(this.argumentTruthTreeValidator);
            os.writeObject(this.closedTreeDeterminer);
            os.writeObject(this.logicalFalsehoodDeterminer);
            os.writeObject(this.logicallyConsistentDeterminer);
            os.writeObject(this.logicallyContingentDeterminer);
            os.writeObject(this.logicallyContradictoryDeterminer);
            os.writeObject(this.logicallyContraryDeterminer);
            os.writeObject(this.logicallyEquivalentDeterminer);
            os.writeObject(this.logicallyImpliedDeterminer);
            os.writeObject(this.logicalTautologyDeterminer);
            os.writeObject(this.mainOperatorDetector);
            os.writeObject(this.openTreeDeterminer);
            os.writeObject(this.semanticEntailmentDeterminer);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void readObject (ObjectInputStream  is) {
        try {
            this.argumentTruthTreeValidator = (ArgumentTruthTreeValidator) is.readObject();
            this.closedTreeDeterminer = (ClosedTreeDeterminer) is.readObject();
            this.logicalFalsehoodDeterminer = (LogicalFalsehoodDeterminer) is.readObject();
            this.logicallyConsistentDeterminer = (LogicallyConsistentDeterminer) is.readObject();
            this.logicallyContingentDeterminer = (LogicallyContingentDeterminer) is.readObject();
            this.logicallyContradictoryDeterminer = (LogicallyContradictoryDeterminer) is.readObject();
            this.logicallyContraryDeterminer = (LogicallyContraryDeterminer) is.readObject();
            this.logicallyEquivalentDeterminer = (LogicallyEquivalentDeterminer) is.readObject();
            this.logicallyImpliedDeterminer = (LogicallyImpliedDeterminer) is.readObject();
            this.logicalTautologyDeterminer = (LogicalTautologyDeterminer) is.readObject();
            this.mainOperatorDetector = (MainOperatorDetector) is.readObject();
            this.openTreeDeterminer = (OpenTreeDeterminer) is.readObject();
            this.semanticEntailmentDeterminer = (SemanticEntailmentDeterminer) is.readObject();

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public LinkedList <TranslatableText> toTranslate() {
        return new LinkedList <TranslatableText> () {{
            addAll(argumentTruthTreeValidator.toTranslate());
            addAll(closedTreeDeterminer.toTranslate());
            addAll(logicalFalsehoodDeterminer.toTranslate());
            addAll(logicallyConsistentDeterminer.toTranslate());
            addAll(logicallyContingentDeterminer.toTranslate());
            addAll(logicallyContradictoryDeterminer.toTranslate());
            addAll(logicallyContraryDeterminer.toTranslate());
            addAll(logicallyEquivalentDeterminer.toTranslate());
            addAll(logicallyImpliedDeterminer.toTranslate());
            addAll(logicalTautologyDeterminer.toTranslate());
            addAll(mainOperatorDetector.toTranslate());
            addAll(openTreeDeterminer.toTranslate());
            addAll(semanticEntailmentDeterminer.toTranslate());
        }};
    }

}