import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

public class Driver {

	private Data data = new Data();	
	private int dataInsert = 0;
	//the first layer
	public void meanMenu(){
		if(dataInsert==0){
			data.Officer();
			data.Cyclist();
			data.Swimmer();
			data.Sprinter();
			data.SuperAthletes();
			dataInsert++;
		}
		System.out.println("Ozlympic Game");
		System.out.println("================================================");
		System.out.println("---1---Select a game to run---------------------");
		System.out.println("---2---Predict the winner of the game-----------");
		System.out.println("---3---Start the game---------------------------");
		System.out.println("---4---Display the final results of all games---");
		System.out.println("---5---Display the points of all athletes-------");
		System.out.println("---6---Exit-------------------------------------");
	}
	public void meanMenuControl(){
		meanMenu();		
		try{
			System.out.println("Please enter your commond : ");
			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();
			if(choice == 1)
				gameMenuControl();
			else if(choice == 0){
				System.out.println("Now, we have these cyclists :");
				
			}
			else if(choice == 2 ){
				predictMenuControl();
			}
			else if(choice == 3){
				startTheGame();
			}
			else if(choice == 4){
				desplayAllGameResults();
			}
			else if(choice == 5){
				displayPointsOfAllAthletes();
			}
			else if(choice == 6){
				System.out.println("------Bye------");
				System.exit(0);
			}
			else{
				System.out.println("You enter a wrong number! Try it again!");
				meanMenu();
				meanMenuControl();
			}
		} catch(Exception e){
			System.out.println("Please enter a number from 1 to 6.");
			meanMenuControl();
		}
	}
	
	//the second layer
	public void gameMenu(){
		System.out.println("Now please select a game.");
		System.out.println("================================");
		System.out.println("---1---Cycling------------------");
		System.out.println("---2---Running------------------");
		System.out.println("---3---Swimming-----------------");
		System.out.println("---4---Back to mean menu--------");
	}
		
	//these three variables is used for gameID
//	private int cyclingGameNumber = 1;
//	private int runningGameNumber = 1;
//	private int swimmingGameNumber = 1;
//	private String reStartUse = null;
	
	public void gameMenuControl(){
		
		gameMenu();
		System.out.println("Please enter your commond : ");
		try{
			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();
			if(choice == 1){
				data.setReStartUse(null);
				String gameID = "C" + Integer.toString(data.getCyclingGameNumber());
				data.setCyclingGameNumber(data.getCyclingGameNumber()+1);
				Cycling cycling = new Cycling(gameID, "Cycling", false, null);
				data.setCycling(cycling);
				data.setGameType("Cycling");
				ArrayList<Cyclist> cyclistInGame = new ArrayList<Cyclist>();
				data.setcyclistInGame(cyclistInGame);
				cyclistInGame = data.getCyclistInGame();
				ArrayList<Official> officialInGame = new ArrayList<Official>();
				data.setOfficialInGame(officialInGame);
				officialInGame = data.getOfficialInGame();
				ArrayList<SuperAthletes> superAthletesInGame = new ArrayList<SuperAthletes>();
				data.setsuperAthletesInGame(superAthletesInGame);
				superAthletesInGame = data.getSuperAthletesInGame();
				cyclingMenuControl(gameID, cyclistInGame, officialInGame, superAthletesInGame);				
			}
			else if(choice == 2){
				data.setReStartUse(null);
				String gameID = "R" + Integer.toString(data.getRunningGameNumber());
				data.setRunningGameNumber(data.getRunningGameNumber() + 1);
				Running running = new Running(gameID, "Running", false, null);
				data.setRunning(running);;
				data.setGameType("Running");
				ArrayList<Sprinter> runnerInGame = new ArrayList<Sprinter>();
				data.setRunnerInGame(runnerInGame);
				runnerInGame = data.getRunnerInGame();
				ArrayList<Official> officialInGame = new ArrayList<Official>();
				data.setOfficialInGame(officialInGame);
				officialInGame = data.getOfficialInGame();
				ArrayList<SuperAthletes> superAthletesInGame = new ArrayList<SuperAthletes>();
				data.setsuperAthletesInGame(superAthletesInGame);
				superAthletesInGame = data.getSuperAthletesInGame();
				runningMenuControl(gameID, runnerInGame, officialInGame, superAthletesInGame);				
			}
			else if(choice == 3){
				data.setReStartUse(null);
				String gameID = "S" + Integer.toString(data.getSwimmingGameNumber());
				data.setSwimmingGameNumber(data.getSwimmingGameNumber() + 1);
				Swimming swimming = new Swimming(gameID, "Swimming", false, null);
				data.setSwimming(swimming);
				data.setGameType("Swimming");
				ArrayList<Swimmer> swimmerInGame = new ArrayList<Swimmer>();
				data.setSwimmerInGame(swimmerInGame);
				swimmerInGame = data.getSwimmerInGame();
				ArrayList<Official> officialInGame = new ArrayList<Official>();
				data.setOfficialInGame(officialInGame);
				officialInGame = data.getOfficialInGame();
				ArrayList<SuperAthletes> superAthletesInGame = new ArrayList<SuperAthletes>();
				data.setsuperAthletesInGame(superAthletesInGame);
				superAthletesInGame = data.getSuperAthletesInGame();
				swimmingMenuControl(gameID, swimmerInGame, officialInGame, superAthletesInGame);	
			}
			else if(choice == 4){		
				if(data.getOfficial() == null){
					data.setGameType(null);
				}
				meanMenuControl();
			}
			else{
				System.out.println("You enter a wrong number, try it again!");
				gameMenuControl();
			}
		} catch(Exception e){
			System.out.println("Please enter a number from 1 to 4.");
			gameMenuControl();
		}
	}
	
	//the third layer ------ running, cycling, swimming
	public void runningMenu(){
		System.out.println("Please choose the athletes and official for the running game");
		System.out.println("============================================================");
		System.out.println("---1---Choose the athlets-----------------------------------");
		System.out.println("---2---Choose the offical-----------------------------------");
		System.out.println("---3---Back to the game menu--------------------------------");
	}
	public void runningMenuControl(String gameID, ArrayList runnerInGame, ArrayList officialInGame, ArrayList superAthletesInGame){
		runningMenu();
		data.setRunnerInGame(runnerInGame);
		data.setsuperAthletesInGame(superAthletesInGame);
		System.out.println("Please enter your commond : ");
		try{
			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();
			int athletesNumber = runnerInGame.size() + superAthletesInGame.size();
			if(choice == 1){
				if(athletesNumber <= 7)
					runnerMenuControl(gameID, runnerInGame, officialInGame, superAthletesInGame);
				else {
					System.out.println("The game has 8 athletes already!");
					runningMenuControl(gameID, runnerInGame, officialInGame, superAthletesInGame);
				}
			}
			else if(choice ==2){
				officialMenuControl(gameID, runnerInGame, officialInGame, superAthletesInGame);				
			}
			else if(choice == 3){
				if(athletesNumber >= 5 && athletesNumber <=8 && officialInGame.size() == 1)
					gameMenuControl();
				else{
					checkGameLimitation(gameID, runnerInGame, superAthletesInGame);
					System.out.println("Would you like to go back to game menu?(yes/no)");
					Scanner cc = new Scanner(System.in);
					String backOrNot = cc.nextLine();
					if(backOrNot.equals("yes")){
						if(data.getRunningGameNumber() != 1){
							data.setRunningGameNumber(data.getRunningGameNumber() - 1);
							data.setRunning(null);;
							data.setGameType(null);
							data.setOfficial(null);;
						}
						System.out.println("The game has been concled.");
						gameMenuControl();
					}
					else if(backOrNot.equals("no")){
						runningMenuControl(gameID, runnerInGame, officialInGame, superAthletesInGame);
					}
					else {
						System.out.println("You enter a wrong commond.");
						runningMenuControl(gameID, runnerInGame, officialInGame, superAthletesInGame);
					}
				}
			}
			else{
				System.out.println("Please enter a number from 1 to 3:");
				runningMenuControl(gameID, runnerInGame, officialInGame, superAthletesInGame);
			}
		} catch(Exception e){
			System.out.println("Please enter a number from 1 to 3:");
			runningMenuControl(gameID, runnerInGame, officialInGame, superAthletesInGame);
		}
	}
	
	public void cyclingMenu(){
		System.out.println("Please choose the athletes and official for the cucling game");
		System.out.println("============================================================");
		System.out.println("---1---Choose the athlets-----------------------------------");
		System.out.println("---2---Choose the offical-----------------------------------");
		System.out.println("---3---Back to the game menu--------------------------------");
	}
	public void cyclingMenuControl(String gameID, ArrayList cyclistInGame, ArrayList officialInGame, ArrayList superAthletesInGame){		
		cyclingMenu();
		data.setcyclistInGame(cyclistInGame);
		data.setsuperAthletesInGame(superAthletesInGame);
		System.out.println("Please enter your commond : ");
		try{
			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();
			int athletesNumber = cyclistInGame.size() + superAthletesInGame.size();
			if(choice == 1){
				if(athletesNumber <= 7)
					cyclistMenuControl(gameID, cyclistInGame, officialInGame, superAthletesInGame);
				else {
					System.out.println("The game has 8 athletes already!");
					cyclingMenuControl(gameID, cyclistInGame, officialInGame, superAthletesInGame);
				}
			}
			else if(choice ==2){
				officialMenuControl(gameID, cyclistInGame, officialInGame, superAthletesInGame);				
			}
			else if(choice == 3){
				if(athletesNumber >= 5 && athletesNumber <=8 && officialInGame.size() == 1)
					gameMenuControl();
				else{
					checkGameLimitation(gameID, cyclistInGame, superAthletesInGame);
					System.out.println("Would you like to go back to game menu?(yes/no)");
					Scanner cc = new Scanner(System.in);
					String backOrNot = cc.nextLine();
					if(backOrNot.equals("yes")){
						if(data.getCyclingGameNumber() != 1){
							data.setCyclingGameNumber(data.getCyclingGameNumber() - 1);
							data.setCycling(null);
							data.setGameType(null);
							data.setOfficial(null);
						}
						System.out.println("The game has been concled.");
						gameMenuControl();
					}
					else if(backOrNot.equals("no")){
						cyclingMenuControl(gameID, cyclistInGame, officialInGame, superAthletesInGame);
					}
					else {
						System.out.println("You enter a wrong commond.");
						cyclistMenuControl(gameID, cyclistInGame, officialInGame, superAthletesInGame);
					}
				}
			}
			else{
				System.out.println("Please enter a number from 1 to 3:");
				cyclingMenuControl(gameID, cyclistInGame, officialInGame, superAthletesInGame);
			}
		} catch(Exception e){
			System.out.println("Please enter a number from 1 to 3:");
			cyclingMenuControl(gameID, cyclistInGame, officialInGame, superAthletesInGame);
		}
	}

	public void checkGameLimitation(String gameID, ArrayList cyclistInGame, ArrayList superAthletesInGame){
		String reason ;
		int athletesNumber = cyclistInGame.size() + superAthletesInGame.size();
		if(athletesNumber == 8){
			System.out.println("The game has 8 athletes so you can't add any athletes!");
		}
		else if(athletesNumber < 5){
			System.out.println("There are less then 5 athletes in the game. \nIf you go back to game menu, this game will be concled.");
		}
		else{
			System.out.println("There are no official in the game. \nIf you go back to game menu, this game will be concled.");
		}
	}
	
 	public void swimmingMenu(){
		System.out.println("Please choose the athletes and official for the swimming game");
		System.out.println("=============================================================");
		System.out.println("---1---Choose the athlets------------------------------------");
		System.out.println("---2---Choose the offical------------------------------------");
		System.out.println("---3---Back to the game menu---------------------------------");
	}
	public void swimmingMenuControl(String gameID, ArrayList swimmerInGame, ArrayList officialInGame, ArrayList superAthletesInGame){
		swimmingMenu();
		data.setSwimmerInGame(swimmerInGame);
		data.setsuperAthletesInGame(superAthletesInGame);
		System.out.println("Please enter your commond : ");
		try{
			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();
			int athletesNumber = swimmerInGame.size() + superAthletesInGame.size();
			if(choice == 1){
				if(athletesNumber <= 7)
					swimmerMenuControl(gameID, swimmerInGame, officialInGame, superAthletesInGame);
				else {
					System.out.println("The game has 8 athletes already!");
					swimmingMenuControl(gameID, swimmerInGame, officialInGame, superAthletesInGame);
				}
			}
			else if(choice ==2){
				officialMenuControl(gameID, swimmerInGame, officialInGame, superAthletesInGame);				
			}
			else if(choice == 3){
				if(athletesNumber >= 5 && athletesNumber <=8 && officialInGame.size() == 1)
					gameMenuControl();
				else{
					checkGameLimitation(gameID, swimmerInGame, superAthletesInGame);
					System.out.println("Would you like to go back to game menu?(yes/no)");
					Scanner cc = new Scanner(System.in);
					String backOrNot = cc.nextLine();
					if(backOrNot.equals("yes")){
						if(data.getSwimmingGameNumber() != 1){
							data.setSwimmingGameNumber(data.getSwimmingGameNumber() - 1);
							data.setSwimming(null);
							data.setGameType(null);
							data.setOfficial(null);
						}
						System.out.println("The game has been concled.");
						gameMenuControl();
					}
					else if(backOrNot.equals("no")){
						swimmingMenuControl(gameID, swimmerInGame, officialInGame, superAthletesInGame);
					}
					else {
						System.out.println("You enter a wrong commond.");
						swimmerMenuControl(gameID, swimmerInGame, officialInGame, superAthletesInGame);
					}
				}
			}
			else{
				System.out.println("Please enter a number from 1 to 3:");
				swimmingMenuControl(gameID, swimmerInGame, officialInGame, superAthletesInGame);
			}
		} catch(Exception e){
			System.out.println("Please enter a number from 1 to 3:");
			swimmingMenuControl(gameID, swimmerInGame, officialInGame, superAthletesInGame);
		}
	}
	
	//the last layer ------ runner, swimmer, cyclist, superathlete, official
	public void runnerMenu(){
		//To print all the runner in the list
		Iterator iter = data.getsprinterList().entrySet().iterator();
		while(iter.hasNext()){
			HashMap.Entry<String, Sprinter> entry = (Entry<String, Sprinter>)iter.next();
			System.out.println("Sprinter ID :\t" + entry.getKey() + "\tSprinter Name :\t" 
					+ entry.getValue().getName());
		}
	}	
	public void runnerMenuControl(String gameID, ArrayList runnerInGame, ArrayList officialInGame, ArrayList superAthletesInGame){
		int athletesNumber = runnerInGame.size() + superAthletesInGame.size();
		// To check the athletes in game
		if (athletesNumber <= 7) {
			System.out.println("Now, we have these athletes :");
			cyclistMenu();
			swimmerMenu();
			runnerMenu();
			supperAthletesMenu();
			System.out.println("Please enter the athletes' ID: ");
			Scanner sc = new Scanner(System.in);
			String ID = sc.nextLine();
			// Check the runner is in the list and not in the game.
			if (data.getsprinterList().get(ID) != null && !runnerInGame.contains(data.getsprinterList().get(ID))) {
				runnerInGame.add(data.getsprinterList().get(ID));
				System.out.println("Now we have: " + runnerInGame.size() + " runner in the game.");
				System.out.println("Would you like to choose another athletes? Please enther 'yes' or 'no' : ");
				String choose = sc.nextLine();
				if (choose.equals("yes")) {
					runnerMenuControl(gameID, runnerInGame, officialInGame, superAthletesInGame);
				} else if (choose.equals("no")) {
					runningMenuControl(gameID, runnerInGame, officialInGame, superAthletesInGame);
				} else {
					System.out.println("You didn't input the right commond! Back to last menu");
					runningMenuControl(gameID, runnerInGame, officialInGame, superAthletesInGame);
				}
			}
			// To check whether the object that user choose is excist in the
			// athletesList and an athlete cann't take in a same game twice.
			else if (data.getSuperAthletesList().get(ID) != null
					&& !superAthletesInGame.contains(data.getSuperAthletesList().get(ID))) {
				superAthletesInGame.add(data.getSuperAthletesList().get(ID));
				System.out.println("Now, we have: " + superAthletesInGame.size() + " superathletes in the game.");
				System.out.println("Would you like to choose another athletes? Please enther 'yes' or 'no' : ");
				String choose = sc.nextLine();
				if (choose.equals("yes")) {
					runnerMenuControl(gameID, runnerInGame, officialInGame, superAthletesInGame);
				} else if (choose.equals("no")) {
					runningMenuControl(gameID, runnerInGame, officialInGame, superAthletesInGame);
				}
				else{
					System.out.println("You didn't input the right commond! Back to last menu");
					runningMenuControl(gameID, runnerInGame, officialInGame, superAthletesInGame);
				}
			} else if(data.getCyclistList().get(ID) !=null || data.getSwimmerList().get(ID) != null){
				System.out.println("Only Sprinters and superathletes can participate in running!");
				runnerMenuControl(gameID, runnerInGame, officialInGame, superAthletesInGame);
			} else if (data.getSuperAthletesList().get(ID) == null && data.getsprinterList().get(ID) == null) {
				System.out.println("The athlete does not exist!");
				runnerMenuControl(gameID, runnerInGame, officialInGame, superAthletesInGame);
			} else if (runnerInGame.contains(data.getsprinterList().get(ID))
					|| superAthletesInGame.contains(data.getSuperAthletesList().get(ID))) {
				System.out.println("The athlete has already in the game, you can't do it twice");
				runnerMenuControl(gameID, runnerInGame, officialInGame, superAthletesInGame);
			} else {
				System.out.println("Something unexcept happen, you will go back to last menu...");
				runnerMenuControl(gameID, runnerInGame, officialInGame, superAthletesInGame);
			}
		} else {
			System.out.println("There are 8 athletes in the game. \nYou cannot add athletes.");
			runningMenuControl(gameID, runnerInGame, officialInGame, superAthletesInGame);
		}
	}
	
	
	public void swimmerMenu(){
		//To print all the cyclists in the list
		Iterator iter = data.getSwimmerList().entrySet().iterator();
		while(iter.hasNext()){
			HashMap.Entry<String, Swimmer> entry = (Entry<String, Swimmer>)iter.next();
			System.out.println("swimmer ID :\t" + entry.getKey() + "\tswimmer Name :\t" 
					+ entry.getValue().getName());
		}
	}
	public void swimmerMenuControl(String gameID, ArrayList swimmerInGame, ArrayList officialInGame, ArrayList superAthletesInGame){
		int athletesNumber = swimmerInGame.size() + superAthletesInGame.size();
		// To check the athletes in game
		if (athletesNumber <= 7) {
			System.out.println("Now, we have these athletes :");
			runnerMenu();
			cyclistMenu();
			swimmerMenu();
			supperAthletesMenu();
			System.out.println("Please enter the athletes' ID: ");
			Scanner sc = new Scanner(System.in);
			String ID = sc.nextLine();
			// Check the cyclist is in the list and not in the game.
			if (data.getSwimmerList().get(ID) != null && !swimmerInGame.contains(data.getSwimmerList().get(ID))) {
				swimmerInGame.add(data.getSwimmerList().get(ID));
				System.out.println("Now we have: " + swimmerInGame.size() + " swimmers in the game.");
				System.out.println("Would you like to choose another athletes? Please enther 'yes' or 'no' : ");
				String choose = sc.nextLine();
				if (choose.equals("yes")) {
					swimmerMenuControl(gameID, swimmerInGame, officialInGame, superAthletesInGame);
				} else if (choose.equals("no")) {
					swimmingMenuControl(gameID, swimmerInGame, officialInGame, superAthletesInGame);
				} else {
					System.out.println("You didn't input the right commond! Back to last menu");
					swimmingMenuControl(gameID, swimmerInGame, officialInGame, superAthletesInGame);
				}
			}
			// To check whether the object that user choose is excist in the
			// athletesList and an athlete cann't take in a same game twice.
			else if (data.getSuperAthletesList().get(ID) != null
					&& !superAthletesInGame.contains(data.getSuperAthletesList().get(ID))) {
				superAthletesInGame.add(data.getSuperAthletesList().get(ID));
				System.out.println("Now, we have: " + superAthletesInGame.size() + " superathletes in the game.");
				System.out.println("Would you like to choose another athletes? Please enther 'yes' or 'no' : ");
				String choose = sc.nextLine();
				if (choose.equals("yes")) {
					swimmerMenuControl(gameID, swimmerInGame, officialInGame, superAthletesInGame);
				} else if (choose.equals("no")) {
					swimmingMenuControl(gameID, swimmerInGame, officialInGame, superAthletesInGame);
				}
				else{
					System.out.println("You didn't input the right commond! Back to last menu");
					swimmingMenuControl(gameID, swimmerInGame, officialInGame, superAthletesInGame);
				}
			}else if(data.getsprinterList().get(ID) != null || data.getCyclistList().get(ID) != null){ 
				System.out.println("Only cyclist and superathletes can participate in the cycling!");
				swimmerMenuControl(gameID, swimmerInGame, officialInGame, superAthletesInGame);
			}else if (data.getSuperAthletesList().get(ID) == null && data.getCyclistList().get(ID) == null) {
				System.out.println("The athlete does not exist!");
				swimmerMenuControl(gameID, swimmerInGame, officialInGame, superAthletesInGame);
			} else if (swimmerInGame.contains(data.getSwimmerList().get(ID))
					|| superAthletesInGame.contains(data.getSuperAthletesList().get(ID))) {
				System.out.println("The athlete has already in the game, you can't do it twice");
				swimmerMenuControl(gameID, swimmerInGame, officialInGame, superAthletesInGame);
			} else {
				System.out.println("Something unexcept happen, you will go back to last menu...");
				swimmerMenuControl(gameID, swimmerInGame, officialInGame, superAthletesInGame);
			}
		} else {
			System.out.println("There are 8 athletes in the game. \nYou cannot add athletes.");
			swimmingMenuControl(gameID, swimmerInGame, officialInGame, superAthletesInGame);
		}
	}
	
	
	public void supperAthletesMenu(){
		//To print all the superathletes in the list
		Iterator iter = data.getSuperAthletesList().entrySet().iterator();
		while(iter.hasNext()){
			HashMap.Entry<String, SuperAthletes> entry = (Entry<String, SuperAthletes>)iter.next();
			System.out.println("superathlete ID : " + entry.getKey() + "\tsuperathlete Name :" 
					+ entry.getValue().getName());
		}
	}

	public void cyclistMenu(){		
		//To print all the cyclists in the list
		Iterator iter = data.getCyclistList().entrySet().iterator();
		while(iter.hasNext()){
			HashMap.Entry<String, Cyclist> entry = (Entry<String, Cyclist>)iter.next();
			System.out.println("cyclist ID :\t" + entry.getKey() + "\tcyclist Name :\t" 
					+ entry.getValue().getName());
		}
	}
	public void cyclistMenuControl(String gameID, ArrayList cyclistInGame, ArrayList officialInGame, ArrayList superAthletesInGame){
		int athletesNumber = cyclistInGame.size() + superAthletesInGame.size();
		// To check the athletes in game
		if (athletesNumber <= 7) {
			System.out.println("Now, we have these athletes :");
			runnerMenu();
			swimmerMenu();
			cyclistMenu();
			supperAthletesMenu();
			System.out.println("Please enter the athletes' ID: ");
			Scanner sc = new Scanner(System.in);
			String ID = sc.nextLine();
			// Check the cyclist is in the list and not in the game.
			if (data.getCyclistList().get(ID) != null && !cyclistInGame.contains(data.getCyclistList().get(ID))) {
				cyclistInGame.add(data.getCyclistList().get(ID));
				System.out.println("Now we have: " + cyclistInGame.size() + " cyclists in the game.");
				System.out.println("Would you like to choose another athletes? Please enther 'yes' or 'no' : ");
				String choose = sc.nextLine();
				if (choose.equals("yes")) {
					cyclistMenuControl(gameID, cyclistInGame, officialInGame, superAthletesInGame);
				} else if (choose.equals("no")) {
					cyclingMenuControl(gameID, cyclistInGame, officialInGame, superAthletesInGame);
				} else {
					System.out.println("You didn't input the right commond! Back to last menu");
					cyclingMenuControl(gameID, cyclistInGame, officialInGame, superAthletesInGame);
				}
			}
			// To check whether the object that user choose is excist in the
			// athletesList and an athlete cann't take in a same game twice.
			else if (data.getSuperAthletesList().get(ID) != null
					&& !superAthletesInGame.contains(data.getSuperAthletesList().get(ID))) {
				superAthletesInGame.add(data.getSuperAthletesList().get(ID));
				System.out.println("Now, we have: " + superAthletesInGame.size() + " superathletes in the game.");
				System.out.println("Would you like to choose another athletes? Please enther 'yes' or 'no' : ");
				String choose = sc.nextLine();
				if (choose.equals("yes")) {
					cyclistMenuControl(gameID, cyclistInGame, officialInGame, superAthletesInGame);
				} else if (choose.equals("no")) {
					cyclingMenuControl(gameID, cyclistInGame, officialInGame, superAthletesInGame);
				}
				else{
					System.out.println("You didn't input the right commond! Back to last menu");
					cyclingMenuControl(gameID, cyclistInGame, officialInGame, superAthletesInGame);
				}
			}else if(data.getsprinterList().get(ID) != null || data.getSwimmerList().get(ID) != null){ 
				System.out.println("Only cyclist and superathletes can participate in the cycling!");
				cyclistMenuControl(gameID, cyclistInGame, officialInGame, superAthletesInGame);
			}else if (data.getSuperAthletesList().get(ID) == null && data.getCyclistList().get(ID) == null) {
				System.out.println("The athlete does not exist!");
				cyclistMenuControl(gameID, cyclistInGame, officialInGame, superAthletesInGame);
			} else if (cyclistInGame.contains(data.getCyclistList().get(ID))
					|| superAthletesInGame.contains(data.getSuperAthletesList().get(ID))) {
				System.out.println("The athlete has already in the game, you can't do it twice");
				cyclistMenuControl(gameID, cyclistInGame, officialInGame, superAthletesInGame);
			} else {
				System.out.println("Something unexcept happen, you will go back to last menu...");
				cyclistMenuControl(gameID, cyclistInGame, officialInGame, superAthletesInGame);
			}
		} else {
			System.out.println("There are 8 athletes in the game. \nYou cannot add athletes.");
			cyclingMenuControl(gameID, cyclistInGame, officialInGame, superAthletesInGame);
		}
	}

	public void officialMenu(){
		//To print all the official in the list
		Iterator iter = data.getOfficialList().entrySet().iterator();		
		while (iter.hasNext()){
			HashMap.Entry<String, Official> entry = (Entry<String, Official>)iter.next();
			System.out.println("official ID :\t" + entry.getKey() + "\tofficial Name :\t" 
					+ entry.getValue().getName());
		}
	}
	public void officialMenuControl(String gameID, ArrayList cyclistInGame, ArrayList officialInGame, ArrayList superAthletesInGame){
		//Firstly, check whether there is an officer in the game	
		if(officialInGame.size() != 0){
			System.out.println("The game has already have an official.");
			System.out.println("You cann't add any other official!");
			if(data.getGameType().equals("Cycling"))
				cyclingMenuControl(gameID, cyclistInGame, officialInGame, superAthletesInGame);
			if(data.getGameType().equals("Running"))
				runningMenuControl(gameID, cyclistInGame, officialInGame, superAthletesInGame);
			if(data.getGameType().equals("Swimming"))
				swimmingMenuControl(gameID, cyclistInGame, officialInGame, superAthletesInGame);
		}
		else{
			officialMenu();
			System.out.println("Please enter the official's ID: ");
			Scanner sc = new Scanner(System.in);
			String ID = sc.nextLine();
			if(data.getOfficialList().get(ID) != null){
				officialInGame.add(data.getOfficialList().get(ID));	
				data.setOfficial((Official) data.getOfficialList().get(ID));
				System.out.println("Your choice is successfull!");
				System.out.println("Now we have: " + officialInGame.size() + " official in game.");
				if(data.getGameType().equals("Cycling"))
					cyclingMenuControl(gameID, cyclistInGame, officialInGame, superAthletesInGame);
				if(data.getGameType().equals("Running"))
					runningMenuControl(gameID, cyclistInGame, officialInGame, superAthletesInGame);
				if(data.getGameType().equals("Swimming"))
					swimmingMenuControl(gameID, cyclistInGame, officialInGame, superAthletesInGame);
			} 
			else {
				System.out.println("The official is not exist!");
				System.out.println("Pleas enter it again:");
				officialMenuControl(gameID, cyclistInGame, officialInGame, superAthletesInGame);
			}
		}
	}

	//String pridict = null;
	public void predictMenuControl(){		
		if(data.getGameType() == null){
			System.out.println("There are no games.");
			meanMenu();
		} else {
			System.out.println("Now we have these athletes in the game:");
			if(data.getGameType().equals("Cycling")){
				data.printCyclistInGame();
				data.printSuperAthletesInGame();
			} 
			else if(data.getGameType().equals("Swimming")){
				data.printSwimmerInGame();
				data.printSuperAthletesInGame();
			}
			else if(data.getGameType().equals("Running")){
				data.printRunnerInGame();
				data.printSuperAthletesInGame();
			} else{
				System.out.println("Something goes wrong in predictMenuControl!");
				meanMenuControl();
			}
		}
			predictGame();
	}
	public void predictGame(){
		System.out.println("Please choose an athlete's ID: ");
		Scanner sc = new Scanner(System.in);
		String athleteID = sc.nextLine();
		if(data.getGameType().equals("Cycling")){
			if(data.getCyclistList().get(athleteID)==null && data.getSuperAthletesList().get(athleteID)==null){
				System.out.println("The athlete does not exist, please try it again!");
				predictGame();
			} else {
				if(data.getCyclistInGame().contains(data.getCyclistList().get(athleteID)) 
					|| data.getSuperAthletesInGame().contains(data.getSuperAthletesList().get(athleteID))){
						data.setPredict(athleteID);
						System.out.println("You predict " + athleteID + " as winner!");
						data.getPredictList().put(data.getCycling().getGameID(), athleteID);
						meanMenuControl();
				} else {
					System.out.println("The athlete does not exist, please try it again!");
					predictGame();
				}
			}
		}
		else if(data.getGameType().equals("Swimming")){
			if(data.getSwimmerList().get(athleteID)==null && data.getSuperAthletesList().get(athleteID)==null){
				System.out.println("The athlete does not exist, please try it again!");
				predictGame();
			} else {
				if(data.getSwimmerInGame().contains(data.getSwimmerList().get(athleteID))
					|| data.getSuperAthletesInGame().contains(data.getSuperAthletesList().get(athleteID))){
						data.setPredict(athleteID);
						System.out.println("You predict " + athleteID + " as winner!");
						data.getPredictList().put(data.getSwimming().getGameID(), athleteID);
						meanMenuControl();
				} else {
					System.out.println("The athlete does not exist, please try it again!");
					predictGame();
				}
			}
		} else if(data.getGameType().equals("Running")){
			if(data.getsprinterList().get(athleteID)==null && data.getSuperAthletesList().get(athleteID)==null){
				System.out.println("The athlete does not exist, please try it again!");
				predictGame();
			} else {
				if(data.getRunnerInGame().contains(data.getsprinterList().get(athleteID))
						|| data.getSuperAthletesInGame().contains(data.getSuperAthletesList().get(athleteID))){
					data.setPredict(athleteID);
					System.out.println("You predict " + athleteID + " as winner!");
					data.getPredictList().put(data.getRunning().getGameID(), athleteID);
					meanMenuControl();
				} else {
					System.out.println("The athlete does not exist, please try it again!");
					predictGame();
				}
			}
		} else {
			System.out.println("There are some error in predictGame!");
			meanMenuControl();
		}
	}
	
	public void startTheGame(){
		if(data.getGameType() == null){
			System.out.println("There are no games.");
			meanMenu();
		} else {
			if(data.getReStartUse() == null){
				HashMap<String, Double> result = new HashMap<String, Double>();
				if(data.getGameType() == "Cycling"){
					data.setReStartUse("ran");
					String gameID = data.getCycling().getGameID();
					System.out.println("The game is start. Please wait...");
					startCycling(gameID, result);
				}
				else if(data.getGameType() == "Running"){
					data.setReStartUse("ran");
					String gameID = data.getRunning().getGameID();
					System.out.println("The game is start. Please wait...");
					startRunning(gameID, result);
				}
				else if(data.getGameType() == "Swimming"){
					data.setReStartUse("ran");
					String gameID = data.getSwimming().getGameID();
					System.out.println("The game is start. Please wait...");
					startSwimming(gameID, result);
				}
				else{
					System.out.println("The game does not exist.");
					meanMenuControl();
				}
			} else {
				System.out.println("Would you like restart the game?(yes/no)");
				Scanner sc = new Scanner(System.in);
				String choice = sc.nextLine();
				if(choice.equals("yes")){
					resetPoints();
					System.out.println("You should reset the prediction first!");
					data.setReStartUse(null);
					predictMenuControl();
				}
				else if(choice.equals("no"))
					meanMenuControl();
				else{
					System.out.println("You entered wrong commond!");
					meanMenuControl();
				}
			}
			
		}
	}
	public void startCycling(String gameID, HashMap<String, Double> result){
		//CyclingGameParticipator cGP = (CyclingGameParticipator) data.getCyclingGameList().get(gameID);
		int athletesNumber = data.getCyclistInGame().size() + data.getSuperAthletesInGame().size();
		double[] rank = new double[athletesNumber];
		for(int i=0;i<data.getCyclistInGame().size();i++){
			Cyclist c = (Cyclist) data.getCyclistInGame().get(i);
			double time = c.compete(data.getGameType());
			String ID = c.getID();
			result.put(ID, time);
			rank[i] = time;
		}
		int j=0;
		for(int i=data.getCyclistInGame().size();i<athletesNumber;i++){
			SuperAthletes s = (SuperAthletes) data.getSuperAthletesInGame().get(j);
			double time = s.compete(data.getGameType());
			String ID = s.getID();
			result.put(ID, time);
			rank[i] = time;
			j++;
		}
		Arrays.sort(rank);
		String winner = null, second = null, third = null;
		try{
		    Thread.sleep(((int) rank[athletesNumber-1])*1);
		}
		catch (InterruptedException e){
		    //e.printStackTrace();
		}
		System.out.println("The game is finished.");
		Iterator iter = result.entrySet().iterator();		
		while (iter.hasNext()){
			HashMap.Entry<String, Double> entry = (Entry<String, Double>)iter.next();
			if(entry.getValue()==rank[0]){
				winner = entry.getKey();
			}
			if(entry.getValue()==rank[1]){
				second = entry.getKey();
			}
			if(entry.getValue()==rank[2]){
				third = entry.getKey();
			}
		}
		System.out.println("The winner is: " + winner + "\tHis result is: " + rank[0]);
		System.out.println("The second is: " + second + "\tHis result is: " + rank[1]);
		System.out.println("The third  is: " + third + "\tHis result is: " + rank[2]);
		data.getResultList().put(gameID, result);
		if(data.getPredict().equals(winner)){
			System.out.println("You win!");
		}else
			System.out.println("You loose!");
		setPoints(winner, second, third);
		meanMenuControl();
	}
	public void startRunning(String gameID, HashMap<String, Double> result){
		int athletesNumber = data.getRunnerInGame().size() + data.getSuperAthletesInGame().size();
		double[] rank = new double[athletesNumber];
		for(int i=0;i<data.getRunnerInGame().size();i++){
			Sprinter r = (Sprinter) data.getRunnerInGame().get(i);
			double time = r.compete(data.getGameType());
			String ID = r.getID();
			result.put(ID, time);
			rank[i] = time;
		}
		int j=0;
		for(int i=data.getRunnerInGame().size();i<athletesNumber;i++){
			SuperAthletes s = (SuperAthletes) data.getSuperAthletesInGame().get(j);
			double time = s.compete(data.getGameType());
			String ID = s.getID();
			result.put(ID, time);
			rank[i] = time;
			j++;
		}
		Arrays.sort(rank);
		String winner = null, second = null, third = null;
		try{
		    Thread.sleep(((int) rank[athletesNumber-1])*1000);
		}
		catch (InterruptedException e){
		    //e.printStackTrace();
		}
		System.out.println("The game is finished.");
		Iterator iter = result.entrySet().iterator();		
		while (iter.hasNext()){
			HashMap.Entry<String, Double> entry = (Entry<String, Double>)iter.next();
			if(entry.getValue()==rank[0]){
				winner = entry.getKey();
			}
			if(entry.getValue()==rank[1]){
				second = entry.getKey();
			}
			if(entry.getValue()==rank[2]){
				third = entry.getKey();
			}
		}
		System.out.println("The winner is: " + winner + "\tHis result is: " + rank[0]);
		System.out.println("The second is: " + second + "\tHis result is: " + rank[1]);
		System.out.println("The third  is: " + third + "\tHis result is: " + rank[2]);
		data.getResultList().put(gameID, result);
		if(data.getPredict().equals(winner)){
			System.out.println("You win!");
		}else
			System.out.println("You loose!");
		setPoints(winner, second, third);
		meanMenuControl();
	}
	public void startSwimming(String gameID, HashMap<String, Double> result){
		int athletesNumber = data.getSwimmerInGame().size() + data.getSuperAthletesInGame().size();
		double[] rank = new double[athletesNumber];
		for(int i=0;i<data.getSwimmerInGame().size();i++){
			Swimmer s = (Swimmer) data.getSwimmerInGame().get(i);
			double time = s.compete(data.getGameType());
			String ID = s.getID();
			result.put(ID, time);
			rank[i] = time;
		}
		int j=0;
		for(int i=data.getSwimmerInGame().size();i<athletesNumber;i++){
			SuperAthletes s = (SuperAthletes) data.getSuperAthletesInGame().get(j);
			double time = s.compete(data.getGameType());
			String ID = s.getID();
			result.put(ID, time);
			rank[i] = time;
			j++;
		}
		Arrays.sort(rank);
		String winner = null, second = null, third = null;
		try{
		    Thread.sleep(((int) rank[athletesNumber-1])*1000);
		}
		catch (InterruptedException e){
		    //e.printStackTrace();
		}
		System.out.println("The game is finished.");
		Iterator iter = result.entrySet().iterator();		
		while (iter.hasNext()){
			HashMap.Entry<String, Double> entry = (Entry<String, Double>)iter.next();
			if(entry.getValue()==rank[0]){
				winner = entry.getKey();
			}
			if(entry.getValue()==rank[1]){
				second = entry.getKey();
			}
			if(entry.getValue()==rank[2]){
				third = entry.getKey();
			}
		}
		System.out.println("The winner is: " + winner + "\tHis result is: " + rank[0]);
		System.out.println("The second is: " + second + "\tHis result is: " + rank[1]);
		System.out.println("The third  is: " + third + "\tHis result is: " + rank[2]);
		data.getResultList().put(gameID, result);
		if(data.getPredict().equals(winner)){
			System.out.println("You win!");
		}else
			System.out.println("You loose!");
		setPoints(winner, second, third);
		meanMenuControl();
	}
	
	public void setPoints(String winner, String second, String third){
		if(data.getCyclistList().get(winner) != null || data.getsprinterList().get(winner) != null || data.getSwimmerList().get(winner)!= null){
			if(data.getGameType().equals("Cycling")){
				Cyclist c1 = (Cyclist) data.getCyclistList().get(winner);
				c1.setPoint(5);
			} else if (data.getGameType().equals("Running")){
				Sprinter r1 = (Sprinter) data.getsprinterList().get(winner);
				r1.setPoint(5);
			} else if(data.getGameType().equals("Swimming")){
				Swimmer s1 = (Swimmer) data.getSwimmerList().get(winner);
				s1.setPoint(5);
			} else
				System.out.println("There are some errors in setpoints()");
		} else {
			SuperAthletes sa1 = (SuperAthletes) data.getSuperAthletesList().get(winner);
			sa1.setPoint(5);
		} 
		if(data.getCyclistList().get(second) != null || data.getsprinterList().get(second) != null || data.getSwimmerList().get(second) != null){
			if(data.getGameType().equals("Cycling")){
				Cyclist c2 = (Cyclist) data.getCyclistList().get(second);
				c2.setPoint(2);
			} else if (data.getGameType().equals("Running")){
				Sprinter r2 = (Sprinter) data.getsprinterList().get(second);
				r2.setPoint(2);
			} else if(data.getGameType().equals("Swimming")){
				Swimmer s2 = (Swimmer) data.getSwimmerList().get(second);
				s2.setPoint(2);
			} else
				System.out.println("There are some errors in setpoints()");
		}else{
			SuperAthletes sa2 = (SuperAthletes) data.getSuperAthletesList().get(second);
			sa2.setPoint(2);
		}
		if(data.getCyclistList().get(third) != null || data.getsprinterList().get(third) != null || data.getSwimmerList().get(third) != null){
			if(data.getGameType().equals("Cycling")){
				Cyclist c3 = (Cyclist) data.getCyclistList().get(third);
				c3.setPoint(1);
			} else if (data.getGameType().equals("Running")){
				Sprinter r3 = (Sprinter) data.getsprinterList().get(third);
				r3.setPoint(1);
			} else if(data.getGameType().equals("Swimming")){
				Swimmer s3 = (Swimmer) data.getSwimmerList().get(third);
				s3.setPoint(1);
			} else
				System.out.println("There are some errors in setpoints()");
		}else{
			SuperAthletes sa2 = (SuperAthletes) data.getSuperAthletesList().get(third);
			sa2.setPoint(1);
		}
	}
	public void resetPoints(){
		if(data.getGameType() == "Cycling"){
			data.getCycling().resetPoints(data);
		} 
		else if(data.getGameType() == "Running"){
			data.getRunning().resetPoints(data);
		}
		else if(data.getGameType() == "Swimming"){
			data.getSwimming().resetPoints(data);
		}
	}
	
	public void desplayAllGameResults(){
		if(data.getResultList().size()!=0){
			Iterator iter = data.getResultList().entrySet().iterator();		
			while (iter.hasNext()){
				HashMap.Entry<String, HashMap<String, Double>> entry = (Entry<String, HashMap<String, Double>>)iter.next();
				printResults(entry.getKey());
			}
			meanMenuControl();
		} else {
			System.out.println("There are not any game has been finished!");
			meanMenuControl();
		}
	}
	
	public void printResults(String gameID){
		HashMap<String, Double> result = (HashMap<String, Double>) data.getResultList().get(gameID);
		Double[] rank = new Double[result.size()];
		int i = 0;
		Iterator iter = result.entrySet().iterator();		
		while (iter.hasNext()){
			HashMap.Entry<String, Double> entry = (Entry<String, Double>)iter.next();
			//System.out.println("ID" + entry.getKey() + "time" + entry.getValue());
			rank[i] = entry.getValue();
			i++;		
		}
		Arrays.sort(rank);
		String winner = null, second = null, third = null, referee;
		String winnerName = null, seconderName = null, thirderName = null, refereeName;
		iter = result.entrySet().iterator();
		while (iter.hasNext()){
			HashMap.Entry<String, Double> entry = (Entry<String, Double>)iter.next();
			if(rank[0]==entry.getValue()){
				winner = entry.getKey();
			}
			if(rank[1]==entry.getValue()){
				second = entry.getKey();
			}
			if(rank[2]==entry.getValue()){
				third = entry.getKey();
			}
		}
		winnerName = getAthletesName(winner, winnerName);
		seconderName = getAthletesName(second, seconderName);
		thirderName = getAthletesName(third, thirderName);
		referee = data.getOfficial().getID();
		refereeName = data.getOfficial().getName();
		System.out.println("GameID:\t" + gameID +"\tUser prediction:\t" + data.getPredictList().get(gameID));
		System.out.println("\tRefereeID:\t" + referee + "\tReferee's Name:\t" + refereeName);
		System.out.println("\tWinnerID:\t" + winner + "\tWinner's Name:\t" + winnerName + "\tResult:\t" + rank[0]);
		System.out.println("\tSeconderID:\t" + second + "\tseconder's Name:" + seconderName + "\tResult:\t" + rank[1]);
		System.out.println("\tThirderID:\t" + third + "\tthirder's Name:\t" + thirderName + "\tResult:\t" + rank[2]);
	}
	
	public String getAthletesName(String ID, String Name){
		if(data.getCyclistList().get(ID)!=null){
			Cyclist c = (Cyclist) data.getCyclistList().get(ID);
			Name = c.getName();
		} 
		else if(data.getSwimmerList().get(ID)!=null){
			Swimmer s = (Swimmer) data.getSwimmerList().get(ID);
			Name = s.getName();
		}
		else if(data.getsprinterList().get(ID)!=null){
			Sprinter r = (Sprinter) data.getsprinterList().get(ID);
			Name = r.getName();
		}
		else {
			SuperAthletes first = (SuperAthletes) data.getSuperAthletesList().get(ID);
			Name = first.getName();
		}
		return Name;
	}
	
	public void displayPointsOfAllAthletes(){
		int[] rank = new int[data.getCyclistList().size()+data.getSwimmerList().size()+data.getsprinterList().size()+data.getSuperAthletesList().size()];
		HashMap<String, Integer> allAthletesPoint = new HashMap<String, Integer>();
		int i = 0;
		//All cyclists points
		Iterator iter = data.getCyclistList().entrySet().iterator();		
		while (iter.hasNext()){
			HashMap.Entry<String, Cyclist> entry = (Entry<String, Cyclist>)iter.next();
			allAthletesPoint.put(entry.getValue().getName(), entry.getValue().getPoint());
		}
		//All swimmer points
		iter = data.getSwimmerList().entrySet().iterator();		
		while (iter.hasNext()){
			HashMap.Entry<String, Swimmer> entry = (Entry<String, Swimmer>)iter.next();
			allAthletesPoint.put(entry.getValue().getName(), entry.getValue().getPoint());
		}
		//All sprinter points
		iter = data.getsprinterList().entrySet().iterator();		
		while (iter.hasNext()){
			HashMap.Entry<String, Sprinter> entry = (Entry<String, Sprinter>)iter.next();
			allAthletesPoint.put(entry.getValue().getName(), entry.getValue().getPoint());
		}
		//all superathlete points
		iter = data.getSuperAthletesList().entrySet().iterator();		
		while (iter.hasNext()){
			HashMap.Entry<String, SuperAthletes> entry = (Entry<String, SuperAthletes>)iter.next();
			allAthletesPoint.put(entry.getValue().getName(), entry.getValue().getPoint());
		}
		//To sort it
		List<Map.Entry<String,Integer>> list = new ArrayList<Map.Entry<String, Integer>>(allAthletesPoint.entrySet());
        Collections.sort(list,new Comparator<Map.Entry<String,Integer>>() {
            public int compare(Entry<String, Integer> o1,
                    Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
            
        });
        
        for(Entry<String, Integer> mapping:list){ 
               System.out.println(mapping.getKey()+":"+mapping.getValue()); 
          } 
		meanMenuControl();
	}
	
	
	
}
