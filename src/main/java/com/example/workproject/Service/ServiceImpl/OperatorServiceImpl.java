package com.example.workproject.Service.ServiceImpl;

import com.example.workproject.Service.OperatorService;
import com.example.workproject.entity.Mapper.OperatorMapper;
import com.example.workproject.entity.Mapper.Operator_MybatisPlus_Mapper;
import com.example.workproject.entity.PoJo.operatorBean;
import com.example.workproject.entity.PoJo.unitBean;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class OperatorServiceImpl implements OperatorService {
    @Resource
    OperatorMapper operatorMapper;

    @Resource
    Operator_MybatisPlus_Mapper operator_mybatisPlus_mapper;

    @Override
    public String getAllOperator() {
        return null;
    }

    @Override
    public String getOperatorByInstitutionDM(long institutionId, int page, int limit){
        int num = operatorMapper.getOperatorNum(institutionId);
//        List<unitBean> list = unit_mybatisPlus_mapper.selectPage(pagesize, null).getRecords();
        List<operatorBean> list = operatorMapper.getOperatorByInstitutionDM(institutionId, (page - 1) * limit, limit);
        GsonBuilder builder = new GsonBuilder();
        builder.excludeFieldsWithoutExposeAnnotation();
        Gson gson = new Gson();
        StringBuilder ss = new StringBuilder();
        ss.append("{\n" +
                "  \"code\": 0,\n" +
                "  \"msg\": \"\",\n" +
                "  \"count\": "+ num +",\"data\": ");
        ss.append(gson.toJson(list)+"}");
        return ss.toString();
    }

    @Override
    public void insertOperator(String[] param) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String createTime = simpleDateFormat.format(date);
        long czydm = operatorMapper.getOperatorDm_MAX() + 1;
        operatorMapper.updateMaxOperatorDm();

        operatorBean bean = new operatorBean();
        bean.setDwdm(param[0]);
        bean.setZnjgfzdm(Integer.parseInt(param[1]));
        bean.setZnjgdm(Integer.parseInt(param[2]));
        bean.setCzyxm(param[3]);
        bean.setCzysfzh(param[4]);
        bean.setCzyyddh(param[5]);
        bean.setCzyjs(param[6]);
        bean.setCzymail(param[7]);
        bean.setCzygddh(param[8]);
        bean.setCjrq(createTime);
        bean.setZt("1");
        bean.setCzydm(czydm);
        bean.setCzykl("123456");
        operator_mybatisPlus_mapper.insert(bean);
    }

    @Override
    public void updateOperator(String czydm, String zt) {
        operatorMapper.updateOperator(czydm, zt);
    }

}
