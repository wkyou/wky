package com.wang.common.utils;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

/**
 * @Author WangKanYou
 * @Date 2022/11/26 22:09
 * @描述:
 */
public class ExcelUtil {
    public static <T> AnalysisEventListener<T> getListener(Consumer<List<T>> consumer, int threshold) {
        return new AnalysisEventListener<T>() {
            private LinkedList<T> linkedList = new LinkedList<T>();

            @Override //每一行触发一次
            public void invoke(T t, AnalysisContext analysisContext) {
                linkedList.add(t);
                if (linkedList.size() == threshold) { //达到一定数据量时截断，防止数据量过多暂用内存或数据丢失
                    consumer.accept(linkedList);  //调用存储业务方法
                    linkedList.clear();
                }
            }

            @Override //每读取完一个sheet
            public void doAfterAllAnalysed(AnalysisContext analysisContext) {
                if (linkedList.size() > 0) {
                    consumer.accept(linkedList); //调用存储业务方法
                    linkedList.clear();
                }
            }

            @Override //获取头部信息
            public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
            }
        };
    }
}
