package at.weblaola1.dev.mastermind;

import android.support.annotation.NonNull;

import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static at.weblaola1.dev.mastermind.CodePegColor.BLUE;
import static at.weblaola1.dev.mastermind.CodePegColor.GREEN;
import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.assertThat;

public class CodeGeneratorTest {
    @Test
    public void should_create_codes_for_one_blue_codePeg() {
        int codePegCount = 1;
        CodeGenerator codeGenerator = new CodeGenerator(BLUE);

        List<Code> allPossibleCodes = codeGenerator.createAllCodes(codePegCount);

        Code expectedCode = new Code(Collections.singletonList(blueCodePeg()));
        assertThat(allPossibleCodes, hasItems(expectedCode));
    }

    @Test
    public void should_create_codes_for_two_green_codePegs() {
        int codePegCount = 2;
        CodeGenerator codeGenerator = new CodeGenerator(GREEN);

        List<Code> allPossibleCodes = codeGenerator.createAllCodes(codePegCount);

        Code expectedCode = new Code(asList(
                greenCodePeg(),
                greenCodePeg()
        ));
        assertThat(allPossibleCodes, hasItems(expectedCode));
    }

    @NonNull
    private CodePeg blueCodePeg() {
        return new CodePeg(BLUE);
    }

    @NonNull
    private CodePeg greenCodePeg() {
        return new CodePeg(GREEN);
    }
}
