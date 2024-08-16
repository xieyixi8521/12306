package com.xyx.common.ticket.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xyx.common.ticket.mapper.TTrainStationMapper;
import com.xyx.common.ticket.service.TTrainStationService;
import com.xyx.index12306.model.ticket.entry.TTrainStation;
import org.springframework.stereotype.Service;

/**
* @author xyx
* @description 针对表【t_train_station(列车站点表)】的数据库操作Service实现
* @createDate 2024-08-15 16:45:10
*/
@Service
public class TTrainStationServiceImpl extends ServiceImpl<TTrainStationMapper, TTrainStation>
    implements TTrainStationService {

}




