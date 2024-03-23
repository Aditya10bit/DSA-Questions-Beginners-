public class llqueue {
    static class Node {
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;

        }
    }
    static class queue1{
        static Node head;
        static Node tail;
        public static boolean isEmpty() {
            return head == null && tail== null;
        }

        public static void add(int data) {
            Node newNode = new Node(data);
            if(head==null){
                head=tail=newNode;
                return;
            }
            tail.next=newNode;
            tail=newNode;
        }

        public static int remove() {
            if(isEmpty()){
                System.out.println("Empty queue");
                return -1;
            }
           int result = head.data;;
            if(head==tail){
               head=tail=null;
           }
           else {
               head=head.next;
           }
           return result;
        }

        public static int peek() {
            if(isEmpty()){
                System.out.println("Empty queue");
                return -1;
            }
        return head.data;
        }

    }
    public static  void main(String args[]){
        queue1 q= new queue1();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }
    }
}
