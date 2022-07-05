<h1><p align="center">Formal Logic Aiding Tutor</p></h1>

<h2>Introduction</h2>
FLAT (the Formal Logic Aiding Tutor) is an extension to LLAT (the Logic Learning Assistant Tool) that aims to improve the overall pedagogical value. That is, rather than being only a brute-force solver, we have included new features that help students better understand the logic.

<h2>Features</h2>
FLAT has several algorithms, or subfeatures, for students to use. These include

- Natural Deduction Prover (no conditional or indirect proofs)
- Truth Tree (semantic tableaux) Generator
- Argument Validity via Truth Tree Determiner
- Open/Closed/Ground Sentence Determiners
- Bound/Free Variable Detectors
- Logical Relationship Determiners
- Truth Table Generator
- Vacuous Quantifier Detector
- Random Logic Formula Generator
- Main Operator Detector
- Parse Tree Generator
- Semantic Entailment Determiner
- PDF/LaTeX Export

We also allow the user to change the UI color scheme and language. Be aware, though, that language changes, along with PDF generation, require an internet connection.

In the settings menu, there is an __Advanced__ section. For the beginning student, this menu should be avoided. If, however, you wish to raise the limits that the program enforces for algorithm timeouts, this is where they are located.

<h2>Using FLAT</h2>
To use FLAT:

1. Make sure you have Java 8 installed (necessary for JavaFX). We recommend Amazon Corretto 8. Then, download the FLAT-Jar directory to your computer, and click ```FLAT.jar```.
2. Type a well-formed formula in propositional or first-order predicate logic in the bottom text input field.

   _Note:_ Make sure to use parentheses around the wffs and to avoid parentheses when typing predicates (i.e., use Pxyz and not P(x, y, z)). Unary operators such as negation do not use parentheses. All binary operators require parentheses. In other words, there is __no implicit precedence of operators!__
3. Click the Solve button. If an error pops up, read it, then re-enter your wff making sure to correct any mistakes. After this, the top three drop-downs should be populated with algorithms appropriate for your input.
4. Now, click the algorithm you want to try. Then, click the Apply button. Assuming everything is done correctly, the buttons below the three drop-downs will light up (again, depending on which algorithm you used). Click these to investigate the output.
5. Trees are draggable and adjustable. To adjust a subtree, just click and drag it around. To zoom in and out, use the mouse wheel.

__Practice Mode__ is the switch that allows students to test their understanding of the algorithms. When the switch is enabled, the "solver" functionality temporarily disables itself. From here, use the above process to choose an algorithm, but after hitting apply, the right-hand pane should populate with a question and input field. Follow the instructions to solve the question.

__Rules/Axioms__ is the other viewable pane on the right-hand side which displays information about connectives and symbols from the left-hand side. To view information about a symbol, CTRL-Click the corresponding symbol.

__Symbols__ in the left-hand side are swappable. If, for instance, you use a different symbol than the ones displayed, you can change it to your liking. Simply right-click the symbol and a drop-down will appear, allowing you to select one of several alternatives.

<h2>Rebuilding FLAT</h2>
We built FLAT using the Maven architecture and IntelliJ IDE. We have, however, designed the project to be IDE-agnostic. Though, because we use JavaFX without modules, Java 8 is the only supported version. We used Amazon Corretto's JRE8/JDK8, so it's recommended that you do as well.

To rebuild the project, clone the repository to your computer and open it in whichever IDE you wish. Assuming it detects Maven projects correctly (Eclipse, NetBeans, and IntelliJ work), it should open and compile correctly.

<h2>References</h2>
To cite this project, use the following paper citation:

Larry Joshua Crotts. 2022. *Construction and Evaluation of a Gold Standard Syntax for Formal Logic Formulas and Systems.* Master's thesis. University of North Carolina Greensboro (UNCG), Greensboro, North Carolina, USA.

PDF generation uses the following remote API: https://github.com/YtoTech/latex-on-http

Language generation uses the Google Translate API.
