package generator;

public enum Operator {
    GT(">"),
    GTEQ(">="),
    L("<"),
    LEQ("<="),
    EQ("="),
    NEQ("!=");

    private String operatorString;

    Operator(String operatorString) {
        this.operatorString = operatorString;
    }

    public String getOperatorString() {
        return operatorString;
    }

    public String getOperatorName() {
        switch (operatorString) {
            case ">": {
                return "GT";
            }
            case ">=": {
                return "GTEQ";
            }
            case "<": {
                return "L";
            }
            case "<=": {
                return "LEQ";
            }
            case "=": {
                return "EQ";
            }
            case "!=": {
                return "NEQ";
            }
            default: {
                return null;
            }
        }
    }
}
