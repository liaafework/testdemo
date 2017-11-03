package kalle;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;


public class ReadFromFile {
	
	
	
	public List<Activities> read(String fileName) throws IOException, ClassNotFoundException, FileNotFoundException {
		FileInputStream fin= new FileInputStream (fileName);
		ObjectInputStream ois = new ObjectInputStream(fin);
		ArrayList<Activities> list= (ArrayList<Activities>)ois.readObject(); 
		fin.close();
		return list;
		}

}
