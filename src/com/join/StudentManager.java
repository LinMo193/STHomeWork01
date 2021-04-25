package com.join;

import java.util.*;

public class StudentManager {
    private ArrayList<Student> list;

    public StudentManager() {
        this.list=new ArrayList<>(20);
    }

    /**
     * 控制整体流程
     */
    public void App() {
        while (true) {
            // 调用菜单
            easySout();
            Scanner reader=new Scanner(System.in);
            int num=reader.nextInt();
            switch (num) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    queryByName();
                    break;
                case 3:
                    deleteStudent();
                    break;
                case 4:
                    editStudent();
                    break;
                case 5:
                    queryAll();
                    break;
                case 6:
                    exit();
                    break;
                default:
                    System.out.println("输入错误，请重新输入：");
                    break;
            }
        }
    }

    public void easySout() {
        System.out.println("请选择操作：");
        System.out.println("***********************************");
        System.out.println("*             1 插入               *");
        System.out.println("*             2 查找               *");
        System.out.println("*             3 删除               *");
        System.out.println("*             4 修改               *");
        System.out.println("*             5 输出               *");
        System.out.println("*             6 退出               *");
        System.out.println("***********************************");
        System.out.println("请输入你的操作数：");
    }


    /**
     * 根据姓名查询该学生是否存在
     */
    public void queryByName() {
        Scanner reader=new Scanner(System.in);
        System.out.println("请输入待查询学生的姓名：");
        String name=reader.next();
        for (int i=0;i<list.size();i++) {
            if (name.equals(list.get(i).getName())) {
                Student student=list.get(i);
                System.out.println("查询成功，该学生信息如下：");
                System.out.println(String.format("%-10s%-10s%-12s%-4s","学号","姓名","出生日期","性别"));
                System.out.println(String.format("%-10d%-10s%-16s%-2s",student.getId(),student.getName(),student.getBirDate(),student.getGender()));
                return;
            }
        }
        System.out.println("查询失败，请检查学生姓名是否正确！");
        return;
    }

    /**
     * 插入学生信息
     */
    public void addStudent() {
        // 判断学生数组是否已满
        if (list.size()==20) {
            System.out.println("在籍学生已满，请重新操作！");
            return;
        }
        Scanner reader=new Scanner(System.in);
        System.out.println("请输入学生学号：");
        int id=reader.nextInt();
        System.out.println("请输入学生的姓名：");
        String name=reader.next();
        System.out.println("请输入学生的出生年月日（例如：20010709）：");
        String birDate=reader.next();
        System.out.println("请输入学生性别：");
        String gender=reader.next();
        // 根据名字查找学生是否存在，若存在则不插入
        if (queryByName(name)) {
            System.out.println("该学生已存在，请重新操作！");
            return;
        }
        Student student=new Student(id,name,birDate,gender);
        list.add(student);
        Collections.sort(list);
        System.out.println("该学生插入成功");
        return;
    }
    public boolean queryByName(String name) {
        for (int i=0;i<list.size();i++) {
            if (name.equals(list.get(i).getName())) {
                return true;
            }
        }
        return false;
    }

    /**
     * 删除学生信息
     */
    public void deleteStudent() {
        Scanner reader=new Scanner(System.in);
        System.out.println("请输入待删除学生的姓名：");
        String name=reader.next();
        for (int i=0;i<list.size();i++) {
            if (name.equals(list.get(i).getName())) {
                list.remove(i);
                System.out.println("删除成功");
                return;
            }
        }
        System.out.println("删除失败，无该学生信息！");
        return;
    }

    /**
     * 根据学生姓名修改学生信息
     * 可以修改年龄及出生日期等信息
     */
    public void editStudent() {
        int i;
        Scanner reader=new Scanner(System.in);
        System.out.println("请输入待修改学生的姓名：");
        String name=reader.nextLine();
        // 查询该学生的具体索引
        for (i=0;i<list.size();i++) {
            if (name.equals(list.get(i).getName())) {
                break;
            }
        }
        while (true) {
            System.out.println("***********************************");
            System.out.println("*          1 修改学生的年龄          *");
            System.out.println("*          2 修改学生的性别          *");
            System.out.println("*          3 退出修改               *");
            System.out.println("***********************************");
            System.out.println("请输入操作数：");
            switch (reader.nextInt()) {
                // 修改学生年龄
                case 1:
                    System.out.println("请输入学生出生年月日（例如：20010709）：");
                    String birDate=reader.next();
                    list.get(i).setBirDate(birDate);
                    break;
                // 修改学生性别
                case 2:
                    System.out.println("请输入学生性别：");
                    String gender=reader.next();
                    list.get(i).setGender(gender);
                    break;
                case 3:
                    return;
            }
        }
    }

    /**
     * 输出所有学生信息
     */
    public void queryAll() {
        if (list.size()==0) {
            System.out.println("无在籍学生，请先录入学生信息！");
            return;
        }
        System.out.println("以下是所有在籍学生信息：");
        System.out.println(String.format("%-10s%-10s%-12s%-4s","学号","姓名","出生日期","性别"));
        for (int i=0;i<list.size();i++) {
            Student student=list.get(i);
            System.out.println(String.format("%-10d%-10s%-16s%-2s",student.getId(),student.getName(),student.getBirDate(),student.getGender()));
        }
        return;
    }

    /**
     * 退出程序
     */
    public void exit() {
        System.exit(0);
    }
}