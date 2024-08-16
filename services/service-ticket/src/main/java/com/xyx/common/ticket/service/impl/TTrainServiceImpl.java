package com.xyx.common.ticket.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xyx.common.ticket.mapper.TTrainMapper;
import com.xyx.common.ticket.service.TTrainService;
import com.xyx.index12306.model.ticket.entry.TTrain;
import org.springframework.stereotype.Service;

/**
* @author xyx
* @description 针对表【t_train(列车表)】的数据库操作Service实现
* @createDate 2024-08-15 16:45:10
*/
@Service
public class TTrainServiceImpl extends ServiceImpl<TTrainMapper, TTrain>
    implements TTrainService {

}




