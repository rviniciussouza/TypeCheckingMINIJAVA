public class NumberDecimalExpression extends Expression {
    public NumberDecimal value;

    @Override
    public Type accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
