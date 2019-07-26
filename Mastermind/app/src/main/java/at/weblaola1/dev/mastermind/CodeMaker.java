package at.weblaola1.dev.mastermind;

import static at.weblaola1.dev.mastermind.CodePeg.*;

public class CodeMaker {

    private Code code;

    CodeMaker() {
        code = new Code(BLUE, GREEN, RED, MAGENTA);
    }

    Code getCode() {
        return code;
    }

    public void setCode(Code code) {
        this.code = code;
    }
}
