package com.clh.learn._2array;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.Random;

/**
 * 测试年龄用
 */
public class Test {
	public static void main(String[] args) throws Exception {

		long startTime = System.currentTimeMillis();
		final String fileName = "c:\\age1.txt";
		final Random random = new Random();
		BufferedWriter objWriter = null;
		objWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName)));
		for (int i = 0; i < 1400000000; i++) {     //执行14亿次，生成 age1.txt 文件 5.7GB
			//int age = Math.abs(random.nextInt()) % 180;  //生成一个很大的值，取余数180
			int age =random.nextInt(180)+1;  //生成一个很大的值，取余数180
			objWriter.write(age + "\r\n");
		}
		long endTime = System.currentTimeMillis();
		//  花费时间：78943       14亿数据 花费毫秒数
		System.out.println("花费时间："+(endTime-startTime));
		objWriter.flush();
		objWriter.close();

	}
}
