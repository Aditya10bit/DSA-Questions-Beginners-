import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeB {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            this.left=left;
            this.right=right;
        }
    }
    static class BinaryTree{
        static int idx=-1;
        public static Node buildTree(int nodes[]){
            idx++;
            if(nodes[idx]==-1){
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left=buildTree(nodes);
            newNode.right=buildTree(nodes);
            return newNode;
        }
        public static void PreOrder(Node root){
            if(root == null){
                System.out.print("-1  ");
                return;
            }
            System.out.print(root.data+" ");
            PreOrder(root.left);//calling for the left subtree
            PreOrder(root.right);//calling for the right subtree
        }
        public static void InOrder(Node root){
            if(root==null){
                System.out.print(" -1 ");
                return ;
            }
            InOrder(root.left);
            System.out.print(root.data+ " ");
            InOrder(root.right);
        }
        public static void PostOrder(Node root){
            if(root == null){
                System.out.print(" -1 ");
                return ;
            }
            PostOrder(root.left);
            PostOrder(root.right);
            System.out.print(root.data+ "  ");
        }
        public static void LevelOrder(Node root){
            if(root==null){
                return;
            }
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);
            while(!q.isEmpty()){
                Node currNode = q.remove();//remove first element everytime until empty
                if(currNode==null){//no elements
                    System.out.println();//nextline
                    if(q.isEmpty()){
                        break;//every element is removed
                    }
                    else{
                        q.add(null);//added again for next nextline
                    }
                }
                else{//printing the first removed  element  and adding left right node simultaniously
                    System.out.print(currNode.data);//print the elements of the first  level
                    if(currNode.left!=null){
                        q.add(currNode.left);//add the left part
                    }
                    if(currNode.right!=null){
                        q.add(currNode.right);//add the right part
                    }
                }
            }
        }
        public  static int Height(Node root){
            if (root == null ){
                return 0;//no node so 0 height
            }
            int lh= Height(root.left);
            int rh= Height(root.right);
            int height=Math.max(lh,rh) + 1;
            return height;

        }
        public static int CountNodes(Node root){
            if(root == null ){
                return 0;
            }
            int lc=CountNodes(root.left);
            int rc=CountNodes(root.right);
            return (lc+rc+1);
        }
        public static  int SumofNodes(Node root){
            if(root == null){
                return 0;
            }
            int rnode=SumofNodes(root.left);
            int lnode=SumofNodes(root.right);
            return rnode+rnode+root.data;
        }
        static class Info{
            int diam;
            int ht;
            public Info(int diam,int ht){
               this.diam=diam;
               this.ht=ht;
            }
        }
        public static Info diameter(Node root){
            if(root == null){
                return new Info(0,0);
            }
            Info leftInfo =diameter(root.left);
            Info rightInfo=diameter(root.right);
            int currDiam=Math.max(Math.max(leftInfo.diam, rightInfo.diam),(leftInfo.ht+ rightInfo.ht+1));
            int ht=Math.max(leftInfo.ht, rightInfo.ht)+1;
            return  new Info(currDiam,ht);
        }

    }
    public static void main(String args[]){

        int nodes[]={1,2,4,-1,-1,5,-1,-1,3,7,-1,-1,6,-1,-1};
        BinaryTree tree = new BinaryTree();
        BinaryTree tree1 = new BinaryTree();
        Node root=tree.buildTree(nodes);
        System.out.println(root.data);
       // System.out.println(tree.diameter(root).diam);

    }
}