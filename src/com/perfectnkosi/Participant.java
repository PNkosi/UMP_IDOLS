package com.perfectnkosi;

public class Participant {
    private int participantNumber;
    private String participantFirstName;
    private String participantSurname;
    private final int NUMBER_OF_JUDGES = 5;
    private String[] judgeAlias = new String[NUMBER_OF_JUDGES];
    private double[] judgeScores = new double[NUMBER_OF_JUDGES];
    private double avgJudgeScore;
    private int smsCount;

    public Participant() {
        this.participantNumber = 0;
        this.participantFirstName = null;
        this.participantSurname = null;

        // Initializing judgeAlias array elements to null
        for (String alias : this.judgeAlias) {
            alias = null;
        }

        // Initializing judgeScores to zero
        for (double score : this.judgeScores) {
            score = 0;
        }

        this.avgJudgeScore = 0.0d;
        this.smsCount = 0;
    }
    

    public void setParticipantDetails(int participantNumber, String participantFirstName, String participantSurname,
                                      String[] judgeAlias, double[] judgeScores, int smsCount) {
        this.participantNumber = participantNumber;
        this.participantFirstName = participantFirstName;
        this.participantSurname = participantSurname;
        this.judgeAlias = judgeAlias;
        this.judgeScores = judgeScores;
        this.smsCount = smsCount;
        this.avgJudgeScore = this.calculateAverageJudgeScore();
    }
    

    public double determineMinScore() {
        double minScore = this.judgeScores[0];

        for (double score : this.judgeScores) {
            if (score < minScore) {
                minScore = score;
            }
        }
        return minScore;
    }


    public void displayParticipant() {
        System.out.println("Participant Name: " + this.participantFirstName + " " + this.participantSurname);
        System.out.println("Participant Number: " + this.participantNumber);
        System.out.println("Average Score: " + this.avgJudgeScore);
        System.out.println("SMS Count: " + this.smsCount);
    }

    
    public String getParticipantFirstName() {
        return this.participantFirstName;
    }
    

    private double calculateAverageJudgeScore() {
        double total = 0.0d;
        for (final double score : this.judgeScores) {
            total += score;
        }

        return total / this.NUMBER_OF_JUDGES;
    }

    public double getAverageJudgeScore() {
        return this.avgJudgeScore;
    }

    public int getSmsCount() {
        return this.smsCount;
    }
}
