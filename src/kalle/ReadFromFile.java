package kalle;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class ReadFromFile {
	
	
	
	public void read(String fileName,List<Activities> list) throws IOException, ClassNotFoundException {
		FileInputStream fin= new FileInputStream (fileName);
		ObjectInputStream ois = new ObjectInputStream(fin);
		list= (ArrayList<Activities>)ois.readObject(); 
		fin.close();
		}

}
