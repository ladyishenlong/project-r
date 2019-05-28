package com.ladyishenlong.rprojectjava;

import java.util.*;

/**
 * @Author ruanchenhao
 * @Date 2019-05-28 11:20
 * <p>
 * 三种集合接口全部实现Collection接口
 */
public class CollectionDemo {


    /**
     * 允许重复元素
     * 允许任意数量空值
     * 保持插入顺序
     */
    private List<Integer> list = new ArrayList<>();
    /**
     * 不允许重复元素
     * 仅允许一个空值
     * 无序，根据实现类可排序
     */
    private Set<Integer> set = new HashSet<>();
    /**
     * key不允许重复元素 ,value允许重复元素
     * 仅允许一个空键， 允许任意的空值
     * 无序，根据实现类可排序
     */
    private Map<Integer, Integer> map = new HashMap<>();


}
