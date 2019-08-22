package at.weblaola1.dev.mastermind;

class GameSettings {
    private CodePeg[] codePegs;
    private int codePegCount;

    GameSettings(CodePeg[] codePegs, int codePegCount) {
        this.codePegs = codePegs;
        this.codePegCount = codePegCount;
    }

    CodePeg[] getCodePegs() {
        return codePegs;
    }

    int getCodePegCount() {
        return codePegCount;
    }
}

