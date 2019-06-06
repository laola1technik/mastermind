package at.weblaola1.dev.mastermind;

import android.support.annotation.NonNull;

import java.util.HashSet;
import java.util.Set;

class CodeGenerator {
    private Set<CodePegColor> colors;

    CodeGenerator(Set<CodePegColor> colors) {
        this.colors = colors;
    }

    Set<Code> createAllCodes(int codePegColorCount) {
        Set<Code> result = new HashSet<>();

        colors.forEach(codePegColor -> result.add(Code.fromColors(codePegColor)));

        return createCombinations(result, codePegColorCount);
    }

    @NonNull
    private Set<Code> createCombinations(Set<Code> result, int codePegColorCount) {
        if (codePegColorCount <= 1) {
            return result;
        }
        Set<Code> newResult = new HashSet<>();
        result.forEach(code -> {
            colors.forEach(codePegColor -> {
                Code copiedCode = Code.fromCodeAndColor(code, codePegColor);
                newResult.add(copiedCode);
            });
        });
        return createCombinations(newResult, codePegColorCount - 1);
    }
}
