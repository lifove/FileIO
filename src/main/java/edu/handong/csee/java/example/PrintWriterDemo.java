package edu.handong.csee.java.example;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class PrintWriterDemo {

	public static void main(String[] args) {
		PrintWriterDemo writer = new PrintWriterDemo();
		writer.run();
	}

	private void run() {
		String fileName = "out.txt";
		PrintWriter outputStream = null;
		
		try {
			outputStream = new PrintWriter(fileName);
		} catch(FileNotFoundException e) {
			System.out.println("Error opening the file " + fileName);
			System.exit(0);
		}
		
		outputStream.close();
	}
}
