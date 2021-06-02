package service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWrite {
   File file;
   FileWriter fileWrite;
   String fileNm = "D:\\result_file.txt"; //메모장 파일 경로, C 경로는 거부될 경우 있으니 다른 드라이브 추천
   
   public FileWrite()
   {
      file = new File(fileNm);
   }
   
   public void write(String text)
   {
      try {
         fileWrite = new FileWriter(file,true);
         
         fileWrite.write(text);
         fileWrite.flush();
         fileWrite.close();
      } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }   
   }
   
   
}