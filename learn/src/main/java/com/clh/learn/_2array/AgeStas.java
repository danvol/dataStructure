package com.clh.learn._2array;

/**
 * 读取 年龄文件 ，14亿行 ，每行 有一个 整型的 年龄值 ，该值 大于 1 ，小于200
 * 2G，2核CPU  计算14亿数据 时间
 */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import javax.imageio.stream.FileImageInputStream;

public class AgeStas {

	public static void main(String[] args) throws Exception {
		String str = null;
		String fileName = "c:\\age1.txt";
		InputStreamReader isr = new InputStreamReader(new FileInputStream(fileName),"UTF-8");
		
		long start = System.currentTimeMillis();
		BufferedReader br = new BufferedReader(isr);
		int tot = 0 ;	//21亿
		int data [] = new int[200];
		while((str = br.readLine()) != null){		// 时间复杂度：找while 循环的地方 循环次数不确定，  一行一行的读 O(n)
			int age = Integer.valueOf(str);
		//	System.out.println(age);
			data[age] ++ ;   //data[age]=data[age]+1;   //数组元素自增运算
			tot ++ ;
		}
		//假设 cpu 处理性能在 每秒处理100万次
		//O(n) 14亿. 100万/秒 *1000 = 10亿 100~1000s之间 => 500s以下 60*8=480s
		System.out.println("总共的数据大小: " + tot);
		
		for(int i = 0 ; i < 200 ; i ++){//下标从0开始的
			System.out.println(i + ":" + data[i]);
		}
		//144239ms => 144s
		System.out.println("计算花费的时间为:" + (System.currentTimeMillis() - start) + "ms");
	}


	//写文件
	public void writeToFile(){

	}
}
