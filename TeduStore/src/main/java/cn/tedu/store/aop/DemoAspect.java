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
//表示切面类
@Aspect
public class DemoAspect {
	/**
	 * @Before表示在业务方法之前执行
	 * bean(userServiceImpl)表示横切面的bean类为userService类
	 * userService表示Spring实例化的bean的名称
	 */
	@Before("bean(userServiceImpl)")
	public void test1(){
		System.out.println("aop的test方法");
	}
	//后置通知，即横切的方法之后执行，最终通知，不论横切的方法是否有异常都会执行
	@After("bean(userServiceImpl)")
	public void test2(){
		System.out.println("业务方法之后最终通知方法。。。");
	}
	//横切的方法不发生异常时的后置通知
	@AfterReturning("bean(userServiceImpl)")
	public void test3(){
		System.out.println("被横切的方法正常执行的后置通知。。。。。。");
	}
	//横切的方法发生异常的后置通知
	@AfterThrowing("bean(userServiceImpl)")
	public void test4(){
		System.out.println("异常通知。。。。");
	}
	/**
	 * @throws Throwable 
	 * @Around环绕通知
	 * 1.方法必须有返回值：返回值类型为被横切的方法的返回值类型
	 * 2.必须有参数
	 * 3.必须把值返回
	 */
	@Around("bean(userServiceImpl)")
	public Object test5(ProceedingJoinPoint pp) throws Throwable{
		long start = System.currentTimeMillis();
		System.out.println("环绕通知之前:");
		//表示调用横切类的方法
		Object obj = pp.proceed();
		long end = System.currentTimeMillis();
		System.out.println("环绕通知之后:"+(end-start));
		System.out.println("环绕通知的返回值："+obj);
		return obj;
	}
}
