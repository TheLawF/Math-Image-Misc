package logosjson.symbols;

public enum OperationTypes {

    PARENTHESIS(0),
    BRACKET(1),
    NOT(2),
    MUL(3),
    DIVISION(4),
    PLUS(5),
    MINUS(6),
    LESS(7),
    NO_BIGGER(8),
    BIGGER(9),
    NO_LESS(10),
    INSTANCE_OF(11),
    EQUALS(12),
    NOT_EQUALS(13),
    AND(14),
    OR(15),
    DIALECTICS(16),
    IMPLICIT(17),
    EQUIVALENT(18),
    ASSIGN(19),
    COMMA(20),
    DEFINITION(21);

    final int level;

    OperationTypes(int level) {
        this.level = level;
    }

}
