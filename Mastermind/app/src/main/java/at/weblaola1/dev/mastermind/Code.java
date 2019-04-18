package at.weblaola1.dev.mastermind;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

class Code {
    private List<CodePeg> codePegs;

    Code(List<CodePeg> codePegs) {
        this.codePegs = codePegs;
    }

    static Code fromColors(CodePegColor... colors) {
        List<CodePeg> codePegs = new ArrayList<>();
        Arrays.stream(colors).forEach(color -> codePegs.add(new CodePeg(color)));

        return new Code(codePegs);
    }

    static Code fromCodeAndColor(Code code, CodePegColor codePegColor) {
        List<CodePeg> codePegsCopy = new ArrayList<>(code.codePegs);
        codePegsCopy.add(new CodePeg(codePegColor));
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
        List<CodePegColor> pegColors = guessedCodePegs.stream().map(CodePeg::getType)
                .collect(Collectors.toList());

        return (int) codePegs.stream()
                .filter(codePeg -> removedMisplacedPeg(pegColors, codePeg.getType()))
                .count();
    }

    private boolean removedMisplacedPeg(List<CodePegColor> pegColors, CodePegColor pegColor) {
        int pegTypeIndex = pegColors.indexOf(pegColor);
        if (pegTypeIndex > -1) {
            pegColors.remove(pegTypeIndex);
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
