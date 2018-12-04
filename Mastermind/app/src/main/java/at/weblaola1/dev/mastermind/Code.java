package at.weblaola1.dev.mastermind;

import java.util.Arrays;

class Code {
    private CodePeg[] codePegs;

    Code(CodePeg[] codePegs) {
        this.codePegs = codePegs;
    }

    CompareResult compareWith(Code otherCode) {
        if (Arrays.equals(codePegs, otherCode.codePegs)) {
            CompareResult compareResult = new CompareResult();
            compareResult.increaseNumberOfWellPlaced();
            return compareResult;
        }
        return new CompareResult();
    }
}
