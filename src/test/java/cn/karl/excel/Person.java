package cn.karl.excel;

import org.apache.poi.hssf.usermodel.HSSFDataFormat;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author karl
 */

public class Person {

    @ExcelColumn(title = "姓名", index= 0)
    private String username;
    @ExcelColumn(title = "年龄", index = 1)
    private int age;
    @ExcelColumn(title = "出生日期", index = 2, format = "d-mmm-yy")
    private Date birthDate;

    public Person(String username, int age, Date birthDate) {
        this.username = username;
        this.age = age;
        this.birthDate = birthDate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public static List<Person> exampleList(){
        Person a = new Person("A", 18, new Date());
        Person b = new Person("B", 19, new Date());
        Person c = new Person("C", 20, new Date());
        return Arrays.asList(a, b, c);
    }
}
