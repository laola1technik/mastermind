package at.weblaola1.dev.mastermind;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Code {
    private List<CodePeg> codePegs;

    Code(List<CodePeg> codePegs) {
        this.codePegs = codePegs;
    }

    CompareResult compareWith(Code otherCode) {
        List<CodePeg> remainingCodePegs = new ArrayList<>(codePegs);
        List<CodePeg> remainingOtherCodePegs = new ArrayList<>(otherCode.codePegs);
        CompareResult compareResult = new CompareResult();

        for (int codePegIndex = codePegs.size() - 1; codePegIndex >= 0; codePegIndex--) {
            if (codePegs.get(codePegIndex).equals(otherCode.codePegs.get(codePegIndex))) {
                compareResult.increaseNumberOfWellPlaced();
                remainingCodePegs.remove(codePegIndex);
                remainingOtherCodePegs.remove(codePegIndex);
            }
        }

        compareResult.setNumberOfMisplaced(countMisplacedCodePegs(remainingCodePegs, remainingOtherCodePegs));

        return compareResult;
    }

    private int countMisplacedCodePegs(List<CodePeg> codePegs, List<CodePeg> otherCodePegs) {
        List<CodePegType> pegTypes = otherCodePegs.stream().map(CodePeg::getType)
                .collect(Collectors.toList());

        return (int) codePegs.stream()
                .filter(codePeg -> removedMisplacedPeg(pegTypes, codePeg.getType()))
                .count();
    }

    private boolean removedMisplacedPeg(List<CodePegType> pegTypes, CodePegType pegType) {
        int pegTypeIndex = pegTypes.indexOf(pegType);
        if (pegTypeIndex > -1) {
            pegTypes.remove(pegTypeIndex);
            return true;
        }
        return false;
    }
}
