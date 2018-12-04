package at.weblaola1.dev.mastermind;

class CodePeg {
    private Type type;

    public enum Type {
        RED,
        GREEN
    }

    public CodePeg(Type type) {
        this.type = type;
    }
}
