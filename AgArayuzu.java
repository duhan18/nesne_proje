
package nesne_proje;

import java.util.Scanner;

public class AgArayuzu implements ISogutucuAcmaIletici,ISogutucuKapatmaIletici,ISicaklikCevaplayici {
    
    private static AgArayuzu agArayuzu;
    Publisher p = new Publisher();
    
    private int calismaDurumu = 1;
    
    private AgArayuzu()
    {
        
    }
    
    public static AgArayuzu agArayuzuneBaglan()
    {
        if(agArayuzu == null){
         agArayuzu = new AgArayuzu();
       }
       
       return agArayuzu;
    }
    
    public void SicaklikGonder()
    {
        System.out.println("Sicaklik goruntuleme istegi ag arayuzunden merkezi islem birimine iletildi");
        MerkeziIslemBirimi.merkeziIslemBirimineBaglan().sicaklikBilgisiniIlet();
    }
   
    @Override
    public void sicaklikBilgisiniCevapla()
    {
        if(calismaDurumu == 1)
        {
          System.out.println("sicaklik bilgisi kullaniciya gosteriliyor");
          System.out.println("Ortamin sicakligi: " + SicaklikAlgilayici.sicaklikAlgilayicisinaBaglan().SicakligiEkranaYaz() + " derece");
        }
        
        else
        {
            System.out.println("hata alindi, tekrar deniyoruz");
        }
    }
    
    @Override
    public void sogutucuyuAcBilgisiniIlet()
    {
        System.out.println("Sogutucuyu acma istegi ag arayuzunden merkezi islem birimine iletildi");
        MerkeziIslemBirimi.merkeziIslemBirimineBaglan().sogutucuyuAcBilgisiniIlet();
    }
    
    @Override
    public void sogutucuyuKapatBilgisiniIlet()
    {
        System.out.println("Sogutucuyu kapatma istegi ag arayuzunden merkezi islem birimine iletildi");
        MerkeziIslemBirimi.merkeziIslemBirimineBaglan().sogutucuyuKapatBilgisiniIlet();
    }
    
    public void basla()
    {
        KullaniciVeritabani.veritabaninaBaglan();
     
        System.out.println("Sisteme giris yapildi, lutfen yapmak istediginiz islemi girin");
     
        int cevap;
        int cikis = 0;
        do{
            
            System.out.println("1: Sicakligi goruntule ");
            System.out.println("2: Sogutucuyu ac ");
            System.out.println("3: Sogutucuyu kapat ");
            System.out.println("4: Sistemi kapat ");
            
            Scanner girdi = new Scanner(System.in);
            cevap = girdi.nextInt();
            
            switch(cevap)
            {
                case 1:
                     
                    AgArayuzu.agArayuzuneBaglan().SicaklikGonder();
                  
           break;
                case 2:
                    
                    AgArayuzu.agArayuzuneBaglan().sogutucuyuAcBilgisiniIlet();
                    
              break;
                case 3:
                    
                    AgArayuzu.agArayuzuneBaglan().sogutucuyuKapatBilgisiniIlet();
             
              break;       
                case 4:
                    
                    System.out.println("---Sistem Bilgileri---");
                    
                    p.attach(Eyleyici.eyleyiciyeBaglan());
                    p.attach(SicaklikAlgilayici.sicaklikAlgilayicisinaBaglan());
                    MerkeziIslemBirimi.merkeziIslemBirimineBaglan().publisher = p;
                    MerkeziIslemBirimi.merkeziIslemBirimineBaglan().calismaDurumuDuzenle("pasif");
                    p.detach(Eyleyici.eyleyiciyeBaglan());
                    p.detach(SicaklikAlgilayici.sicaklikAlgilayicisinaBaglan());
                    
                    cikis  = 1;
                    
              break;      
            }
            
        }while(cikis != 1);
    }
}
