package at.weblaola1.dev.mastermind;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;

@RunWith(Parameterized.class)
public class MastermindTest {

    private final Code correctCode;
    private final Code guessedCode;
    private final int wellPlaced;
    private final int misplaced;

    public MastermindTest(String testName, Code correctCode, Code guessedCode, int wellPlaced, int misplaced) {
        this.correctCode = correctCode;
        this.guessedCode = guessedCode;
        this.wellPlaced = wellPlaced;
        this.misplaced = misplaced;
    }

    @Test
    public void should_give_well_placed_and_misplaced_for_guessed_code() {
        CompareResult result = correctCode.compareWith(guessedCode);

        Assert.assertEquals(wellPlaced, result.getNumberOfWellPlaced());
        Assert.assertEquals(misplaced, result.getNumberOfMisplaced());
    }

    @Parameterized.Parameters(name = "{0}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {
                        "should_return_zero_well_placed_and_zero_misplaced_key_pegs_for_code_red_and_guess_green",
                        createCode(CodePeg.Type.RED),
                        createCode(CodePeg.Type.GREEN),
                        0,
                        0
                },
                {
                        "should_return_one_wellplaced_and_zero_misplaced_for_code_red_and_guess_red",
                        createCode(CodePeg.Type.RED),
                        createCode(CodePeg.Type.RED),
                        1,
                        0
                },
                {
                        "should_return_two_wellplaced_and_zero_misplaced_for_2_correct_pegs",
                        createCode(CodePeg.Type.RED, CodePeg.Type.GREEN),
                        createCode(CodePeg.Type.RED, CodePeg.Type.GREEN),
                        2,
                        0
                },
                {
                        "should_return_zero_wellplaced_and_one_misplaced_for_one_misplaced_peg",
                        createCode(CodePeg.Type.RED, CodePeg.Type.GREEN),
                        createCode(CodePeg.Type.MAGENTA, CodePeg.Type.RED),
                        0,
                        1
                },
                {
                        "should_return_zero_wellplaced_and_two_misplaced_for_two_misplaced_pegs",
                        createCode(CodePeg.Type.WHITE, CodePeg.Type.GREEN),
                        createCode(CodePeg.Type.GREEN, CodePeg.Type.WHITE),
                        0,
                        2
                }
        });
    }

    private static Code createCode(CodePeg.Type... codePegTypes) {
        ArrayList<CodePeg> codePegs = new ArrayList<>();

        for (CodePeg.Type codePegType : codePegTypes) {
            codePegs.add(new CodePeg(codePegType));
        }
        return new Code(codePegs);
    }
}