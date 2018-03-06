import java.util.*;

public class VirtualMachine {
	private List<Command> comList;
	private Integer pc;
	private Stack<Integer> stk;
	private Map<String, Integer> env;

	public VirtualMachine(List<Command> cl) {
		comList = cl;
	}

	public void reset(Integer pc, Stack<Integer> stk, Map<String, Integer> env) {
		this.pc = pc;
		this.stk = stk;
		this.env = env;
	}

	public List<Command> getComList() {
		return comList;
	}

	public String toString() {
		return "comList: " + comList.toString() + "  pc: " + pc + " stk: " + stk.toString() + " env: " + env.toString();

	}

	public Map<String, Integer> run() throws VMException {
		Command com;
		Integer n2;
		Integer n1;
		Integer n;
		while (true) {
			if (pc < 0 || pc >= comList.size()) {
				throw new VMException(pc, comList.size());
			}
			com = comList.get(pc);
			switch (com.getName()) {
			case PUSH:
				n = com.getNum();
				stk.push(n);
				pc++;
				break;
			case LOAD:
				if (!env.containsKey(com.getVar())) {
					throw new NullPointerException();
				}
				n = env.get(com.getVar());
				stk.push(n);
				pc++;
				break;
			case STORE:
				if (stk.isEmpty()) {
					throw new VMException(stk);
				}
				n = stk.pop();
				env.put(com.getVar(), n);
				pc++;
				break;
			case MONE:
				if (stk.isEmpty()) {
					throw new VMException(stk);
				}
				n = stk.pop();
				stk.push(-n);
				pc++;
				break;
			case MUL:
				if (stk.size() < 2) {
					throw new VMException(stk);
				}
				n2 = stk.top();
				stk.pop();
				n1 = stk.top();
				stk.pop();
				n = n1 * n2;
				stk.push(n);
				pc++;
				break;
			case QUO:
				if (stk.size() < 2) {
					throw new VMException(stk);
				}
				n2 = stk.top();
				stk.pop();
				n1 = stk.top();
				stk.pop();
				if (n2 == 0) {
					throw new VMException();
				}
				n = n1 / n2;
				stk.push(n);
				pc++;
				break;
			case REM:
				if (stk.size() < 2) {
					throw new VMException(stk);
				}
				n2 = stk.top();
				stk.pop();
				n1 = stk.top();
				stk.pop();
				if (n2 == 0) {
					throw new VMException();
				}
				n = n1 % n2;
				stk.push(n);
				pc++;
				break;
			case ADD:
				if (stk.size() < 2) {
					throw new VMException(stk);
				}
				n2 = stk.top();
				stk.pop();
				n1 = stk.top();
				stk.pop();
				n = n1 + n2;
				stk.push(n);
				env.put(com.getVar(), n);
				pc++;
				break;
			case SUB:
				if (stk.size() < 2) {
					throw new VMException(stk);
				}
				n2 = stk.top();
				stk.pop();
				n1 = stk.top();
				stk.pop();
				n = n1 - n2;
				stk.push(n);
				pc++;
				break;
			case QUIT:
				if (stk.size() != 1) {
					throw new VMException(stk, stk.size());
				}
				n = stk.top();
				stk.pop();
				env.put(com.getVar(), n);
				return env;
			default:
				throw new IllegalStateException("pc1: " + pc + " cl1: " + comList);
			}
		}
	}
}