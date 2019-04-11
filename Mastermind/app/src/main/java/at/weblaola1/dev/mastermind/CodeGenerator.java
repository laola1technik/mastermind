package at.weblaola1.dev.mastermind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class CodeGenerator {
    private List<CodePegColor> colors;

    CodeGenerator(CodePegColor... colors) {
        this.colors = Arrays.asList(colors);
    }

    List<Code> createAllCodes(int codePegCount) {

        List<Code> codes = new ArrayList<>();

        for (int j = 0; j < colors.size(); j++) {
            List<CodePeg> codePegList = new ArrayList<>();

            for (int i = 0; i < codePegCount; i++) {
                codePegList.add(new CodePeg(colors.get(j)));
            }
            codes.add(new Code(codePegList));
        }

        return codes;
    }
}
