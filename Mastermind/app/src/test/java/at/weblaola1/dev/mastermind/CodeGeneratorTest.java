package at.weblaola1.dev.mastermind;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

public class CodeGeneratorTest {
    @Test
    public void should_create_codes_for_one_blue_codePeg() {
        int codePegCount = 1;
        CodeGenerator codeGenerator = new CodeGenerator(CodePegColor.BLUE);

        List<Code> allPossibleCodes = codeGenerator.createAllCodes(codePegCount);

        Code expectedCode = new Code(Collections.singletonList(new CodePeg(CodePegColor.BLUE)));
        Assert.assertThat(allPossibleCodes, CoreMatchers.hasItems(expectedCode));
    }

}
