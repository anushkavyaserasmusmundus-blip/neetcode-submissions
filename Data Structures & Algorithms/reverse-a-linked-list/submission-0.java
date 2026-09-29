/**
 * Definition for singly-linked list.
 * public class ListNode { //helper class
 *     int val; // number
 *     ListNode next; //connection
 *     ListNode() {} //constructor setup
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; } //pointers
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {


        ListNode previous = null;   
        ListNode current = head;

        while(current != null){
            ListNode next = current.next;   //next->current.next //next adress needs to be stored first

            current.next = previous;        //now currentnext is a pointer which now points backwards

            previous = current;                
            current = next;
        }
        return previous;

        
    }
}
//o(n) stack
//o(1) 3 pointer

//next is on estep forward to curretn
//store the address of next in "next" variable
//break the connect , current now points backwards to previous
// previous moves one step forward
//curretn moves one step forward

//the nodes itself dont move only the pointers move untill the current is at the last element and it becomes head and each node points backwards.