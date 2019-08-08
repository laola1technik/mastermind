package at.weblaola1.dev.mastermind;

import org.junit.Test;

import java.util.HashSet;

import static at.weblaola1.dev.mastermind.CodePeg.GREEN;
import static at.weblaola1.dev.mastermind.CodePeg.RED;
import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class CodeMakerTest {

    @Test
    public void should_hold_code_of_size_four() {
        HashSet<CodePeg> pegTypes = new HashSet<>(asList(RED, GREEN));
        CodeMaker codeMaker = new CodeMaker(new CodeGenerator(pegTypes));

        assertEquals(4, codeMaker.getCode().getPegs().size());
    }
}