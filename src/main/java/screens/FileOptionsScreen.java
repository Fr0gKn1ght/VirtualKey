package screens;


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import services.DirectoryService;
import services.ScreenService;
import entities.File;

public class FileOptionsScreen implements Screen {

    private ArrayList<String> options = new ArrayList<>();
    private Scanner in;
    private Scanner fScan = new Scanner(System.in);


    public FileOptionsScreen(Scanner s) {
        options.add("1. Add a File");
        options.add("2. Delete A File");
        options.add("3. Search A FIle");
        options.add("4. Return to Main Menu");
        options.add("5. Quit");
        
        in = s;

    }

    @Override
    public void Show()
    {
        System.out.println("\n");

        for (String s : options)  {
            System.out.println(s);
        }

    }

    @Override
    public void GetUserInput()
    {
        int selectedOption;
        while ((selectedOption = this.getOption()) != 5) {
            this.NavigateOption(selectedOption);
        }
    }

    @Override
    public void NavigateOption(int option)
    {
        switch(option) {

            case 1: // Add File
                this.AddFile();
                break;
            case 2: // Delete File
            	this.DeleteFile();
            	break;
            case 3: // Search File
            	this.SearchFile();
            	break;
            case 4: // Return to main menu
            	ScreenService.setCurrentScreen(ScreenService.WelcomeScreen);
                ScreenService.getCurrentScreen().Show();
                ScreenService.getCurrentScreen().GetUserInput();
            	break;
            default: // Invalid Operation
                System.out.println("Invalid Option");
                break;

        }

    }

    public void AddFile() {
        System.out.println("Please Enter the Filename:");

        String fileName = this.getInputString();
        DirectoryService.getFileDirectory().AddFile(new File(fileName));
        DirectoryService.sort();
    }
    
    public void DeleteFile() {
    	System.out.println("Please Enter the Filename:");
    	String fileName = this.getInputString();
    	DirectoryService.getFileDirectory().DeleteFile(new File(fileName));
    }
    
    private void SearchFile() {
    	System.out.println("Please Enter the Filename:");
    	String fileName = this.getInputString();
    	File f = DirectoryService.getFileDirectory().SearchFile(fileName);
    }

    private String getInputString()
    {
        return(in.nextLine());

    }
    private int getOption()
    {
        int returnOption = 0;
        try {
        	String iput = in.nextLine();
            returnOption = Integer.parseInt(iput);
        }
        catch (NumberFormatException ex) {
        	System.err.println("Input must be an int!");
        	return -1;
        }
        return returnOption;

    }

}

