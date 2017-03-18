package ex.abhi.tree;

/**
 * Created by abhishekshukla on 1/23/17.
 */
public class PrintLeftViewBinaryTree {
     int data;
     PrintLeftViewBinaryTree left, right ;

     public PrintLeftViewBinaryTree(int item){
         data = item;
         left = right = null;
     }
}

class BinaryTree{
    PrintLeftViewBinaryTree root;
    static int max_level = 0;

    void leftViewUtil(PrintLeftViewBinaryTree node , int level){
        if(node == null)
            return;
        if(max_level < level){
            System.out.print(" "+node.data);
            max_level =level;
        }

        leftViewUtil(node.left,level+1);
        leftViewUtil(node.right,level+1);
    }

    void leftView(){
        leftViewUtil(root,1);
    }

    public static void main(String [] args){
        BinaryTree tree = new BinaryTree();
        tree.root = new PrintLeftViewBinaryTree(12);
        tree.root.left = new PrintLeftViewBinaryTree(10);
        tree.root.right = new PrintLeftViewBinaryTree(30);
        tree.root.right.left = new PrintLeftViewBinaryTree(25);
        tree.root.right.right = new PrintLeftViewBinaryTree(40);
        tree.leftView();
    }
}

