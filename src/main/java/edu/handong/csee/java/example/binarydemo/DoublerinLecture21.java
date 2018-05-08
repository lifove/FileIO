package edu.handong.csee.java.example.binarydemo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class DoublerinLecture21 {
	
	ArrayList<Integer> numbersFromBinaryFile = new ArrayList<Integer>();

	public static void main(String[] args) {
		DoublerinLecture21 demonstraotor = new DoublerinLecture21();
		demonstraotor.run();

	}

	private void run() {
		String biranyFileName = "out.dat";
		try {
			ObjectInputStream stream = new ObjectInputStream(new FileInputStream(biranyFileName));
			
			int anInteger = stream.readInt();;
			while(anInteger >=0) {
				numbersFromBinaryFile.add(anInteger);
				anInteger = stream.readInt();
			}
			stream.close();
			
			ArrayList<Integer> doubledNumbers = doubleIntNumbers();
			
			// to save doubledNumbers into a file name, doubledOut.dat
			String finalOutBinaryFile = "doubledOut.dat";
			
			ObjectOutputStream outStream = new ObjectOutputStream(new FileOutputStream(finalOutBinaryFile));
			
			for(int currentDoubledInt:doubledNumbers) {
				outStream.writeInt(currentDoubledInt);
			}
			
			outStream.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private ArrayList<Integer> doubleIntNumbers() {
		ArrayList<Integer> doubledNumbers = new ArrayList<Integer>();
		
		for(Integer currentInt:numbersFromBinaryFile) {
			doubledNumbers.add(currentInt*2);
		}
		
		return doubledNumbers;
	}

}
