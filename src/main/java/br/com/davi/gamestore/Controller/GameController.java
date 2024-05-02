package br.com.davi.gamestore.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.davi.gamestore.Model.GameModel;
import br.com.davi.gamestore.Repository.GameRepository;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class GameController {
    
    @Autowired
    GameRepository gameRepository;
    
    @GetMapping("/list")
    public ModelAndView getListGame(){
        ModelAndView mv = new ModelAndView("game-lista");
        mv.addObject("games", gameRepository.findAll());

        return mv;
    }

    @GetMapping("/addgame")
    public ModelAndView getAddGame(){
    ModelAndView mv = new ModelAndView("game-add.html");
    return mv;
    }

    @PostMapping("adicionar")
    public ModelAndView adicionarGAme(GameModel gameModel) {
        ModelAndView mv = new ModelAndView("game-add.html");
        gameRepository.save(gameModel);
        
        return mv;
    }
    





}
