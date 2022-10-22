package sample;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class DictionarySaver {

    private HashMap<String, String> dicList;
    DictionarySaver(HashMap<String, String> dicList)
    {
        this.dicList=dicList;

    }
    HashMap<String,String> getDicList()
    {
        return dicList;
    }

    void addWord(String word, String meaning)
    {
        dicList.put(word,meaning);
    }

    void serializeHashMap()
    {
        try {
            FileOutputStream fos
                    = new FileOutputStream("dicListData");

            ObjectOutputStream oos
                    = new ObjectOutputStream(fos);

            oos.writeObject(dicList);
            oos.close();
            fos.close();

//                System.out.println("namesList serialized");
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
    void deserializeHashMap()
    {
        try
        {
            // Reading the object from a file
            FileInputStream file = new FileInputStream("dicListData");
            ObjectInputStream in = new ObjectInputStream(file);
            dicList = (HashMap<String, String>) in.readObject();


            in.close();
            file.close();

//            System.out.println("Object has been deserialized ");

        }

        catch(IOException ex)
        {
            System.out.println("IOException is caught");
        }

        catch(ClassNotFoundException ex)
        {
            System.out.println("ClassNotFoundException is caught");
        }
    }

}

