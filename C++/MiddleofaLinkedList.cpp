#include <iostream>
using namespace std;
struct ListNode{
    int val;
    ListNode *next;
    ListNode(int x):val(x),next(NULL){}

};
ListNode* middleNode(ListNode* head){
    ListNode* slow=head;
        ListNode* fast=head;
        while(fast!=NULL && fast->next!=NULL){
            slow=slow->next;
            fast=fast->next->next;

        }
        return slow;
}
ListNode* createLinkedList(){
    cout<< "Enter the number of elements:";
    int n;
    cin>>n;

    ListNode* head=NULL;
    ListNode* tail=NULL;
    cout<<"Enter the elements :\n";
    for(int i=0;i<n;i++){
        int value;
        cin>>value;
        ListNode* newNode=new ListNode(value);
        if(head==NULL){
            head=newNode;
            tail=newNode;
        }
        else{
            tail->next=newNode;
            tail=newNode;
        }
    }
    return head;
}
void printLinkedList(ListNode* head){
    cout<<"Linked List: ";
    while(head!=NULL){
        cout<<head->val<<" ";
        head=head->next;
    }
    cout<<endl;
}
int main(){
    ListNode* head=createLinkedList();
    printLinkedList(head);
    ListNode* middle=middleNode(head);
    cout<<"Middle Node:"<<middle->val<<endl;
    return 0;

}