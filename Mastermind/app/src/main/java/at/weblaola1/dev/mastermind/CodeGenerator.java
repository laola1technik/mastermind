package at.weblaola1.dev.mastermind;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class CodeGenerator {
    private List<CodePegType> types;

    CodeGenerator(CodePegType... types) {
        this.types = Arrays.asList(types);
    }

    List<Code> createAllCodes(int codePegCount) {
        return Collections.singletonList(
                new Code(Collections.singletonList(new CodePeg(types.get(0))))
        );
    }
}
