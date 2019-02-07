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

        for (int i = remainingCodePegs.size() - 1; i >= 0; i--) {
            for (int j = remainingOtherCodePegs.size() - 1; j >= 0; j--) {
                if (remainingCodePegs.get(i).equals(remainingOtherCodePegs.get(j))) {
                    remainingOtherCodePegs.remove(j);
                    compareResult.increaseNumberOfMisplaced();
                    break;
                }
            }
        }
        return compareResult;
    }
}
