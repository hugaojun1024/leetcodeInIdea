package com.algorithm.javaCollection;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author hugaojun Email:nat17185546@163.com
 * @create 2024-08-08-[下午 9:42]-周四
 */
public class ArrayDemo {

    @Test
    public void arrayInit() {
        // 初始化一个 String 类型的数组
        String[] stringArr = new String[]{"hello", "world", "!"};
        // 修改数组元素的值
        stringArr[0] = "goodbye";
        System.out.println(Arrays.toString(stringArr));// [goodbye, world, !]
        // 删除数组中的元素，需要手动移动后面的元素
        for (int i = 0; i < stringArr.length - 1; i++) {
            stringArr[i] = stringArr[i + 1];
        }
        stringArr[stringArr.length - 1] = null;
        System.out.println(Arrays.toString(stringArr));// [world, !, null]
    }

    @Test
    public void arrayDeleteOneElement() {
        int[] arr = new int[] {1,2,3,4,5};
        // int[] arr2 = {1,2,3,4,5}; //更加简洁
        int indexToRemove = 2;  // 要删除的元素的索引

        // 创建一个新的数组，比原来数组小一个元素
        int[] newArr = new int[arr.length - 1];

        // 将不需要删除的元素复制到新数组
        for (int i = 0, j = 0; i < arr.length; i++ ) {
            if (i != indexToRemove) {
                newArr[j ++] = arr[i];
            }
        }
    }
    /** 在这个例子中，当你把 arr 设为 null 时，原来的数组不再被引用。Java 的垃圾回收器会在适当的时候自动回收该数组所占用的内存。
    需要注意的几点：
    垃圾回收不是即时的：垃圾回收器会根据 JVM 的需要和内存使用情况决定何时回收对象。因此，你无法准确控制什么时候内存会被回收。
    作用域结束时的回收：如果你在方法内部声明了一个数组，当方法执行完毕，数组的引用超出作用域，垃圾回收器也可能回收该数组。
    显式地设置为 null：虽然不建议频繁这样做，但如果你明确知道某个数组不再需要，可以将其引用设置为 null，这将加快垃圾回收器的检测。
    总之，你不需要手动销毁数组或其他对象。Java 的垃圾回收机制会自动处理不可达对象。*/
    @Test
    public void howToMakeInitialArrayDelete() {
        int[] arr = {1,2,3,4};
        // arr 被赋值为 null，使原数组不再有引用
        arr = null;
        // 这里原来的数组就变成了不可达对象，它将会在垃圾回收时被销毁，重新给 arr 赋值一个新的数组
        // arr 变量本身没有被销毁：arr 是一个指向数组的引用变量。
        // 当你将它设置为 null 时，只是让它不再引用之前的数组对象，但 arr 变量依然存在。

        arr = new int[] {6, 7, 8};
        // 现在 arr 指向新的数组
        for (int num : arr) {
            System.out.println(num);  // 输出: 6, 7, 8
        }
    }

    public static void main(String[] args) {
        Object[] objectArr = new Object[] {null, null};
        for (int i = 0; i <= objectArr.length - 1; i ++) {
            System.out.println(objectArr[i]);
        }

        // int[] intArr = new int[] {null, null};

    }
}
