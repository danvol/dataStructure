package com.clh.learn._4stack;

public interface MyStack<Item> {

	MyStack<Item> push(Item item);		//入栈
	
	Item pop();	//出栈
	
	int size();		// 大小
	
	boolean isEmpty();
}
