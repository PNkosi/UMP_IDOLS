package com.perfectnkosi;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

/**
* @author Perfect NKosi__Codingd-dude
*/

public class Functions {
    public static void enterParticipantDetails(Participant[] participants, int numberOfParticipants) {
//        if (numberOfParticipants != 3) {
//            throw new IllegalArgumentException("Invalid number of participants parameter: " + numberOfParticipants);
//        }

        Scanner input = new Scanner(System.in);
        input.useLocale(Locale.US); // Setting number format
        
        final int NUMBER_OF_JUDGES = 5;

        for (int i = 0; i < numberOfParticipants; i++) {
        	
            try {
            	System.out.println("----------- Participant " + (i + 1) + " -----------");
                System.out.print("Please enter the participant's number: ");
                final int number = input.nextInt();
                
             

                input.nextLine();

                System.out.print("Please enter the participant's first name: ");
                final String firstName = input.nextLine();

                System.out.print("Please enter the participant's surname: ");
                final String surname = input.nextLine();

                String[] alias = new String[NUMBER_OF_JUDGES];
                double[] scores = new double[NUMBER_OF_JUDGES];
                
                for (int j = 0; j < NUMBER_OF_JUDGES; j++) {
                    try {
                    	System.out.print("Please enter the judge's alias: ");
                        alias[j] = input.nextLine();
                        
                        if (alias[j].contentEquals("")) {
                        	throw new EmptyAliasException();
                        }

                        System.out.print("Please enter " + alias[j] + "'s score: ");
                        scores[j] = input.nextDouble();

                        input.nextLine(); // Clearing input scanner
                        
					} catch (InputMismatchException e) {
						System.out.println("Invalid judge score. Please try again");
						j--;
						input.nextLine(); // Clearing input scanner
						
					} catch (EmptyAliasException e) {
						System.out.println(e.getMessage());
						j--;
					}
                    
                }

                System.out.print("Please enter the number of sms's for the participant: ");
                final int numberOfSMS = input.nextInt();

                // Setting the data to the participant object
                participants[i].setParticipantDetails(number, firstName, surname, alias, scores, numberOfSMS);
            }

            catch(InputMismatchException e) {
                System.out.println("Invalid participant number. Please try again");
                i--;
                input.nextLine(); // Clearing input scanner
            }
            System.out.println("\n");

        }
        input.close(); 
    }

    
 
    public static void sortParticipantsByFirstName(Participant[] participants, int numberOfParticipants) {
//        if (numberOfParticipants != 3) {
//            throw new IllegalArgumentException("Invalid number of participants parameter: " + numberOfParticipants);
//        }
    	
        Participant temp;
        for (int i = 0; i < numberOfParticipants; i++) {
            for (int j = i + 1; j < numberOfParticipants; j++) {

                // to compare one string with other strings
                if (participants[i].getParticipantFirstName().compareTo(participants[j].getParticipantFirstName()) > 0) {
                    // swapping
                    temp = participants[i];
                    participants[i] = participants[j];
                    participants[j] = temp;
                }
            }
        }
    }
    
    

    public static int determineMaxAvgScore(Participant[] participants, int numberOfParticipants) {
//        if (numberOfParticipants != 3) {
//            throw new IllegalArgumentException("Invalid number of participants parameter: " + numberOfParticipants);
//        }

        double highestAvg = participants[0].getAverageJudgeScore();
        int highIndex = 0;
        for (int i = 0; i < numberOfParticipants; i++) {
            if (participants[i].getAverageJudgeScore() > highestAvg) {
                highestAvg = participants[i].getAverageJudgeScore();
                highIndex = i;
            }
        }
        return highIndex;
    }


    public static int determineMostSms(Participant[] participants, int numberOfParticipants) {
//        if (numberOfParticipants != 3) {
//            throw new IllegalArgumentException("Invalid number of participants parameter: " + numberOfParticipants);
//        }

        double highestAvg = participants[0].getSmsCount();
        int highIndex = 0;
        for (int i = 0; i < numberOfParticipants; i++) {
            if (participants[i].getSmsCount() > highestAvg) {
                highestAvg = participants[i].getSmsCount();
                highIndex = i;
            }
        }
        return highIndex;
    }
}
