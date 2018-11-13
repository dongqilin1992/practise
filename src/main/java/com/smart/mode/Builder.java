package com.smart.mode;

/**
 * @description:建造者模式
 * @author: dongql
 * @date: 2018/4/2 14:42
 */
public class Builder {
    public static void main(String[] args) {
        Student a = new Student.StudentBuilder().setAge(13).setName("LiHua").setNumber(1).build();
        Student b = new Student.StudentBuilder().setSchool("sc").setSex("Male").setName("ZhangSan").build();
        System.out.println(a);
        System.out.println(b);
    }
}

class Student {
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", number=" + number +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", school='" + school + '\'' +
                '}';
    }

    String name = null;
    int number = -1;
    String sex = null;
    int age = -1;
    String school = null;

    public Student(StudentBuilder builder) {
        this.age = builder.age;
        this.name = builder.name;
        this.number = builder.number;
        this.school = builder.school;
        this.sex = builder.sex;
    }

    static class StudentBuilder {
        String name = null;
        int number = -1;
        String sex = null;
        int age = -1;
        String school = null;

        public StudentBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public StudentBuilder setNumber(int number) {
            this.number = number;
            return this;
        }

        public StudentBuilder setSex(String sex) {
            this.sex = sex;
            return this;
        }

        public StudentBuilder setAge(int age) {
            this.age = age;
            return this;
        }

        public StudentBuilder setSchool(String school) {
            this.school = school;
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }
}


