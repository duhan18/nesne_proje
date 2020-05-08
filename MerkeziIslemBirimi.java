
package nesne_proje;

public class MerkeziIslemBirimi implements ISicaklikIletici,ISicaklikCevaplayici,ISogutucuAcmaIletici,ISogutucuKapatmaIletici {
    
    ISubject publisher;
    
    private static MerkeziIslemBirimi merkeziIslemBirimi;
    
    private MerkeziIslemBirimi()
    {
        
    }
    
    public static MerkeziIslemBirimi merkeziIslemBirimineBaglan()
    {
        if(merkeziIslemBirimi == null){
         merkeziIslemBirimi = new MerkeziIslemBirimi();
       }
       
       return merkeziIslemBirimi;
    }
   
  
    
    @Override
    public void sicaklikBilgisiniIlet()
    {
        SicaklikAlgilayici.sicaklikAlgilayicisinaBaglan().SicaklikOku();
    }
    
    @Override
    public void sicaklikBilgisiniCevapla()
    {
        
        System.out.println("sicaklik bilgisi ag arayuzune iletildi");
        AgArayuzu.agArayuzuneBaglan().sicaklikBilgisiniCevapla();
     
    }
    
    @Override
    public void sogutucuyuAcBilgisiniIlet()
    {
        
        System.out.println("sogutucuyu acma bilgisi eyleyiciye iletildi");
        Eyleyici.eyleyiciyeBaglan().sogutucuyuAcBilgisiniIlet();
     
    }
    
    @Override
    public void sogutucuyuKapatBilgisiniIlet()
    {
        
        System.out.println("sogutucuyu kapatma bilgisi eyleyiciye iletildi");
        Eyleyici.eyleyiciyeBaglan().sogutucuyuKapatBilgisiniIlet();
     
    }
    
    public void calismaDurumuDuzenle(String durum)
    {    
	publisher.notify("Calısma Durumu: "+durum);            
    }
    
}
