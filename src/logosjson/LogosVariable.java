package logosjson;

public class LogosVariable{
    String index;
    String type;
    String left;
    LogosVariable right;

    public LogosVariable(String index, String type, String left, String value) {
        this.index = index;
        this.type = type;
        this.left = left;
    }

    public LogosVariable(String index, String type, String left, String value, LogosVariable right) {
        this.index = index;
        this.type = type;
        this.left = left;
        this.right = right;
    }

    public LogosVariable(String index, String type, String value) {
        this.index = index;
        this.type = type;
    }

}
