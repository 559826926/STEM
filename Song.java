import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Song{

    File db = new File("db.csv");

    static ArrayList<MeasureInfo> measures = new ArrayList<MeasureInfo>();
    String fullLine;
    String[] partialLine;
    int measureNumber = 1;

    static SongInfo sang = new SongInfo("Song", measures );
   
    public Song(){
    try{
        Scanner scan = new Scanner(db);
        while (scan.hasNextLine()){
            this.fullLine = scan.nextLine();
            this.partialLine  = fullLine.split(",");
            String timeSig = this.partialLine[2] + "/" + this.partialLine[3];
            boolean[] an = new boolean[Integer.parseInt(this.partialLine[2])];
            if (this.partialLine.length > 5){
                for (int j = 5; j < this.partialLine.length; j++){
                    an[Integer.parseInt(this.partialLine[j]) - 1] = true;
                }
            }
            sang.addMeasure(this.measureNumber,Integer.parseInt(this.partialLine[1]),Integer.parseInt(this.partialLine[2]),Integer.parseInt(this.partialLine[3]),timeSig, an);
            
            this.measureNumber +=1;
        }
    }
    catch (FileNotFoundException fe){
        System.out.print("");}

        System.out.println(sang);

    }


    


}
