package entities;

import java.util.ArrayList;
import java.util.Locale;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Directory {
	
	private static Pattern valid = Pattern.compile("([A-Za-z0-9_\\-])\\w+\\.[a-z]+");

    String name;

    ArrayList<File> files = new ArrayList<File>();

    ArrayList<Directory> directories = new ArrayList<Directory>();
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<File> getFiles() {
        return files;
    }

    public void setFiles(ArrayList<File> files) {
        this.files = files;
    }

    public ArrayList<Directory> getDirectories() {
        return directories;
    }

    public void setDirectories(ArrayList<Directory> directories) {
        this.directories = directories;
    }
    
    public static boolean checkValidity(String filename)
    {
    	Matcher m = valid.matcher(filename);
    	if(m.matches())
    		return true;
    	else
    		return false;
    }

    public File SearchFile(String filename) {
    	if(checkValidity(filename) == false)
    	{
    		System.out.println("File name is invalid!");
    		return null;
    	}
        for (File f : files) {
            if (f.getName().toLowerCase().equals(filename.toLowerCase())) {
            	{
            		System.out.println("The File \"" + filename + "\" was found!");
            		return f;
            	}
            }
        }
        System.out.println("The File \"" + filename + "\" was not found!");
        return null;
    }
    
    public int getFileIndex(String filename)
    {
    	for (int i = 0; i < files.size(); i++) {
            if (files.get(i).getName().toLowerCase().equals(filename.toLowerCase())) {
                return i;
            }
        }
        return -1;
    }

    public void DeleteFile(File file) {
    	if(checkValidity(file.getName()) == false)
    	{
    		System.out.println("File name is invalid!");
    	}
        int idx = getFileIndex(file.name);
        if(idx!=-1)
        	files.remove(idx);
        else
        	System.out.println("The following file was not found in the directory: " + file.name);
    }
    public void AddFile(File file) {
    	if(checkValidity(file.getName()) == false)
    	{
    		System.out.println("File name is invalid!");
    	}
        int idx = getFileIndex(file.name);
        if(idx == -1)
        	files.add(file);
        else
        	System.out.println("The file \"" + file.name + "\" already exists.");

    }

}
