package at.weblaola1.dev.mastermind;

class CodePeg {
    private CodePegType type;

    CodePeg(CodePegType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object obj) {
        return type == ((CodePeg)obj).type;
    }

    public CodePegType getType() {
        return type;
    }
}
