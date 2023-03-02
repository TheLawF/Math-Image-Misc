package logosjson.symbols;

/**
 * 决定着符号分隔符执行优先级的枚举
 */
public enum SyntaxSymbols {

    PARENTHESES("("),
    BACK_PARENTHESES(")"),
    BRACE("{"),
    BACK_BRACE("}"),
    EXCLAMATION("!"),
    ASTERISK("*"),
    SLASH("/"),
    PLUS("+"),
    MINUS("-"),
    OR("|"),
    AND("&"),
    GREATER(">"),
    LESS("<"),
    COMMA(","),
    AT("@"),
    COLON(":"),
    ASSIGNMENT("="),
    TILDE("~"),
    DOT("."),
    PERCENT("%"),
    CIRCUMFLEX("^"),
    SEMICOLON(";"),
    BACKSLASH("\\"),
    QUOTATION("\""),
    SHARP("#");
    // BRACKET("["),
    // BACK_BRACKET("]");
    
    final String symbol;

    SyntaxSymbols(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
