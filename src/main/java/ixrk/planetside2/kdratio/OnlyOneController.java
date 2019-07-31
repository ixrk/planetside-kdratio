package ixrk.planetside2.kdratio;

import ixrk.planetside2.kdratio.character.CharactersStatDTO;
import ixrk.planetside2.kdratio.character.CharactersStatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OnlyOneController {
    private CharactersStatService charactersStatService;

    @Autowired
    public OnlyOneController(CharactersStatService charactersStatService) {
        this.charactersStatService = charactersStatService;
    }

    @RequestMapping("/")
    @GetMapping
    public String controller(@RequestParam(required = false) String characterName, Model model) {
        if (characterName != null) {
            CharactersStatDTO stats = charactersStatService.kdStats(characterName);
            model.addAttribute("stats", stats);
        }

        return "index";
    }
}
