package at.weblaola1.dev.mastermind;

import android.support.annotation.NonNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

import static at.weblaola1.dev.mastermind.CodePeg.BLUE;
import static at.weblaola1.dev.mastermind.CodePeg.GREEN;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(Parameterized.class)
public class CodeGeneratorTest {
    private int pegCount;
    private Set<CodePeg> pegs;
    private Set<Code> expectedCodes;

    public CodeGeneratorTest(String testName, int pegCount, Set<CodePeg> pegs, Set<Code> expectedCodes) {
        this.pegCount = pegCount;
        this.pegs = pegs;
        this.expectedCodes = expectedCodes;
    }

    @Test
    public void should_create_all_codes() {
        CodeGenerator codeGenerator = new CodeGenerator(pegs);

        Set<Code> allPossibleCodes = codeGenerator.createAllCodes(pegCount);

        assertThat(allPossibleCodes).containsExactlyInAnyOrder(expectedCodes.toArray(new Code[]{}));
    }

    @Parameterized.Parameters(name = "{0}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {
                        "should create codes for code length one and one peg",
                        1,
                        EnumSet.of(GREEN),
                        createCodeSet(new Code(GREEN))
                },
                {
                        "should create all codes for code length two and one peg",
                        2,
                        EnumSet.of(GREEN),
                        createCodeSet(new Code(GREEN, GREEN))
                },
                {
                        "should create all codes for code length one and two pegs",
                        1,
                        EnumSet.of(GREEN, BLUE),
                        createCodeSet(new Code(GREEN), new Code(BLUE))
                },
                {
                        "should create all codes for code length two and two pegs",
                        2,
                        EnumSet.of(GREEN, BLUE),
                        createCodeSet(
                                new Code(GREEN, GREEN),
                                new Code(GREEN, BLUE),
                                new Code(BLUE, GREEN),
                                new Code(BLUE, BLUE)
                        )
                }
        });
    }

    @NonNull
    private static HashSet<Code> createCodeSet(Code... codes) {
        return new HashSet<>(asList(codes));
    }
}
