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

    void increaseNumberOfWellPlaced() {
        numberOfWellPlaced++;
    }

    void setNumberOfMisplaced(int numberOfMisplaced) {
      this.numberOfMisplaced = numberOfMisplaced;
    }
}
