package logosjson;

import logosjson.lang.LogosArgument;

import java.util.List;

public class JsonLogos {
    Object head;
    Object body;

    public JsonLogos(Object head, Object body) {
        this.head = head;
        this.body = body;
    }

    public static class LogosClass {
        MainMethod mainMethod;
        StaticMethod staticMethod;

        public LogosClass(MainMethod mainMethod) {
            this.mainMethod = mainMethod;
        }
    }

    public static class MainMethod {
        List<? extends LogosArgument> args;
    }

    public static class StaticMethod {
        List<Object> args;
    }
}
