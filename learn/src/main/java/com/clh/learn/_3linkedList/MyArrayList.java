package com.clh.learn._3linkedList;


public class MyArrayList<E> implements MyList<E> {

	private static final int DEFAULT_SIZE = 10;  //默认数组大小
	private Object data[];
	private int index; //有效元素的下标
	private int size;   //数组总大小

	public MyArrayList() {
		this.data = new Object[DEFAULT_SIZE];
		this.size = DEFAULT_SIZE;
	}

	/**
	 * 新增元素
	 * 判断是否需要扩容，不需要直接添加；扩容 用新的数组，将旧数组 逐一替换
	 * 插入尾部。
	 * 如果是插入中间位置，会复杂点，往后平移
	 * @param e
	 */
	@Override
	public void add(E e) {
		data[index++] = e;  // index++  等价于  this.index++   ;默认是 this 对象的，如果  add(int index)  则需要区分 this.index= index 前者是 this的成员变量，后者是 方法的局部变量
		if (index == size) { // 扩容:经历了++运算后等于size 大小，说明该扩容了
			this.size = this.size * 2 + 1;
			Object newData[] = new Object[this.size];
			for (int i = 0; i < data.length; i++) {                     //循环复制copy 过去
				newData[i] = data[i];
			}
			this.data = newData;
		}
	}

	/**
	 * 根据下标移除元素
	 * 从下标位置 ，逐个将后面的元素向前平移
	 * @param i
	 */
	@Override
	public void remove(int i) {
		if (i >= 0 && i < index) {
			for (int j = i; j < this.data.length - 1; j++) {
				data[j] = data[j + 1];
			}
			this.index--;
		}
	}

	@Override
	public E get(int i) {
		if (i >= 0 && i < index) {
			return (E) this.data[i];
		}
		return null;
	}

	@Override
	public int size() {
		return index;
	}

	@Override
	public boolean isEmpty() {
		if(index <= 0) return true;
		return false;
	}

	/**
	 * 根据对象地址移除元素
	 * @param e
	 */
	@Override
	public void remove(Object e) {
		if(!isEmpty()) {
			for(int i = 0 ; i < this.data.length ; i ++) {
				if(data[i].equals(e)) {
					remove(i);
					break;
				}
			}
		}
	}

	public static void main(String[] args) {
		MyArrayList<Integer> list = new MyArrayList<>();
		list.add(1);
		list.add(5);
		list.add(4);
		System.out.println(list.size());
		System.out.println(list.isEmpty());
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		Integer integer = new Integer(5);
		list.remove(integer);
		System.out.println(list.get(1));
	}
	
}
