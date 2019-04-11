package at.weblaola1.dev.mastermind;

import android.support.annotation.NonNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static at.weblaola1.dev.mastermind.CodePegColor.BLUE;
import static at.weblaola1.dev.mastermind.CodePegColor.GREEN;
import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class CodeGeneratorTest {
    private int pegCount;
    private Set<CodePegColor> colors;
    private Set<Code> expectedCodes;

    public CodeGeneratorTest(String testName, int pegCount, Set<CodePegColor> colors, Set<Code> expectedCodes) {
        this.pegCount = pegCount;
        this.colors = colors;
        this.expectedCodes = expectedCodes;
    }

    @Test
    public void should_create_all_codes() {
        // TODO refactor toArray()
        CodeGenerator codeGenerator = new CodeGenerator(colors.toArray(new CodePegColor[]{}));

        List<Code> allPossibleCodes = codeGenerator.createAllCodes(pegCount);

        assertThat(allPossibleCodes, hasItems(expectedCodes.toArray(new Code[]{})));
    }

    @Parameterized.Parameters(name = "{0}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {
                        "should create codes for one peg and one color",
                        1,
                        EnumSet.of(GREEN),
                        createCodeSet(createCode(GREEN))
                },
                {
                        "should create all codes for two pegs and one color",
                        2,
                        EnumSet.of(GREEN),
                        createCodeSet(createCode(GREEN, GREEN))
                },
                {
                        "should create all codes for one peg and two colors",
                        1,
                        EnumSet.of(GREEN, BLUE),
                        createCodeSet(createCode(GREEN), createCode(BLUE))
                }
        });
    }

    @NonNull
    private static HashSet<Code> createCodeSet(Code... codes) {
        return new HashSet<>(asList(codes));
    }

    @NonNull
    private CodePeg blueCodePeg() {
        return new CodePeg(BLUE);
    }

    @NonNull
    private static CodePeg greenCodePeg() {
        return new CodePeg(GREEN);
    }

    private static Code createCode(CodePegColor... codePegColors) {
        ArrayList<CodePeg> codePegs = new ArrayList<>();

        for (CodePegColor codePegColor : codePegColors) {
            codePegs.add(new CodePeg(codePegColor));
        }
        return new Code(codePegs);
    }
}
