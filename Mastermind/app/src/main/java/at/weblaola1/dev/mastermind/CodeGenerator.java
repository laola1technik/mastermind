package at.weblaola1.dev.mastermind;

import android.support.annotation.NonNull;

import java.util.HashSet;
import java.util.Set;

class CodeGenerator {
    private Set<CodePegColor> colors;

    CodeGenerator(Set<CodePegColor> colors) {
        this.colors = colors;
    }

    Set<Code> createAllCodes(int codePegCount) {
        Set<Code> result = new HashSet<>();

        colors.forEach(codePegColor -> result.add(Code.fromColors(codePegColor)));

        return createCombinations(result, codePegCount);
    }

    @NonNull
    private Set<Code> createCombinations(Set<Code> result, int codePegCount) {
        if (codePegCount <= 1) {
            return result;
        }
        Set<Code> newResult = new HashSet<>();
        result.forEach(code -> {
            colors.forEach(codePegColor -> {
                Code copiedCode = Code.fromCodeAndColor(code, codePegColor);
                newResult.add(copiedCode);
            });
        });
        return createCombinations(newResult, codePegCount - 1);
    }
}
