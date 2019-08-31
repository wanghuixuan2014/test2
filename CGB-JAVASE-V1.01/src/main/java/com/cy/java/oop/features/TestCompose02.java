package com.cy.java.oop.features;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
/**
  *  构建一个Cache对象:FifoCache
 * 1)存储结构:哈希表(例如可借助HashMap存储)
 * 2)算法:先进先出(FIFO):可借助LinkedList记录顺序
 */
class FifoCache{
	//has a
	private Map<String,Object> cache;
	//has a
	private LinkedList<String> orderKeys;
	/**记录最多有多少个有效元素*/
	private int maxSize;
	public FifoCache(int maxSize) {
		this.maxSize=maxSize;
	}
	public void setOrderKeys(LinkedList<String> orderKeys) {
		this.orderKeys = orderKeys;
	}
	public void setCache(Map<String, Object> cache) {
		this.cache = cache;
	}
	public void put(String key,Object value) {
		//1.记录key(永远添加在最后一个元素的后面)
		orderKeys.addLast(key);//LinkedList
		//2.移除元素(假如满了)
		if(orderKeys.size()>maxSize) {
			//2.1移除LinkedList中移除第一个元素
			String eldestKey=
					orderKeys.removeFirst();
			//2.2移除cache中的元素
			cache.remove(eldestKey);
		}
		//3.放新元素
		cache.put(key, value);
	}
	@Override
	public String toString() {
		return cache.toString();
	}
}
public class TestCompose02 {
	public static void main(String[] args) {
		FifoCache cache=new FifoCache(2);//size
		cache.setOrderKeys(new LinkedList<String>());
		cache.setCache(new HashMap<String, Object>());
		cache.put("A",100);
		cache.put("B",200);
		cache.put("C",300);
		cache.put("D",300);
		cache.put("E",300);
		PrintStream ps=System.out;
		ps.println(cache);//B,C
	}
}






