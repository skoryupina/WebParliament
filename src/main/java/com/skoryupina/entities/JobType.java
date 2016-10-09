package com.skoryupina.entities;

public enum JobType {
    LEADER,
    ORDINARY;

    @Override
    public String toString() {
        switch (this){
            case LEADER: return "Руководитель";
            case ORDINARY: return "Депутат";
            default: return "Не определено";
        }
    }
}
