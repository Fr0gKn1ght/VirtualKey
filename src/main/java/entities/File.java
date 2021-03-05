package entities;

public class File {

    String name;

    String path;


    public File(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
    
    public boolean compareLessThan(File f)
    {
    	int smallest = (this.getName().length()<f.getName().length())? this.getName().length() : f.getName().length();
    	for(int i = 0; i < smallest; i++)
    	{
    		char myChar = this.getName().toLowerCase().charAt(i);
    		char fChar = f.getName().toLowerCase().charAt(i);
    		
    		if (myChar<fChar)
    			return true;
    		else if(fChar<myChar)
    			return false;
    	}
    	if(smallest == this.getName().length())
    		return true;
    	else
    		return false;
    }




}
