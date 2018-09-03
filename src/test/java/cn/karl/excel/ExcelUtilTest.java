package cn.karl.excel;

import org.junit.Test;

import java.io.*;
import java.util.List;

public class ExcelUtilTest {

    @Test
    public void exportList() {
        List<Person> list = Person.exampleList();
        try{
            File file = new File("resources/person.xlsx");
            file.createNewFile();
            OutputStream outputStream = new FileOutputStream(file);
            ExcelUtil.exportList(list, outputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Test
    public void exportList1() {

    }

}