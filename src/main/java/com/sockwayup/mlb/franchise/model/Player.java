package com.sockwayup.mlb.franchise.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "players")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String teamLevel; // MLB, AAA, AA, A
    private String primaryPosition;

    @ElementCollection
    private List<String> secondaryPositions;

    private int originalOverall;
    private int currentOverall;
    private int age;
    private int contractYearsLeft;

    public Player() {}

    public Player(String name, String teamLevel, String primaryPosition, List<String> secondaryPositions,
                  int originalOverall, int currentOverall, int age, int contractYearsLeft) {
        this.name = name;
        this.teamLevel = teamLevel;
        this.primaryPosition = primaryPosition;
        this.secondaryPositions = secondaryPositions;
        this.originalOverall = originalOverall;
        this.currentOverall = currentOverall;
        this.age = age;
        this.contractYearsLeft = contractYearsLeft;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeamLevel() {
        return teamLevel;
    }

    public void setTeamLevel(String teamLevel) {
        this.teamLevel = teamLevel;
    }

    public String getPrimaryPosition() {
        return primaryPosition;
    }

    public void setPrimaryPosition(String primaryPosition) {
        this.primaryPosition = primaryPosition;
    }

    public List<String> getSecondaryPositions() {
        return secondaryPositions;
    }

    public void setSecondaryPositions(List<String> secondaryPositions) {
        this.secondaryPositions = secondaryPositions;
    }

    public int getOriginalOverall() {
        return originalOverall;
    }

    public void setOriginalOverall(int originalOverall) {
        this.originalOverall = originalOverall;
    }

    public int getCurrentOverall() {
        return currentOverall;
    }

    public void setCurrentOverall(int currentOverall) {
        this.currentOverall = currentOverall;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getContractYearsLeft() {
        return contractYearsLeft;
    }

    public void setContractYearsLeft(int contractYearsLeft) {
        this.contractYearsLeft = contractYearsLeft;
    }
// Getters and Setters...
}
