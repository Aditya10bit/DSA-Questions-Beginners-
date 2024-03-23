import java.util.ArrayList;

public class BST {
     static class  Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }
    public static Node Insert(Node root,int val){
        if(root==null){
            root= new Node(val);
            return root;
        }
        if(root.data>val){
            root.left=Insert(root.left,val);
        }
        else{
            root.right=Insert(root.right,val);
        }
       return root;
    }
    public static void Inorder(Node root){
         if (root==null){
             return;
         }
         Inorder(root.left);
         System.out.print(root.data +" ");
         Inorder(root.right);
    }
    public static boolean search(Node root,int key){
         if (root == null){
             return false ;
         }
         if (root.data== key){
             return true;
         }
         if(root.data>key){
             return search(root.left,key);
         }
         else{
             return search(root.right,key);
         }
    }
    public static Node Delete(Node root,int val){
         if(root.data>val){
             Delete(root.left,val);
         }
         else if (root.data<val){
             Delete(root.right,val);
         }
         //delete the node  when value found
         else{
             if(root.left == null && root.right== null){ // when no child
                 return null;
             }
             if(root.left==null){  //when  one child
                 return root.right;
             }
             else if (root.right==null){ //when one child
                 return root.left;
             }
             //when two child
             Node IS=findinorderSuq(root.right);// inorder successor// left most node in the right subtree
             root.data=IS.data;//replacing the node data  by its inorder seq data
             root.right=Delete(root.right,IS.data);//deleteing the node
         }
         return root;
    }
    public static Node findinorderSuq(Node root){
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
    public static boolean isValidBst(Node root , Node min , Node max ){
         if(root== null){
             return true;
         }
         //for right side
        if(min!=null && root.data<=min.data){
            return false;
        }
        //for left side
        if(max!=null && root.data>=max.data){
            return false;
        }
        //check for the remaining subtree
        return isValidBst(root.left,min,root)&&isValidBst(root.right,root,max);
    }
    public static void printInRange(Node root,int k1,int k2){
         if(root==null){
             return;
         }
         if(root.data>=k1 && root.data<=k2){//checking if the root is in the path for tree
             printInRange(root.left,k1,k2);
             System.out.print(root.data+ " ");
             printInRange(root.right,k1,k2);
         }
         //for subtrees
         else if(root.data<k1){
             printInRange(root.right,k1,k2);
         }
         else{
             printInRange(root.left,k1,k2);
         }
    }
    public static  void printPath(ArrayList<Integer> path){
         for(int i =0 ; i <path.size();i++){
             System.out.print(path.get(i) + "->");
         }
         System.out.println("Null");
     }
    public static void root2Leaf(Node root, ArrayList<Integer> path){
        if(root==null){
            return;
        }
        path.add(root.data);
        if(root.left==null && root.right == null){
            printPath(path);
        }
        root2Leaf(root.left,path);
        root2Leaf(root.right,path);
        path.remove(path.size()-1);//removing the last added node
    }
    public static Node createMirror(Node root){
         if(root == null ){
             return null;
         }
         Node leftMiroor=createMirror(root.left);
         Node rightMirror=createMirror(root.right);
         root.left=rightMirror;
         root.right=leftMiroor;
         return root;
    }

    public static  Node BalancedBST(int arr[],int st , int end ){
         if(st>end){
             return null;
         }
         int mid = (st+end)/2;
         Node root = new Node(arr[mid]);
         root.left = BalancedBST(arr,st,mid-1);
         root.right= BalancedBST(arr,mid+1,end);
         return root;
    }


    public static Node balancedBSTfromBST(Node root) {
        //get inorder seq
        ArrayList<Integer> inorder = new ArrayList<>();
        getInorder(root, inorder);
        //inorder to balanced bst
        root = CreateBST(inorder, 0, inorder.size() - 1);
        return root;
    }
    static class Info{
         boolean isBst;
         int size;
         int max;
         int min;

        public Info(boolean isBst, int size, int max, int min) {
            this.isBst = isBst;
            this.size = size;
            this.max = max;
            this.min = min;
        }
    }
   public  static int Maxsize=0;
      public static Info largestBst(Node root){
         if(root==null){
             return new Info (true,0,Integer.MIN_VALUE,Integer.MAX_VALUE);
         }
         Info leftInfo=largestBst(root.left);
        Info rightInfo=largestBst(root.right);
        int size= leftInfo.size+ rightInfo.size+1;
        int max=Math.max(root.data, Math.max(leftInfo.max,rightInfo.max));
        int min=Math.min(root.data,Math.min(leftInfo.min, rightInfo.min ));

        if(root.data<= leftInfo.max  || root.data>= rightInfo.min){
            return new Info(false,size,max,min);
        }
        if(leftInfo.isBst && rightInfo.isBst){
            Maxsize=Math.max(Maxsize,size);
            return new Info(true,size,max,min);
        }
        return new Info(false,size,max,min);
     }
    public  static void Preorder(Node root){
        if ( root == null){
            return ;
        }
        System.out.print(root.data + "  ->  ");
        Preorder(root.left);
        Preorder(root.right);
    }
    public static void getInorder(Node root,ArrayList<Integer>inorder){
        if(root==null){
            return ;
        }
        getInorder(root.left,inorder);
        inorder.add(root.data);
        getInorder(root.right,inorder);
    }
    public static Node CreateBST(ArrayList<Integer> inorder,int st,int end ){
        if(st>end){
            return null;
        }
        int mid = (st+end)/2;
        Node root = new Node (inorder.get(mid));
        root.left=CreateBST(inorder,st,mid-1);
        root.right=CreateBST(inorder,mid+1,end);
        return root;
    }
    public static Node mergeBst(Node root1,Node root2){
          ArrayList<Integer> arr1= new ArrayList<>();
          getInorder(root1,arr1);
         ArrayList<Integer> arr2= new ArrayList<>();
         getInorder(root2,arr2);
        //merge
        ArrayList<Integer> fin= new ArrayList<>();
        int i=0,j=0;
        while (i<arr1.size() && j<arr2.size()){
            if(arr1.get(i)<=arr2.get(j)){
                fin.add(arr1.get(i));
                i++;
            }
            else{
                fin.add(arr2.get(j));
                j++;
            }
        }
        while(i<arr1.size()){
            fin.add(arr1.get(i));
            i++;
        }
        while(j<arr2.size()){
            fin.add(arr2.get(j));
            j++;
        }
        return CreateBST(fin,0,fin.size()-1);
    }

    public static void main(String args[]){
//        int val[]={8,5,3,6,10,11,14};
//        Node root=null;
//        for(int i = 0 ; i <val.length;i++){
//            root=Insert(root,val[i]);
//        }
//         Inorder(root);
//        System.out.println();
//        createMirror(root);
//        Inorder(root);
        // printInRange(root,10,14);
        //System.out.println();
        // root2Leaf(root,new ArrayList<>());
       //  Delete(root,5);
        //Inorder(root);
       // System.out.println(search(root,3));
//        if(isValidBst(root,null,null)){
//            System.out.print("valid");
//        }
//        else{
//            System.out.print("not valid");
//        }
        //int arr[] = {3,5,6,8,10,11,12};
        //preorder ->8,5,3,6,11,10,12
       // Node root=BalancedBST(arr,0,arr.length-1);
//        Node root = new Node(50);
//        root.left=new Node(30);
//        root.left.left=new Node(5);
//        root.left.left.right=new Node(20);
//        root.right=new Node(60);
//        root.right.left=new Node(45);
//        root.right.right=new Node(70);
//        root.right.right.left=new Node(65);
//        root.right.right.right=new Node(80);
//        Info info = largestBst(root);
//        System.out.println("the largest size is "+Maxsize);
//        root=balancedBSTfromBST(root);
//        Preorder(root);

        Node root1= new Node(2);
        root1.left=new Node(1);
        root1.right= new Node(4);

        Node root2= new Node(9);
        root2.left=new Node(3);
        root2.right=new Node(12);

        Node root = mergeBst(root1,root2);//o(m+n)
        Preorder(root);


    }
}
