import java.applet.*;
import java.io.File;
import java.net.*;

public class Play{

	private static Song sing= new Song();

	public static void play() throws InterruptedException,MalformedURLException {

			AudioClip clip = Applet.newAudioClip(new URL("file:clicker(rev).wav"));
			clip.loop();
			//System.out.println("test");
            Thread.sleep(50);
            clip.stop();

	}
	
	    public static void play2() throws InterruptedException,MalformedURLException {

            AudioClip clip = Applet.newAudioClip(new URL("file:clicker(rev(rev)).wav"));
            clip.loop();
            //System.out.println("test");
            Thread.sleep(50);
            clip.stop();

	}
	
	public static void met(double bpm) throws InterruptedException,MalformedURLException {
	do{
	play();
	Thread.sleep((long)(60000.0/bpm-90));

	} while(Main.exiter);
}

	public static void playAdv(double mult) throws InterruptedException,MalformedURLException {
		MeasureInfo mi = new MeasureInfo();
		int j = 0;
		//for (int j = 0; j< sing.sang.measureInfoList.size();j++){
		while(Main.exiter && j< sing.sang.measureInfoList.size()){
		
		int[] test = new int[2];
		mi = sing.sang.measureInfoList.get(j);
		test = mi.getMeasureStuff();
		int bpm1 = test[1];
		int numBeats = test[0];
		System.out.println("new measure: measure " + mi.getMeasureNum());

		for (int i =0;i<numBeats;i++){
		    
		    if (mi.getAccentedNoteBoolean(i) == true){
		        play();
		        Thread.sleep((long)(60000.0/mult/bpm1-90));
		    }
		    else{
		        play2();
		        Thread.sleep((long)(60000.0/mult/bpm1-90));
		    }
		    
		}
		j++;
		}

	}


}
