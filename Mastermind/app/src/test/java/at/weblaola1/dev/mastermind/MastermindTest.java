package at.weblaola1.dev.mastermind;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;

@RunWith(DataProviderRunner.class)
public class MastermindTest {
    @Test
    public void should_return_zero_well_placed_and_zero_misplaced_key_pegs_for_code_red_and_guess_green() {
        CodePeg redCodePeg = new CodePeg(CodePeg.Type.RED);
        CodePeg greenCodePeg = new CodePeg(CodePeg.Type.GREEN);
        Code correctCode = new Code(new CodePeg[]{redCodePeg});
        Code guessedCode = new Code(new CodePeg[]{greenCodePeg});

        CompareResult result = correctCode.compareWith(guessedCode);

        Assert.assertEquals(0, result.getNumberOfWellPlaced());
        Assert.assertEquals(0, result.getNumberOfMisplaced());
    }

    @Test
    @UseDataProvider("correct_code_guessed_code_well_placed_misplaced")
    public void should_give_well_placed_and_misplaced_for_guessed_code(Code correctCode, Code guessedCode, int wellPlaced, int misplaced) {
        CompareResult result = correctCode.compareWith(guessedCode);

        Assert.assertEquals(wellPlaced, result.getNumberOfWellPlaced());
        Assert.assertEquals(misplaced, result.getNumberOfMisplaced());
    }

    private static Code createCode(CodePeg.Type... codePegTypes) {
        CodePeg[] codePegs = new CodePeg[codePegTypes.length];
        for (int i = 0; i < codePegTypes.length; i++) {
            codePegs[i] = new CodePeg(codePegTypes[i]);
        }
        return new Code(codePegs);
    }

    @DataProvider
    public static Object[][] correct_code_guessed_code_well_placed_misplaced() {
        return new Object[][]{
                {
                    createCode(CodePeg.Type.RED),
                    createCode(CodePeg.Type.RED),
                    1,
                    0
                }
        };
        // @formatter:on
    }

}