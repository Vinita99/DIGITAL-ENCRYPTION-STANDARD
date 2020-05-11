/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encryption;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import static javax.xml.crypto.KeySelector.Purpose.DECRYPT;
import static javax.xml.crypto.KeySelector.Purpose.ENCRYPT;

/**
 *
 * @author KOTRESHA
 */
public class desen {
    public static void encrypt(String key,InputStream is,OutputStream os) throws Exception
    {
        encryptorDecrypt(key,Cipher.ENCRYPT_MODE,is,os);
        
    }
    public static void decrypt(String key,InputStream is,OutputStream os)throws Exception{
        encryptorDecrypt(key,Cipher.DECRYPT_MODE,is ,os);
        
    }
    public static void encryptorDecrypt(String key,int mode,InputStream is,OutputStream os) throws Exception{
        DESKeySpec dks=new DESKeySpec(key.getBytes());
        SecretKeyFactory skf=SecretKeyFactory.getInstance("DES");
        SecretKey desKey=skf.generateSecret(dks);
        Cipher cipher=Cipher.getInstance("DES");
        
        if(mode==Cipher.ENCRYPT_MODE){
            cipher.init(Cipher.ENCRYPT_MODE, desKey);
            CipherInputStream cis=new CipherInputStream(is,cipher);
            makeFile(cis,os);
        }
        else if(mode==Cipher.DECRYPT_MODE){
            cipher.init(Cipher.DECRYPT_MODE, desKey);
            CipherOutputStream cos=new CipherOutputStream(os,cipher);
            makeFile(is,cos);
        }
        
        
    }
    public static void makeFile(InputStream is,OutputStream os) throws IOException{
        byte[] bytes=new byte[64];
        int numBytes;
        while((numBytes=is.read(bytes))!=-1){
            os.write(bytes,0,numBytes);
        }
        os.flush();
        os.close();
        is.close();
    }
    
}
