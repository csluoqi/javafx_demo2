package com.bookmanage.service.impl.type;

import com.bookmanage.mapper.TypeMapper;
import com.bookmanage.model.Type;
import com.bookmanage.service.IService;
import com.bookmanage.service.impl.BaseService;
import com.bookmanage.service.type.TypeService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lq
 * 创建时间 2019/5/3 17:54
 **/
@Service
public class TypeServiceImpl  extends BaseService<Type> implements TypeService {

    @Autowired
    private TypeMapper mapper;

    @Override
    public List<Type> selectType(String typeName,int pageNum, int pageSzie) {
        PageHelper.offsetPage(pageNum,pageSzie);
        List<Type> types = mapper.selectType(typeName);
        return types;
    }
}
