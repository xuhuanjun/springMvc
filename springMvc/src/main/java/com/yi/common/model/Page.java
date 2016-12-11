package com.yi.common.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by point on 2016/12/11.
 */
public class Page<T> implements Serializable {

    private List<T> data;//数据

    private int pageNo;//当前页

    private int pageSize;//条数

    private int total;//总条数

    private int pages;//总页面数目

    public List<T> getDataList() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

}
