package logosjson.lang;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

public class LogosLogger extends SingleArgument implements ILogosExecutor{
    @Override
    public void execute(LogosArgument argumentIn) {
        System.out.println(argumentIn.getValue());
    }
}
