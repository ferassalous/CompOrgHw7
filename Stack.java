import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Stack {
	int SP; // stack pointer
	public int[] stack; // stack array
	int size; // size for array
	String filename;
	ArrayList<String> commands;
	
	String local = "@LCL\n";

	String sP = "@SP\n";
	String m_equals_d = "M=D\n";
	String m_equals_m_plus_1 = "M=M+1\n";
	String m_equals_m_minus_1 = "M=M-1\n";
	String d_equals_a = "D=A\n";
	String a_equals_m = "A=M\n";
	String d_equals_m = "D=M\n";
	String a_equals_a_minus_1 = "A=A-1\n";
	String m_equals_d_plus_m = "M=D+M\n";
	String a_equals_m_plus_1 = "A=M+1\n";
	

	
	
	
	public Stack(String incoming_file_name) throws IOException {
		size = 0;
		SP = 256;
		stack = new int[size];
		filename = incoming_file_name;
		commands = readFile(incoming_file_name);
	}

	public Stack() {
		SP=256;
	}

	public void push() {

	}

	public void pop() {

	}
	
	public ArrayList<String>readFile(String fileName) throws IOException
	{
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		String data;
		
		data = br.readLine();
		while(data != null)
		{
			data = data.trim();
			int index = data.indexOf("//"); //
			if(index > 0)
			{
				data = data.substring(0, index).trim();
			}
			if(data.startsWith("//")) // if the line starts with //
			{
				data = br.readLine();
				continue;
			}
			else if(data.isEmpty()) // if the line is empty
			{
				data = br.readLine();
				continue;
			}
			else
			{
				data = br.readLine();
				
			}
			
			br.close();
		}
		return null;
	}
	// print local to file... 
	public void print_local_to_file_out()
	{
		local = "@LCL\n";
		System.out.println(local+a_equals_m+d_equals_m+sP+a_equals_m+m_equals_d
				+sP+m_equals_m_plus_1);
		++SP;
		
	}
	
	public String print_constant_to_file_out(String num)
	{
		String constantVal = "@" + num + "\n";
		constantVal = constantVal+d_equals_a+sP+a_equals_m+m_equals_d+
				sP+m_equals_m_plus_1;
		++SP;
		return constantVal;	
	}
	public String print_add_to_file_out()
	{
		String print_add_to_file_out;
		//Step 1
		print_add_to_file_out = sP+ m_equals_m_minus_1+ a_equals_m+ d_equals_m;
		--SP;
		//Step 2
		print_add_to_file_out+=(a_equals_a_minus_1 + m_equals_d_plus_m);
		// Pop decrement SP to local 
		print_add_to_file_out+=(sP+ m_equals_m_minus_1 + a_equals_m + d_equals_m);
		--SP;
		return print_add_to_file_out;
	}
	
	public String print_pop_local_to_file_out(int num)
	{
		//String toSend;
		for(int i = 1; i <= num; ++i)
		{
			
			local+=(a_equals_m_plus_1);
		}
			local+= m_equals_d;
		return local;
	}
	
	
	
	
	
	
	

}
