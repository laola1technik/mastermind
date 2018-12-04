package at.weblaola1.dev.mastermind;

class Code {
    private CodePeg[] codePegs;

    public Code(CodePeg[] codePegs) {
        this.codePegs = codePegs;
    }

    public CompareResult compareWith(Code otherCode) {
        return new CompareResult();
    }
}
