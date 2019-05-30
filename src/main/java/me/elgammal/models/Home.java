package me.elgammal.models;

public class Home {
    private final String content;

    public Home(String text)
    {
        this.content = text;
    }

    public String getContent(){ return this.content;}
}
