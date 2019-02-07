package at.weblaola1.dev.mastermind;

import java.util.ArrayList;
import java.util.List;

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

        remainingCodePegs.forEach(peg -> {
            for (int i = remainingOtherCodePegs.size() - 1; i >= 0; i--) {
                if (peg.equals(remainingOtherCodePegs.get(i))) {
                    remainingOtherCodePegs.remove(i);
                    compareResult.increaseNumberOfMisplaced();
                    break;
                }
            }
        });
        return compareResult;
    }
}
