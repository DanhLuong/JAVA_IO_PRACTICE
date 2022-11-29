import java.io.*;
import java.sql.SQLOutput;

public class CopyBytes {
    public static void copy(String sourcePath, String destinationPath) throws IOException {
        FileInputStream inStream = null;
        FileOutputStream outStream = null;
        int temp;
        try {
            File outFile = new File(destinationPath);
            if(!outFile.exists()) {
                inStream = new FileInputStream(sourcePath);
                outStream = new FileOutputStream(destinationPath);
                while ((temp=inStream.read())!=-1) {
                    outStream.write(temp);
                }
            }else {
                System.out.println("Error: Duplicate name. Can not copy.");
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }finally {
            if (inStream!=null) {
                inStream.close();
            }
            if(outStream!=null){
                outStream.close();
            }
        }
    }
}
