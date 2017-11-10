package com.zf.util;


import com.zf.dto.SortDto;
import org.springframework.data.domain.Sort;

/**
 * 排序工具类
 * Created by Administrator on 2017/11/9.
 */
public class SortTools {


    /**
     * 默认根据ID倒序排序
     * @return
     */
    public static Sort basicSort() {
        return basicSort("desc", "id");
    }

    /**
     * 自定义排序
     * @param orderType 排序方式
     * @param orderField    排序字段
     * @return
     */
    public static Sort basicSort(String orderType, String orderField) {
        Sort sort = new Sort(Sort.Direction.fromString(orderType), orderField);
        return sort;
    }


    /**
     * 默认排序方式
     * @param dtos 排序字段
     * @return
     */
    public static Sort basicSort(SortDto... dtos) {
        Sort result = null;
        for(int i=0; i<dtos.length; i++) {
            SortDto dto = dtos[i];
            if(result == null) {
                result = new Sort(Sort.Direction.fromString(dto.getOrderType()), dto.getOrderField());
            } else {
                result = result.and(new Sort(Sort.Direction.fromString(dto.getOrderType()), dto.getOrderField()));
            }
        }
        return result;
    }





}
