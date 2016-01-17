package org.miaohong.jbfs.store.server.controller;

import org.miaohong.jbfs.store.store.Store;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by miaohong on 16/1/13.
 */

@Controller
@RequestMapping("/store/v1/admin/")
public class StoreAdminController {
    @Resource
    public static Store store = Store.getInstance();

//    static {
//        store = Store.getInstance();
//    }

    @PostConstruct
    public void init() {
        //store = Store.getInstance();
    }

    @RequestMapping(value = "/add_free_volume", method = RequestMethod.POST)
    public void addFreeVolume(@RequestParam("n") int n, @RequestParam("bdir") String bdir,
                              @RequestParam("idir") String idir, HttpServletRequest req, HttpServletResponse resp) {
//        System.out.println("add_free_volume");
//
//        System.out.println(n);
//        System.out.println(bdir);
//        System.out.println(idir);
        store.addFreeVolume(n, bdir, idir);
        try {
            resp.getWriter().print("0000");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
