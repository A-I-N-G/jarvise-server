package com.hyundaiite.jarvis.controller;

import com.hyundaiite.jarvis.entity.CompanyPosition;
import com.hyundaiite.jarvis.entity.Position;
import com.hyundaiite.jarvis.service.PositionSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * filename    : PositionCtl.java
 * description : 직무 컨트롤러
 * author      : 김건영
 *
 * Date			  Author		  Description
 * -------------- --------------- --------------------
 * 2023-07-01     김건영			  신규 생성
 *
 * -------------- --------------- --------------------
 */

@RestController
@RequestMapping("/positions")
public class PositionCtl {

    @Autowired
    private PositionSvc positionSvc;

    @PostMapping("/")
    public Position savePosition(@RequestBody Position position) {
        position = positionSvc.savePosition(position);
        return position;

    }

    @GetMapping("/")
    public ArrayList<Position> selectPositions(@RequestBody CompanyPosition companyPosition) {
        ArrayList<Position> selectedPositions = positionSvc.selectPositions(companyPosition);
        return selectedPositions;

    }

    @GetMapping("/")
    public Position selectPosition(@RequestParam(name = "name") String name) {
        Position selectedPosition = positionSvc.selectPosition(name);
        return selectedPosition;
    }

    @PutMapping("/{position_id}")
    public Position updatePosition(@PathVariable Long position_id, @RequestBody Position position) {
        position = Position.builder().id(position_id).build();
        return positionSvc.updatePosition(position);
    }

}
