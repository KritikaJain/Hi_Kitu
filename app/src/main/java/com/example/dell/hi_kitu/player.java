package com.example.dell.hi_kitu;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by dell on 01-Jun-17.
 */

public class player {

    String name;
    String age;
    String player_id;

    public player(String name, String age, String player_id) {
        this.name = name;
        this.age = age;
        this.player_id = player_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPlayer_id() {
        return player_id;
    }

    public void setPlayer_id(String player_id) {
        this.player_id = player_id;
    }
}