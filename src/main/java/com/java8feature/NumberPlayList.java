package com.java8feature;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

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


    }
}
