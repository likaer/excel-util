package cn.karl.excel;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ExcelColumn {

    /**
     * 列标题
     * @return
     */
    String title();
    /**
     * 列顺序
     * @return
     */
    int index();

    /**
     * 单元格格式化
     * @return
     */
    String format() default "";

}
