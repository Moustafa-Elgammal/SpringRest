package me.elgammal.Controllers;


import me.elgammal.models.Home;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;


@RestController
public class HomPagesController {
    @RequestMapping("/")
    public Home Home(){
        return  new Home("REST HOME");
    }
}