package at.weblaola1.dev.mastermind;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.util.Arrays.asList;

class Code {
    private List<CodePegColor> codePegColors;

    Code(List<CodePegColor> codePegColors) {
        this.codePegColors = codePegColors;
    }

    static Code fromColors(CodePegColor... colors) {
        // TODO: remove this
        return new Code(asList(colors));
    }

    // TODO remove static function and make it code.addPeg(CodePegColor codePegColor)
    static Code fromCodeAndColor(Code code, CodePegColor codePegColor) {
        List<CodePegColor> codePegColorsCopy = new ArrayList<>(code.codePegColors);
        codePegColorsCopy.add(codePegColor);
        return new Code(codePegColorsCopy);
    }

    CompareResult compareWith(Code guessedCode) {
        List<CodePegColor> remainingCodePegColors = new ArrayList<>(codePegColors);
        List<CodePegColor> remainingGuessedCodePegs = new ArrayList<>(guessedCode.codePegColors);
        CompareResult compareResult = new CompareResult();

        removeWellPlacedPegs(remainingCodePegColors, remainingGuessedCodePegs);

        compareResult.setNumberOfWellPlaced(codePegColors.size() - remainingCodePegColors.size());
        compareResult.setNumberOfMisplaced(countMisplacedCodePegs(remainingCodePegColors, remainingGuessedCodePegs));

        return compareResult;
    }

    private void removeWellPlacedPegs(List<CodePegColor> codePegColors, List<CodePegColor> guessedCodePegColors) {
        for (int codePegColorIndex = this.codePegColors.size() - 1; codePegColorIndex >= 0; codePegColorIndex--) {
            if (this.codePegColors.get(codePegColorIndex).equals(guessedCodePegColors.get(codePegColorIndex))) {
                codePegColors.remove(codePegColorIndex);
                guessedCodePegColors.remove(codePegColorIndex);
            }
        }
    }

    private int countMisplacedCodePegs(List<CodePegColor> codePegColors, List<CodePegColor> guessedCodePegColors) {
        return (int) codePegColors.stream()
                .filter(codePegColor -> removedMisplacedPeg(guessedCodePegColors, codePegColor))
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
        return Objects.equals(codePegColors, code.codePegColors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codePegColors);
    }

    @NonNull
    @Override
    public String toString() {
        return "Code{" + codePegColors + '}';
    }
}
