package cn.rock.y2020.m05.d27;

import java.util.List;

/**
 *
 * @author wjl48511
 * @create 2020/5/27-18:58
 **/
public class Solution21 {
    /**
     * 21. 合并两个有序链表
     * 将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 

     示例：

     输入：1->2->4, 1->3->4
     输出：1->1->2->3->4->4

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
     public static class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
    }
    public ListNode insert(ListNode l1,ListNode node){
        ListNode iNode = l1;
        ListNode temp1 = null;
        ListNode temp2 = null;
         while (null != iNode.next){
             if (node.val >= iNode.val && iNode.next.val > node.val){
                //执行插入
                 temp1 = iNode.next;
                 iNode.next = node;
                 temp2 = node.next;
                 node.next = temp1;
                 return temp2;
             }
             iNode  = iNode.next;
         }
         iNode.next = node;
         //返回插入节点的位置, 如果返回null 则 代表已完成。
         return  null;
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
         if (null == l1 || null ==l2){
             return l1 == null ? l2: l1;
         }

         if (l1.val > l2.val){
             ListNode temp = l2;
             l2 = l1;
             l1 = temp;
         }
         while(null != l2){
             l2 = insert(l1, l2);
         }
        return l1;
    }

    public static void main(String []args){
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(4);
        ListNode l4 = new ListNode(1);
        ListNode l5 = new ListNode(3);
        ListNode l6 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l4.next = l5;
        l5.next = l6;
        Solution21 solution21 = new Solution21();
        solution21.mergeTwoLists(l1,l4);

    }
}
