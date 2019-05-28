package com.ladyishenlong.rprojectjava;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author ruanchenhao
 * @Date 2019-05-28 11:43
 * <p>
 * 强 软 弱 虚 引用 参考 https://blog.csdn.net/junjunba2689/article/details/80601729
 */
public class Reference {

    /**
     * 强引用
     * <p>
     * 当内存不足，java虚拟机宁愿抛出OutOfMemoryError错误，
     * 使程序异常终止，也不会靠随意回收具有强引用的对象来解决内存不足问题。
     */
    public void strongReference() {
        String str = "abc";
        List<String> list = new ArrayList<>();
        list.add(str);
    }


    /**
     * 软引用
     * <p>
     * 内存足够，不会回收；内存不足，回收对象
     * 软引用可用来实现内存敏感的高速缓存
     * <p>
     * 内存足够大时可以把数组存入软引用，取数据时就可从内存里取数据，提高运行效率
     * 软引用在实际中有重要的应用，例如浏览器的后退按钮
     */
    public void softReference() {
        SoftReference<String> softReference = new SoftReference<String>("测试");
    }

    /**
     * 弱引用
     * 只具有弱引用的对象，当垃圾回收器的线程扫描
     * 无论内存是否足够，一旦发现直接回收
     * <p>
     * 想要引用对象有自己的生命周期，且不想介入对象的生命周期的时候使用弱引用
     */
    public void weakReference() {
        WeakReference<String> weakCar = new WeakReference<>("弱引用");
    }

    /**
     * 虚引用
     *
     * 等同于没有任何引用，任何时候可能被垃圾回收
     * 主要用来追踪对象被垃圾回收的活动
     *
     * 虚引用必须和引用队列（ReferenceQueue）联合使用
     *
     */
    public void phantomReference(){

    }

}
