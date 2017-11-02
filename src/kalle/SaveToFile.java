package kalle;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import java.util.List;

public class SaveToFile {
	
	public void saveList(String fileName, List<Activities> list) throws IOException {
		FileOutputStream fout= new FileOutputStream (fileName, false);
		ObjectOutputStream oos = new ObjectOutputStream(fout);
		oos.writeObject(list);
		fout.close();
		}
	
	
}