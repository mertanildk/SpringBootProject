package com.deke.testredisdbjpa.AopTest;import org.aspectj.lang.annotation.After;import org.aspectj.lang.annotation.AfterReturning;import org.aspectj.lang.annotation.Aspect;import org.aspectj.lang.annotation.Before;import org.springframework.stereotype.Component;import java.util.Date;@Aspect@Componentpublic class AopTestClass {    @Before(value = "execution(* com.deke.testredisdbjpa.serviceImp.FacilityServiceImp.testMethod2(..))&& args(name)")    public void test(String name){        if(name.equals("deke")){            throw new RuntimeException("dont run test method if name is deke");        }    }    @AfterReturning(value = "execution(* com.deke.testredisdbjpa.serviceImp.FacilityServiceImp.testMethod2(..))")    public void test2() {        System.out.println("dönüş sonrası methodu  methodu çalıştı " + new Date());    }    @After(value = "execution(* com.deke.testredisdbjpa.serviceImp.FacilityServiceImp.testMethod2(..))")    public void test4() {        System.out.println("after methodu çalıştı " + new Date());    }}