public class Command {
    private CommandName name;
    private int num;

    public Command(CommandName n) {
        name = n;
    }

    public Command(CommandName n, int x) {
        name = n;
        num = x;
    }

    public CommandName getName() { 
    	return name; 
    }
    public int getNum() { 
    	return num; 
    }

    public String toString() throws IllegalStateException {
        switch (name) {
        case PUSH: 
        	return "push(" + num + ")";
        case MUL: 
        	return "mul";
        case QUO: 
        	return "quo";
        case ADD: 
        	return "add";
        case SUB: 
        	return "sub";
        case QUIT: 
        	return "quit";
        default:
            // You never get here!
            throw new IllegalStateException("command(" + num + ")");
        }
    }
}
