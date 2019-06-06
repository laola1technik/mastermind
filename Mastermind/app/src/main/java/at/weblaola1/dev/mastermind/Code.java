package at.weblaola1.dev.mastermind;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Code {
    private List<CodePeg> codePegs;

    Code(List<CodePeg> codePegs) {
        this.codePegs = codePegs;
    }

    static Code fromCodeAndPeg(Code code, CodePeg codePeg) {
        List<CodePeg> codePegsCopy = new ArrayList<>(code.codePegs);
        codePegsCopy.add(codePeg);
        return new Code(codePegsCopy);
    }

    CompareResult compareWith(Code guessedCode) {
        List<CodePeg> remainingCodePegs = new ArrayList<>(codePegs);
        List<CodePeg> remainingGuessedCodePegs = new ArrayList<>(guessedCode.codePegs);
        CompareResult compareResult = new CompareResult();

        removeWellPlacedPegs(remainingCodePegs, remainingGuessedCodePegs);

        compareResult.setNumberOfWellPlaced(codePegs.size() - remainingCodePegs.size());
        compareResult.setNumberOfMisplaced(countMisplacedCodePegs(remainingCodePegs, remainingGuessedCodePegs));

        return compareResult;
    }

    private void removeWellPlacedPegs(List<CodePeg> codePegs, List<CodePeg> guessedCodePegs) {
        for (int codePegIndex = this.codePegs.size() - 1; codePegIndex >= 0; codePegIndex--) {
            if (this.codePegs.get(codePegIndex).equals(guessedCodePegs.get(codePegIndex))) {
                codePegs.remove(codePegIndex);
                guessedCodePegs.remove(codePegIndex);
            }
        }
    }

    private int countMisplacedCodePegs(List<CodePeg> codePegs, List<CodePeg> guessedCodePegs) {
        return (int) codePegs.stream()
                .filter(codePeg -> removedMisplacedPeg(guessedCodePegs, codePeg))
                .count();
    }

    private boolean removedMisplacedPeg(List<CodePeg> pegs, CodePeg peg) {
        int pegTypeIndex = pegs.indexOf(peg);
        if (pegTypeIndex > -1) {
            pegs.remove(pegTypeIndex);
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Code code = (Code) o;
        return Objects.equals(codePegs, code.codePegs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codePegs);
    }

    @NonNull
    @Override
    public String toString() {
        return "Code{" + codePegs + '}';
    }
}
