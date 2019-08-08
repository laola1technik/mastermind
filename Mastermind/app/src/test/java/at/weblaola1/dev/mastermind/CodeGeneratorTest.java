package at.weblaola1.dev.mastermind;

import android.support.annotation.NonNull;

import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static at.weblaola1.dev.mastermind.CodePeg.BLUE;
import static at.weblaola1.dev.mastermind.CodePeg.GREEN;
import static at.weblaola1.dev.mastermind.CodePeg.RED;
import static java.util.Arrays.asList;
import static junit.framework.TestCase.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertNotEquals;

@RunWith(Enclosed.class)
public class CodeGeneratorTest {

    @RunWith(Parameterized.class)
    public static class CodeGeneratorParameterizedTests {
        private int pegCount;
        private Set<CodePeg> pegs;
        private Set<Code> expectedCodes;

        public CodeGeneratorParameterizedTests(
                @SuppressWarnings("unused") String testName,
                int pegCount,
                Set<CodePeg> pegs,
                Set<Code> expectedCodes
        ) {
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
                            createCodes(new Code(GREEN))
                    },
                    {
                            "should create all codes for code length two and one peg",
                            2,
                            EnumSet.of(GREEN),
                            createCodes(new Code(GREEN, GREEN))
                    },
                    {
                            "should create all codes for code length one and two pegs",
                            1,
                            EnumSet.of(GREEN, BLUE),
                            createCodes(new Code(GREEN), new Code(BLUE))
                    },
                    {
                            "should create all codes for code length two and two pegs",
                            2,
                            EnumSet.of(GREEN, BLUE),
                            createCodes(
                                    new Code(GREEN, GREEN),
                                    new Code(GREEN, BLUE),
                                    new Code(BLUE, GREEN),
                                    new Code(BLUE, BLUE)
                            )
                    }
            });
        }

        @NonNull
        private static HashSet<Code> createCodes(Code... codes) {
            return new HashSet<>(asList(codes));
        }
    }

    public static class CodeGeneratorTests {
        @Test
        public void should_generate_1296_different_codes_for_code_length_4_and_6_pegs() {
            HashSet<CodePeg> pegTypes = new HashSet<>(asList(CodePeg.values()));
            CodeGenerator codeGenerator = new CodeGenerator(pegTypes);

            Set<Code> generatedCodes = codeGenerator.createAllCodes(4);

            Assert.assertEquals(1296, generatedCodes.size());
        }

        @Test
        public void should_generate_code_with_two_pairs() {
            HashSet<CodePeg> pegTypes = new HashSet<>(asList(CodePeg.values()));
            CodeGenerator codeGenerator = new CodeGenerator(pegTypes);

            Code codeOfTwoPairs = codeGenerator.createTwoPairs();

            assertCodeConsistsOfTwoPairs(codeOfTwoPairs);
        }

        @Test
        public void should_generate_codes_with_two_pairs_red_green() {
            HashSet<CodePeg> pegTypes = new HashSet<>(asList(RED, GREEN));
            CodeGenerator codeGenerator = new CodeGenerator(pegTypes);

            Code codeOfTwoPairs = codeGenerator.createTwoPairs();

            assertPairColors(codeOfTwoPairs, RED, GREEN);
            assertCodeConsistsOfTwoPairs(codeOfTwoPairs);
        }

        private void assertPairColors(Code codeOfTwoPairs, CodePeg firstPair, CodePeg secondPair) {
            long amountFirst = codeOfTwoPairs.getPegs().stream().filter(peg -> peg == firstPair).count();
            long amountSecond = codeOfTwoPairs.getPegs().stream().filter(peg -> peg == secondPair).count();
            assertNotEquals(0, amountSecond);
            assertEquals(amountFirst, amountSecond);
        }

        @Test
        public void should_generate_random_code() {
            HashSet<CodePeg> codePegs = new HashSet<>(Arrays.asList(CodePeg.values()));
            CodeGenerator codeGenerator = new CodeGenerator(codePegs);

            Set<Code> codes = new HashSet<>(asList(
                    codeGenerator.createRandomCode(4),
                    codeGenerator.createRandomCode(4),
                    codeGenerator.createRandomCode(4)
            ));

            Assert.assertThat(codes.size(), greaterThan(1));
        }

        private void assertCodeConsistsOfTwoPairs(Code codeOfTwoPairs) {
            List<CodePeg> codePegs = codeOfTwoPairs.getPegs();
            Assert.assertEquals(codePegs.get(0), codePegs.get(1));
            Assert.assertEquals(codePegs.get(2), codePegs.get(3));
            assertNotEquals(codePegs.get(1), codePegs.get(2));
            Assert.assertEquals(4, codePegs.size());
        }


    }
}