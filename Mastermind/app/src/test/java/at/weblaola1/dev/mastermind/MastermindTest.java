package at.weblaola1.dev.mastermind;

import org.junit.Assert;
import org.junit.Test;

public class MastermindTest {
    @Test
    public void should_return_zero_well_placed_and_zero_misplaced_key_pegs_for_code_red_and_guess_green() {
        CodePeg redCodePeg = new CodePeg(CodePeg.Type.RED);
        CodePeg greenCodePeg = new CodePeg(CodePeg.Type.GREEN);
        Code correctCode = new Code(new CodePeg[]{redCodePeg});
        Code guessedCode = new Code(new CodePeg[]{greenCodePeg});
        CompareResult expectedResult = new CompareResult();

        CompareResult result = correctCode.compareWith(guessedCode);

        Assert.assertEquals(expectedResult, result);
    }
}