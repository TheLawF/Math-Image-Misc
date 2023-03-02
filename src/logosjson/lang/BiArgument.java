package logosjson.lang;

import logosjson.symbols.OperationTypes;

import java.util.UUID;

public class BiArgument extends LogosArgument {
    LogosArgument left;
    LogosArgument right;

    public BiArgument(LogosArgument left, String value) {
        super();
        this.left = left;
        this.value = value;
    }

    public BiArgument(String def, UUID uuid,
                      String operator,
                      OperationTypes operationType,
                      LogosArgument left,
                      LogosArgument right) {
        super(def, uuid, operator, operationType);
        this.left = left;
        this.right = right;
    }

    public BiArgument(UUID uuid, String operator, OperationTypes operationType, String value) {
        super(uuid, operator, operationType);
        this.value = value;
    }

    public BiArgument(UUID uuid, String operator, OperationTypes operationType, LogosArgument left, LogosArgument right) {
        super(uuid, operator, operationType);
        this.left = left;
        this.right = right;
    }

    public BiArgument(UUID uuid, String operator, OperationTypes operationType, String value, LogosArgument left) {
        super(uuid, operator, operationType);
        this.value = value;
        this.left = left;
    }

}
