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

        for (int i = codePegs.size() - 1; i >= 0; i--) {
            if (codePegs.get(i).equals(otherCode.codePegs.get(i))) {
                compareResult.increaseNumberOfWellPlaced();
                remainingCodePegs.remove(i);
                remainingOtherCodePegs.remove(i);
            }
        }

        List<CodePegType> pegTypes = remainingOtherCodePegs.stream().map(CodePeg::getType)
                .collect(Collectors.toList());

        remainingCodePegs.forEach(codePeg -> {
            CodePegType pegType = codePeg.getType();
            int pegTypeIndex = pegTypes.indexOf(pegType);
            if (pegTypeIndex > -1) {
                pegTypes.remove(pegTypeIndex);
                compareResult.increaseNumberOfMisplaced();
            }
        });
        return compareResult;
    }
}
