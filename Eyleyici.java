
package nesne_proje;

public class Eyleyici implements ISogutucuAcmaIletici,ISogutucuKapatmaIletici, IObserver {
    
    
    private static Eyleyici eyleyici;
    private int durum = 0;
    
    private int calismaDurumu = 1;
    
    private Eyleyici()
    {
        
    }
    
    public static Eyleyici eyleyiciyeBaglan()
    {
        if(eyleyici == null){
         eyleyici = new Eyleyici();
       }
       
       return eyleyici;
    }
    
     @Override
    public void sogutucuyuAcBilgisiniIlet()
    {
        if(calismaDurumu == 1)
        {
            if(durum != 1)
            {
            System.out.println("sogutucu aciliyor");
            durum = 1;
            }
            else
            {
                System.out.println("Sogutucu zaten acik, lutfen baska bir islem deneyiniz");
            }
        }
        
        else
        {
            System.out.println("Hata alindi, tekrar deniyoruz");
        }
    }
    
     @Override
    public void sogutucuyuKapatBilgisiniIlet()
    {
        if(durum != 0)
        {
           System.out.println("sogutucu kapatiliyor");
           durum = 0;
        }
        
        else
        {
            System.out.println("Sogutucu zaten kapali, lutfen baska bir islem deneyiniz ");
        }
    }
    
      @Override
    public void update(String mesaj) {
        System.out.println("Eyleyici ile ilgili mesaj: " + mesaj);
    }
    
}