package com.perfectnkosi;

/**
* @author Perfect NKosi__Codingd-dude
*/

public class Main {
    public static void main(String[] args) {
        final int MAX_PARTICIPANTS = 1;
        final Participant[] participants = new Participant[MAX_PARTICIPANTS];

        //Instantiation of the three participants
        for (int i = 0; i < MAX_PARTICIPANTS; i++) {
            participants[i] = new Participant();
        }



        System.out.println("====================");
        System.out.println("IDOLS SCORING SYSTEM");
        System.out.println("====================\n");


        Functions.enterParticipantDetails(participants, MAX_PARTICIPANTS);


        System.out.println("Participants Entered");
        System.out.println("---------------------\n");
        for (final Participant participant : participants) {
            participant.displayParticipant();
            System.out.println("\n");
        }


        System.out.println("Participants sorted by first name");
        System.out.println("---------------------------------\n");
        try {
        	Functions.sortParticipantsByFirstName(participants, MAX_PARTICIPANTS);
            for (final Participant participant : participants) {
                participant.displayParticipant();
                System.out.println("\n");
            }
        	
        } catch (IllegalArgumentException e) {
        	System.out.println(e.getMessage());
        }


        System.out.println("Participant with the highest average");
        System.out.println("------------------------------------\n");
        final int HighAvgindex = Functions.determineMaxAvgScore(participants, MAX_PARTICIPANTS);
        participants[HighAvgindex].displayParticipant();


        System.out.println("\n\nParticipant with the most SMSs");
        System.out.println("------------------------------\n");
        final int MostSMSindex = Functions.determineMostSms(participants, MAX_PARTICIPANTS);
        participants[MostSMSindex].displayParticipant();

    }
}
