package logosjson;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;
import logosjson.lang.BiArgument;
import logosjson.lang.LogosArgument;
import logosjson.lang.LogosLogger;
import logosjson.symbols.OperationTypes;

import java.io.*;
import java.util.Objects;
import java.util.UUID;

public class TestMisc {
    @SuppressWarnings("deprecation")
    public static void main(String[] args) throws IOException {
        String line;
        StringBuilder json = new StringBuilder();
        BufferedReader reader = new BufferedReader(new FileReader(
                Objects.requireNonNull(TestMisc.class.getResource(
                        "logos_test.json")).getFile()));
        while ((line = reader.readLine()) != null) {
            json.append(line).append("\n");
        }
        JsonReader jsonReader = new JsonReader(reader);
        Gson gson = new Gson();

        JsonLogos logos = gson.fromJson(jsonReader, JsonLogos.class);
        JsonLogos.LogosClass main = gson.fromJson(gson.toJson(logos, JsonLogos.class),
                JsonLogos.LogosClass.class);

        LogosArgument assignLeft = new LogosArgument("A", UUID.randomUUID(),
                "=>", OperationTypes.IMPLICIT);
        BiArgument assignArg = new BiArgument(assignLeft, "12345");

        LogosLogger logosLogger = new LogosLogger();
        System.out.println(gson.toJson(assignArg, BiArgument.class));
        logosLogger.execute(assignArg);
        // JsonElement element = ;
        // JsonObject object = element.getAsJsonObject();
//
        // Set<Map.Entry<String, JsonElement>> argSet = object.entrySet();
        // for (Map.Entry<String, JsonElement> entry : argSet) {
        //     System.out.println(entry.getValue());
        // }
    }
}
