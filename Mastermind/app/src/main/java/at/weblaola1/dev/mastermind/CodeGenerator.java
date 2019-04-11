package at.weblaola1.dev.mastermind;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class CodeGenerator {
    private Set<CodePegColor> colors;

    CodeGenerator(Set<CodePegColor> colors) {
        this.colors = colors;
    }

    Set<Code> createAllCodes(int codePegCount) {
        Set<Code> codes = new HashSet<>();

        colors.forEach(codePegColor -> {
            List<CodePeg> codePegList = new ArrayList<>();

            for (int i = 0; i < codePegCount; i++) {
                codePegList.add(new CodePeg(codePegColor));
            }
            codes.add(new Code(codePegList));
        });
        return codes;
    }
}
