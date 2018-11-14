package cn.tedu.store.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
//��ʾ������
@Aspect
public class DemoAspect {
	/**
	 * @Before��ʾ��ҵ�񷽷�֮ǰִ��
	 * bean(userServiceImpl)��ʾ�������bean��ΪuserService��
	 * userService��ʾSpringʵ������bean������
	 */
	@Before("bean(userServiceImpl)")
	public void test1(){
		System.out.println("aop��test����");
	}
	//����֪ͨ�������еķ���֮��ִ�У�����֪ͨ�����ۺ��еķ����Ƿ����쳣����ִ��
	@After("bean(userServiceImpl)")
	public void test2(){
		System.out.println("ҵ�񷽷�֮������֪ͨ����������");
	}
	//���еķ����������쳣ʱ�ĺ���֪ͨ
	@AfterReturning("bean(userServiceImpl)")
	public void test3(){
		System.out.println("�����еķ�������ִ�еĺ���֪ͨ������������");
	}
	//���еķ��������쳣�ĺ���֪ͨ
	@AfterThrowing("bean(userServiceImpl)")
	public void test4(){
		System.out.println("�쳣֪ͨ��������");
	}
	/**
	 * @throws Throwable 
	 * @Around����֪ͨ
	 * 1.���������з���ֵ������ֵ����Ϊ�����еķ����ķ���ֵ����
	 * 2.�����в���
	 * 3.�����ֵ����
	 */
	@Around("bean(userServiceImpl)")
	public Object test5(ProceedingJoinPoint pp) throws Throwable{
		long start = System.currentTimeMillis();
		System.out.println("����֪֮ͨǰ:");
		//��ʾ���ú�����ķ���
		Object obj = pp.proceed();
		long end = System.currentTimeMillis();
		System.out.println("����֪֮ͨ��:"+(end-start));
		System.out.println("����֪ͨ�ķ���ֵ��"+obj);
		return obj;
	}
}
