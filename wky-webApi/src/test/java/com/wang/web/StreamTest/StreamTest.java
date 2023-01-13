package com.wang.web.StreamTest;

import com.wang.web.pojo.User;
import net.minidev.json.JSONUtil;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author WangKanYou
 * @Date 2022/10/15 22:07
 * @描述:
 */
public class StreamTest {
    public static void main(String[] args) {
        List<User> userList = getUserList();
        //单列集合
        userList.stream() //创建；流
                .distinct() //去重
                .filter(user -> user.getAge()<19)  //过滤
                .forEach(user -> System.out.println(user));  //终结操作
        //数组创建流 有两种方式 1、Arrays.stream(arr) 2、Stream.of(arr)
        Integer[] arr={1,2,3,4,5};
        Stream<Integer> streamArrays = Arrays.stream(arr);
        Stream<Integer> streamOf = Stream.of(arr);
        streamOf.filter(integer -> integer>3)
                .forEach(i-> System.out.println(i));
        //双列集合 需转为单列集合再创建Stream流
        Map<String, Integer> map = getMap();
        map.forEach(new BiConsumer<String, Integer>() {
            @Override
            public void accept(String s, Integer integer) {
                System.out.println(s+"---"+integer);
            }
        });
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        entries.forEach(s-> System.out.println(s));
        Stream<Map.Entry<String, Integer>> stream = entries.stream();
        stream.distinct()
                .filter(m->m.getValue()>18)
                .forEach(m-> System.out.println("key="+m.getKey()+"--value="+m.getValue()));
        userList.stream()
                .filter(new Predicate<User>() {
                    @Override
                    public boolean test(User user) {
                        return user.getAge()>18;
                    }
                }).forEach(user -> System.out.println(user));
//
//        streamMapTest();
//        streamDistinctTest();

        System.out.println("----------------------分割线----------------------");
//        streamSortedTest();

//        streamLimitTest();
//        streamSkipTest();
//        streamFlatMapTest();
//        streamMaxMinTest();
        streamCollectTest();
    }


    public static void streamMapTest(){
        List<User> userList = getUserList();
        //类型转化
        userList.stream()
                .map((Function<User, Integer>) user -> user.getAge())
                .map(age->age+10)                         //map 进行计算操作 年龄+10返回
                .forEach(age-> System.out.println(age));
    }

    public static void streamDistinctTest(){
        List<User> userList = getUserList();
        userList.stream()
                .distinct()
                .forEach(user -> System.out.println(user));
    }

    public static void streamSortedTest(){
        List<User> userList = getUserList();
        userList.stream()
                .sorted(new Comparator<User>() {
                    @Override
                    public int compare(User o1, User o2) {
                        System.out.println("01="+o1);
                        System.out.println("02="+o2);
                        System.out.println(o1.getAge().compareTo(o2.getAge()));
                        //正序
                        return o1.getTime().compareTo(o2.getTime());  // 大于0:取o1 等于0:按加入集合顺序 小于0:取o2
                    }
                }).forEach(user -> System.out.println(user));
    }

    public static void streamLimitTest(){
        List<User> userList = getUserList();
        userList.stream()
                .limit(2)
                .forEach(user -> System.out.println(user));
    }
    public static void streamSkipTest(){
        List<User> userList = getUserList();
        userList.stream()
                .skip(2)
                .forEach(user -> System.out.println(user));
    }
    public static void streamForEachTest(){
        List<User> userList = getUserList();
        userList.stream()
                .forEach(new Consumer<User>() {
                    @Override
                    public void accept(User user) {
                        System.out.println(user);
                    }
                });
    }

    public static void streamMaxMinTest(){
        //获取语文科目的最值
        List<User> userList = getUserList();
        Optional<Integer> max = userList.stream()
                .flatMap(user -> user.getCourseInfos().stream())
                .filter(courseInfo -> courseInfo.getSuject().equals("语文"))
                .map(courseInfo->courseInfo.getScore())
                .max(new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o1 - o2;
                    }
                });
        //获取最小值
        Optional<Integer> min = userList.stream()
                .flatMap(user -> user.getCourseInfos().stream())
                .filter(courseInfo -> courseInfo.getSuject().equals("语文"))
                .map(courseInfo->courseInfo.getScore())
                .min((score1,score2)->score1-score2);
        System.out.println(max.get());  //85
        System.out.println(min.get());  //80
    }
    public static void streamCollectTest() {
//        List<User> userList = getUserList();
//        List<String> nameList = userList.stream()
//                .map(user -> user.getUserName())
//                .collect(Collectors.toList());
//        System.out.println(nameList);
        //[张三, 小兰, 张三, 李四]
//        List<User> userList = getUserList();
//        Set<String> nameSet = userList.stream()
//                .map(user -> user.getUserName())
//                .collect(Collectors.toSet());
//        System.out.println(nameSet);
//        //[李四, 张三, 小兰]
        List<User> userList = getUserList();
        Map<String, Object> map = userList.stream()
                .map(user -> user.getUserName())
                .distinct()
                .collect(Collectors.toMap(new Function<String, String>() {
                    @Override
                    public String apply(String s) {
                        return s;              //返回key
                    }
                }, new Function<String, Object>() {
                    @Override
                    public Object apply(String s) {
                        return s;              //返回value
                    }
                }));
        System.out.println(map);
        //{李四=李四, 张三=张三, 小兰=小兰}
    }

    public static void streamFlatMapTest(){
//        多个单词，重复的字母不显示
//            List<String> list = Arrays.asList("Hello", "World");
//            List<String> collect = list.stream()
//                    .map(e -> e.split(""))            // 分割为数组
//                    .flatMap(array -> Arrays.stream(array)) // 把数组转为流
//                    .distinct()                             // 去重
//                    .collect(Collectors.toList());          // 转为List集合
//            System.out.println(collect);
//            // 打印结果：[H, e, l, o, W, r, d]
        //map 与 flatMap 区别
        getUserList().stream()
                .map(user -> user.getCourseInfos())
                .forEach(user-> System.out.println(user));
        System.out.println("----------------------分割线----------------------");
        List<User> userList = getUserList();
        userList.stream()
                .flatMap(user -> user.getCourseInfos().stream())
                .forEach(courseInfo -> System.out.println(courseInfo));
        /*
        ----------------------分割线----------------------
            [User.CourseInfo(suject=语文, score=80), User.CourseInfo(suject=数学, score=88)]
            [User.CourseInfo(suject=语文, score=80), User.CourseInfo(suject=数学, score=88)]
            [User.CourseInfo(suject=语文, score=80), User.CourseInfo(suject=数学, score=88)]
            [User.CourseInfo(suject=语文, score=80), User.CourseInfo(suject=数学, score=88)]
            ----------------------分割线----------------------
            User.CourseInfo(suject=语文, score=80)
            User.CourseInfo(suject=数学, score=88)
            User.CourseInfo(suject=语文, score=80)
            User.CourseInfo(suject=数学, score=88)
            User.CourseInfo(suject=语文, score=80)
            User.CourseInfo(suject=数学, score=88)
            User.CourseInfo(suject=语文, score=80)
            User.CourseInfo(suject=数学, score=88)
         */
    }

    public static List<User> getUserList(){
        User.CourseInfo courseInfo1 = new User.CourseInfo();
        courseInfo1.setSuject("语文");
        courseInfo1.setScore(80);
        User.CourseInfo courseInfo2 = new User.CourseInfo();
        courseInfo2.setSuject("数学");
        courseInfo2.setScore(88);
        ArrayList<User.CourseInfo> courseInfoList = new ArrayList<>();
        courseInfoList.add(courseInfo1);
        courseInfoList.add(courseInfo2);
        User user1=new User();
        user1.setUserName("张三");
        user1.setSex("男");
        user1.setAge(18);
        user1.setTime(toDate("2022-01-03 12:34:09"));
        user1.setCourseInfos(courseInfoList);
        User user2=new User();
        user2.setUserName("小兰");
        user2.setSex("女");
        user2.setAge(19);
        user2.setTime(toDate("2022-05-03 12:9:09"));
        user2.setCourseInfos(courseInfoList);
        User user3=new User();
        user3.setUserName("张三");
        user3.setSex("男");
        user3.setAge(18);
        user3.setCourseInfos(courseInfoList);
        user3.setTime(toDate("2022-02-03 12:50:03"));
        User user4=new User();
        user4.setUserName("李四");
        user4.setSex("男");
        user4.setAge(20);
        user4.setTime(toDate("2022-01-3 15:34:09"));
        User.CourseInfo courseInfo3 = new User.CourseInfo();
        courseInfo3.setSuject("语文");
        courseInfo3.setScore(85);
        User.CourseInfo courseInfo4 = new User.CourseInfo();
        courseInfo4.setSuject("数学");
        courseInfo4.setScore(88);
        ArrayList<User.CourseInfo> courseInfoList1 = new ArrayList<>();
        courseInfoList1.add(courseInfo3);
        courseInfoList1.add(courseInfo4);
        user4.setCourseInfos(courseInfoList1);
        ArrayList<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
        return userList;
    }
    public static Map<String,Integer> getMap(){
        Map<String, Integer> map = new HashMap<>();
        map.put("小明",18);
        map.put("小兰",191);
        map.put("小兰",1922 );
        map.put("李四",28);
        return map;
    }
    private static Date toDate(String str) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date parse = null;
        try {
            parse = format.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return parse;
    }
}
