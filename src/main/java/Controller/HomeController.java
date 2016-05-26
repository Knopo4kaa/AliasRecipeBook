package Controller;

import Model.*;
import Repositories.EasyRepository;
import Repositories.HardRepository;
import Repositories.MiddleRepository;
import Services.WordsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by drowerik on 22.05.16.
 */

@Controller
@RequestMapping("/")
public class HomeController {

    private List<Team> teams;
    private int time;

    @Inject
    WordsService wordsService;


    @RequestMapping(value = "", method = RequestMethod.GET)
    public String homepage(ModelMap mav){
        mav.put("name", wordsService.getWordsForEasyGame().size());
        return "homepage";
    }

    @RequestMapping(value = "teampage", method = RequestMethod.GET)
    public String teampage(ModelMap mav){
        List<TeamEntity> list;
//        mav.put("name", wordsService.getWordsForEasyGame().size());
        return "teampage";
    }

    @RequestMapping(value = "options", method = RequestMethod.POST)
    public String options(@RequestParam(value = "title[]", required = false)String [] titles){

        teams = new ArrayList<Team>();
        for (String title : titles) {
            teams.add(new Team(title));
        }
//        mav.put("name", wordsService.getWordsForEasyGame().size());
        return "options";
    }


    @RequestMapping(value = "game", method = RequestMethod.POST)
    public String game(@RequestParam("time")Integer _time,
                       @RequestParam("level")Integer level,
                       ModelMap mav){
        time = _time;
        if (level == 1){
            List<EasyEntity> list = wordsService.getWordsForEasyGame();
            mav.put("words", list);
            System.out.println(list);
        } else if (level == 2){
            List<MiddleEntity> list = wordsService.getWordsForMediumGame();
            mav.put("words", list);
            System.out.println(list);
        } else if (level == 3){
            List<HardEntity> list = wordsService.getWordsForHardGame();
            mav.put("words", list);
            System.out.println(list);
        }
        mav.put("time", time);
        return "gamepage";
    }



    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String addWord(@RequestParam("word")String wordName){
        wordsService.addWord(wordName);
        return "redirect:/homepage";
    }
}
