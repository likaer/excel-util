package cn.karl.excel;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @author karl
 */
public class ExcelUtil {


    public static <T> void exportList(List<T> list, OutputStream outputStream) {
        if (list == null || list.isEmpty()){
            throw new RuntimeException("Empty list");
        }
        T t = list.get(0);
        List<ColumnConf> config = getConfigByAnnotation(t);
        exportList(config, list, outputStream);
    }

    private static List<ColumnConf> getConfigByAnnotation(Object object){
        List<ColumnConf>list = new ArrayList<>();
        Field[] fields = object.getClass().getFields();
        for (Field field : fields){
            ExcelColumn column = field.getAnnotation(ExcelColumn.class);
            if(column != null) {
                ColumnConf columnConf = new ColumnConf();
                columnConf.setTitle(column.title());
                columnConf.setIndex(column.index());
                columnConf.setFormat(column.format());
                list.add(columnConf);
            }
        }
        return list;
    }

    public static <T> void exportList(List<ColumnConf> configs, List<T> list, OutputStream outputStream) {
        if(list == null || list.isEmpty()){
            throw new RuntimeException("Empty list.");
        }
        if(configs == null || configs.isEmpty()){
            throw new RuntimeException("Empty column config.");
        }
        //排序
        configs.sort((ColumnConf a, ColumnConf b) -> {
            if (a.getIndex() == b.getIndex()) {
                return 0;
            }
            return a.getIndex() < b.getIndex() ? -1 : 1;
        });
        //Init sheet
        SXSSFWorkbook wb = new SXSSFWorkbook(1000);
        Sheet sh = wb.createSheet();
        //write Row
        for (int rowIndex = 0; rowIndex< list.size();rowIndex++){
            Row row = sh.createRow(rowIndex);
            for (ColumnConf columnConf : configs){

            }
        }
        try {
            wb.write(outputStream);
        } catch (IOException e) {
            //TODO
        }
    }

    private static Object getPropertyValue(Object obj, String propertyName){
        Field[] fields = obj.getClass().getFields();
        for (int i=0;i<fields.length;i++){
            Object val = null;
            if(fields[i].getName().equals(propertyName)) {
                try {
                    fields[i].setAccessible(true);
                    val = fields[i].get(obj);

                } catch (IllegalAccessException e) {
                    //TODO
                }
                return val;
            }
        }
        return null;
    }


}
