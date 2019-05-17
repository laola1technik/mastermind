package at.weblaola1.dev.mastermind;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static at.weblaola1.dev.mastermind.CodePegColor.BLUE;
import static at.weblaola1.dev.mastermind.CodePegColor.MAGENTA;
import static at.weblaola1.dev.mastermind.TestCodeProvider.createCode;

public class CodeSetTest {
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
}
