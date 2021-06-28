
package timeformatter;




public class TimeFormatter {

    
    public static void main(String[] args) {
        
        System.out.println(duration(3662));
        
        
    }
    
    public static String duration(int sec)
    {
        
        int years = sec/31536000;
        int days = sec%31536000/86400;
        int hours = sec%31536000%86400/3600;
        int minutes = sec%3600/60;
        int secs = sec%3600%60;
        
        int[] dates ={years,days,hours,minutes,secs};
        String[] plural={"years","days","hours","minutes","seconds"};
        String[] singular={"year","day","hour","minute","second"};
        
        if (sec==0) {
            return "Now";
        }
        
        if (sec<0) {
            return "The input format is not appropriate.";
        }
        
        String out="";
        
        for (int i = 0; i < dates.length; i++) {
            
            if (dates[i]>0 && dates[i]==1) {
                
                out+=dates[i]+" "+singular[i]+", ";
                
            }
            
            else if (dates[i]>0) {
                
                out+=dates[i]+" "+plural[i]+", "; 
                
            }
        }
        
        
        out=out.substring(0,out.length()-2);
        
        if(out.length()>10){
            
            int endindex=out.lastIndexOf(" ");
            
            String temp=out.substring(0,endindex);
            
            int penult = temp.lastIndexOf(" ");
            
            out = out.substring(0,penult) + " and" + out.substring(penult,out.length());
            
            int commaindex = out.lastIndexOf(",");
            
            out = out.substring(0,commaindex) + out.substring(commaindex+1,out.length());
            
        }
        return out; 
    }
}
