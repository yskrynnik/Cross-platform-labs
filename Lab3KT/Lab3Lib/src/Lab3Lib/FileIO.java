package Lab3Lib;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileIO {
    public static List<Integer> readFile(String path) throws IOException
    {
        List<Integer> list = new ArrayList<Integer>();
        FileInputStream inputStream = new FileInputStream(path);

        int readResult;
        do
        {
            readResult = inputStream.read();

            if (readResult != -1)
            {
                list.add(readResult);
            }

        }
        while (readResult != -1);

        return list;
    }
}
