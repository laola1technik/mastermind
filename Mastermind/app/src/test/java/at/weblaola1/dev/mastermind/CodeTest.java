package at.weblaola1.dev.mastermind;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static at.weblaola1.dev.mastermind.CodePeg.BLUE;
import static at.weblaola1.dev.mastermind.CodePeg.MAGENTA;

public class CodeTest {
    @Test
    public void should_not_add_same_code_twice() {
        Code code = new Code(BLUE, MAGENTA);
        Code sameCode = new Code(BLUE, MAGENTA);
        Set<Code> codes = new HashSet<>();

        codes.add(code);
        codes.add(sameCode);

        Assert.assertEquals(1, codes.size());
    }

    @Test
    public void should_validate_that_codes_are_equal() {
        Code code = new Code(BLUE, MAGENTA);
        Code sameCode = new Code(BLUE, MAGENTA);

        Assert.assertEquals(code, sameCode);
    }

    @Test
    public void should_create_code_from_pegs() {
        CodePeg[] codePegs = {BLUE, MAGENTA};

        Code code = new Code(codePegs);

        Assert.assertEquals(code, new Code(codePegs));
    }

    @Test
    public void should_return_compare_result_with_four_well_placed() {
        Code code = new Code(BLUE, BLUE, MAGENTA, MAGENTA);

        CompareResult compareResult = code.compareWith(code);

        Assert.assertEquals(4, compareResult.getNumberOfWellPlaced());
    }
}
