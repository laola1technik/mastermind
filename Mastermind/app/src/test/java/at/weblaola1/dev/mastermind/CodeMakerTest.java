package at.weblaola1.dev.mastermind;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CodeMakerTest {

    @Test
    public void should_hold_code_of_size_four() {
        CodeMaker codeMaker = new CodeMaker();

        assertEquals(4, codeMaker.getCode().getPegs().size());
    }
}