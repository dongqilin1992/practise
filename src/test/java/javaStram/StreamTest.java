package javaStram;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @description:
 * @author: dongql
 * @date: 2019/7/2 15:29
 */
public class StreamTest {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        //filter 方法用于通过设置的条件过滤出元素
        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        System.out.println("过滤非空字符串：" + filtered);
        String mergedString = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
        System.out.println("过滤非空字符串并连接字符串: " + mergedString);
        //limit 方法用于获取指定数量的流
        //sorted 方法用于对流进行排序
        Random random = new Random();
        random.ints().limit(5).sorted().forEach(i -> System.out.println("升序排序:" + i));

        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        // 获取对应的平方数
        //map 方法用于映射每个元素到对应的结果
        numbers.stream().map(i -> i * i).collect(Collectors.toList()).forEach(a -> System.out.println("求平方:" + a));

        Stream.of("a", "b", "hello").map(String::toUpperCase).forEach(s -> System.out.println("转为大写：" + s));
    }

    @Test
    public void testMapFilter() {
        Student stuA = new Student(1, "A", "M", 184);
        Student stuB = new Student(2, "B", "G", 163);
        Student stuC = new Student(3, "C", "M", 175);
        Student stuD = new Student(4, "D", "G", 158);
        Student stuE = new Student(5, "E", "M", 170);
        List<Student> list = new ArrayList<>();
        list.add(stuA);
        list.add(stuB);
        list.add(stuC);
        list.add(stuD);
        list.add(stuE);

        list.stream().map(Student::getName).limit(5).skip(3).collect(Collectors.toList()).forEach(a -> System.out.println("五个跳过前三个：" + a));

        list.stream().filter(student -> "A".equals(student.getName())).collect(Collectors.toList()).forEach(a -> System.out.println("过滤出name=A:" + a));

        list.stream().sorted(Comparator.comparing(Student::getHeight).reversed()).forEach(student -> System.out.println("按Height降序排序：" + student));

        list.stream().sorted((p1, p2) -> p1.getName().compareTo(p2.getName())).limit(4).forEach(student -> System.out.println("按name升序排序：" + student));
    }

    @Test
    public void testPeek() {
        Stream.of("one", "two", "three", "four").filter(e -> e.length() > 3).peek(e -> System.out.println("Filtered value: " + e)).map(String::toUpperCase).peek(e -> System.out.println("Mapped value: " + e)).collect(Collectors.toList());
    }

    @Test
    public void testOptional() {
        String text = null;
        Optional.ofNullable(text).ifPresent(System.out::println);
        Integer integer = Optional.ofNullable(text).map(String::length).orElse(-1);
        System.out.println("length:" + integer);
    }

    @Test
    public void testReduce() {
        String concat = Stream.of("A", "B", "C", "D").reduce("", String::concat);
        System.out.println("concat:" + concat);
        double minValue = Stream.of(-1.5, 1.0, -3.0, -2.0).reduce(Double.MAX_VALUE, Double::min);
        System.out.println("minValue:" + minValue);
        // 求和，sumValue = 10, 有起始值
        int sumValue = Stream.of(1, 2, 3, 4).reduce(1, Integer::sum);
        System.out.println("sumValue:" + sumValue);
        // 求和，sumValue = 10, 无起始值
        sumValue = Stream.of(1, 2, 3, 4).reduce(Integer::sum).get();
        System.out.println("sumValue:" + sumValue);
        // 过滤，字符串连接，concat = "ace"
        concat = Stream.of("a", "B", "c", "D", "e", "F").
                filter(x -> x.compareTo("B") > 0).
                reduce("起始值", String::concat);
        System.out.println("concat:" + concat);
    }

    @Test
    public void testMinMaxDistinct() throws IOException {
        // 找出最长一行的长度
        BufferedReader br = new BufferedReader(new FileReader("C:\\baiduyun\\test.txt"));
        int asInt = br.lines().mapToInt(String::length).max().getAsInt();
        br.close();
        System.out.println("最长一行的长度:" + asInt);
        BufferedReader brs = new BufferedReader(new FileReader("C:\\baiduyun\\test.txt"));
        List<String> words = brs.lines().flatMap(line -> Stream.of(line.split(" "))).
                filter(word -> word.length() > 4).map(String::toLowerCase).distinct().sorted().collect(Collectors.toList());
        br.close();
        System.out.println("找出全文的单词，转小写，并排序:" + words);
    }

    @Test
    public void testMatch() {
        Student stuA = new Student(1, "A", "M", 184);
        Student stuB = new Student(2, "B", "G", 163);
        Student stuC = new Student(3, "C", "M", 175);
        Student stuD = new Student(4, "D", "G", 158);
        Student stuE = new Student(5, "E", "M", 170);
        List<Student> list = new ArrayList<>();
        list.add(stuA);
        list.add(stuB);
        list.add(stuC);
        list.add(stuD);
        list.add(stuE);
        boolean isAllAdult = list.stream().allMatch(p -> p.getNo() > 0);
        System.out.println("All are adult? " + isAllAdult);
        boolean isThereAnyChild = list.stream().anyMatch(p -> p.getNo() < 0);
        System.out.println("Any child? " + isThereAnyChild);
    }

    @Test
    public void testGroupBy() {
        Student stuA = new Student(1, "A", "M", 184);
        Student stuB = new Student(2, "B", "G", 163);
        Student stuC = new Student(3, "C", "M", 175);
        Student stuD = new Student(4, "B", "G", 158);
        Student stuE = new Student(5, "C", "M", 170);
        List<Student> list = new ArrayList<>();
        list.add(stuA);
        list.add(stuB);
        list.add(stuC);
        list.add(stuD);
        list.add(stuE);

        //分组
        Map<String, List<Student>> groupBySex = list.stream().collect(Collectors.groupingBy(Student::getSex));
        //遍历分组
        for (Map.Entry<String, List<Student>> entryUser : groupBySex.entrySet()) {
            String key = entryUser.getKey();
            List<Student> entryUserList = entryUser.getValue();
            System.out.println(key + ":"+entryUserList);
        }
        //统计每个分组的count
        Map<String, Long> groupcount = list.stream().collect(Collectors.groupingBy(Student::getSex, Collectors.counting()));
        System.out.println("每个分组的count"+groupcount);

        Map<Integer, Student> userMap = list.stream().collect(Collectors.toMap(Student::getNo, a -> a,(k1,k2)->k1));
        System.out.println("List转map:" + userMap);
        //获取list对象的某个字段组装成新list
        List<Integer> userNoList = list.stream().map(Student::getNo).collect(Collectors.toList());
        System.out.println("userNoList:" +userNoList);

        //分支求和
        List<String> items = Arrays.asList("apple", "apple", "banana", "apple", "orange", "banana", "papaya");
        Map<String, Long> result = items.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(result);

        // 多字段分组统计
        Map<String, Long> countMap = list.stream().collect(Collectors.groupingBy(o -> o.getSex() + "_" + o.getName(), Collectors.counting()));
        System.out.println(countMap);

    }

    class Student {
        int no;
        String name;
        String sex;
        float height;

        public Student(int no, String name, String sex, float height) {
            this.no = no;
            this.name = name;
            this.sex = sex;
            this.height = height;
        }

        public int getNo() {
            return no;
        }

        public void setNo(int no) {
            this.no = no;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public float getHeight() {
            return height;
        }

        public void setHeight(float height) {
            this.height = height;
        }

        @Override
        public String toString() {
            return "Student{" + "no=" + no + ", name='" + name + '\'' + ", sex='" + sex + '\'' + ", height=" + height + '}';
        }
    }
}


