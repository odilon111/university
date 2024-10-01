package grapheQL.example.universityGrapheQL.entitiers;

public enum CreditPoint {
    FIVE(5),
    TEN(10);
    private int creditPoint;
    CreditPoint(int creditPoint) {
        this.creditPoint = creditPoint;
    }
    private int getCreditPoint(){
        return creditPoint;
    }
    public String toString(){
        return Integer.toString(creditPoint);
    }
}
