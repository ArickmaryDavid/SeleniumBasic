package com.coreJava.programs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

@SuppressWarnings("serial")
public class SerializationAndDeSerializationExample implements Serializable {
	public int id;
	public String name;

	public SerializationAndDeSerializationExample(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public void SerializeToFile(SerializationAndDeSerializationExample obj, String FilePath) {

		FileOutputStream fileStream;
		try {
			fileStream = new FileOutputStream(FilePath);
			ObjectOutputStream objStream = new ObjectOutputStream(fileStream);
			objStream.writeObject(obj);
			objStream.close();
			fileStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public Object DeserializeToObject(String FilePath) {
		Object inputObject = null;
		try {
			FileInputStream fileInputStream = new FileInputStream(FilePath);
			ObjectInputStream objInputStream = new ObjectInputStream(fileInputStream);
			inputObject = objInputStream.readObject();

			objInputStream.close();
			fileInputStream.close();

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		return inputObject;

	}

	public static void main(String[] args) {
		SerializationAndDeSerializationExample s1 = new SerializationAndDeSerializationExample(1, "Apple");
		s1.SerializeToFile(s1,
				"D:\\Workspace_2024\\SeleniumBasic\\src\\main\\java\\com\\coreJava\\programs\\SampleTxtFile.txt");
		
		SerializationAndDeSerializationExample s2 = (SerializationAndDeSerializationExample) s1.DeserializeToObject(
				"D:\\Workspace_2024\\SeleniumBasic\\src\\main\\java\\com\\coreJava\\programs\\SampleTxtFile.txt");
		System.out.println("After Deserialization : id = " + s2.id);
		System.out.println("After Deserialization : name = " + s2.name);

	}
}
