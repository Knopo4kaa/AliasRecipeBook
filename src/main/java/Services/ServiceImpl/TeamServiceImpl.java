package Services.ServiceImpl;

import Model.TeamEntity;
import Repositories.TeamRepository;
import Services.TeamService;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by drowerik on 24.05.16.
 */
public class TeamServiceImpl implements TeamService {


    @Inject
    TeamRepository teamRepository;

    public List<TeamEntity> getTeamNames(){
        List<TeamEntity> list = teamRepository.findAll();
        return null;
    }


}
