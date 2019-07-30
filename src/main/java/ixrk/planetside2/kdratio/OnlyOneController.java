package ixrk.planetside2.kdratio;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OnlyOneController {
    @RequestMapping("/")
    @GetMapping
    public String controller(@RequestParam(required = false) String characterName, Model model) {

        return "index";
    }
}
