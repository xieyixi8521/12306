package com.xyx.common.ticket.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.xyx.index12306.model.ticket.entry.TStation;
import com.xyx.index12306.model.ticket.vo.StationQueryRespVO;

import java.util.List;

/**
* @author xyx
* @description 针对表【t_station(车站表)】的数据库操作Service
* @createDate 2024-08-15 16:45:09
*/
public interface TStationService extends IService<TStation> {
    /**
     * 获取所有的站点信息
     * @return
     */
    List<StationQueryRespVO> listAllStation();
}
