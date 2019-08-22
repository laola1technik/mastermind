package at.weblaola1.dev.mastermind;

import java.util.Random;

class CodeMaker {

    private Code code;

    CodeMaker(GameSettings gameSettings) {
        code = createRandomCode(gameSettings);
    }

    private Code createRandomCode(GameSettings settings) {
        CodePeg[] availableCodePegs = settings.getCodePegs();
        CodePeg[] createdCodePegs = new CodePeg[settings.getCodePegCount()];
        for (int i = 0; i < settings.getCodePegCount(); i++) {
            createdCodePegs[i] = availableCodePegs[new Random().nextInt(availableCodePegs.length)];
        }

        return new Code(createdCodePegs);
    }

    Code getCode() {
        return code;
    }
}
