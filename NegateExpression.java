public class NegateExpression extends Expression {
    public Expression exp;

    @Override
    public Type accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
