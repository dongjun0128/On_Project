package service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWrite {
   File file;
   FileWriter fileWrite;
   String fileNm = "D:\\result_file.txt"; //�޸��� ���� ���, C ��δ� �źε� ��� ������ �ٸ� ����̺� ��õ
   
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