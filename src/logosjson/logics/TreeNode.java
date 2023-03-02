package logosjson.logics;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class TreeNode {

    private final TreeNode parent;
    private List<String> keys;
    public String key;
    private final HashMap<String, TreeNode> siblingsMap;
    private HashMap<String, HashMap<String, TreeNode>> childrenMap;

    private Properties properties;

    public TreeNode(@NotNull String key, @Nullable TreeNode parent) {
        if (parent == null) {
            keys.add(key);
        }
        this.parent = parent;
        this.key = key;
        siblingsMap =  new HashMap<>();
        childrenMap = new HashMap<>();
        properties = new Properties();
    }


    final public HashMap<String, HashMap<String, TreeNode>> getChildren(){
        return childrenMap;
    }

    public HashMap<String, TreeNode> getSiblings() {
        return siblingsMap;
    }

    final public TreeNode getChild(TreeNode root, String key) {
        if (!root.keys.contains(key))
            return null;

        return siblingsMap.get(key);
    }

    final public TreeNode getParent(){
        return parent;
    }

    final public void addChild(TreeNode root, TreeNode parent, TreeNode child){
        if (root.keys.contains(child.key)) {
            return;
        }
        root.keys.add(child.key);
        siblingsMap.put(child.key, child);
    }

    final public void removeChild(TreeNode root, String key){
        siblingsMap.remove(getChild(root, key));
    }

    final public boolean hasChild(){

        return siblingsMap.size() > 0;
    }

    final public int getChildrenSize(){
        return siblingsMap.size();
    }


    //the property of the Node
    final public Properties getProperties(){
        return properties;
    }



    public static class Properties {
        final static int DEFAULT_ID = -1;
        final static String STRING_ID = null;

        private int id = DEFAULT_ID;

        public void setId(int id){
            this.id = id;
        }

        public int getId(){
            return this.id;
        }

        //search property
        public boolean containsIndex(int id) {

            if (id == DEFAULT_ID) return false;

            System.out.println("this.id = " + this.id);
            System.out.println("id = " + id);
            return (id == this.id);
        }

        public boolean containsKey(String key) {
            return Objects.equals(key, STRING_ID);
        }
    }
}
