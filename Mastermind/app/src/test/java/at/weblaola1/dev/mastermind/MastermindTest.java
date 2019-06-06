package at.weblaola1.dev.mastermind;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static at.weblaola1.dev.mastermind.CodePeg.GREEN;
import static at.weblaola1.dev.mastermind.CodePeg.MAGENTA;
import static at.weblaola1.dev.mastermind.CodePeg.RED;
import static at.weblaola1.dev.mastermind.CodePeg.WHITE;
import static at.weblaola1.dev.mastermind.CodePeg.YELLOW;
import static at.weblaola1.dev.mastermind.TestCodeProvider.createCode;

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
                        createCode(RED),
                        createCode(GREEN),
                        0,
                        0
                },
                {
                        "should_return_one_wellplaced_and_zero_misplaced_for_code_red_and_guess_red",
                        createCode(RED),
                        createCode(RED),
                        1,
                        0
                },
                {
                        "should_return_two_wellplaced_and_zero_misplaced_for_2_correct_pegs",
                        createCode(RED, GREEN),
                        createCode(RED, GREEN),
                        2,
                        0
                },
                {
                        "should_return_zero_wellplaced_and_one_misplaced_for_one_misplaced_peg",
                        createCode(RED, GREEN),
                        createCode(MAGENTA, RED),
                        0,
                        1
                },
                {
                        "should_return_zero_wellplaced_and_two_misplaced_for_two_misplaced_pegs",
                        createCode(WHITE, GREEN),
                        createCode(GREEN, WHITE),
                        0,
                        2
                },
                {
                        "should_return_one_wellplaced_and_one_misplaced",
                        createCode(WHITE, GREEN, YELLOW),
                        createCode(WHITE, YELLOW, MAGENTA),
                        1,
                        1
                },
                {
                        "should_return_zero_wellplaced_and_one_misplaced_if_colour_matches_multiple_times",
                        createCode(MAGENTA, MAGENTA, MAGENTA, GREEN),
                        createCode(RED, RED, RED, MAGENTA),
                        0,
                        1
                }
        });
    }
}