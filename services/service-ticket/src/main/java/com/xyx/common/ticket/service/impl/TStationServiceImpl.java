package com.xyx.common.ticket.service.impl;


import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xyx.common.ticket.mapper.TStationMapper;
import com.xyx.common.ticket.service.TStationService;
import com.xyx.index12306.model.ticket.entry.TStation;
import com.xyx.index12306.model.ticket.vo.StationQueryRespVO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xyx
 * @description 针对表【t_station(车站表)】的数据库操作Service实现
 * @createDate 2024-08-15 16:45:09
 */
@Service
public class TStationServiceImpl extends ServiceImpl<TStationMapper, TStation>
        implements TStationService {

    @Override
    public List<StationQueryRespVO> listAllStation() {

        List<TStation> list = list();
        if (CollectionUtils.isEmpty(list)) {
            return new ArrayList<>();
        }
        List<StationQueryRespVO> stationQueryRespVOS = BeanUtil.copyToList(list, StationQueryRespVO.class);
        return stationQueryRespVOS;

    }
}




