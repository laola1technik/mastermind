package at.weblaola1.dev.mastermind;

class CodePeg {
    private Type type;

    public enum Type {
        RED,
        GREEN,
        MAGENTA,
        BLUE,
        YELLOW,
        WHITE,
    }

    CodePeg(Type type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object obj) {
        return type == ((CodePeg)obj).type;
    }
}
