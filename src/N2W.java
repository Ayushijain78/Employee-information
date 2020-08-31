
public class N2W 
{
	
		String toword(int n,int n1)
		{
			//int n=Integer.parseInt(s[0]);
			int n2=n1;
			int t=0;
			String word=" ";
			if(n>0)//1234>0
			{
				t=n/1000;//t=234
				if(t>0)//234>0
					word+=getword(t)+" thousand".toUpperCase();//
				n=n%1000;
				t=n/100;
				if(t>0)
					word+=getword(t)+" hundered".toUpperCase();
				n=n%100;
				if(n>0)
					word+=getword(n);
				if(n2>0)
					word+=paise(n2)+"paise".toUpperCase();

			}	
			else
				
					word=" zero";
					return word+" only";
			    
		}//end main
	 String getword(int t)//234
	{
		String[] d=new String[91];
		d[0]=" ";
		d[1]=" one";
		d[2]=" two";
		d[3]=" three";
		d[4]=" four";
		d[5]=" five";
		d[6]=" six";
		d[7]=" seven";
		d[8]=" eight";
		d[9]=" nine";
		d[10]=" ten";
		d[11]=" eleven";
		d[12]=" twelve";
		d[13]=" thirteen";
		d[14]=" fourteen";
		d[15]=" fifteen";
		d[16]=" sixteen";
		d[17]=" seventeen";
		d[18]=" eighteen";
		d[19]=" nineteen";
		d[20]=" twenty";
		d[30]=" thirty";
		d[40]=" fourty";
		d[50]=" fifty";
		d[60]=" sixty";
		d[70]=" seventy";
		d[80]=" eighty";
		d[90]=" ninty";

	String w="";
	if(t<=20||t%10==0)
		w=d[t];
	else
		w=d[t/10*10]+" "+d[t%10];//d[230]+d[4]

	return w.toUpperCase();

	}
	String paise(int n1)
	{
	String[] d=new String[10];

		d[0]=" zero";
		d[1]=" one";
		d[2]=" two";
		d[3]=" three";
		d[4]=" four";
		d[5]=" five";
		d[6]=" six";
		d[7]=" seven";
		d[8]=" eight";
		d[9]=" nine";

		String w1="";
	if(n1>0)
		w1=d[n1/10]+""+d[n1%10];
	return " "+"AND"+w1.toUpperCase()+" ";
	}


	}

