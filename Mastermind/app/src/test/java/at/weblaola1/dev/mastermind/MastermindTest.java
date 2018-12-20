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
                },
                {
                        createCode(CodePeg.Type.RED),
                        createCode(CodePeg.Type.GREEN),
                        0,
                        0
                }

        };
    }

}