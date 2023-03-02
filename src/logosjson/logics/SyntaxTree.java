package logosjson.logics;

import org.jetbrains.annotations.Nullable;

import java.util.Iterator;

public class SyntaxTree{

    TreeNode root = null;

    public void addNode(@Nullable TreeNode parent, TreeNode child){
        //增加根节点
        if(parent == null && !hasRoot()){
            this.root = child;
        }
        else if (parent != null){
            parent.addChild(root, parent, child);
        }
    }

    public TreeNode getRoot(){
        return root;
    }

    public boolean hasRoot(){
        return this.root == null;
    }

    private class TreeIterator implements Iterator<TreeNode> {
        private String parentKey;
        private String key;
        private Integer cursor;

        @Override
        public boolean hasNext() {
            return cursor < root.getChildrenSize();
        }

        @Override
        public TreeNode next() {
            return root.getChildren().get(parentKey).get(key);
        }
    }
}
