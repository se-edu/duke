package Backend;

import Backend.Exceptions.DukeException;

import java.io.*;

public class Storage {

    private static final String dataDirname = "./data";
    private static final String dataPathname = "./data/duke.txt";
    private static final String helpPathname = "help.txt";

    public Storage(){}

    public static String loadDataFromFile() throws DukeException{
        return loadFromFile(dataPathname);
    }

    public static String loadHelpFromFile() throws DukeException {
        return loadFromFile( helpPathname );
    }

    public static void writeDataToFile( String data ) throws DukeException{
        writeToFile( data, dataDirname, dataPathname );
    }

    /**
     * loads file and returns contents
     * @return data string
     * @throws DukeException error reading file or no file exists
     */
    private static String loadFromFile(String pathname) throws DukeException {
        try {

            FileReader fileReader = new FileReader(pathname);
            System.out.println("Existing file found, loading...");

            int i = 0;
            String data = "";

            try {
                while (( i = fileReader.read()) != -1){
                    data += (char)i;
                }

                return data;

            } catch ( IOException e ){
                throw new DukeException(e);
            }

        } catch ( FileNotFoundException e ) {
            throw new DukeException(e);
        }

    }

    /**
     * Writes to a file
     * @param data long string separated by newline character
     * @throws DukeException error writing or closing file
     */
    private static void writeToFile( String data, String dirname, String pathname ) throws DukeException {

        //make directory
        File dir = new File(dirname);
        dir.mkdir();

        //write to file
        File saveFile = new File(pathname);
        FileWriter fileWriter = null;

        try {

            fileWriter = new FileWriter(saveFile);
            fileWriter.write(data);

        } catch (IOException e) {
            throw new DukeException(e);
        } finally {
            try {
                fileWriter.close();
            } catch ( IOException e ) {
                throw new DukeException(e);
            }
        }

    }

}
