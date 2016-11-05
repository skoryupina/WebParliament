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

    public static JobType getCorrespondingJobType(String jobType){
        switch (jobType){
            case "Руководитель": return LEADER;
            case "Депутат": return  ORDINARY;
            default: throw  new RuntimeException("Unreachable statement");
        }
    }
}
