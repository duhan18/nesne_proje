
package nesne_proje;

import java.util.Random;

public class SicaklikAlgilayici implements IObserver {
    
    private static SicaklikAlgilayici sicaklikAlgilayici;
    
    private Random r=new Random();
    private int sicaklik;
    private int calismaDurumu = 1;
    
    
    private SicaklikAlgilayici()
    {  
         sicaklik = 25;   
    }
    
    public static SicaklikAlgilayici sicaklikAlgilayicisinaBaglan()
    {
        if(sicaklikAlgilayici == null){
         sicaklikAlgilayici = new SicaklikAlgilayici();
       }
       
       return sicaklikAlgilayici;
    }
    
    
    public void SicaklikOku ()
    {
        if(calismaDurumu == 1)
        {
         
        System.out.println("Sicaklik bilgisi sicaklik algilayicidan merkezi islem birimine iletildi");
        MerkeziIslemBirimi.merkeziIslemBirimineBaglan().sicaklikBilgisiniCevapla();
       
        sicaklik = r.nextInt(35);
        }
        
        else
        {
            System.out.println("Sicaklik algilanamadi, tekrar deniyoruz");
        }
       
    }
    
    public int SicakligiEkranaYaz()
    {
        return sicaklik;
    }
    
      @Override
    public void update(String mesaj)
    {
        System.out.println("SicaklikAlgilayici ile ilgili mesaj: " + mesaj);
    }
    
    
}
