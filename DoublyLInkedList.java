public class DoublyLInkedList {
    public class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
        public static Node head;
        public static Node tail;
        public  static int size;

        public void addFirst(int data){
            Node newNode= new Node(data);
            size++;
            if(head==null){
                head=tail=newNode;
                return;
            }
            newNode.next=head;
            head.prev=newNode;
            head=newNode;
        }
        public void addLast(int data){
            Node newNode= new Node(data);
            size++;
            if(head==null){
                head = tail = newNode;
                return;
            }
            tail.next=newNode;
            newNode.prev=tail;
            tail= newNode;
        }
        public  int  removeFirst(){
            if(head==null){
                System.out.println("ll is empty");
                return Integer.MIN_VALUE;
            }
            if( size ==1 ){
                int val = head.data;
                head=tail= null;
                size=0;
                return val;
            }
            int val = head.data;
             head=head.next;
            head.prev=null;
            size--;
            return val;
        }
        public int removeLast() {
            if (head == null) {
                System.out.println("ll is empty");
                return Integer.MIN_VALUE;
            }
            if (size == 1) {
                int val = head.data;
                head = tail = null;
                size = 0;
                return val;
            }

            int val = tail.data;
            tail=tail.prev;
            tail.next=null;
            size--;
            return  val;


        }
        public void print(){
            Node temp = head;
            while(temp!=null){
                System.out.print(temp.data+ "->");
                temp=temp.next;
            }
            System.out.println("null");
        }
        public void reverse(){
            Node curr = head;
            Node previous = null;
            Node next;
            while(curr!= null){
                next = curr .next;
                curr.next = previous ;
                 curr.prev = next;
                 previous= curr;
                 curr = next;
            }
            head = previous;
        }
        public static  void  main(String args[]){
            DoublyLInkedList dll = new DoublyLInkedList();
            dll.addLast(3);
            dll.addLast(2);
            dll.addLast(1);
            dll.print();
            dll.reverse();
            dll.print();

        }


    }

