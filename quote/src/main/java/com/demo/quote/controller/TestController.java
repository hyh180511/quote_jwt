package com.demo.quote.controller;

import com.demo.quote.JSONResult;
import com.demo.quote.pojo.ProjectInfo;
import com.demo.quote.pojo.ProjectMgr;
import com.demo.quote.service.service.UserService;
import com.demo.quote.util.DocUtil;
import com.demo.quote.util.ProjectMgrUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/test")
public class TestController {


    @GetMapping("/index")
    public Object getPage()
    {
        return "index";
    }


    @Autowired
    ProjectMgrUtil projectMgrUtil;

    @GetMapping("/GetDoc")
    @ResponseBody
    public void GetDoc( HttpServletRequest request, HttpServletResponse response)
    {
        int proId=1;
        Map<String,Object> dataMap = new HashMap<String,Object>();

        ProjectMgr projectMgr=projectMgrUtil.getProjectMgr(proId);

        dataMap.put("projectMgr",projectMgr);

        String newWordName = "方案标准化技术配置文件.doc";
        //调用打印word的函数
        DocUtil.download(request, response, newWordName, dataMap);

    }

//        /**
//     * 保存项目名
//     * @param projectInfo
//     * @return
//     */
//    @PostMapping("/saveProject")
//    @ResponseBody
//    @ApiOperation(notes ="项目概述数据保存", value ="获取项目概述数据，保存在数据库中", httpMethod = "POST")
//    public Object saveProject(@RequestBody ProjectInfo projectInfo)
//    {
//        projectInfoService.save(projectInfo);
//        return new JSONResult("200",projectInfo);
//    }

}
