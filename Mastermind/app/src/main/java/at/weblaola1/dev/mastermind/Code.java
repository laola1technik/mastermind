package at.weblaola1.dev.mastermind;

import java.util.List;

class Code {
    private List<CodePeg> codePegs;

    Code(List<CodePeg> codePegs) {
        this.codePegs = codePegs;
    }

    CompareResult compareWith(Code otherCode) {
        CompareResult compareResult = new CompareResult();
        for (int i = 0; i < codePegs.size(); i++) {
            if (codePegs.get(i).equals(otherCode.codePegs.get(i))) {
                compareResult.increaseNumberOfWellPlaced();
            }
        }

        return compareResult;
    }
}
