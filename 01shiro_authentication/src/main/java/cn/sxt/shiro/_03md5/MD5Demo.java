package cn.sxt.shiro._03md5;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;

public class MD5Demo {
	public static void main(String[] args) {
		//使用MD5加密
		Md5Hash md5=new Md5Hash("1111");
		System.out.println(md5.toString());
		//加盐
		Md5Hash md51=new Md5Hash("1111","sxt");
		System.out.println(md51.toString());
		//迭代次数
		Md5Hash md52=new Md5Hash("1111","sxt",3);
		System.out.println(md52.toString());
		
		SimpleHash hash = new SimpleHash("md5", "1111", "sxt", 3);
		System.out.println(hash.toString());
		
	}
}
