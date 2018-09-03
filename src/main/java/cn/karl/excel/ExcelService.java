package cn.karl.excel;

import java.util.List;

/**
 * @author karl
 */
public interface ExcelService {

    /**
     * Excel按照注解导出List
     * @param list
     * @param <T>
     */
    public <T> void exportList(List<T>list);

    /**
     * Excel按照配置导出List
     *
     * @param configs
     * @param list
     * @param <T>
     */
    public <T> void exportList(List<ColumnConf> configs, List<T> list);

}
