package lt.seb.productrecommendationtool.model.enums;

public enum Income {

    NONE(0, 0),
    LOW(1, 12000),
    MEDIUM(12001, 40000),
    HIGH(40000, Integer.MAX_VALUE);

    final int lowerBound;
    final int upperBound;

    Income(int lowerBound, int upperBound) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(this.lowerBound));
        if (this.upperBound == Integer.MAX_VALUE) {
            stringBuilder.append('+');
        } else if (this.lowerBound != this.upperBound) {
            stringBuilder.append('-').append(this.upperBound);
        }
        return stringBuilder.toString();
    }
}
