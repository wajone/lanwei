package com.sifunit.lanwei.vo;

import com.sifunit.lanwei.domain.LayuiTree;

import java.io.Serializable;
import java.util.List;

public class ProceCateTree implements Serializable {

    private long id;//树节点id,也是菜单id

    private String title;//树节点名称

    private long parent_id;

    private List<ProceCateTree> children;//该节点的子节点集合

    public ProceCateTree() {
    }

    public ProceCateTree(long id, String title, long parent_id, List<ProceCateTree> children) {
        this.id = id;
        this.title = title;
        this.parent_id = parent_id;
        this.children = children;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getParent_id() {
        return parent_id;
    }

    public void setParent_id(long parent_id) {
        this.parent_id = parent_id;
    }

    public List<ProceCateTree> getChildren() {
        return children;
    }

    public void setChildren(List<ProceCateTree> children) {
        this.children = children;
    }
}
