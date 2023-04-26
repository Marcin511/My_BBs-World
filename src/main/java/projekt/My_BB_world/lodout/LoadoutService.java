package projekt.My_BB_world.lodout;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class LoadoutService {
    private final LoadoutRepository loadoutRepository;

    public LoadoutService(LoadoutRepository loadoutRepository) {
        this.loadoutRepository = loadoutRepository;
    }
    Loadout addLoadout(Loadout loadout){
       return loadoutRepository.save(loadout);
    }
    List<Loadout> showLoadout(){
        return loadoutRepository.findAll();
    }
    Loadout getLoadout(Long loadoutId){
        return loadoutRepository.findLoadoutById(loadoutId)
                .orElseThrow(()-> new NoSuchElementException("loadout not exist"));
    }
    Loadout updateLoadout(Long loadoutId,@RequestBody Loadout loadoutToUpdate){
        return loadoutRepository.findLoadoutById(loadoutId)
                .map(loadout -> {loadout.setType(loadoutToUpdate.getType());
                loadout.setFps(loadoutToUpdate.getFps());
                return loadoutRepository.save(loadout);})
                .orElseThrow(()->new NoSuchElementException("loadout not exist"));
    }
}
