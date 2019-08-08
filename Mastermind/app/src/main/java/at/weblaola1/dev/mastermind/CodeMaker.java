package at.weblaola1.dev.mastermind;

class CodeMaker {

    private Code code;

    CodeMaker(CodeGenerator codeGenerator) {
        code = codeGenerator.createRandomCode(4);
    }

    Code getCode() {
        return code;
    }
}
