package edu.handong.csee.java.example.binarydemo;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class BinaryInputEOFDemo {

	public static void main(String[] args) {
		BinaryInputEOFDemo demonstrator = new BinaryInputEOFDemo();
		demonstrator.run();
	}

	private void run() {
		String fileName = "numbers.dat";
		
		try {
			ObjectInputStream inputStream = new ObjectInputStream(
								new FileInputStream(fileName));
			System.out.println("Reading the nonnegative integers");
			System.out.println("in the file " + fileName);
			while(true) {
				int anInteger = inputStream.readInt();
				System.out.println(anInteger);
			}
		} catch(FileNotFoundException e) {
			System.out.println("Problem opening the file " + fileName);
		} catch (EOFException e) {
			System.out.println("Reached end of the file.");
		} catch (IOException e) {
			System.out.println("Problem reading the file " + fileName);
		}
	}
}
