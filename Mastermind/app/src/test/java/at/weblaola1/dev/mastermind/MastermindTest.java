package at.weblaola1.dev.mastermind;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
                        createCode(CodePegType.RED),
                        createCode(CodePegType.GREEN),
                        0,
                        0
                },
                {
                        "should_return_one_wellplaced_and_zero_misplaced_for_code_red_and_guess_red",
                        createCode(CodePegType.RED),
                        createCode(CodePegType.RED),
                        1,
                        0
                },
                {
                        "should_return_two_wellplaced_and_zero_misplaced_for_2_correct_pegs",
                        createCode(CodePegType.RED, CodePegType.GREEN),
                        createCode(CodePegType.RED, CodePegType.GREEN),
                        2,
                        0
                },
                {
                        "should_return_zero_wellplaced_and_one_misplaced_for_one_misplaced_peg",
                        createCode(CodePegType.RED, CodePegType.GREEN),
                        createCode(CodePegType.MAGENTA, CodePegType.RED),
                        0,
                        1
                },
                {
                        "should_return_zero_wellplaced_and_two_misplaced_for_two_misplaced_pegs",
                        createCode(CodePegType.WHITE, CodePegType.GREEN),
                        createCode(CodePegType.GREEN, CodePegType.WHITE),
                        0,
                        2
                },
                {
                        "should_return_one_wellplaced_and_one_misplaced",
                        createCode(CodePegType.WHITE, CodePegType.GREEN, CodePegType.YELLOW),
                        createCode(CodePegType.WHITE, CodePegType.YELLOW, CodePegType.MAGENTA),
                        1,
                        1
                },
                {
                        "should_return_zero_wellplaced_and_one_misplaced_if_colour_matches_multiple_times",
                        createCode(CodePegType.MAGENTA, CodePegType.MAGENTA, CodePegType.MAGENTA, CodePegType.GREEN),
                        createCode(CodePegType.RED, CodePegType.RED, CodePegType.RED, CodePegType.MAGENTA),
                        0,
                        1
                }
        });
    }

    private static Code createCode(CodePegType... codePegTypes) {
        ArrayList<CodePeg> codePegs = new ArrayList<>();

        for (CodePegType codePegType : codePegTypes) {
            codePegs.add(new CodePeg(codePegType));
        }
        return new Code(codePegs);
    }

    @Test
    public void should_create_all_possible_codes_for_code_with_one_codePeg() {
        int possibleColoursCount = 4;
        int codePegCount = 1;
        CodeGenerator codeGenerator = new CodeGenerator();

        List<?> allPossibleCodes = codeGenerator.createAllCodes(possibleColoursCount, codePegCount);

        Assert.assertEquals(((int) Math.pow(possibleColoursCount, codePegCount)), allPossibleCodes.size());
    }
}