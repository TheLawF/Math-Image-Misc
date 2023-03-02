package logosjson.lang;

import logosjson.symbols.OperationTypes;

import java.util.UUID;

public class LogosArgument {
    String def;
    UUID uuid;
    String operator;
    public String value;

    OperationTypes operationType;

    public LogosArgument() {

    }

    public LogosArgument(String def, UUID uuid, String operator, OperationTypes operationType) {
        this.def = def;
        this.uuid = uuid;
        this.operator = operator;
        this.operationType = operationType;
    }

    public LogosArgument(UUID uuid, String operator, OperationTypes operationType) {
        this.uuid = uuid;
        this.operator = operator;
        this.operationType = operationType;
    }



    public String getDef() {
        return def;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getValue() {
        return value;
    }

    public String getOperator() {
        return operator;
    }

    public OperationTypes getOperationType() {
        return operationType;
    }
}
