/**   
 * Copyright © 神州租车. All rights reserved.
 * 
 * @Title: Test01.java 
 * @Project: Learning
 * @Package: com.xandy.test01 
 * @Description: TODO
 * @author: liang.xu01@ucarinc.com  
 * @date: 2017年7月3日 上午9:36:06 
 * @version: V1.0   
 */
package com.xandy.test01;

/**
 * @author xuliang04@zuche.com
 * @version 
 * @since 2017年7月3日
 */
public class Test01 {
	public static void main(String[] args) {
		
		
		System.out.println(Integer.toHexString(10));
	}
	
}

class Single01{
	public static Single01 SINGLE = new Single01();
	
	private Single01(){
		
	}
	
	public void saySingle(){
		System.out.println("first kind single");
	}
	
	public static void main(String[] args) {
		Single01 single01 = Single01.SINGLE;
		single01.saySingle();
	}
	
}


class Single02{
	private static Single02 SINGLE;
	
	private Single02(){
		
	}
	
	public static Single02 getSingle(){
		if(SINGLE == null){
			SINGLE = new Single02();
		}
		return SINGLE;
	}
	
	public void saySingle(){
		System.out.println("second kind single");
	}
	public static void main(String[] args) {
		Single02 single02 = Single02.getSingle();
		
		
		System.out.println(Integer.toBinaryString(10));
	}
}


