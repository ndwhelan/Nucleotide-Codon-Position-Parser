import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 
 * @author Nicholas Whelan
 *
 */
/**
The MIT License (MIT)

Copyright (c) 2012,2013 Nicholas Whelan

Permission is hereby granted, free of charge, to any person obtaining a copy of
this software and associated documentation files (the "Software"), to deal in
the Software without restriction, including without limitation the rights to
use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
the Software, and to permit persons to whom the Software is furnished to do so,
subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
*/
public class NucleotideFileThreesome {

	public static void main(String[] args) {
		if(args.length != 1) {
			System.out.println("Please specify the input file. ");
		}
		boolean exists = (new File(args[0])).exists();
		if (!exists) {
		    System.out.println("That file does not appear to exist.  Try including the fully qualified path, like 'C:\\genetic_shizzle.fasta' or /home/whatever/genetic_shizzle.fasta");
		    System.exit(-1);
		}
		
		try {
		    BufferedReader in = new BufferedReader(new FileReader(args[0]));
		    BufferedWriter out1 = new BufferedWriter(new FileWriter(args[0].substring(0, args[0].lastIndexOf(".")) + "_1.fasta"));
		    BufferedWriter out2 = new BufferedWriter(new FileWriter(args[0].substring(0, args[0].lastIndexOf(".")) + "_2.fasta"));
		    BufferedWriter out3 = new BufferedWriter(new FileWriter(args[0].substring(0, args[0].lastIndexOf(".")) + "_3.fasta"));
	        
	        String str;
		    int index = 1;
		    while ((str = in.readLine()) != null) {
		    	if(index % 2 == 1) {
		    		out1.append(str + "\n");
		    		out2.append(str + "\n");
		    		out3.append(str + "\n");
		    	}
		    	else
		    		processNucleotide(str, out1, out2, out3);
		    	index++;
		    }
		    in.close();
		    out1.close();
		    out2.close();
		    out3.close();
		    
		    System.out.println("Finished Successfully");
		} catch (IOException e) {
			System.out.println("The following exception occurred. Not sure why. You get what you pay for!");
			e.printStackTrace();
		}
	}
	
	public static void processNucleotide(String sequence, BufferedWriter out1, BufferedWriter out2, BufferedWriter out3) throws IOException{
		
		for(int x = 0; x < sequence.length(); x++) {
			if(x % 3 == 0)
				out1.append(sequence.charAt(x));
			if(x % 3 == 1)
				out2.append(sequence.charAt(x));
			if(x % 3 == 2)
				out3.append(sequence.charAt(x));
		}
		out1.append("\n");
		out2.append("\n");
		out3.append("\n");
	}
	
}
