package edu.nju.ise.model;

/**
 * 为表格数据封装一个数据类型，包含总条数，当前页数，显示条数等信息
 *
 * @author Hermit
 * @version 1.0 2018/02/15
 * */
public class TableData {

    //总条数
    private Long recordsTotal;
    private Long recordsFiltered;
    //渲染次数
    private Long draw;
    //当前页数
    private Long currentPage;
    //显示条数
    private Long pageSize;
    //返回数据
    private Object data;

    public TableData() {}

    public Long getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(Long recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public Long getRecordsFiltered() {
        return recordsFiltered;
    }

    public void setRecordsFiltered(Long recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }

    public Long getDraw() {
        return draw;
    }

    public void setDraw(Long draw) {
        this.draw = draw;
    }

    public Long getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Long currentPage) {
        this.currentPage = currentPage;
    }

    public Long getPageSize() {
        return pageSize;
    }

    public void setPageSize(Long pageSize) {
        this.pageSize = pageSize;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
