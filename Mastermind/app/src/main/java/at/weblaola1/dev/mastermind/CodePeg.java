package at.weblaola1.dev.mastermind;

class CodePeg {
    private CodePegColor type;

    CodePeg(CodePegColor type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object obj) {
        return type == ((CodePeg)obj).type;
    }

    public CodePegColor getType() {
        return type;
    }
}
