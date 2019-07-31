package ixrk.planetside2.kdratio;

import ixrk.planetside2.kdratio.character.CharactersStatDTO;
import ixrk.planetside2.kdratio.character.CharactersStatService;
import ixrk.planetside2.kdratio.character.InvalidCharacterNameException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String controller(@RequestParam(required = false) String characterName, Model model) {
        if (characterName != null) {
            CharactersStatDTO stats;
            model.addAttribute("characterName", characterName);
            try {
                stats = charactersStatService.kdStats(characterName);
                model.addAttribute("stats", stats.getMap());
            } catch (InvalidCharacterNameException e) {
                model.addAttribute("invalidNameMessage", "Invalid character name");
            }
        }

        return "index";
    }
}
