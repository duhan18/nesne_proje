
package nesne_proje;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import java.util.ArrayList;
//import java.sql.*;


public class KullaniciVeritabani {
   
    private static KullaniciVeritabani veritabani;
    public static InternetKullanicisi kullanici;
    
    private String ad;
    private String sifre;
    
    private ArrayList<String> kullaniciBilgileri = new ArrayList<String>();
    
    private KullaniciVeritabani(){
    
    try
        {   
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/nesne_proje", "postgres", "123456");
            if (conn != null)
                System.out.println("Veritabanına bağlandı!");
            else
                System.out.println("Bağlantı girişimi başarısız!");


            String sql= "SELECT \"KullaniciAdi\", \"Sifre\" FROM \"InternetKullanicilari\"";

            /***** Sorgu çalıştırma *****/
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            /***** Bağlantı sonlandırma *****/
            conn.close();
            
           
            kullanici = new InternetKullanicisi();
          
            int kontrol = 0;
           
            System.out.println("Lutfen giris yapmak icin bilgilerinizi giriniz");
            
        do{    
            System.out.print("Kullanici adinizi girin: \n");
            Scanner girdi = new Scanner(System.in);
            
            ad=girdi.nextLine();
            
            System.out.print("Sfrenizi girin: \n");
            Scanner girdi2 = new Scanner(System.in);
            
            sifre=girdi2.nextLine();
           
           
            while(rs.next())
            {
                kullaniciBilgileri.add(rs.getString("KullaniciAdi"));
                kullaniciBilgileri.add(rs.getString("Sifre"));
            }
            
            for(int i = 0; i < kullaniciBilgileri.size(); i++ )
            {
                if(ad.equals(kullaniciBilgileri.get(i)))
                {
                    if(sifre.equals(kullaniciBilgileri.get(i+1)))
                    {
                        System.out.println("Bilgiler dogrulandi, lutfen bekleyin...");
                        kontrol = 1;
                    }
                }
            }
            
            if(kontrol == 0)
            {
                System.out.println("Girilen bilgiler yanlis, kontrol edip tekrar deneyin");
            }
            
           }while(kontrol == 0);
        
            kullanici.setKullaniciAdi(ad);
            kullanici.setSifre(sifre);
            
            /***** Kaynakları serbest bırak *****/
            rs.close();
            stmt.close();
        }
    
        catch (Exception e)
        {
            e.printStackTrace();
        }
   
    
    }
    
    public static KullaniciVeritabani veritabaninaBaglan()
    {
       if(veritabani == null){
         veritabani = new KullaniciVeritabani();
       }
       
       return veritabani;
    }  
    
}
