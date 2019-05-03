package com.bookmanage.service.type;

import com.bookmanage.mapper.TypeMapper;
import com.bookmanage.model.Type;
import com.bookmanage.service.IService;
import com.bookmanage.service.impl.BaseService;

import java.util.List;

/**
 * @author lq
 * 创建时间 2019/5/3 17:54
 **/
public interface TypeService extends IService<Type> {

    /**
     * 查询所有类型
     * @return
     */
    List<Type> selectType(String typeName,int pageNum,int pageSzie);



//  List<Citys> selectCitysByFatherCode(@Param("fatherCode")String fatherCode);
//    queryTypesWithPage();
//    /**
//     * 根据父级Code查询    省的 father_code == 0000
//     * @param fatherCode
//     * @return
//     */
//    List<Citys> queryTypesWithPage(String fatherCode);
//
//
//    /**
//     * 根据名称查询Code
//     * @param name
//     * @return
//     */
//    Citys selectCitysByAddrName(String name,String type);
}
