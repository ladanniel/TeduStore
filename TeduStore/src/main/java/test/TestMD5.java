package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

public class TestMD5 {
	@Test
	public void testString(){
		String str1 = "123456";
		String str2 = "123456";
		String md5Str1 = DigestUtils.md5Hex(str1);
		String md = DigestUtils.md5Hex(str2);
		System.out.println("第一个:"+md5Str1);
		System.out.println("第二个："+md);
	}
	@Test
	public void testFile() throws Exception{
		String md = DigestUtils.md5Hex(new FileInputStream("pom.xml"));
		String m = DigestUtils.md5Hex(new FileInputStream("pom2.xml"));
		System.out.println("第一个："+md);
		System.out.println("第二个："+m);
	}
	@Test
	public void testSalt(){
		String str = "123456";
		String salt = "ndsadoiasdoiasweq";
		System.out.println("不加盐："+DigestUtils.md5Hex(str));
		System.out.println("加盐："+DigestUtils.md5Hex(str+salt));
	}
}
