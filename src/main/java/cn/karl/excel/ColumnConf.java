package cn.karl.excel;

/**
 * 列配置层
 *
 * @author karl
 */
public class ColumnConf {

    //标题
    private String title;
    //属性名
    private String property;
    //顺序
    private int index;
    //格式化
    private String format;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }
}
