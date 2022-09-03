package app.controllers;

import app.models.Crew;
import app.models.SpaceShip;
import app.models.SpaceShipClass;
import app.repositories.CrewRepo;
import app.repositories.SpaceShipRepo;
import app.services.CrewService;
import app.services.SpaceShipService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Controller
public class SpaceShipController {

    private final SpaceShipService spaceShipService;
    private final CrewService crewService;
    private final CrewRepo crewRepo;
    private final SpaceShipRepo spaceShipRepo;

    public SpaceShipController(SpaceShipService spaceShipService, CrewService crewService, CrewRepo crewRepo, SpaceShipRepo spaceShipRepo) {
        this.spaceShipService = spaceShipService;
        this.crewService = crewService;
        this.crewRepo = crewRepo;
        this.spaceShipRepo = spaceShipRepo;
    }


    @GetMapping(value = {"/spaceship"})
    public String saveNewSpaceShip(Model model) {
        model.addAttribute("newShip", new SpaceShip());
        model.addAttribute("shipClasses", SpaceShipClass.values());

        return "spaceship_new";
    }

    @GetMapping(value = {"/spaceshipsdata"})
    public String spaceshipsData(Model model){
        List<SpaceShip> spaceShips = spaceShipService.getAllSpaceship();
        model.addAttribute("spaceShips", spaceShips);
        return "spaceshipsdata";
    }

    @PostMapping(value = {"/spaceshipsdata"})
    public String spaceshipIsActiveData(Model model){
        return "redirect:spaceshipisactivedata";
    }

    @GetMapping(value = {"/spaceshipisactivedata"})
    public String spaceshipsIsActiveData(Model model){
        List<SpaceShip> spaceShips = spaceShipService.getAllActiveSpaceship();
        model.addAttribute("spaceShips", spaceShips);
        return "spaceshipisactivedata";
    }

    @PostMapping(value = {"/spaceshipisactivedata"})
    public String spaceshipAllData(Model model){
        return "redirect:spaceshipsdata";
    }

    /*@GetMapping(value = {"/spaceshipcrew/{slug}"}, produces = "application/json")
    public String spaceshipCrewData(Model model){
        List<Crew> crews = crewService.getAllMembers();
        model.addAttribute("crew", crews);
        return "spaceshipcrew";
    }*/

    @GetMapping(value = "/spaceshipcrew/{dutyShip}")
    public String spaceshipCrewData(@PathVariable String dutyShip, Model model) {
        Optional<SpaceShip> ship = spaceShipService.getShip(dutyShip);

        model.addAttribute("crew", ship.orElseThrow().getCrews());
        return "oneshipcrew";
    }



}
