package at.weblaola1.dev.mastermind;

import android.support.annotation.NonNull;

import java.util.HashSet;
import java.util.Set;

class CodeGenerator {
    private Set<CodePeg> pegs;

    CodeGenerator(Set<CodePeg> pegs) {
        this.pegs = pegs;
    }

    Set<Code> createAllCodes(int codePegCount) {
        Set<Code> result = new HashSet<>();

        pegs.forEach(codePeg -> result.add(new Code(codePeg)));

        return createCombinations(result, codePegCount);
    }

    @NonNull
    private Set<Code> createCombinations(Set<Code> result, int codePegCount) {
        if (codePegCount <= 1) {
            return result;
        }
        Set<Code> newResult = new HashSet<>();
        result.forEach(code -> pegs.forEach(codePeg -> {
            Code copiedCode = Code.fromCodeAndPeg(code, codePeg);
            newResult.add(copiedCode);
        }));
        return createCombinations(newResult, codePegCount - 1);
    }

    Code createTwoPairs() {
        CodePeg[] pegsArray = pegs.toArray(new CodePeg[]{});
        if (pegsArray.length < 2) {
            throw new RuntimeException("No Pegs provided ");
        }
        return new Code(pegsArray[0], pegsArray[0], pegsArray[1], pegsArray[1]);
    }
}
