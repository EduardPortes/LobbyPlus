package me.p0rtz.lobbyplus.entities;

public class Player {

    private String name;
    private String pswd;

    public Player(String name, String pswd) {
        this.name = name;
        this.pswd = pswd;
    }

    public String getName() {
        return name;
    }

    public String getPswd() {
        return pswd;
    }
}
