
public class Driver {

	public static void main(String[] args) {
		/*
		if(args.length == 0)
		{
			System.out.println("Error, no arguemnts given");
			System.exit(-1);
		}*/
	Stack stack_test = new Stack();
	stack_test.print_local_to_file_out();
	System.out.println("SP= " + stack_test.SP+"\n");
	System.out.println("Constant Test\n");
	System.out.println(stack_test.print_constant_to_file_out("5"));
	System.out.println("SP= " + stack_test.SP);
	System.out.println("Add Test\n");
	System.out.println(stack_test.print_add_to_file_out());	
	
	System.out.println("SP= " + stack_test.SP);
	
	System.out.println("Test pop to local 1:\n");
	
	System.out.println(stack_test.print_pop_local_to_file_out(7));

	
	
	}

}
