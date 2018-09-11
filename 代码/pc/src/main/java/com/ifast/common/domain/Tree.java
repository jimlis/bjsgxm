package com.ifast.common.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;

/**
 * <pre>
 * </pre>
 * <small> 2018年3月23日 | Aron</small>
 * @param <T>
 */
public class Tree<T> {
    /**
     * 节点ID
     */
    private String id;
    /**
     * 显示节点文本
     */
    private String text;
    /**
     * 节点状态，open closed
     */
    private Map<String, Object> state;
    /**
     * 节点是否被选中 true false
     */
    private boolean checked = false;
    /**
     * 节点属性
     */
    private Map<String, Object> attributes;

    /**
     * 节点的子节点
     */
    private List<Tree<T>> children = new ArrayList<Tree<T>>();

    /**
     * 父ID
     */
    private String parentId;
    /**
     * 是否有父节点
     */
    private boolean hasParent = false;
    /**
     * 是否有子节点
     */
    private boolean hasChildren = false;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    /**
     * 获取显示节点文本
     */
    public String getText() {
        return text;
    }
    
    /**
     * 设置显示节点文本
     * @param text
     */
    public void setText(String text) {
        this.text = text;
    }
    
    /**
     * 获取节点状态，open closed
     */
    public Map<String, Object> getState() {
        return state;
    }
    
    /**
     * 设置节点状态，open closed
     */
    public void setState(Map<String, Object> state) {
        this.state = state;
    }
    
    /**
     * 获取节点节点是否被选中 true false
     */
    public boolean isChecked() {
        return checked;
    }
    
    /**
     * 设置节点节点是否被选中 true false
     */
    public void setChecked(boolean checked) {
        this.checked = checked;
    }
    
    /**
     * 获取节点属性
     */
    public Map<String, Object> getAttributes() {
        return attributes;
    }
    
    /**
     * 设置节点属性
     */
    public void setAttributes(Map<String, Object> attributes) {
        this.attributes = attributes;
    }
    
    /**
     * 获取节点的子节点
     */
    public List<Tree<T>> getChildren() {
        return children;
    }
    
    /**
     * 设置节点的子节点
     */
    public void setChildren(List<Tree<T>> children) {
        this.children = children;
    }
    
    /**
     * 获取是否有父节点
     */
    public boolean isHasParent() {
        return hasParent;
    }
    
    /**
     * 设置是否有父节点
     */
    public void setHasParent(boolean isParent) {
        this.hasParent = isParent;
    }
    
    /**
     * 获取是否有子节点
     */
    public boolean isHasChildren() {
        return hasChildren;
    }
    
    /**
     * 设置是否有子节点
     */
    public void setChildren(boolean isChildren) {
        this.hasChildren = isChildren;
    }
    
    /**
     * 获取父id
     */
    public String getParentId() {
        return parentId;
    }
    
    /**
     * 设置父id
     * @param parentId
     */
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public Tree(String id, String text, Map<String, Object> state, boolean checked, Map<String, Object> attributes,
            List<Tree<T>> children, boolean isParent, boolean isChildren, String parentID) {
        super();
        this.id = id;
        this.text = text;
        this.state = state;
        this.checked = checked;
        this.attributes = attributes;
        this.children = children;
        this.hasParent = isParent;
        this.hasChildren = isChildren;
        this.parentId = parentID;
    }

    public Tree() {
        super();
    }

    @Override
    public String toString() {

        return JSON.toJSONString(this);
    }

}