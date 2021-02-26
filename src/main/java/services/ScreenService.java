package services;

import screens.FileOptionsScreen;
import screens.Screen;
import screens.WelcomeScreen;
import java.util.Scanner;

public class ScreenService {
	
	public static Scanner input = new Scanner(System.in);
    public static WelcomeScreen WelcomeScreen = new WelcomeScreen(input);
    public static FileOptionsScreen FileOptionsScreen = new FileOptionsScreen(input);
    


    public static Screen CurrentScreen = WelcomeScreen;

    public static Screen getCurrentScreen() {
        return CurrentScreen;
    }

    public static void setCurrentScreen(Screen currentScreen) {
        CurrentScreen = currentScreen;
    }
    
    public static void end()
    {
    	input.close();
    }
}