package com.flat.models.treenode;

import com.flat.tools.FLATUtils;
import com.flat.tools.TexPrintable;

import javax.xml.soap.Node;
import java.util.ArrayList;

/**
 *
 */
public class WffTree implements Copyable, TexPrintable {

    /**
     * Defines the type of node that we're using. There should be only one
     * ROOT node in the tree.
     */
    private final NodeType nodeType;

    /**
     *
     */
    private final ArrayList<WffTree> children;

    /**
     *
     */
    private final ArrayList<Boolean> truthValues;

    /**
     *
     */
    private String symbol;

    /**
     *
     */
    private int flags;

    public WffTree(String _symbol, NodeType _nodeType) {
        this.symbol = _symbol;
        this.nodeType = _nodeType;
        this.children = new ArrayList<>();
        this.truthValues = new ArrayList<>();
    }

    public WffTree(NodeType _nodeType) {
        this(null, _nodeType);
    }

    public WffTree() {
        this(null, NodeType.ROOT);
    }

    @Override
    public WffTree copy() {
        WffTree t = new WffTree(this.symbol, this.nodeType);
        t.setFlags(this.getFlags());
        this.copyHelper(this, t);
        return t;
    }

    /**
     * Performs a recursive copy of all children in this truth tree.
     * Applies to the second parameter.
     *
     * @param _root    - root of tree to copy.
     * @param _newTree - tree to copy into.
     */
    private void copyHelper(WffTree _root, WffTree _newTree) {
        for (WffTree ch : _root.children) {
            _newTree.addChild(ch.copy());
        }
    }

    /**
     * Turns off highlighting for all nodes in the AST. This just iterates through the tree and
     * calls setHighlighted(false) on all nodes and their children. Each time an algorithm is called,
     * just call this before running it.
     */
    public void clearHighlighting() {
        this.setHighlighted(false);
        for (WffTree t : this.children) {
            this.clearHighlightingHelper(t);
        }
    }

    /**
     * Recursive clear highlighting method. This removes all highlighting
     * performed by the front-end or anything that suggests that *this* node
     * is the result of some algorithm.
     *
     * @param _root - root of WffTree.
     */
    private void clearHighlightingHelper(WffTree _root) {
        for (WffTree ch : _root.children) {
            ch.setHighlighted(false);
            this.clearHighlightingHelper(ch);
        }
    }

    /**
     *
     * @return
     */
    public int allChildSizeCount() {
        return allChildSizeCountHelper(this);
    }

    /**
     *
     * @param _tree
     * @return
     */
    private int allChildSizeCountHelper(WffTree _tree) {
        int size = 0;
        for (int i = 0; i < _tree.children.size(); i++) {
            size += _tree.getChild(i).getChildrenSize() + this.allChildSizeCountHelper(_tree.getChild(i));
        }

        return size;
    }

    /**
     * Recursively collects all AtomNodes in a tree. The ArrayList is treated as a set.
     *
     * @throws IllegalArgumentException if the formula is a predicate logic formula since they don't
     *         use atoms.
     *
     * @return new ArrayList of all distinct AtomNodes.
     */
    public ArrayList<AtomNode> getAtoms() {
        if (this.isPredicateWff()) {
            throw new IllegalArgumentException("Cannot retrieve atoms on a predicate logic formula.");
        }

        ArrayList<AtomNode> atoms = new ArrayList<>();
        this.getAtomsHelper(this, atoms);
        return atoms;
    }

    /**
     * Recursive helper function for the above.
     *
     * @param _wffTreeNode - WffTree node to check.
     * @param _atoms - ArrayList of AtomNodes to add onto.
     */
    private void getAtomsHelper(WffTree _wffTreeNode, ArrayList<AtomNode> _atoms) {
        if (_wffTreeNode == null) return;
        for (WffTree ch : _wffTreeNode.getChildren()) {
            if (ch.isAtom() && !_atoms.contains(ch)) { _atoms.add((AtomNode) ch); }
            this.getAtomsHelper(ch, _atoms);
        }
    }

    /**
     * Performs a recursive preorder traversal on the WffTree.
     *
     * @return ArrayList of WffTrees representing the preorder traversal of the parse tree.
     */
    public ArrayList<WffTree> preorderTraversal() {
        ArrayList<WffTree> wffTreeArrayList = new ArrayList<>();
        this.preorderTraversalHelper(this, wffTreeArrayList);
        return wffTreeArrayList;
    }

    /**
     * Helper function to perform preorder traversal.
     *
     * @param _wffTree - current node in the traversal.
     * @param _preorderList - list to add to.
     */
    private void preorderTraversalHelper(WffTree _wffTree, ArrayList<WffTree> _preorderList) {
        if (_wffTree == null) return;
        _preorderList.add(_wffTree);
        _wffTree.getChildren().forEach(child -> {
            this.preorderTraversalHelper(child, _preorderList);
        });
    }

    /**
     * Performs a recursive inorder traversal on the WffTree.
     *
     * @return ArrayList of WffTrees representing the inorder traversal of the parse tree.
     */
    public ArrayList<WffTree> inorderTraversal() {
        ArrayList<WffTree> wffTreeArrayList = new ArrayList<>();
        this.inorderTraversalHelper(this, wffTreeArrayList);
        return wffTreeArrayList;
    }

    /**
     * Helper function to perform inorder traversal.
     *
     * @param _wffTree - current node in the traversal.
     * @param _inorderTraversal - list to add to.
     */
    private void inorderTraversalHelper(WffTree _wffTree, ArrayList<WffTree> _inorderTraversal) {
        if (_wffTree == null) { return; }

        // Total children count
        int total = _wffTree.children.size();
        // Only one child means we traverse the child then add it.
        if (total == 1) {
            this.inorderTraversalHelper(_wffTree.children.get(0), _inorderTraversal);
            _inorderTraversal.add(_wffTree);
        } else {
            // All the children except the last
            for (int i = 0; i < total - 1; i++) {
                this.inorderTraversalHelper(_wffTree.children.get(i), _inorderTraversal);
            }

            // Print the current node's data
            _inorderTraversal.add(_wffTree);

            // Last child
            if (!_wffTree.children.isEmpty()) {
                this.inorderTraversalHelper(_wffTree.children.get(total - 1), _inorderTraversal);
            }
        }
    }

    /**
     * Performs a recursive postorder traversal on the WffTree.
     *
     * @return ArrayList of WffTrees representing the postorder traversal of the parse tree.
     */
    public ArrayList<WffTree> postorderTraversal() {
        ArrayList<WffTree> wffTreeArrayList = new ArrayList<>();
        this.postorderTraversalHelper(this, wffTreeArrayList);
        return wffTreeArrayList;
    }

    /**
     * Helper function to perform postorder traversal.
     *
     * @param _wffTree - current node in the traversal.
     * @param _postorderTraversal - list to add to.
     */
    private void postorderTraversalHelper(WffTree _wffTree, ArrayList<WffTree> _postorderTraversal) {
        if (_wffTree == null) return;
        _wffTree.getChildren().forEach(child -> {
            this.postorderTraversalHelper(child, _postorderTraversal);
        });
        _postorderTraversal.add(_wffTree);
    }

    /**
     * Recursively prints the syntax tree.
     */
    public void printSyntaxTree() {
        System.out.println(this.printSyntaxTreeHelper(0));
    }

    /**
     * Recursive function to print a syntax tree. The current depth is passed
     * as the "indent" parameter so that the output looks properly nested.
     * Each recursive call for a child is indented by two additional spaces.
     *
     * @param indent current indentation level
     * @return a string representation of this syntax tree node (and its descendants)
     * @author Steve Tate
     */
    private StringBuilder printSyntaxTreeHelper(int indent) {
        StringBuilder sb = new StringBuilder();
        sb.append(FLATUtils.repeatString(Math.max(0, indent), " "));
        sb.append(this.toString());

        if (!this.children.isEmpty()) {
            sb.append(" (\n");
            boolean isFirstChild = true;
            for (WffTree child : this.children) {
                if (!isFirstChild) {
                    sb.append(",\n");
                }
                isFirstChild = false;
                sb.append(child.printSyntaxTreeHelper(indent + 2));
            }
            sb.append(")");
        }

        return sb;
    }

    /**
     * Returns whether or not the string representations of two Wffs are equivalent. The important
     * distinction is that this method does NOT compare object references - the equals method
     * does this. This ONLY compares the strings that make up this Wff.
     * <p>
     * //     * Also, note that this DOES ***NOT*** try to flip the operands if and ONLY if they are a symmetric
     * //     * operator e.g., AND, OR, and BICOND. All others are non-symmetric. Identity is a
     * //     * separate check.
     *
     * @param _obj - WffTree object to compare against.
     * @return true if the string representations match, false otherwise.
     */
    public boolean stringEquals(Object _obj) {
        if (!(_obj instanceof WffTree)) {
            throw new ClassCastException("Cannot cast object of type " + _obj.getClass() + " to WffTree.");
        }

        WffTree o = (WffTree) _obj;
        String wff1Equiv = WffTree.getStandardizedEquiv(this.getStringRep());
        String wff2Equiv = WffTree.getStandardizedEquiv(o.getStringRep());

        if (wff1Equiv.equals(wff2Equiv)) {
            return true;
        }

        StringBuilder w1 = new StringBuilder(wff1Equiv);
        StringBuilder w2 = new StringBuilder(wff2Equiv);

        // Check to see if both are identity operators and if so, reverse them.
        if ((this.isIdentity() && o.isIdentity())
                && (FLATUtils.sbCompareTo(w1, w2.reverse()) == 0
                || FLATUtils.sbCompareTo(w1.reverse(), w2.reverse()) == 0
                || FLATUtils.sbCompareTo(w1.reverse(), w2) == 0)) {
            return true;
        } else {
            // This is a bit ugly but hopefully it works...
            // Check to see if either one has a negation.
            // If the identity is of the form ~x=y, reverse it as ~y=x
            if (this.isNegation() && this.getChild(0).isIdentity()) {
                StringBuilder i1r = new StringBuilder(w1.substring(1)).reverse();
                i1r.insert(0, "~");
                return FLATUtils.sbCompareTo(i1r, w2) == 0;
            } else if (o.isNegation() && o.getChild(0).isIdentity()) {
                StringBuilder i2r = new StringBuilder(w2.substring(1)).reverse();
                i2r.insert(0, "~");
                return FLATUtils.sbCompareTo(i2r, w1) == 0;
            }
        }

        return false;
    }

    /**
     * Replaces all instances of the customized symbols to a standard
     * notation so the equivalence checker has some uniformity.
     * <p>
     * We should probably replace these as static regex compilers...
     *
     * @param _strRep
     * @return
     */
    private static String getStandardizedEquiv(String _strRep) {
        String s = _strRep.replaceAll(" ", "");
        s = s.replaceAll("[~¬!]|(not|NOT)", "~"); // NEG
        s = s.replaceAll("[∧^⋅]|(and|AND)", "&"); // AND
        s = s.replaceAll("[\\|+\\|\\|]|(or|OR)", "∨"); // OR
        s = s.replaceAll("[→⇒⊃>]|(implies|IMPLIES)", "→"); // IMP
        s = s.replaceAll("[⇔≡↔]|(<>|iff|IFF)", "↔"); // BICOND
        s = s.replaceAll("[⊻≢⩒↮]|(xor|XOR)", "⊕"); // XOR
        s = s.replaceAll("[(]", "#");
        s = s.replaceAll("[)]", "#"); // We need to standardize these as well!
        return s;
    }

    @Override
    public boolean equals(Object _obj) {
        return super.equals(_obj);
    }

    @Override
    public int hashCode() {
        return this.getStringRep().hashCode() ^ (int) System.currentTimeMillis();
    }

    /**
     * Returns the i-th child in the list of children.
     *
     * @param i - index of child to return.
     * @return WffTree child that is desired.
     * @throws IndexOutOfBoundsException if i is out of bounds of the list.
     */
    public WffTree getChild(int i) {
        try {
            return this.children.get(i);
        } catch (IndexOutOfBoundsException ex) {
            return null;
        }
    }

    /**
     * A node P is closable if and only if it is one of the following types of wffs:
     * ~P
     * P
     * I (where I is an arbitrary identity wff)
     * ~I (same as above)
     * <p>
     * All others MUST be processed before closing.
     *
     * @return true if the node is closable, false otherwise.
     */
    public boolean isClosable() {
        if (this.isPredicate() || this.isAtom()) {
            return true;
        }
        // Nodes of type ~P are good.
        else if (this.isNegation() && this.getChild(0) != null && (this.getChild(0).isPredicate() || this.getChild(0).isAtom())) {
            return true;
        }
        // Nodes of type ~identity are good.
        else if (this.isNegation() && this.getChild(0) != null && this.getChild(0).isIdentity()) {
            return true;
        }
        // Nodes of type identity are good.
        else {
            return this.isIdentity();
        }
    }

    public int getChildrenSize() {
        return this.children.size();
    }

    public void addChild(WffTree _node) {
        this.children.add(_node);
    }

    public void setChild(int _index, WffTree _node) {
        this.children.set(_index, _node);
    }

    public boolean isRoot() {
        return this.nodeType == NodeType.ROOT;
    }

    public boolean isAtom() {
        return this.nodeType == NodeType.ATOM;
    }

    public boolean isNegation() {
        return this.nodeType == NodeType.NEG;
    }

    public boolean isDoubleNegation() {
        return this.nodeType == NodeType.NEG && this.getChild(0) != null &&
                this.getChild(0).nodeType == NodeType.NEG;
    }

    public boolean isNegAtom() {
        return this.nodeType == NodeType.NEG && this.getChild(0) != null &&
                this.getChild(0).nodeType == NodeType.ATOM;
    }

    public boolean isNegPredicate() {
        return this.nodeType == NodeType.NEG && this.getChild(0) != null &&
                this.getChild(0).nodeType == NodeType.PREDICATE;
    }

    public boolean isNegImp() {
        return this.nodeType == NodeType.NEG && this.getChild(0) != null &&
                this.getChild(0).nodeType == NodeType.IMP;
    }

    public boolean isNegAnd() {
        return this.nodeType == NodeType.NEG && this.getChild(0) != null &&
                this.getChild(0).nodeType == NodeType.AND;
    }

    public boolean isNegOr() {
        return this.nodeType == NodeType.NEG && this.getChild(0) != null &&
                this.getChild(0).nodeType == NodeType.OR;
    }

    public boolean isNegExclusiveOr() {
        return this.nodeType == NodeType.NEG && this.getChild(0) != null &&
                this.getChild(0).nodeType == NodeType.XOR;
    }

    public boolean isNegIdentity() {
        return this.nodeType == NodeType.NEG && this.getChild(0) != null &&
                this.getChild(0).nodeType == NodeType.IDENTITY;
    }

    public boolean isAnd() {
        return this.nodeType == NodeType.AND;
    }

    public boolean isOr() {
        return this.nodeType == NodeType.OR;
    }

    public boolean isImp() {
        return this.nodeType == NodeType.IMP;
    }

    public boolean isTrue() { return this.nodeType == NodeType.TRUTH; }

    public boolean isFalse() { return this.nodeType == NodeType.FALSE; }

    public boolean isBicond() {
        return this.nodeType == NodeType.BICOND;
    }

    public boolean isExclusiveOr() {
        return this.nodeType == NodeType.XOR;
    }

    public boolean isIdentity() {
        return this.nodeType == NodeType.IDENTITY;
    }

    public boolean isQuantifier() {
        return this.nodeType == NodeType.EXISTENTIAL || this.nodeType == NodeType.UNIVERSAL;
    }

    public boolean isExistential() {
        return this.nodeType == NodeType.EXISTENTIAL;
    }

    public boolean isUniversal() {
        return this.nodeType == NodeType.UNIVERSAL;
    }

    public boolean isBinaryOp() {
        return this.isAnd() || this.isOr() || this.isImp() || this.isBicond() || this.isExclusiveOr() || this.isIdentity();
    }

    public boolean isPredicate() {
        return this.nodeType == NodeType.PREDICATE;
    }

    public boolean isConstant() {
        return this.nodeType == NodeType.CONSTANT;
    }

    public boolean isVariable() {
        return this.nodeType == NodeType.VARIABLE;
    }

    public NodeType getNodeType() {
        return this.nodeType;
    }

    public boolean isPropositionalWff() {
        return (this.flags & NodeFlag.PROPOSITIONAL) != 0;
    }

    public boolean isPredicateWff() {
        return (this.flags & NodeFlag.PREDICATE) != 0;
    }

    public boolean isArgument() {
        return (this.flags & NodeFlag.ARGUMENT) != 0;
    }

    public ArrayList<WffTree> getChildren() {
        return this.children;
    }

    public ArrayList<Boolean> getTruthValues() {
        return this.truthValues;
    }

    public void setTruthValue(boolean _b, int i) {
        if (i >= this.truthValues.size()) {
            this.truthValues.add(i, _b);
        } else {
            this.truthValues.set(i, _b);
        }
    }

    public String getSymbol() {
        return this.symbol;
    }

    public void setSymbol(String _s) {
        this.symbol = _s;
    }

    public int getFlags() {
        return this.flags;
    }

    public void setFlags(int _flag) {
        this.flags |= _flag;
    }

    public boolean isHighlighted() {
        return (this.flags & NodeFlag.HIGHLIGHT) != 0;
    }

    public void setHighlighted(boolean _highlighted) {
        if (_highlighted) {
            this.flags |= NodeFlag.HIGHLIGHT;
        } else {
            this.flags &= ~NodeFlag.HIGHLIGHT;
        }
    }

    /**
     *
     * @return
     */
    public boolean isPalindromeWff() {
        String s = this.getStringRep();
        int n = s.length();
        for (int i = 0; i < (n / 2); ++i) {
            if (s.charAt(i) != s.charAt(n - i - 1)) {
                return false;
            }
        }
        return true;
    }

    /**
     * @return
     */
    public String getStringRep() {
        StringBuilder str = new StringBuilder();
        for (WffTree ch : this.getChildren()) {
            str.append(ch.getStringRep());
        }
        return str.toString();
    }

    /**
     * Recursively returns the tex command for this WffTree.
     *
     * @return String representation of the tex commands needed to display this in LaTeX.
     */
    public String getTexCommand() {
        StringBuilder str = new StringBuilder();
        for (WffTree ch : this.getChildren()) {
            str.append(ch.getTexCommand());
        }
        return str.toString();
    }

    /**
     * Returns the tex command for this WffTree ONLY, meaning that no children are called. Whatever is
     * returned is the tex commmand for that particular node. For WffTree nodes, it is null since this
     * should be the root of an AST.
     *
     * @return String representation of TeX command.
     */
    public String getTexParseCommand() {
        return null;
    }

    @Override
    public String toString() {
        return this.nodeType.toString();
    }
}
