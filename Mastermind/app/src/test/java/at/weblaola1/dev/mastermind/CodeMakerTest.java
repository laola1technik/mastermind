package at.weblaola1.dev.mastermind;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static at.weblaola1.dev.mastermind.CodePeg.GREEN;
import static at.weblaola1.dev.mastermind.CodePeg.RED;
import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertEquals;

public class CodeMakerTest {

    @Test
    public void should_hold_code_of_size_four() {
        CodePeg[] pegTypes = new CodePeg[]{RED, GREEN};
        GameSettings settings = new GameSettings(pegTypes, 4);
        CodeMaker codeMaker = new CodeMaker(settings);

        assertEquals(4, codeMaker.getCode().getPegs().size());
    }

    @Test
    public void should_generate_random_code() {
        GameSettings settings = new GameSettings(CodePeg.values(), 4);

        Set<Code> codes = new HashSet<>(asList(
                new CodeMaker(settings).getCode(),
                new CodeMaker(settings).getCode(),
                new CodeMaker(settings).getCode()
        ));

        Assert.assertThat(codes.size(), greaterThan(1));
    }
}