package com.itwill.willsta.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

/*
 * 메쏘드 실행시간측정 메쏘드실행전후
 */
@Component
@Aspect
public class ProfilingAroundAnnotationAdvice {
	/*
	<aop:aspect ref="profilingAroundAdvice">
			<aop:around method="aroundProfiling" 
						pointcut="execution(* *..UserDao.*(..))"/>
	</aop:aspect>
	 */
	/*
	@Pointcut("execution(* *..UserDao.*(..))") 
	private void profilingAroundAdvicePointCut() {}
	
	@Around("profilingAroundAdvicePointCut()")
	public Object aroundProfiling() throws Throwable {
		System.out.println("###[AroundAdvice(Annotation)]메쏘드호출전 필요한작업기술");
		System.out.println("###[AroundAdvice(Annotation)]메쏘드호출후 필요한작업기술");
		return null;
	}
	*/
	
	@Around(value="execution(* *..UserDao.*(..))")
	public Object aroundProfiling(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("###[AroundAdvice(Annotation)]메쏘드호출전 필요한작업기술");
		StopWatch stopWatch=new StopWatch();
		stopWatch.start();
		Object returnObject = pjp.proceed();// target객체메쏘드호출
		stopWatch.stop();
		long duration = stopWatch.getTotalTimeMillis();
		/*****************************************/
		Object targetObject = pjp.getTarget();
		String className = targetObject.getClass().getName();
		String methodName = pjp.getSignature().getName();
		Object[] argsObjects = pjp.getArgs();
		int argCount = 0;
		if (argsObjects != null) {
			argCount = argsObjects.length;
		}
		String args = "";

		for (int i = 0; i < argCount; i++) {
			String argClassName = argsObjects[i].getClass().getName();
			args += argClassName;
			if (i != argCount - 1)
				args += ",";

		}

		String profilingMsg=className+"."+methodName+"("+args+") "+ duration+" ms took";
		//if(duration > 100) {
			System.out.println("###[AroundAdvice(Annotation)]"+profilingMsg);
		//}
		/*****************************************/
		System.out.println("###[AroundAdvice(Annotation)]메쏘드호출후 필요한작업기술");
		return returnObject;
	}
}
