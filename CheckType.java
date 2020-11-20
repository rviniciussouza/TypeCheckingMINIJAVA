public class CheckType implements Visitor {
    /**
     * Tabela de simbolos
     */
    private Table table;
    
    /**
     * Error para indicar se um erro foi encontrado
     */
    private ErrorMsg error;


    public boolean correctTypes(FunctionDeclaration fun) {
        table = new Table();
        error = new ErrorMsg();

        for(VariableDeclaration paramter : fun.parameterList) {
            table.put(Symbol.symbol(paramter.variableName.id), paramter.variableType);
        }

        for(VariableDeclaration var : fun.variableDeclarationList) {
            if(table.hash.containsKey(Symbol.symbol(var.variableName.id))) {
                error.complain(
                    "The variable " + var.variableName.id + " has already been declared in this scope"
                );
            }
            table.put(Symbol.symbol(var.variableName.id), var.variableType);
        }

        for(Statement statement : fun.functionBody) {
            statement.accept(this);
        }
        checkTypeReturn(fun);    
        return !error.errorFound;
    }

    public void checkTypeReturn(FunctionDeclaration fun) {
        if(!fun.returnExpression.accept(this).getClass().equals(fun.returnType.getClass())) {
            error.complain(
                "The " + fun.functionName.id + " function should return a value of type " + fun.returnType.toString()
            );
        }
    }

    public Type visit(PlusExpression expression) {
        if(!(expression.left.accept(this) instanceof TypeInt)) {
            error.complain("Left side of binary operator '+' must be of type integer");
        }
        else if(!(expression.right.accept(this) instanceof TypeInt)) {
            error.complain("Right side of binary operator '+' must be of type integer");
        }
        return new TypeInt();
    }

    public Type visit(MinusExpression expression) {
        if(!(expression.left.accept(this) instanceof TypeInt)) {
            error.complain("Left side of binary operator '-' must be of type integer");
        }
        else if(!(expression.right.accept(this) instanceof TypeInt)) {
            error.complain("Right side of binary operator '-' must be of type integer");
        }
        return new TypeInt();
    }

    public Type visit(TimesExpression expression) {
        if(!(expression.left.accept(this) instanceof TypeInt)) {
            error.complain("Left side of binary operator '*' must be of type integer");
        }
        else if(!(expression.right.accept(this) instanceof TypeInt)) {
            error.complain("Right side of binary operator '*' must be of type integer");
        }
        return new TypeInt();
    }

    public Type visit(LessExpression expression) {
        if(!(expression.left.accept(this) instanceof TypeInt)) {
            error.complain("Left side of binary operator '<' must be of type integer");
        }
        else if(!(expression.right.accept(this) instanceof TypeInt)) {
            error.complain("Right side of binary operator '<' must be of type integer");
        }
        return new TypeBoolean();
    }
    
    public Type visit(NegateExpression expression) {
        if(!(expression.exp.accept(this) instanceof TypeBoolean)) {
            error.complain("The operand of unary operator '!' must be of type boolean");
        }
        return new TypeBoolean();
    }
    
    public Type visit(AndExpression expression) {
        if(!(expression.left.accept(this) instanceof TypeBoolean)) {
            error.complain("Left side of binary operator '&&' must be of type boolean");
        }
        if(!(expression.right.accept(this) instanceof TypeBoolean)) {
            error.complain("Right side of binary operator '&&' must be of type boolean");
        }
        return new TypeBoolean();
    }

    public Type visit(OrExpression expression) {
        if(!(expression.left.accept(this) instanceof TypeBoolean)) {
            error.complain("Left side of binary operator '||' must be of type boolean");
        }
        if(!(expression.right.accept(this) instanceof TypeBoolean)) {
            error.complain("Right side of binary operator '||' must be of type boolean");
        }
        return new TypeBoolean();
    }
    
    public Type visit(VariableExpression variableExpression) {
        Type typeVar = table.get(Symbol.symbol(variableExpression.varName.id));
        if(typeVar instanceof TypeInt) {
            return new TypeInt();
        }
        return new TypeBoolean();
    }
    
    public Type visit(BooleanValueExpression booleanExpression) {
        return new TypeBoolean();
    }
    
    public Type visit(NumberDecimalExpression numberDecimalExpression) {
        return new TypeInt();
    }

    /* Statement */

    public void visit(IfStatement statement) {
        if(!(statement.condition.accept(this) instanceof TypeBoolean)) {
            error.complain("The condition of an IF statement must be of type boolean");
        }
        statement.thenStatement.accept(this);
        statement.elseStatement.accept(this);
    }

    public void visit(PrintStatement statement) {
        statement.printValue.accept(this);
    }
    
    public void visit(WhileStatement statement) {
        if(!(statement.condition.accept(this) instanceof TypeBoolean)) {
            error.complain("The condition of an While statement must be of type boolean");
        }
        statement.body.accept(this);
    }

    public void visit(AttributionStatement statement) {
        Type typeVar = table.get(Symbol.symbol(statement.leftSide.id));
        if(!statement.rightSide.accept(this).getClass().equals(typeVar.getClass())) {
            error.complain(
                "The variable " + statement.leftSide.id + " expected a value of type " + typeVar.toString()
            );
        }
    }

    public void visit(StatementList statementList) {
        for(Statement statement : statementList.statementList) {
            statement.accept(this);
        }
    }
}
