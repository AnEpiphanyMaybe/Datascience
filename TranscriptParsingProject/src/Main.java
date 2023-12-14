import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String file = readFile("data/sample01.vtt");
        String[] lines = file.split("\n");
        ArrayList<String> timeList = new ArrayList<>();
        ArrayList<String> textList = new ArrayList<>();
        ArrayList<String> nameList = new ArrayList<>();
        ArrayList<String> speakerList = new ArrayList<>();
        ArrayList<Double> timesList = new ArrayList<>();
        for (int i = 2; i < lines.length; i=i+4) {
            if(lines[i+1].contains(">") && lines[i+2].contains(": ")){
                timeList.add(lines[i+1]);
                textList.add(lines[i+2]);
            }
        }
        nameList = names(textList);
        //System.out.println(speakerswitch(nameList));
        timesList = gettime(timeList);
        speakerList = givelistspeaker(nameList);
        for (int i = 0; i < timesList.size(); i++) {
            System.out.println(timesList.get(i));
            // System.out.println(nameList.get(i));
        }


    }
    public static ArrayList<String> names(ArrayList<String> people){
        ArrayList<String> names = new ArrayList<>();
        for (int i = 0; i < people.size(); i++) {
            int endofname = (people.get(i)).indexOf(":");
            String name = (people.get(i)).substring(0, endofname);
            names.add(name);
        }
        return names;
    }

    public static int speakerswitch(ArrayList<String> names){
        int counter = 0;
        for (int i = 0; i < names.size()-1; i++) {
            if(!((names.get(i)).equals(names.get(i+1)))){
                counter++;
            }
        }return counter;
    }

    public static ArrayList<String> givelistspeaker(ArrayList<String> names){
        ArrayList<String> speakers = new ArrayList<>();
        for (int i = 0; i < names.size(); i++) {
            String currname = names.get(i);
            int counter = 0;
            for (int j = 0; j < speakers.size(); j++) {
                if(!(currname.equals(speakers.get(j)))){
                    counter++;

                }
            }
            if(counter == speakers.size()){
                speakers.add(currname);
            }
        }

        return speakers;

    }






    public static ArrayList<Double> gettime(ArrayList<String> timelist){
        ArrayList<Double> timecurrlist = new ArrayList<>();
        for (int i = 0; i < timelist.size(); i++) {
            String currtimes = timelist.get(i);
            double beginningtimemin = Double.parseDouble(currtimes.substring(3,5));
            double beginningtimesec = Double.parseDouble(currtimes.substring(7,12));
            double totalbeginningtime = (beginningtimemin*60)+beginningtimesec;
            double endtimemin = Double.parseDouble(currtimes.substring(20,22));
            double endtimesec = Double.parseDouble(currtimes.substring(23));
            double totalendtime = (endtimemin*60)+endtimesec;
            double totaltime=(totalendtime-totalbeginningtime);
            timecurrlist.add(totaltime);
        }
        return timecurrlist;

    }













    private static String readFile(String filePath) {
        StringBuilder sb = new StringBuilder();

        try (BufferedReader br = Files.newBufferedReader(Paths.get(filePath))) {

            String line = br.readLine();
            while ( line != null) {
                sb.append(line).append(System.getProperty("line.separator"));
                line = br.readLine();
            }

        } catch (Exception errorObj) {
            System.err.println("Couldn't read file: " + filePath);
            errorObj.printStackTrace();
        }

        return sb.toString();
    }
}