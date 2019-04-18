package at.weblaola1.dev.mastermind;

import java.util.HashSet;
import java.util.Set;

class CodeGenerator {
    private Set<CodePegColor> colors;

    CodeGenerator(Set<CodePegColor> colors) {
        this.colors = colors;
    }

    Set<Code> createAllCodes(int codePegCount) {
        Set<Code> result = new HashSet<>();

        Set<Code> finalResult = result;
        colors.forEach(codePegColor -> finalResult.add(Code.fromColors(codePegColor)));

        for (int i = 1; i < codePegCount; i++) {
            Set<Code> newResult = new HashSet<>();
            for (Code code : result) {
                colors.forEach(codePegColor -> {
                    Code copiedCode = code.deepCopy();
                    copiedCode.append(codePegColor);
                    newResult.add(copiedCode);
                });
            }
            result = newResult;
        }

        return result;
    }
}
