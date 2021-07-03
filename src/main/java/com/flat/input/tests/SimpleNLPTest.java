package com.flat.input.tests;

import com.flat.FLAT;
import com.flat.tools.FLATUtils;
import simplenlg.features.Feature;
import simplenlg.framework.NLGFactory;
import simplenlg.lexicon.Lexicon;
import simplenlg.phrasespec.NPPhraseSpec;
import simplenlg.phrasespec.SPhraseSpec;
import simplenlg.phrasespec.VPPhraseSpec;
import simplenlg.realiser.english.Realiser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * This is some suppppeerrrr nasty code but it's JUST for testing!
 */
public class SimpleNLPTest {

    /**
     *
     */
    private static final Lexicon lexicon = Lexicon.getDefaultLexicon();

    /**
     *
     */
    private static final NLGFactory nlgFactory = new NLGFactory(lexicon);

    /**
     *
     */
    private static final Realiser realiser = new Realiser(lexicon);

    /**
     *
     */
    private static ArrayList<String> nouns;

    /**
     *
     */
    private static ArrayList<String> adjectives;

    /**
     *
     */
    private static ArrayList<String> quantifiers;

    /**
     *
     */
    private static ArrayList<String> conclusions;

    public static void main(String[] args) {
        try {
            loadInputFiles();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        System.out.println(generateRandomSyllogism());
    }

    /**
     * @return
     */
    private static void loadInputFiles() throws IOException {
        nouns = new ArrayList<>();
        adjectives = new ArrayList<>();
        quantifiers = new ArrayList<>();
        conclusions = new ArrayList<>();

        String line = "";
        // First load in nouns.
        BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/assets/nlp/nouns.txt"));
        while ((line = reader.readLine()) != null) {
            nouns.add(line);
        }

        // Now load in adjectives.
        reader = new BufferedReader(new FileReader("src/main/resources/assets/nlp/adjectives.txt"));
        while ((line = reader.readLine()) != null) {
            adjectives.add(line);
        }

        // Now load in quantifiers.
        reader = new BufferedReader(new FileReader("src/main/resources/assets/nlp/quantifiers.txt"));
        while ((line = reader.readLine()) != null) {
            quantifiers.add(line);
        }

        // Now load in conclusions.
        reader = new BufferedReader(new FileReader("src/main/resources/assets/nlp/conclusions.txt"));
        while ((line = reader.readLine()) != null) {
            conclusions.add(line);
        }
    }

    /**
     * @return
     */
    private static String generateRandomSyllogism() {
        // Set up the probabilities of generating a negation.
        // Set up the three objects to use in the syllogism.
        String nounOne = nouns.get(FLATUtils.randomInt(nouns.size() - 1));
        String nounTwo = nouns.get(FLATUtils.randomInt(nouns.size() - 1));
        String clauseTwoObj = Math.random() < 0.5 ? nouns.get(FLATUtils.randomInt(nouns.size() - 1))
                                                  : adjectives.get(FLATUtils.randomInt(adjectives.size() - 1));

        String s1 = createPremise(1, nounOne, nounTwo, clauseTwoObj);
        String s2 = createPremise(2, nounOne, nounTwo, clauseTwoObj);
        String c = createConclusion(nounOne, nounTwo, clauseTwoObj);
        return s1 + "\n" + s2 + "\n" + c;
    }

    private static String createPremise(int _id, String _nounOne, String _nounTwo, String _clauseTwoObj) {
        NPPhraseSpec clauseOneObj = nlgFactory.createNounPhrase(_id == 1 ? _nounOne : _clauseTwoObj);
        clauseOneObj.setPlural(true);
        clauseOneObj.setDeterminer((Math.random() < 0.25 ? generateRandomNegatedPrefix() : "")
                + " " + quantifiers.get(FLATUtils.randomInt(quantifiers.size() - 1)));
        VPPhraseSpec premiseOneVerb = nlgFactory.createVerbPhrase("is");
        premiseOneVerb.setPlural(true);
        if (Math.random() < 0.25) premiseOneVerb.setFeature(Feature.NEGATED, true);
        NPPhraseSpec s2 = nlgFactory.createNounPhrase(_id == 2 ? _nounOne : _nounTwo);
        s2.setPlural(true);
        premiseOneVerb.addModifier(s2);
        SPhraseSpec p = nlgFactory.createClause();
        p.setSubject(clauseOneObj);
        p.setVerb(premiseOneVerb);
        return realiser.realiseSentence(p);
    }

    private static String createConclusion(String _nounOne, String _nounTwo, String _clauseTwoWord) {
        String conclusion = conclusions.get(FLATUtils.randomInt(conclusions.size() - 1));
        String negPrefix = Math.random() < 0.25 ? generateRandomNegatedPrefix() + " " : "";
        NPPhraseSpec clauseOneObj = nlgFactory.createNounPhrase(_clauseTwoWord);
        clauseOneObj.setPlural(true);
        clauseOneObj.setDeterminer(conclusion + " " + negPrefix + quantifiers.get(FLATUtils.randomInt(quantifiers.size() - 1)));
        VPPhraseSpec premiseOneVerb = nlgFactory.createVerbPhrase("is");
        if (Math.random() < 0.25) premiseOneVerb.setFeature(Feature.NEGATED, true);
        NPPhraseSpec s2 = nlgFactory.createNounPhrase(Math.random() < 0.5 ? _nounOne : _nounTwo);
        s2.setPlural(true);
        premiseOneVerb.addModifier(s2);
        SPhraseSpec p = nlgFactory.createClause();
        p.setSubject(clauseOneObj);
        p.setVerb(premiseOneVerb);
        return realiser.realiseSentence(p);
    }

    /**
     *
     * @return
     */
    private static String generateRandomNegatedPrefix() {
        ArrayList<String> negatedPrefixes = new ArrayList<>();
        negatedPrefixes.add("it is not the case that");
        negatedPrefixes.add("it does not hold that");
        negatedPrefixes.add("it is not true that");
        return negatedPrefixes.get(FLATUtils.randomInt(negatedPrefixes.size() - 1));
    }
}
