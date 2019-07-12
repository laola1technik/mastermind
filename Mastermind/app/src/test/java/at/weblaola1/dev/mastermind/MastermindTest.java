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

@RunWith(Parameterized.class)
public class MastermindTest {

    private final Code correctCode;
    private final Code guessedCode;
    private final int wellPlaced;
    private final int misplaced;

    public MastermindTest(
            @SuppressWarnings("unused") String testName,
            Code correctCode,
            Code guessedCode,
            int wellPlaced,
            int misplaced
    ) {
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
                        new Code(RED),
                        new Code(GREEN),
                        0,
                        0
                },
                {
                        "should_return_one_wellplaced_and_zero_misplaced_for_code_red_and_guess_red",
                        new Code(RED),
                        new Code(RED),
                        1,
                        0
                },
                {
                        "should_return_two_wellplaced_and_zero_misplaced_for_2_correct_pegs",
                        new Code(RED, GREEN),
                        new Code(RED, GREEN),
                        2,
                        0
                },
                {
                        "should_return_zero_wellplaced_and_one_misplaced_for_one_misplaced_peg",
                        new Code(RED, GREEN),
                        new Code(MAGENTA, RED),
                        0,
                        1
                },
                {
                        "should_return_zero_wellplaced_and_two_misplaced_for_two_misplaced_pegs",
                        new Code(WHITE, GREEN),
                        new Code(GREEN, WHITE),
                        0,
                        2
                },
                {
                        "should_return_one_wellplaced_and_one_misplaced",
                        new Code(WHITE, GREEN, YELLOW),
                        new Code(WHITE, YELLOW, MAGENTA),
                        1,
                        1
                },
                {
                        "should_return_zero_wellplaced_and_one_misplaced_if_colour_matches_multiple_times",
                        new Code(MAGENTA, MAGENTA, MAGENTA, GREEN),
                        new Code(RED, RED, RED, MAGENTA),
                        0,
                        1
                }
        });
    }
}