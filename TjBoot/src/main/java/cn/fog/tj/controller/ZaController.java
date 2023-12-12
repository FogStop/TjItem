package cn.fog.tj.controller;

import cn.fog.tj.entity.JsonResult;
import cn.fog.tj.entity.Za;
import cn.fog.tj.service.IZaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
 * @since 2023-11-30
 */
@RestController
@RequestMapping("/za")
public class ZaController {
    @Autowired
    private IZaService zaService;
    @GetMapping("list")
    public JsonResult getAll(){
        List<Za> list = zaService.list();
        return JsonResult.ok(list);
    }
}
