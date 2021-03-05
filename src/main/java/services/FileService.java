package services;

import entities.File;

public class FileService {
	
private static File currentFile;

public static void printFileInfo(){
	System.out.println(currentFile.getName());
}
	
}
