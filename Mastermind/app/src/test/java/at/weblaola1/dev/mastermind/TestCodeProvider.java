package at.weblaola1.dev.mastermind;

import java.util.ArrayList;

class TestCodeProvider {
    static Code createCode(CodePegColor... codePegColors) {
        ArrayList<CodePeg> codePegs = new ArrayList<>();

        for (CodePegColor codePegColor : codePegColors) {
            codePegs.add(new CodePeg(codePegColor));
        }
        return new Code(codePegs);
    }
}
