package edu.handong.csee.java.example.binarydemo;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Doubler {
	private ObjectInputStream inputStream = null;
	private ObjectOutputStream outputStream = null;
	Scanner keyboard = null;
	
	public static void main(String[] args) {
		
		Doubler twoTimer = new Doubler();
		twoTimer.run();
		
	}

	public void run() {
		keyboard = new Scanner(System.in);
		connectToInputFile();
		connectToOutputFile();
		keyboard.close();
		timesTwo();
		closeFiles();
		System.out.println("Numbers from input file");
		System.out.println("doubled and copied to output file.");
		
	}

	public void connectToOutputFile() {
		String outputFileName = getFileName("Enter name of output file: ");
		
		try {
			outputStream = new ObjectOutputStream(
					new FileOutputStream(outputFileName));
		} catch(IOException e) {
			System.out.println("Error opening output file " + outputFileName);
			System.out.println(e.getMessage());
			System.exit(0);
		}
	}

	public void closeFiles() {
		try {
			inputStream.close();
			outputStream.close();
		} catch (IOException e) {
			System.out.println("Error closing files " + e.getMessage());
			System.exit(0);
		}		
	}

	public void timesTwo() {
		try {
			while(true) {
				int next = inputStream.readInt();
				outputStream.writeInt(2*next);
			}
		} catch(EOFException e) {
			
		} catch(IOException e) {
			System.out.println("Error: reading or writing files.");
			System.exit(0);
		}
	}

	public void connectToInputFile() {
		String inputFileName = getFileName("Enter name of input file:");
		try {
			inputStream = new ObjectInputStream(
					new FileInputStream(inputFileName));
		} catch(FileNotFoundException e) {
			System.out.println("File " + inputFileName + " not found.");
			System.exit(0);
		} catch (IOException e) {
			System.out.println("Error opening input file: " + inputFileName);
		}
	}

	private String getFileName(String prompt) {
		String fileName = null;
		System.out.println(prompt);
		fileName = keyboard.nextLine();
		
		return fileName;
	}
}
