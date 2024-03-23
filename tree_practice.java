public class tree_practice {

        static class Node {
            int data;
            Node left;
            Node right;

            Node(int data) {
                this.data = data;
                this.left = null;
                this.right = null;
            }
        }
        static boolean isUnival(Node root){
            if(root == null){
                return true;//if the tree reaches null so true
            }
            //checking for times when it can be false
            if(root.left!=null && root.data!=root.left.data){
                return false;
            }
            if(root.right!=null && root.data!=root.right.data){
                return false;
            }
            return isUnival(root.left)&& isUnival(root.right);//for getting the return result of the next nodes
        }
        public static void preorder(Node root){
        if(root==null){
            return  ;
        }
        System.out.print(root.data + " -> " + " ");
        preorder(root.left);
        preorder(root.right);
        }
        public static Node mirror(Node root){
            if (root==null){
                return root;
            }
            //get the left and right nodes
            Node left=mirror(root.left);
            Node right =mirror(root.right);
            //swap the nodes
            root.left=right;
            root.right=left;
            return root;
        }
        public static  Node DeleteTarget(Node root,int x){
            if(root==null){
                return root;
            }
             root.left=DeleteTarget(root.left,x);
            root.right=DeleteTarget(root.right,x);
            if(root.data==x && root.left==null && root.right==null){
                return null;
            }
            return root;
        }
        public static void main(String args[]){
            Node root = new Node(1);
            root.left=new Node(3);
            root.right=new Node(3);
            root.left.left=new Node (3);
            root.left.right=new Node (2);
            root.right.left=new Node (3);
            root.right.right=new Node (2);
            preorder(root);
//            System.out.println();
//            mirror(root);
//            preorder(root)
//            if(isUnival(root)){
//                System.out.print("YES");
//            }
//            else{
//                System.out.print("NO");
//            }
            DeleteTarget(root,3);
            System.out.println();
            preorder(root);
        }
    }


