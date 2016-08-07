package pl.wroc.uni.unf.webservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.wroc.uni.unf.domain.entity.News;



@RestController
public class NewsController {

    @RequestMapping("/news")
    public News news(@RequestParam(value="name", defaultValue="default") String name) {
        return new News();
    }

}
