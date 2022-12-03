import java.util.*;
import java.lang.*;
import java.io.*;
import java.io.BufferedReader;
import java.io.FileReader;


public class Main
{
        public static void main (String[] args) throws IOException {

        FileReader f = new FileReader("Stop Words.txt");
        BufferedReader b = new BufferedReader(f);
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        String line;

        while ((line = b.readLine()) != null)
        {
            hm.put(line,1);
        }

        TreeMap<StringBuffer, Integer> tm = new TreeMap<StringBuffer, Integer>();

        f = new FileReader("Friendship is all we need.txt");


        while((line = b.readLine()) != null)
        {
            String[] words = line.split("");
            for(int i=0; i<words.length; i++)
            {
                StringBuffer str = new StringBuffer(words[i]);
                for(int j=0;j<str.length();j++)
                {
                    if(str.charAt(j)>='A' && str.charAt(j)<='Z')
                    {
                        Character c = str.charAt(j);
                        str.replace(i,i+1,Character.toLowerCase(c) + "");
                    }
                    else if(str.charAt(j)>='a' && str.charAt(j)<='z')
                    {
                        continue;
                    }
                    else
                    {
                        str.delete(j,j+1);
                    }
                }
                if(hm.get(str) == null)
                {
                    if(tm.get(str) == null)
                        tm.put(str,1);
                    else
                    {
                        int count = tm.get(str) + 1;
                        tm.put(str,count);
                    }
                }
            }
        }
        for(Map.Entry<StringBuffer, Integer> entry: tm.entrySet())
        {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}