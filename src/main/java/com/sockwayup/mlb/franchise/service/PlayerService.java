package com.sockwayup.mlb.franchise.service;

import com.sockwayup.mlb.franchise.exception.ResourceNotFoundException;
import com.sockwayup.mlb.franchise.model.Player;
import com.sockwayup.mlb.franchise.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public Player getPlayerById(Long id) {
        return playerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Player not found with id: " + id));
    }

    public List<Player> getPlayersByTeamLevel(String teamLevel) {
        return playerRepository.findByTeamLevel(teamLevel);
    }

    public Player addPlayer(Player player) {
        return playerRepository.save(player);
    }

    public Player updatePlayer(Long id, Player updatedPlayer) {
        Player existingPlayer = getPlayerById(id);
        existingPlayer.setName(updatedPlayer.getName());
        existingPlayer.setTeamLevel(updatedPlayer.getTeamLevel());
        existingPlayer.setPrimaryPosition(updatedPlayer.getPrimaryPosition());
        existingPlayer.setSecondaryPositions(updatedPlayer.getSecondaryPositions());
        existingPlayer.setOriginalOverall(updatedPlayer.getOriginalOverall());
        existingPlayer.setCurrentOverall(updatedPlayer.getCurrentOverall());
        existingPlayer.setAge(updatedPlayer.getAge());
        existingPlayer.setContractYearsLeft(updatedPlayer.getContractYearsLeft());
        return playerRepository.save(existingPlayer);
    }

    public void deletePlayer(Long id) {
        Player player = getPlayerById(id);
        playerRepository.delete(player);
    }

    public List<Player> searchPlayersByName(String name) {
        return playerRepository.findByNameContainingIgnoreCase(name);
    }
}

