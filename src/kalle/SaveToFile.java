package kalle;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SaveToFile {
	ToDoList list  = new ToDoList();
	
	

	public void saveList(String fileName) throws IOException {
		FileOutputStream fout= new FileOutputStream (fileName);
		ObjectOutputStream oos = new ObjectOutputStream(fout);
		oos.writeObject(list);
		fout.close();
		}
	
}