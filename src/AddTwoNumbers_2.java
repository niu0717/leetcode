public class AddTwoNumbers_2 {

    public static void main(String[] args){
        ListNode l1 = new ListNode(9);
//        l1.next = new ListNode(1);
//        l1.next.next = new ListNode(9);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(9);

        ListNode l3 = addTwoNumbers(l1, l2);
        System.out.println("======================");
        System.out.println(l3);
    }

    /**
     * my ugly method
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ln1 = l1;
        ListNode ln2 = l2;
        ListNode l3 = new ListNode(0);
        ListNode ln3 = l3;
        boolean flag = false;
        while (ln1!=null && ln2 !=null){
            if(!flag)ln3.val = ln1.val + ln2.val;
            else{
                ln3.val = ln1.val + ln2.val+1;
                flag = false;
            }
            if(ln3.val>=10){
                ln3.val = ln3.val - 10;
                flag = true;
            }
            ln1 = ln1.next;
            ln2 = ln2.next;
            if(ln1!=null || ln2!=null|| flag)ln3.next = new ListNode(0);
            ln3 = ln3.next;
        }
        if(ln1 == null && ln2 == null && flag){
            ln3.val = 1;
        }else{
            if(ln1!=null){
                addOne(ln1,ln3,flag);
            }else{
                addOne(ln2,ln3,flag);
            }
        }
        return l3;
    }
    public static ListNode addOne(ListNode l,ListNode tl,boolean flag){
        while (l != null) {
            if(!flag) tl.val = l.val;
            else{tl.val = l.val+1;flag=false;
            }
            if(tl.val>=10){
                tl.val = tl.val - 10;
                flag = true;
            }
            l = l.next;
            if(l!=null || flag)tl.next = new ListNode(0);
            tl = tl.next;
        }
        if(flag){
            tl.val = 1;
        }
        return  tl;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    @Override
    public String toString() {
        String s = val+"";
        while (next!=null){
            s +=" "+next.val;
            next = next.next;
        }
        return s;
    }
}