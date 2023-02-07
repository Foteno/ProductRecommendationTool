package lt.seb.productrecommendationtool.model.enums;

public enum Age {

    TEEN(0, 17),
    ADULT(18, 64),
    SENIOR(65, Integer.MAX_VALUE);

    final int lowerBound;
    final int upperBound;

    Age(int lowerBound, int upperBound) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(this.lowerBound));
        if (this.upperBound == Integer.MAX_VALUE) {
            stringBuilder.append('+');
        } else {
            stringBuilder.append('-').append(this.upperBound);
        }
        return stringBuilder.toString();
    }
}
