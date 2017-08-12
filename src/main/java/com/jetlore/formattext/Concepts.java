package com.jetlore.formattext;

public class Concepts {

    public String  entity;
    public Integer startPosition;
    public Integer endPosition;

    public Concepts(String entity, Integer startPosition, Integer endPosition) {
        this.entity = entity;
        this.startPosition = startPosition;
        this.endPosition = endPosition;
    }


    public Integer getStartPosition() {
        return startPosition;
    }

    public void setStartPosition(Integer startPosition) {
        this.startPosition = startPosition;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public Integer getEndPosition() {
        return endPosition;
    }

    public void setEndPosition(Integer endPosition) {
        this.endPosition = endPosition;
    }


}
