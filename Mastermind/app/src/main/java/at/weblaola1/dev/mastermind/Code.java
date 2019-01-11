package at.weblaola1.dev.mastermind;

import java.util.List;

class Code {
    private List<CodePeg> codePegs;

    Code(List<CodePeg> codePegs) {
        this.codePegs = codePegs;
    }

    CompareResult compareWith(Code otherCode) {
        if (codePegs.equals(otherCode.codePegs)) {
            CompareResult compareResult = new CompareResult();
            compareResult.increaseNumberOfWellPlaced();
            return compareResult;
        }
        return new CompareResult();
    }
}
