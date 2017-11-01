package kalle;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class ReadFromFile {
	
	List<Activities> list = new ArrayList<Activities>();
	
	public void read(String fileName) throws IOException, ClassNotFoundException {
		FileInputStream fin= new FileInputStream (fileName);
		ObjectInputStream ois = new ObjectInputStream(fin);
		list= (ArrayList<Activities>)ois.readObject(); 
		fin.close();
		}

}
