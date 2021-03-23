package com.sifunit.lanwei.domain;

import java.io.Serializable;
import java.util.List;

public class LayuiTree implements Serializable {
    private long id;//树节点id,也是菜单id

    private String title;//树节点名称

    private long parent_id;

    private List<LayuiTree> children;//该节点的子节点集合

    public LayuiTree(long id, String title, long parent_id, List<LayuiTree> children) {
        this.id = id;
        this.title = title;
        this.parent_id = parent_id;
        this.children = children;
    }

    public LayuiTree() {
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public List<LayuiTree> getChildren() {
        return children;
    }

    public long getParent_id() {
        return parent_id;
    }

    public void setId(long id) {
        this.id = id;
    }



    public void setParent_id(long parent_id) {
        this.parent_id = parent_id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setChildren(List<LayuiTree> children) {
        this.children = children;
    }
}