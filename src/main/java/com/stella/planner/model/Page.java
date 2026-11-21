package com.stella.planner.model;

import java.util.ArrayList;
import java.util.List;

public class Page {
    private String id;
    private String title;
    private String content;
    private Page parent;
    private List<Page> children;

    public Page(String id, String title) {
        this.id = id;
        this.title = title;
        this.children = new ArrayList<>();
    }

    public String getID() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getContent(){
        return this.content;
    }

    public Page getParent() {
        return this.parent;
    }

    public List<Page> getChildren() {
        return this.children;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setParent(Page parent) {
        this.parent = parent;
    }

    public void addChild(Page child) {
        this.children.add(child);
        child.setParent(this);
    }

    public void removeChild(Page child) {
        this.children.remove(child);
        child.setParent(null);
    }
}
