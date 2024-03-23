import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Subtree {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    public static boolean isIdentical(Node node , Node subroot){
        if(node==null && subroot==null){
            return true;
        }
        else if(node==null||subroot==null||node.data!= subroot.data){
            return false;
        }
        if(!isIdentical(node.left,subroot.left)){
            return false;
        }
        if(!isIdentical(node.right,subroot.right)){
            return false;
        }
        return  true;
    }
    public static boolean isSubTree(Node root , Node subroot){
        if(root==null){
            return false;
        }
        if(root.data==subroot.data) {
            if (isIdentical(root, subroot)) {
                return true;
            }
        }
        return isSubTree(root.left,subroot)||isSubTree(root.right,subroot);
    }
    static  class Info{
        int hd;
        Node node;
        public Info(int hd , Node node){
            this.hd=hd;
            this.node=node;
        }
    }
    public static void ViewTop(Node root) {
        Queue<Info> q = new LinkedList<>();
        HashMap<Integer, Node> map = new HashMap<>();
        q.add(new Info(0, root));
        q.add(null);
        int min = 0, max = 0;
        while (!q.isEmpty()) {
            Info curr = q.remove();
            if (curr == null) {//check if the current node is null
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            }
            //if current node is not null
            else {
                if (!map.containsKey(curr.hd)) {
                    map.put(curr.hd, curr.node);//if the horizontal distance is first time
                }
                if (curr.node.left != null) {//for left part
                    q.add(new Info(curr.hd - 1, curr.node.left));
                    min = Math.min(min, curr.hd - 1);
                }
                if (curr.node.right != null) {//for right part
                    q.add(new Info(curr.hd + 1, curr.node.right));
                    max = Math.max(max, curr.hd + 1);
                }
            }
        }
        for(int i = min;i<=max;i++){
            System.out.print(map.get(i).data +" ");
        }
    }
    public static void KthLevel(Node root,int level,int k){
        if(root==null){
            return;
        }
        if(level==k){
            System.out.print(root.data+ " ");
            return;
        }
        KthLevel(root.left,level+1,k);
        KthLevel(root.right,level+1,k);
    }
    public static void KthLevel2(Node root, int k){
        if(root==null){
            return;
        }
        Queue<Node> q= new LinkedList<>();
        int level=1;
        q.add(root);
        q.add(null);
        while(!q.isEmpty()) {
            Node curr = q.remove();
            if (curr == null) {
                if (q.isEmpty()) {
                    break;
                } else {
                    level++;
                    q.add(null);
                }
            } else {
                if (level == k) {
                    System.out.print(curr.data+" ");
                }
                    if (curr.left != null) {
                        q.add(curr.left);
                    }
                    if (curr.right != null) {
                        q.add(curr.right);
                    }
            }
        }
    }
    public static boolean getPath(Node root, int n ,ArrayList<Node> path){
        if(root==null){
            return false;
        }
        path.add(root);
        if(root.data==n){
            return  true;
        }
        if(getPath(root.left,n,path) || getPath(root.right,n,path)){
            return true;
        }
        path.remove(path.size()-1);
        return false;
    }
    public static Node LowestCommonAncestor(Node root ,int n1,int n2){
        ArrayList<Node>path1=new ArrayList<>();
        ArrayList<Node>path2=new ArrayList<>();
        //get the two paths
        getPath(root,n1,path1);
        getPath(root,n2,path2);
        int i=0;
        for(; i<path1.size() & i <path2.size();i++){
            if(path1.get(i)!=path2.get(i)){
                break;
            }
        }
        Node lca= path1.get(i-1);
        return lca;
    }
    public static Node lca2(Node root,int n1,int n2){
        if(root==null ||root.data==n1 || root.data==n2){
            return root;
        }
        Node leftlca=lca2(root.left,n1,n2);
        Node rightlca=lca2(root.right,n1,n2);
        if (leftlca == null) {
            return rightlca;
        }
        if(rightlca==null){
            return leftlca;
        }
        return root;
    }
    public static int lcaDist(Node root,int n){
        if(root==null){
            return -1;
        }
        if(root.data==n){
            return 0;
        }
        int leftdist=lcaDist(root.left,n);
        int rightdist=lcaDist(root.right,n);
        if(leftdist==-1&& rightdist==-1){
            return -1;
        }
        else if(leftdist==-1){
            return rightdist+1;
        }
        else{
            return leftdist+1;
        }
    }
    public static int minDist(Node root,int n1,int n2){
        Node lca=lca2(root,n1,n2);
        int dist1=lcaDist(lca,n1);
        int dist2=lcaDist(lca,n2);
        return dist1+dist2;
    }
    public static int KthAncestor(Node root,int n,int k){
    if(root==null){
        return -1;
    }
    if(root.data==n){
        return 0;
    }
    int leftdist=KthAncestor(root.left,n,k);
    int rightdist=KthAncestor(root.right,n,k);
    if(leftdist==-1 && rightdist==-1){
        return -1;
    }
    int max= Math.max(leftdist,rightdist);
    if(max+1==k){
        System.out.print(root.data);
    }
    return max+1;
    }
      public static  int Transform(Node root){
        if(root==null){
            return 0;
        }
        int leftChild=Transform(root.left);
        int rightChild=Transform(root.right);
        int data=root.data;
        int newLeft= root.left==null?0:root.left.data;//the left node after changing
        int newright= root.right==null?0: root.right.data;//the right node after changing
        root.data=newLeft+leftChild+newright+rightChild;
        return data;//for getting the previous value
      }
      public static void preorder(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.data+ " ");
        preorder(root.left);
        preorder(root.right);
      }


    public static void main(String args[]){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left=new Node(4);
        root.left.right= new Node(5);
        root.right.left=new Node(6);
        root.right.right=new Node(7);
        //ViewTop(root);
       // KthLevel2(root,2);
//        Node subroot = new Node(2);
//        subroot.left= new Node(4);
//        subroot.right= new Node(5);
      //  System.out.println(isSubTree(root,subroot));
       // System.out.print(LowestCommonAncestor(root,6,7).data);
       // System.out.println(lca2(root,4,6).data);
       // System.out.println(minDist(root,4,6));
       // KthAncestor(root,6,1);
        Transform(root);
        preorder(root);
    }

}
