public class linkedlist{
    public static class Node{
        int data;
        Node next;
        //parameterized constructor to assign the node with data and point the next initially to null
        public Node(int data){
            this.data= data;
            this.next= null;
        }
    }
    public static Node Head;//start
    public static Node Tail;//end
    public static int size;//for size;
    //adding
    public void addFirst(int data){
        //creating a newNode
        Node newNode = new Node(data);
        //if empty
        size++;
        if(Head==null){
            Head=Tail=newNode;
            return;
        }
        //newNode's next = head
        newNode.next=Head;
        //make it as new head
        Head=newNode;
    }
    public void addLast(int data){
        //creating a node
        Node newNode = new Node(data);
        //if empty
        size++;
        if(Head== null){
            Head=Tail=newNode;
            return;
        }
        //newNode.next = tail
        Tail.next=newNode;
        //make it tail
        Tail=newNode;
    }
    public void print(){
        if(Head==null){
            System.out.println("LIST IS EMPTY");
            return;
        }
        Node temp = Head; //temp pointing to next
        while(temp!=null){
            System.out.print(temp.data+ "-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
    public void add(int idx,int data){
        //if we want to change the head
        if(idx==0){
            addFirst(data);
            return;
        }
        //create a node
        Node newNode= new Node(data);
        size++;
        Node temp = Head;
        int i =0;
        while(i<idx-1){
            temp=temp.next;
            i++;
        }
        newNode.next=temp.next;
        temp.next = newNode;
    }
    public int removeFirst(){
        if(size==0){
            System.out.println("linked list is empty");
            return Integer.MIN_VALUE;
        }
        else if(size==1){
            int val = Head.data;
            Head=Tail=null;
            size=0;
            return val;
        }
        else{
            int val = Head.data;
            Head=Head.next;
            size--;
            return val;
        }
    }
    public int removeLast(){
        if(size==0){
            System.out.println("Linked list is empty");
            return Integer.MIN_VALUE;
        }
        else if(size==1){
            int val= Head.data;
            Head=Tail=null;
            size=0;
            return val;
        }
        else{
            Node prev=Head;
            int i =0;
            while(i<size-2){
                prev=prev.next;
                i++;
            }
            int val=prev.next.data;
            prev.next=null;
            Tail=prev;
            size--;
            return val;
        }
    }
    public int search(int key){
        Node temp = Head;
        int i =0;
        while(temp.next!=null){
            if(temp.data==key){
                return i ;
            }
            temp=temp.next ;
            i++;
        }
        return -1;
    }
    public  int helper(Node Head,int key){
        if(Head==null){
            return -1;
        }
         if(Head.data== key){
             return 0;
         }
         int idx= helper(Head.next,key);
         if(idx==-1){
             return -1;
         }
         return idx+1;
    }
    public  int recSearch(int key){

        return helper(Head,key);
    }
    public void reverse(){
        Node prev = null;
        Node curr= Tail = Head;
        Node next;
        while (curr!=null){
            next = curr.next;
            curr.next = prev ;
            prev= curr;
            curr= next;
        }
        Head= prev;
    }
    public void delfromlast(int n){
        Node temp = Head;
        int sz=0;
        while(temp!=null){
            temp = temp.next;
            sz++;
        }
        if(n==sz){
            Head=Head.next;
            return;
        }
        int i = 1;
        int idxtoFind= sz-n;//just the previous of idx to del
        Node prev = Head;
         while (i<idxtoFind){
             prev=prev.next;
             i++;
         }
        prev.next = prev.next.next;
    }
    private Node Middle(Node Head){
        Node slow = Head;
        Node fast = Head;
        while( fast != null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public boolean palindrome(){
        if(Head==null || Head.next==null){
            return true;
        }
        //find mid
        Node mid = Middle(Head);
        //reverse 2nd half
        Node curr=mid;
        Node prev = null;
        while(curr!=null){
            Node next = curr.next; //next node is directed towards current .next
            curr.next = prev;//current.next points to previous
            prev = curr;//previous has current value
            curr= next;//current has next value
        }
        Node right = prev ;//right side head
        Node left = Head;//left side head;
        //check if equal
        while(right!=null){
            if(left.data!= right.data){
                return false;
            }
            left = left.next;
            right=right.next;
        }
        return true;
    }
    //flloyds cycle
    public static boolean isCycle(){
        Node slow=Head;
        Node fast =Head;
        while(fast !=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                return true;
            }
        }
        return false;
    }
    public static void  cycleRemove(){
        Node slow=Head;
        Node fast =Head;
        boolean cycle = false;
        while(fast !=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                cycle =true ;
                break;
            }
        }
       if(cycle ==false){
           return ;
       }
       slow=Head;
       Node prev = null;
       while(slow!=fast){
           prev=fast;
           slow=slow.next;
           fast=fast.next;
       }
       prev.next =null;//directing it to null
    }
    public Node getMid(Node Head){
        Node slow= Head;
        Node fast = Head.next;
        while(fast != null && fast.next !=null){
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
    }
    public Node merge( Node head1,Node head2){
        Node mergedLL = new Node (-1);
        Node temp = mergedLL;
        while(head1!=null && head2!=null){
            if(head1.data<=head2.data){
                temp.next =head1;
                head1=head1.next;
                temp = temp.next;
            }
            else{
                temp.next =head2;
                head2=head2.next;
                temp = temp.next;
            }
            while(head1!=null){
                temp.next =head1;
                head1=head1.next;
                temp = temp.next;
            }
            while(head2!=null){
                temp.next =head2;
                head2=head2.next;
                temp = temp.next;
            }
        }
        return mergedLL.next;
    }

    public Node mergeSort(Node Head){
        if (Head== null ||Head.next==null){
            return Head;
        }
        //find mid
        Node mid = getMid(Head);
        //mergesort
        Node rightHead = mid.next;
        mid.next = null;
        Node left =  mergeSort(Head);
       Node right =  mergeSort(rightHead);
       //merge
        return merge(left,right);
    }
    public void ZigZag(){
        //get mid
        Node slow=Head;
        Node fast = Head.next;
        while (fast != null  && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        Node mid = slow;
        //reverse 2nd half
        Node curr= mid.next;
        mid.next=null;
        Node prev = null;
        Node next;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node lefthead= Head;
        Node righthead= prev;
        Node nextL;
        Node nextR;
        //alt.merge;
        while(lefthead!=null && righthead!=null){
            nextL=lefthead.next;
            lefthead.next=righthead;
            nextR=righthead.next;
            righthead.next=nextL;

            lefthead=nextL;
            righthead=nextR;
        }

    }



    public static void main(String args[]){
        linkedlist ll = new linkedlist();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.addLast(8);
        ll.print();

       // ll.ZigZag();
      //  ll.print();
       /* Head= new Node(1);
        Node temp= new Node(2);
        Head.next= temp;
        Head.next.next=new Node(3);
        Head.next.next.next = temp;
      //  1-2-3-3;
        System.out.println(isCycle());
        cycleRemove();
        System.out.println(isCycle());


        ll.addFirst(1);
        ll.addLast(2);
        ll.addLast(1);
        ll.print();
        System.out.println( ll.palindrome());

      //  ll.palindrome();
      //  ll.add(4,5);
        // System.out.println(ll.recSearch(4));
        // System.out.println(ll.size);
        //ll.reverse();
       // ll.print();
       // ll.delfromlast(4);
     //   ll.print();
        //ll.removeFirst();
        //ll.print();
        //ll.removeLast();
        //ll.print();
        //System.out.println(ll.search(3));
        //System.out.println(ll.size);
*/
    }
}

