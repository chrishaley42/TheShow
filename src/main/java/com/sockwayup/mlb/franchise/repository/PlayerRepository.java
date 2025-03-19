package com.sockwayup.mlb.franchise.repository;

import com.sockwayup.mlb.franchise.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    List<Player> findByTeamLevel(String teamLevel);
    List<Player> findByNameContainingIgnoreCase(String name);
}





