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
    private Integer gameLevel = null;
    private List<Team> teams;
    private List<Team> playedTeams = new ArrayList<Team>();
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
            teams.add(new Team(title,teams.size()));
        }
//        mav.put("name", wordsService.getWordsForEasyGame().size());
        return "options";
    }


    @RequestMapping(value = "game", method = RequestMethod.POST)
    public String game(@RequestParam(value = "time" , required = false)Integer _time,
                       @RequestParam(value = "level" , required = false)Integer level,
                       @RequestParam(value = "score" , required = false)Integer score,
                       @RequestParam(value = "id" , required = false)Integer id,
                       ModelMap mav){

        int random;
        if (level != null){
            gameLevel = level;
            time = _time;
//            System.out.println(teams.size());
            random = (int )(Math. random() * teams.size());
//            System.out.println(random);

            mav.put("team", teams.get(random));

        }else{
            Team team = new Team();
            for (Team t: teams) {
                if (t.getId() == id){
                    team = t;
                    break;
                }
            }
            team.setScore(score);
            playedTeams.add(team);
            teams.remove(team);
            if (teams.size() == 0){
                return "redirect:/results";
            }
            System.out.println(teams.size());
            random = (int )(Math. random() * teams.size());
            System.out.println(random);
            mav.put("team", teams.get(random));
        }

        if (gameLevel == 1){
            List<EasyEntity> list = wordsService.getWordsForEasyGame();
            mav.put("words", list);
        } else if (gameLevel == 2){
            List<MiddleEntity> list = wordsService.getWordsForMediumGame();
            mav.put("words", list);
        } else if (gameLevel == 3){
            List<HardEntity> list = wordsService.getWordsForHardGame();
            mav.put("words", list);
        }


        mav.put("time", time);




        return "gamepage";
    }



    @RequestMapping(value = "results", method = RequestMethod.GET)
    public String results(ModelMap mav){

        mav.put("team", playedTeams);
        return "results";
    }



    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String addWord(@RequestParam("word")String wordName){
        wordsService.addWord(wordName);
        return "redirect:/homepage";
    }
}
