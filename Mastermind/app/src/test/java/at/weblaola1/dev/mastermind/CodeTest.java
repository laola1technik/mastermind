package at.weblaola1.dev.mastermind;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static at.weblaola1.dev.mastermind.CodePeg.BLUE;
import static at.weblaola1.dev.mastermind.CodePeg.MAGENTA;
import static at.weblaola1.dev.mastermind.TestCodeProvider.createCode;
import static java.util.Arrays.asList;

public class CodeTest {
    @Test
    public void should_not_add_same_code_twice() {
        Code code = createCode(BLUE, MAGENTA);
        Code sameCode = createCode(BLUE, MAGENTA);
        Set<Code> codeSet = new HashSet<>();

        codeSet.add(code);
        codeSet.add(sameCode);

        Assert.assertEquals(1, codeSet.size());
    }

    @Test
    public void should_validate_that_codes_are_equal() {
        Code code = createCode(BLUE, MAGENTA);
        Code sameCode = createCode(BLUE, MAGENTA);

        Assert.assertEquals(code, sameCode);
    }

    @Test
    public void should_create_code_from_pegs() {
        CodePeg[] codePegs = {BLUE, MAGENTA};

        Code code = new Code(asList(codePegs));

        Assert.assertEquals(code, createCode(codePegs));
    }
}
