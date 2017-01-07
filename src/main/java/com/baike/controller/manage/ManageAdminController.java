package com.baike.controller.manage;

import com.baike.common.SpringMvcActionContext;
import com.baike.model.Admin;
import com.baike.model.PageBean;
import com.baike.service.AdminService;
import com.baike.util.StringUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xiechur on 2016/11/25/025.
 */

@Controller
@RequestMapping("manage/admin")
public class ManageAdminController extends SpringMvcActionContext {

    private static final transient Logger log = org.slf4j.LoggerFactory.getLogger(ManageAdminController.class);
    @Resource
    private AdminService adminService;
    /**
     * 管理员登陆
     * @param admin
     * @return
     */
    @RequestMapping("login")
    public String manageLogin(Admin admin) {
        HttpSession session = getSession();
        admin = adminService.login(admin);
        if (admin == null) {
            getSession().setAttribute("admin", admin);
            getRequest().setAttribute("error", "用户名或密码错误");
            return "/admin/login";
        } else {
            getSession().setAttribute("admin", admin);
            return "redirect:/admin/main.jsp";
        }
    }

    /**
     * 管理员登出
     *
     * @return
     */
    @RequestMapping("/logout")
    public String logout() {
        getSession().removeAttribute("admin");
        return "redirect:/admin/login.jsp";
    }


    /**
     * 查询管理员表
     * @param page
     * @param rows
     * @param admin
     * @return
     * @throws Exception
     */
    @RequestMapping("adminList")
    @ResponseBody
    public Object adminList(@RequestParam(value = "page",required = false)String page, @RequestParam(value = "rows",required = false)String rows, Admin admin)throws Exception{
        PageBean pageBean = new PageBean(Integer.parseInt(page),Integer.parseInt(rows));
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("adminName", StringUtil.formatLike(admin.getAdminName()));
//        if (manager.getFreeze() == null){
//            map.put("freeze",manager.getFreeze());
//        }else {
//            map.put("freeze",manager.getFreeze().toString());
//        }
        map.put("start", pageBean.getStart());
        map.put("size", pageBean.getPageSize());
        List<Admin> adminList = adminService.find(map);
        Long total= adminService.getTotal(map);
        JSONObject result=new JSONObject();
        JSONArray jsonArray= JSONArray.fromObject(adminList);
        result.put("rows", jsonArray);
        result.put("total", total);
        System.out.println(result.toString());
        return result;
    }

    /**
     * 管理员修改
     * @param admin
     * @return
     *
     * */
    @RequestMapping("edit")
    @ResponseBody
    public Object editAdmin(Admin admin){
        int result = adminService.update(admin);
        JSONObject jsonObject = new JSONObject();
        if(result > 0){   //说明修改成功
            jsonObject.put("success", true);
        }else{
            jsonObject.put("success", false);
        }
        return jsonObject;
    }
}
