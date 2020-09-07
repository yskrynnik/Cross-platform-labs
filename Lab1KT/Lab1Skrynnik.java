/**
* This class demonstrates first java application
* @author Skrynnik Yehor y.skrynnik@student.csn.khai.edu
* @version 1.0
* @since 2020-06-09
*/
public class Lab1Skrynnik{ 
     /**
	* This method demonstrates student information
	* @param args Unused.
	*/
    public static void main (String[] args){
        String[] Text = new String[] { 
		"Group: 535a", 
		"Student: Skrynnik Yehor Igorevich",
		"Variant: 14",
		" *********    ************    *********",
		"***     ***   ************    *********",
		"**            ***                ***   ",
		" **           ***                ***   ",
        "  ********    ************       ***   ",
		"         **   ************       ***   ",
		"*        **   ***                ***   ",
		"**      **    ***                ***   ",
		" ********     ************    *********",
		"  ******      ************    *********"
		};
		for(String s : Text)
		{
			System.out.println(s);
		}
    }
}