package com.atwuhuai.pojo;

import java.util.List;

/**
 * 一个泛型的javabean对象
 * @param <T>
 */
public class Page<T> {
    public  static final Integer PAGE_SIZI=4;
    //当前页码
    private Integer PageNo;
    //总页码数
    private Integer PageTotal;
    //每一页的数据
    private List<T> pageItems;
    //每一页的数据量
    private  Integer PageSize;
    //总的数据量
    private  Integer PageTotalCount;
    //请求地址
    private String url;
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getPageNo() {
        return PageNo;
    }

    public void setPageNo(Integer pageNo) {
        //数据有效边界的检查
        if (pageNo<1){
            PageNo=1;
        }else if (pageNo>PageTotal){
            PageNo=PageTotal;
        }else {
            PageNo = pageNo;
        }
    }

    public Integer getPageTotal() {
        return PageTotal;
    }

    public void setPageTotal(Integer pageTotal) {
        PageTotal = pageTotal;
    }

    public List<T> getPageItems() {
        return pageItems;
    }

    public void setPageItems(List<T> pageItems) {
        this.pageItems = pageItems;
    }

    public Integer getPageSize() {
        return PageSize;
    }

    public void setPageSize(Integer pageSize) {
        PageSize = pageSize;
    }

    public Integer getPageTotalCount() {
        return PageTotalCount;
    }

    public void setPageTotalCount(Integer pageTotalCount) {
        PageTotalCount = pageTotalCount;
    }

    public Page(Integer pageTotal, List<T> pageItems,String url, Integer pageSize, Integer pageTotalCount) {
        PageTotal = pageTotal;
        this.pageItems = pageItems;
        PageSize = pageSize;
        PageTotalCount = pageTotalCount;
        this.url=url;
    }
    public Page(){}

    @Override
    public String toString() {
        return "Page{" +
                "PageNo=" + PageNo +
                ", PageTotal=" + PageTotal +
                ", pageItems=" + pageItems +
                ", PageSize=" + PageSize +
                ", PageTotalCount=" + PageTotalCount +
                ", url='" + url + '\'' +
                '}';
    }
}
