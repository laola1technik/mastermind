package at.weblaola1.dev.mastermind;

class CompareResult {
    private int numberOfMisplaced;
    private int numberOfWellPlaced;

    void setNumberOfMisplaced(int number) {
        numberOfMisplaced = number;
    }

    int getNumberOfMisplaced() {
        return numberOfMisplaced;
    }

    int getNumberOfWellPlaced() {
        return numberOfWellPlaced;
    }

    void increaseNumberOfWellPlaced() {
        numberOfWellPlaced++;
    }
}
