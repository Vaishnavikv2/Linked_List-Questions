package LinkedList;

import java.util.List;
import java.util.Scanner;

class ListNode{
    int data;
    ListNode next;
    ListNode(int data){
        this.data=data;
        this.next=null;
    }

}
public class RemoveNthFromTheEnd {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        ListNode head=null;
        ListNode tail=null;
        for(int i=0;i<n;i++){
            int data=sc.nextInt();
            ListNode newNode=new ListNode(data);
            if(head==null){
                head=newNode;
                tail=newNode;
            }
            else{
                tail.next=newNode;
                tail=newNode;
            }
        }
        RemoveNthFromTheEnd obj=new RemoveNthFromTheEnd();
        head=obj.removeNth(head,2);
        obj.print(head);


    }
    void print(ListNode head){
        ListNode curr=head;
        while(curr!=null){
            System.out.print(curr.data+" ");
            curr=curr.next;
        }
        System.out.println();
    }
    public ListNode removeNth(ListNode head,int n){
        ListNode slow=head;
        ListNode fast=head;
        while(n>0){
            fast=fast.next;
            n--;
        }
        if(fast==null) return head.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next;
        }
        slow.next=slow.next.next;
        return head;

    }
}
