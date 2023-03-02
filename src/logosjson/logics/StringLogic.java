package logosjson.logics;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import logosjson.symbols.SyntaxSymbols;

import java.util.*;

public class StringLogic {

    public static final String thesis = "!";
    public static final String antithesis = "?";
    public static final String synthesis = "!!";

    public static boolean containsPair(String original, String startPattern, String endPattern) {
        return original.contains(startPattern) && original.contains(endPattern);
    }

    public static String getStringBetween(String original, String startPattern, String endPattern) {
        String start = "";
        String end = "";
        for (int i = 0; i < original.length(); i++) {
            if (original.contains(startPattern)) {
                start = original.replace(startPattern, "");
            }
            if (!start.equals("") && original.contains(endPattern)) {
                end = start.replace(endPattern, "");
            }
        }
        return end;
    }
    public static ArrayList<String> splitMulti(String pattern, HashMap<String, String> formatMap, ArrayList<String> list, String... splitKeys) {
        if (list.size() == 0 && splitKeys.length == 1) {
            if (pattern.contains(splitKeys[0])) {
                list = new ArrayList<>(Arrays.asList(pattern.split(splitKeys[0])));
                System.out.println(list);
                formatMap.put(splitKeys[0], list.get(0));
                list.remove(0);
            }
        }
        else if (pattern.contains(splitKeys[0]) && splitKeys.length == 1) {
            ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(list.get(0).split(splitKeys[0])));
            formatMap.put(splitKeys[0], arrayList.get(0));
            arrayList.remove(0);
            list = arrayList;
        }
        return list;
    }

    public static ArrayList<String> splitMulti(String pattern, String... splitKeys) {
        return new ArrayList<>();
    }

    public static List<String> splitLine(String script) {
        return Arrays.asList(script.replace("\n","").split(";"));
    }

    public static String serializeToJson(String line) {
        Gson gson = new Gson();
        HashMap<String, HashMap<String, String>> expressionMap = putIfContainsSymbols(line);
        return gson.toJson(expressionMap);
    }

    public static HashMap<String, HashMap<String, String>> putIfContainsSymbols(String line) {
        // 这个哈希表的键是变量名，值为变量里面的内容，即变量名与变量值的映射
        HashMap<String, String> varMap = new HashMap<>();

        // 把枚举变成数组
        List<SyntaxSymbols> varList = Arrays.asList(SyntaxSymbols.values());

        // 这个哈希表的键是操作符的字符串，值为上面的varMap，即运算符号与左值右值之间的映射
        HashMap<String, HashMap<String, String>> operations = new HashMap<>();
        for (int i = 0; i < line.length(); i++) {
            if (i <= line.length()-1) {
                int finalI = i;
                varList.forEach(str -> {
                    String symbol = getSymbolOrCollection(line, finalI, str.getSymbol());
                    if (symbol != null && line.split(symbol).length > 1) {
                        System.out.print(symbol + " ");
                        varMap.put(line.split(symbol)[0], line.split(symbol)[1]);
                        operations.put(symbol, varMap);
                    }
                });
            }
        }
        return operations;
    }

    /* TODO: Make the sequence of iteration correct in order to make the
        priority of execution correct.
    */
    /**
     * 获取符号或符号组合，对于每一行传入的字符串，索引
     * @param line 单行字符串
     * @param index 索引值
     * @param symbol 运算符符号
     * @return 运算符符号或运算符符号组合
     */
    public static String getSymbolOrCollection(String line, int index, String symbol) {
        if (line.contains(symbol) && index <= line.length()-2) {
            int next = index + 1;
            switch (symbol) {
                case "(":
                    return "(";
                case ":":
                    return ":";
                case "=":
                    if (hasNextSymbol(line, next, "=")) {
                        return "==";
                    } else if (hasNextSymbol(line, next, ">")) {
                        return "=>";
                    }
                    return "=";
                case "-":
                    if (hasNextSymbol(line, next, ">")) {
                        return "->";
                    }
                    return "-";
                case "|":
                    return "|";
                case "<":
                    if (hasNextSymbol(line, next, "=")) {
                        next++;
                        if (hasNextSymbol(line, next, ">")){
                            return "<=>";
                        }
                        return "<=";
                    }
                    return "<";
            }
        }
        return null;
    }

    public static HashMap<String, HashMap<String,String>> forEachInVarMap(String line, int finalI, SyntaxSymbols ss,
                                       HashMap<String,String> varMap,
                                       HashMap<String, HashMap<String,String>> operations) {

        return operations;
    }

    public static boolean hasNextSymbol(String line, int index, String symbol) {
        return Objects.equals(String.valueOf(line.charAt(index)), symbol);
    }

    public static HashMap<String, HashMap<String, String>> removeIfContains(
            HashMap<String, HashMap<String, String>> map, String[] keys) {
        for (String key : keys) {
            map.remove(key);
        }
        return map;
    }

    public static boolean hasHead(String pattern, String head) {
        String[] list = pattern.split(" ");
        return Objects.equals(list[0], head);
    }

    public static boolean hasParameter(String pattern, String head) {
        final Object b = pattern.split(" ")[1];
        if (head == null) {
            return false;
        }
        else if (pattern.split(" ").length == 0) {
            return false;
        }
        else return b != null;
    }

    public static int getDepth(String pattern) {
        return 0;
    }

    public static SyntaxTree addToSyntaxTree(String pattern, int depth, int width) {
        SyntaxTree syntax = new SyntaxTree();
        TreeNode root = new TreeNode("root", null);
        syntax.addNode(null, root);
        for (int i = 0; i < width; i++) {
            TreeNode trunk = new TreeNode(String.valueOf(i), root);
            syntax.addNode(root, trunk);
            for (int j = 0; j < depth; j++) {
                TreeNode leaf = new TreeNode(String.valueOf(j), root);
                syntax.addNode(root, leaf);
            }
        }
        return syntax;
    }

    public static JsonObject toJsonObject(String json){
        return null;
    }
}
