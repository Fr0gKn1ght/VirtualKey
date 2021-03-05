package services;

import java.util.ArrayList;

import entities.Directory;
import entities.File;

public class DirectoryService {

    private static Directory fileDirectory = new Directory();


    public static void AddTestData() {
        fileDirectory.AddFile(new File("test1.txt"));
        fileDirectory.AddFile(new File("test2.txt"));
        fileDirectory.AddFile(new File("test3.txt"));
        fileDirectory.AddFile(new File("test4.txt"));

    }

    public static void PrintFiles() {

        for (File file : DirectoryService.getFileDirectory().getFiles())
        {
            System.out.println(file.getName());
        }
    }
    public static Directory getFileDirectory() {
        return fileDirectory;
    }

    public static void setFileDirectory(Directory fileDirectory) {
        DirectoryService.fileDirectory = fileDirectory;
    }

    static void heapify(ArrayList<File> array, int size, int idx)
	{
		int largest = idx;
		int left = 2*idx+1;
		int right = 2*idx+2;
		
		if(left<size&&array.get(largest).compareLessThan(array.get(left)))
			largest = left;
		if(right<size&&array.get(largest).compareLessThan(array.get(right)))
			largest = right;
		
		if(largest!=idx)
		{
			swap(array,idx,largest);
			heapify(array,size,largest);
		}
	}
	
	public static void sort()
	{
		for(int i = fileDirectory.getFiles().size()/2-1;i>=0;i--)
			heapify( fileDirectory.getFiles(), fileDirectory.getFiles().size(),i);
		
		for(int i =  fileDirectory.getFiles().size()-1; i>=0;i--)
		{
			swap( fileDirectory.getFiles(),0,i);
			heapify( fileDirectory.getFiles(),i,0);
		}
	}
	
	static void swap(ArrayList<File>array,int id1, int id2)
	{
		File tmp = array.get(id1);
		array.set(id1, array.get(id2));
		array.set(id2, tmp);
	}
}