package com.rd.epam.autotasks.scopes;

import com.rd.epam.autotasks.scopes.config.thread.ThreadScopeConfig;
import com.rd.epam.autotasks.scopes.config.threetimes.ThreeTimesScopeConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ThreadScopeConfig.class);
        final Object[] beans = Stream.generate(() -> context.getBean("threadBean1"))
                .limit(10)
                .toArray(Object[]::new);

        for (Object bean : beans) {
            System.out.println(beans[0]);
        }

        ConcurrentHashMap<Thread, Object> threadToBeans = new ConcurrentHashMap<>();

        final List<Thread> beanThreads = IntStream.range(0, 10)
                .mapToObj(i -> new Thread(
                        () -> threadToBeans.put(
                                Thread.currentThread(),
                                context.getBean("threadBean1"))))
                .collect(toList());

        for (Thread thread : beanThreads) {
            thread.start();
            System.out.println(thread);
        }
        for (Thread thread : beanThreads) {
            thread.join();
            System.out.println(thread);
        }
//
//        final Object[] concurrentBeans = threadToBeans.values().toArray();
//        for (int i = 0; i < concurrentBeans.length; i++) {
//            for (int j = 0; j < concurrentBeans.length; j++) {
//                if (i != j) {
//                    assertNotSame(concurrentBeans[i], concurrentBeans[j]);
//                }
//            }
//        }



        // ============================================= 1 part
//        AnnotationConfigApplicationContext context1 = new AnnotationConfigApplicationContext(ThreeTimesScopeConfig.class);
//        final Object[] beans = Stream.generate(() -> context1.getBean("threeTimesBean1"))
//                .limit(10)
//                .toArray(Object[]::new);
//        System.out.println(Arrays.toString(beans));
//
//        System.out.println("====================");
//        for (Object e : beans) {
//            System.out.println(e.hashCode());
//        }
//        System.out.println("====================");
//
//        AnnotationConfigApplicationContext context2 = new AnnotationConfigApplicationContext(ThreeTimesScopeConfig.class);
//        final Object[] beans1 = Stream.generate(() -> context2.getBean("threeTimesBean1"))
//                .limit(4)
//                .toArray(Object[]::new);
//        final Object[] beans2 = Stream.generate(() -> context2.getBean("threeTimesBean2"))
//                .limit(2)
//                .toArray(Object[]::new);
//
//        System.out.println(Arrays.toString(beans1));
//        System.out.println(Arrays.toString(beans2));
//        System.out.println(beans1[0].equals(beans1[2]));
//        System.out.println(beans1[0]);
//        System.out.println(beans1[0].hashCode());
//        System.out.println(beans1[2]);
//        System.out.println(beans1[2].hashCode());

    }
}
