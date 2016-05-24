package Controller;

import Services.WordsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.inject.Inject;

/**
 * Created by drowerik on 22.05.16.
 */

@Controller
@RequestMapping("/")
public class HomeController {

    @Inject
    WordsService wordsService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String homepage(ModelMap mav){
        mav.put("name", wordsService.getWordsForEasyGame().size());
        return "homepage";
    }

    @RequestMapping(value = "teampage", method = RequestMethod.GET)
    public String teampage(ModelMap mav){
//        mav.put("name", wordsService.getWordsForEasyGame().size());
        return "teampage";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String addWord(@RequestParam("word")String wordName){
        wordsService.addWord(wordName);
        return "redirect:/homepage";
    }
}
