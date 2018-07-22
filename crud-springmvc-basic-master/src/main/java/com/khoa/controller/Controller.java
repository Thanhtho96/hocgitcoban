package com.khoa.controller;

import com.khoa.bean.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpRequest;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.ApplicationScope;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.ws.spi.http.HttpContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@org.springframework.stereotype.Controller
@RequestMapping("/home/")
public class Controller {
    @RequestMapping("")
    public String loadIndex(ModelMap model) {
        List<Employee> employees = new ArrayList<Employee>();
        employees.add(new Employee(01, "khoa", 1000, "Developer"));
        employees.add(new Employee(01, "mr.blue", 1200, "Project Manager"));
        model.addAttribute("employees", employees);
        return "index";
    }

    @ModelAttribute("members")
    public Map<String,String>getMembers(){
        Map<String,String> members = new HashMap<String, String>();
        members.put("01","khoa");
        members.put("02","hieu");
        members.put("03","dat");
        return members;
    }

    @RequestMapping(value = "testparam",params = "mvc")
    public String testParam(){
        return "param";
    }

    @RequestMapping("scope")
    public String testScope(
            HttpSession session, HttpServletRequest request
    ){
        ServletContext context = request.getSession().getServletContext();
        session.setAttribute("status","session: sad");
        request.setAttribute("status","request: happy");
        context.setAttribute("status","Application boring");
        return "testScope";
    }

    @RequestMapping(value = "xuly", method = RequestMethod.GET)
    public String xuly(@RequestParam("name") String name, @RequestParam("email") String email, ModelMap model) {
        model.addAttribute("name", name);
        model.addAttribute("email", email);
        return "info";
    }
}
