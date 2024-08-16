package com.xyx.common.ticket.controller.rest;

import com.alibaba.nacos.api.model.v2.Result;
import com.xyx.common.ticket.service.TStationService;
import com.xyx.index12306.model.ticket.vo.StationQueryRespVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/ticket-service/station")
public class ApiStationController {

    @Autowired
    private  TStationService tStationService;

    @GetMapping("/all")
    public Result<List<StationQueryRespVO>> listAllStation() {
        return Result.success(tStationService.listAllStation());
    }
}
