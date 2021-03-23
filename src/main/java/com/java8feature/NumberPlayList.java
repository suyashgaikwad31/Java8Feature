package com.java8feature;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class NumberPlayList {
    public static void main(String[] args) {
        List<Integer> myList = new ArrayList<Integer>();
        for(int i=0; i<5; i++) myList.add(i);

        Iterator<Integer> it = myList.iterator();
        while (it.hasNext()) {
            Integer i = it.next();
            System.out.println("Iterator Value::" + i);
        }

        class MyConsumer implements Consumer<Integer> {
            public void accept(Integer t) {
                System.out.println("Mth2: Consumer impl Value::"+t);
            }
        }
        MyConsumer action = new MyConsumer();
        myList.forEach(action);

        myList.forEach(new Consumer<Integer>() {
            public void accept(Integer t){
                System.out.println("Mth3 forEach anonymous Class Value::"+t);
            }
        });

        Consumer<Integer> myListAction = n-> {
            System.out.println("Mth4: forEach Lambda impl Value::" + n);
        };
        myList.forEach(myListAction);

        myList.forEach(n-> {
            System.out.println("Mth5: forEach Lambda impl Value::"+n);
        });

        Function<Integer,Double> doubleFunction = Integer::doubleValue;
        myList.forEach(n-> {
            System.out.println("Mth5: ForEach Lambda Double Value::" + doubleFunction.apply(n));
        });

        Predicate<Integer> isEvenFunction = n -> n%2 == 0;
        myList.forEach(n-> {
            System.out.println("Mth5: ForEach Value of" +n+ "Check For Even" + isEvenFunction.test(n));
        });

        myList.stream().forEach(n ->{
            System.out.println("Mth5: Stream For Each Value:: " +n);
        });

        Function<Integer, Double> toDoubleFunction = Integer::doubleValue;
        myList.forEach(n ->{
            System.out.println("Mth5: foreach Lambda Double Value::" +toDoubleFunction.apply(n));
        });
        myList.stream().map(toDoubleFunction).forEach(System.out::println);
        List<Double> doubleList = myList.stream()
                                  .map(toDoubleFunction)
                                  .collect(Collectors.toList());
        System.out.println("Printing Double List:" + doubleList);

        Predicate<Integer> IsEvenFunction = n -> n%2 == 0;
        myList.forEach(n-> {
            System.out.println("Mth5 For Each Value Of:"+n+ "Check For Even" + IsEvenFunction.test(n));
        });
        List<Integer> evenList = myList.stream()
                                 .filter(IsEvenFunction)
                                 .collect(Collectors.toList());
        System.out.println("Printing Even List: " +evenList );

        Integer first = myList.stream().filter(IsEvenFunction)
                        .peek(n -> System.out.println("Peak Even Number:" +n))
                        .findFirst()
                        .orElse(null);
        System.out.println("Mth8 First Even: " +first);

        Integer min = myList.stream().filter(IsEvenFunction)
                      .min((n1, n2) -> n1-n2).orElse(null);
        System.out.println("Mth9 MinEven: " +min);

        Integer max = myList.stream().filter(IsEvenFunction)
                      .max(Comparator.comparing(Integer::intValue))
                      .orElse(null);
        System.out.println("Mth10 MinMax: " +max);

        Integer sum = myList.stream().reduce(0, Integer::sum);
        long count = myList.stream().count();
        System.out.println("Mth11 Avg of "+sum+"/"+count+"="+sum/count);

        boolean allEven = myList.stream().allMatch(IsEvenFunction);
        boolean oneEven = myList.stream().anyMatch(IsEvenFunction);
        boolean noneMultOfSix = myList.stream().noneMatch(i -> i > 0 && i % 6 == 0);
        System.out.println("Mth12 AllEven:"+allEven+ "OneEven"+oneEven+ "OnoneMultOfSix"+noneMultOfSix);

        List<Integer> sortedList = myList.stream()
                                    .sorted((n1, n2) -> n2.compareTo(n1))
                                    .collect(Collectors.toList());
        System.out.println("Mth13 SortedList: " +sortedList);






    }
}
