package com.lucoo.boot.common.page;

import java.util.List;

/**
 * Created by lucoo on 2016/11/4.
 */
public class BlueSkyPage<T> {
    private long totalCount;

    private List<T> data;

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
