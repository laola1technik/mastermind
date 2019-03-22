package at.weblaola1.dev.mastermind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class CodeGenerator {
    private List<CodePegColor> types;

    CodeGenerator(CodePegColor... types) {
        this.types = Arrays.asList(types);
    }

    List<Code> createAllCodes(int codePegCount) {
        List<CodePeg> codePegList = new ArrayList<>();

        for (int i = 0; i < codePegCount; i++) {
            codePegList.add(new CodePeg(types.get(0)));
        }

        return Collections.singletonList(
                new Code(codePegList)
        );
    }
}
