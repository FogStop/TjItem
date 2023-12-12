package cn.fog.tj.controller;

import cn.fog.tj.entity.Gather;
import cn.fog.tj.entity.JsonResult;
import cn.fog.tj.service.IGatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Fog
 * @since 2023-12-04
 */
@RestController
@RequestMapping("/gather")
public class GatherController {
@Autowired
    private IGatherService gatherService;

    @GetMapping("/list")
    public JsonResult getAll(){
        List<Gather> list = gatherService.list();
        return JsonResult.ok(list);
    }
}
