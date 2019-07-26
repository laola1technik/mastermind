package at.weblaola1.dev.mastermind;

import java.util.Random;

public enum CodePeg {
    RED,
    GREEN,
    MAGENTA,
    BLUE,
    YELLOW,
    WHITE;

    public static CodePeg getRandom() {
        return values()[new Random().nextInt(values().length)];
    }
}
