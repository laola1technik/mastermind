package at.weblaola1.dev.mastermind;

class CompareResult {
    private int numberOfMisplaced;
    private int numberOfWellPlaced;

    int getNumberOfMisplaced() {
        return numberOfMisplaced;
    }

    int getNumberOfWellPlaced() {
        return numberOfWellPlaced;
    }

    void increaseNumberOfMisplaced() {
        numberOfMisplaced++;
    }

    void increaseNumberOfWellPlaced() {
        numberOfWellPlaced++;
    }
}
