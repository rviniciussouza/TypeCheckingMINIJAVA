public interface Visitor {
    
    /* Atrimetico */
    public Type visit(PlusExpression expression);
    public Type visit(MinusExpression expression);
    public Type visit(TimesExpression expression);
    
    /* Variável */
    public Type visit(VariableExpression variableExpression);

    /* DecimalExpresion, BooleanValueExpression */

    public Type visit(BooleanValueExpression booleanExpression);
    public Type visit(NumberDecimalExpression numberDecimalExpression);

    /* Operadores logico */
    public Type visit(NegateExpression expression);
    public Type visit(LessExpression expression);
    public Type visit(AndExpression expression);
    public Type visit(OrExpression expression);
    
    /* Statement */
    public void visit(IfStatement statement);
    public void visit(PrintStatement statement);
    public void visit(WhileStatement statement);
    public void visit(AttributionStatement statement);
    public void visit(StatementList statement);
}

