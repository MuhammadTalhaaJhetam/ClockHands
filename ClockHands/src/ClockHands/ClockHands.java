package ClockHands;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ClockHands {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Scanner sc= null;
		
		File f= new File("times.txt");
		
		try {
			sc= new Scanner(f);
			
			int numOfTimes= sc.nextInt();
			
			String[] times= new String[numOfTimes];
			for(int i=0;i<numOfTimes;i++){
				times[i]=sc.next();
			}
			
			
			ArrayList<Double> timeAnswers=new ArrayList<Double>();
			double hours,minutes=0;
			for(String s:times){
				
				if(s.length()==5){
					 hours=Character.getNumericValue(s.charAt(0))*10 + Character.getNumericValue(s.charAt(1));
					 minutes=Character.getNumericValue(s.charAt(3))*10 + Character.getNumericValue(s.charAt(4));
					
				}else{
					 hours=Character.getNumericValue(s.charAt(0));
					 minutes=Character.getNumericValue(s.charAt(2))*10 + Character.getNumericValue(s.charAt(3));
				}
				
				
				//cos@ = a/h --->h=6 ---> hcos@=a -->6cos@=a
				double HourDegrees= ( (-(((hours+minutes/60)%12)-3))  *30);//360 degrees/12hrs = 30 Degrees for each hour & hours% 12= hour in 12 hr format for the clock face e.g 18% 12 =6
			
				double HourPositionY=0;
				double HourPositionX=0;
				
				if(HourDegrees>90 && HourDegrees<180){
					HourDegrees=180-HourDegrees;
					HourPositionX= 6* -Math.cos(Math.toRadians(HourDegrees))+10;
					 HourPositionY= 6* Math.sin(Math.toRadians(HourDegrees)) +10; 
				}else if(HourDegrees>180 && HourDegrees<270){
					HourDegrees=HourDegrees-180;
				
					HourPositionX= 6* -Math.cos(Math.toRadians(HourDegrees))+10;
					 HourPositionY= 6* -Math.sin(Math.toRadians(HourDegrees)) +10; 
				}else if(HourDegrees>270 && HourDegrees<360){
					HourDegrees=360-HourDegrees;
					
					HourPositionX= 6* Math.cos(Math.toRadians(HourDegrees))+10;
					 HourPositionY= 6* -Math.sin(Math.toRadians(HourDegrees)) +10;
				/*}else if(HourDegrees>0 && HourDegrees<90){
					//HourDegrees=90-HourDegrees;
					HourPositionY= 6* Math.cos(Math.toRadians(HourDegrees))+10;
					 HourPositionX= 6* Math.sin(Math.toRadians(HourDegrees)) +10;*/
				}else{
					HourPositionX= 6* Math.cos(Math.toRadians(HourDegrees))+10;
					 HourPositionY= 6* Math.sin(Math.toRadians(HourDegrees)) +10;
				}
				
				
				
				//sin@ =o/h --->h=6 ---> hsin@=o --->6sin@=o

				double MinuteDegrees= -(minutes-15)*6;//minutes never exceed 60 so no modding is required
				
				double MinutePositionX= 0;
				double MinutePositionY= 0;
				
				if(MinuteDegrees>90 && MinuteDegrees<180){
					MinuteDegrees=180-MinuteDegrees;
					MinutePositionX= 9* -Math.cos(Math.toRadians(MinuteDegrees))+10;
					MinutePositionY= 9* Math.sin(Math.toRadians(MinuteDegrees)) +10; 
				}else if(MinuteDegrees>180 && MinuteDegrees<270){//3rd quadrant
					MinuteDegrees=MinuteDegrees-180;
					MinutePositionX=9* -Math.cos(Math.toRadians(MinuteDegrees))+10;
					MinutePositionY= 9* -Math.sin(Math.toRadians(MinuteDegrees)) +10; 
				}else if(MinuteDegrees>270 &&MinuteDegrees<360){
					MinuteDegrees=360-MinuteDegrees;
					MinutePositionX= 9* Math.cos(Math.toRadians(MinuteDegrees))+10;
					MinutePositionY= 9* -Math.sin(Math.toRadians(MinuteDegrees)) +10;
				/*}else if(MinuteDegrees>0 && MinuteDegrees<90){
					MinuteDegrees=90-MinuteDegrees;
					MinutePositionY= 9* Math.cos(Math.toRadians(MinuteDegrees))+10;
					MinutePositionX= 9* Math.sin(Math.toRadians(MinuteDegrees)) +10;*/
				}
				else{
					MinutePositionX= 9* Math.cos(Math.toRadians(MinuteDegrees))+10;
					MinutePositionY= 9* Math.sin(Math.toRadians(MinuteDegrees)) +10;
				}
				timeAnswers.add(Math.round(HourPositionX*100000000d)/100000000d);
				timeAnswers.add(Math.round(HourPositionY*100000000d)/100000000d);
				timeAnswers.add(Math.round(MinutePositionX*100000000d)/100000000d);
				timeAnswers.add(Math.round(MinutePositionY*100000000d)/100000000d);
			}
			
			
			//print out answers
			for(int i=0;i<timeAnswers.size();i++){
				if(i%4==0){
					System.out.println(" ");
				}
				System.out.print(timeAnswers.get(i)+" ");
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
