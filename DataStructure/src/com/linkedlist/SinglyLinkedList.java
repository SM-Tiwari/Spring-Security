package com.linkedlist;

public class SinglyLinkedList {
	
	//private NodeList head;
	
	public void display(NodeList head) {
		if(head==null) {
			return;
		}
		NodeList curr = head;
		while(curr!=null) {
			System.out.print(curr.data + " --> ");
			curr = curr.next;
		}
		System.out.println(curr);
	}
	
	public void lengthList(NodeList head) {
		if(head==null) {
			return;
		}
		int count=0;
		NodeList curr = head;
		while(curr!=null) {
			count++;
			curr = curr.next;
		}
		
		System.out.println(count);
		
	}
	
	public NodeList insertAtBeginnig(NodeList head, int data) {
		NodeList newNode = new NodeList(data);
		if(head==null) {
			return newNode;
		}
		newNode.next = head;
		head=newNode;
		return head;
		
	}
	
	private static class NodeList{
		private int data;
		private NodeList next;
		
		NodeList(int data){
			this.data = data;
			this.next = null;
		}
	}

	public static void main(String[] args) {
		
		NodeList head = new NodeList(10);
		NodeList second = new NodeList(8);
		NodeList third = new NodeList(1);
		NodeList fourth = new NodeList(11);
		head.next=second;
		second.next=third;
		third.next=fourth;
		
		SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
		singlyLinkedList.display(head);
		singlyLinkedList.lengthList(head);
		NodeList newHead = singlyLinkedList.insertAtBeginnig(head, 15);
		singlyLinkedList.display(newHead);
	}

}
