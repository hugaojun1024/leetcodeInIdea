package com.algorithm.javaCollection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author hugaojun Email:nat17185546@163.com
 * @create 2024-08-08-[下午 9:58]-周四
 */
public class ListDemo {

    @Test
    public void initArrayList() {
        // 初始化一个 String 类型的 ArrayList
        ArrayList<String> stringList = new ArrayList<>(
                Arrays.asList("hello", "world", "!")
        );
        // 添加元素到 ArrayList 中
        stringList.add("goodbye");
        System.out.println(stringList);// [hello, world, !, goodbye]
        // 修改 ArrayList 中的元素
        stringList.set(0, "hi");
        System.out.println(stringList);// [hi, world, !, goodbye]
        // 删除 ArrayList 中的元素
        stringList.remove(0);
        System.out.println(stringList); // [world, !, goodbye]
    }

    @Test
    public void initLinkedList() {
        LinkedList<String> stringLinkedList = new LinkedList<>(
                Arrays.asList("hello", "world", "!")
        );
        // 添加元素到 LinkedList 中
        stringLinkedList.add("goodbye");
        // 修改 LinkedList 中的元素
        stringLinkedList.set(0, "hi");
        System.out.println(stringLinkedList);
        // 删除 LinkedList 中的元素，删除头节点
        stringLinkedList.remove();
        System.out.println(stringLinkedList);
        // 查看 LinkedList 中的元素
        System.out.println(stringLinkedList.get(1));
    }

    @Test
    public void testListRemove(){
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        updateList(list);
        System.out.println(list);
    }

    private static void updateList(List list){
        // list.remove(2);
        list.remove(new Integer(2));
    }
}
