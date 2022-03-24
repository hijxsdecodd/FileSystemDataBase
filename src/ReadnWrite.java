import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Class that allows us to write and read a file.
 * @version 23/03/2022
 */
public class ReadnWrite {

	protected File file;

	/**
	 * Create a new ReadnWriter object.
	 * @param name names file
	 */
	public ReadnWrite(String name) {
		this.file = new File(name);

	}

	/**
	 * Write the data in the file.
	 * @param line the data.
	 */
	public void write(String line) {
        FileWriter writer;

        try {

            writer = new FileWriter(file); 
            writer.write(line); 
            writer.close();

        } catch (IOException e) { System.out.println(e.getMessage()); }
    }

	/**
	 * Read the data in the file.
	 * @return the data.
	 * @throws FileNotExists in case the file is not found.
	 */
    public String[] read() throws FileNotExists {
    	Scanner sc = null;
		
		String line = "";
	
		try {
	            sc = new Scanner(file);

	            while (sc.hasNextLine()) {
	            	line += sc.nextLine() + "|";
	            }

		} catch (FileNotFoundException e) {
	            throw new FileNotExists("There's nothing to read");
	        }

		String others [] = line.split("\\|");
		return others;
    }

}