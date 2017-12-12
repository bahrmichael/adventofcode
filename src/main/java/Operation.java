public class Operation {
    private String targetRegister;
    private Byte sign;
    private Integer modifier;
    private String conditionRegister;
    private String conditionOperator;
    private Integer conditionValue;

    public Operation(final String targetRegister, final Byte sign, final Integer modifier,
            final String conditionRegister,
            final String conditionOperator, final Integer conditionValue) {
        this.targetRegister = targetRegister;
        this.sign = sign;
        this.modifier = modifier;
        this.conditionRegister = conditionRegister;
        this.conditionOperator = conditionOperator;
        this.conditionValue = conditionValue;
    }

    public String getTargetRegister() {
        return targetRegister;
    }

    public Byte getSign() {
        return sign;
    }

    public Integer getModifier() {
        return modifier;
    }

    public String getConditionRegister() {
        return conditionRegister;
    }

    public String getConditionOperator() {
        return conditionOperator;
    }

    public Integer getConditionValue() {
        return conditionValue;
    }
}
