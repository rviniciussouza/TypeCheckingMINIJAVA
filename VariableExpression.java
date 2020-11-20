public class VariableExpression extends Expression {
    public ID varName;

    @Override
    public Type accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
