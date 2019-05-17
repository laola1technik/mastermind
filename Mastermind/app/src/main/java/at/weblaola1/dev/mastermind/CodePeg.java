package at.weblaola1.dev.mastermind;

import android.support.annotation.NonNull;

import java.util.Objects;

class CodePeg {
    private CodePegColor type;

    CodePeg(CodePegColor type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof CodePeg) {
            return type == ((CodePeg) obj).type;
        }
        return false;
    }

    CodePegColor getType() {
        return type;
    }

    @NonNull
    @Override
    public String toString() {
        return type.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(type);
    }
}
