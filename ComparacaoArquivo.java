import java.io.DataInputStream;
import java.io.FileInputStream;

import org.omg.CORBA_2_3.portable.InputStream;

public class ComparacaoArquivo {

    public static void main(String[] args)  throws Exception {

        DataInputStream arquivo1 = new DataInputStream(new FileInputStream("./arquivo1.txt"));
        DataInputStream arquivo2 = new DataInputStream(new FileInputStream("./arquivo2.txt"));

        byte byte1 = 0;
        byte byte2 = 0;
        int cont = 0;
        boolean EOF = false;

        byte1 = byte2;

        while (byte1 == byte2 && !EOF) {
            
            try{
                byte1 = arquivo1.readByte();
            }catch(Exception e){
                EOF = true;
            }
          
            try{
                byte2 = arquivo2.readByte();
            }catch(Exception e){
                EOF = true;
            }
            
           cont += 1;                 
        }

        if(byte1 == byte2)
        System.out.println("Os arquivos são iguais");
        else
        System.out.println("Os arquivos são diferentes na posição: " + cont);

        arquivo1.close();
        arquivo2.close();
    }
}
