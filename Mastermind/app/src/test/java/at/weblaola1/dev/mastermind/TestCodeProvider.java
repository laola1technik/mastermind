package at.weblaola1.dev.mastermind;

import static java.util.Arrays.asList;
//TODO: remove this
class TestCodeProvider {
    static Code createCode(CodePegColor... codePegColors) {
        return new Code(asList(codePegColors));
    }
}
