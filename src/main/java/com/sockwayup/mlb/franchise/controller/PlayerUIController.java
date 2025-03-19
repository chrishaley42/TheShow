package com.sockwayup.mlb.franchise.controller;

import com.sockwayup.mlb.franchise.model.Player;
import com.sockwayup.mlb.franchise.service.PlayerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/players")
public class PlayerUIController {

    private final PlayerService playerService;

    public PlayerUIController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    public String showPlayers(Model model) {
        List<Player> players = playerService.getAllPlayers();
        model.addAttribute("players", players);
        return "players-list";  // Thymeleaf template name
    }

    @GetMapping("/add")
    public String showAddPlayerForm(Model model) {
        model.addAttribute("player", new Player());
        return "player-form";
    }

    @PostMapping("/save")
    public String savePlayer(@ModelAttribute Player player) {
        playerService.addPlayer(player);
        return "redirect:/players";  // Redirect back to the list
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Player player = playerService.getPlayerById(id);
        model.addAttribute("player", player);
        return "player-form";
    }

    @GetMapping("/delete/{id}")
    public String deletePlayer(@PathVariable Long id) {
        playerService.deletePlayer(id);
        return "redirect:/players";
    }

}

