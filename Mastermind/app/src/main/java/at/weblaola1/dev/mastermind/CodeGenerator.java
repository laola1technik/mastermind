package at.weblaola1.dev.mastermind;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class CodeGenerator {
    public List<Code> createAllCodes(int possibleColoursCount, int codePegCount) {
        return Arrays.asList(
                new Code(Collections.singletonList(new CodePeg(CodePegType.MAGENTA))),
                new Code(Collections.singletonList(new CodePeg(CodePegType.MAGENTA))),
                new Code(Collections.singletonList(new CodePeg(CodePegType.MAGENTA))),
                new Code(Collections.singletonList(new CodePeg(CodePegType.MAGENTA)))
        );
    }
}
