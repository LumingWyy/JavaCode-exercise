import java.util.*;

public class VirtualMachine {
	private List<Command> comList;
	private Integer pc;
	private Stack<Integer> stk;
	private Map<String, Integer> env;

	public VirtualMachine(List<Command> cl) {
		comList = cl;
	}

	public VirtualMachine(List<Command> cl, Integer pc, Stack<Integer> stk, Map<String, Integer> env) {
		comList = cl;
		this.pc = pc;
		this.stk = stk;
		this.env = env;
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
		return "pc: " + pc + ", stack: " + stk + ", env: " + env + ", cl: " + comList;

	}

	public Map<String, Integer> run() throws VMException {
		Command com = comList.get(pc);
		Integer n2;
		Integer n1;
		Integer n;
		while (true) {
			if (pc < 0 || pc >= comList.size()) {
				throw new VMException(pc, comList.size());
			}
			// com = comList.get(pc);
			switch (com.getName()) {
			case PUSH:
				n = com.getNum();
				stk.push(n);
				pc++;
				break;
			case CJMP:
				if (stk.isEmpty()) {
					throw new VMException(stk);
				}
				n = com.getNum();
				int c = stk.pop();
				if (c != 0) {
					pc = pc + n;
				} else {
					pc = pc + 1;
				}
				break;
			case JMP:
				// if (stk.isEmpty()) {
				// throw new VMException(stk);
				// }
				n = com.getNum();
				pc = pc + n;
				break;
			case LOAD:
				if (!env.containsKey(com.getVar())) {
					throw new VMException();
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
			case NEQ:
				if (stk.size() < 2) {
					throw new VMException(stk);
				}
				n2 = stk.top();
				stk.pop();
				n1 = stk.top();
				stk.pop();
				n = (n1 == n2 ? 0 : 1);
				stk.push(n);
				pc++;
				break;
			case EQ:
				if (stk.size() < 2) {
					throw new VMException(stk);
				}
				n2 = stk.top();
				stk.pop();
				n1 = stk.top();
				stk.pop();
				n = (n1 == n2 ? 1 : 0);
				stk.push(n);
				pc++;
				break;
			case OR:
				if (stk.size() < 2) {
					throw new VMException(stk);
				}
				n2 = stk.top();
				stk.pop();
				n1 = stk.top();
				stk.pop();
				n = (n1 == 0 ? (n2 == 0 ? 0 : 1) : 1);
				stk.push(n);
				pc++;
				break;
			case LT:
				if (stk.size() < 2) {
					throw new VMException(stk);
				}
				n2 = stk.top();
				stk.pop();
				n1 = stk.top();
				stk.pop();
				n = n1 < n2 ? 1 : 0;
				stk.push(n);
				pc++;
				break;
			case GT:
				if (stk.size() < 2) {
					throw new VMException(stk);
				}
				n2 = stk.top();
				stk.pop();
				n1 = stk.top();
				stk.pop();
				n = n1 > n2 ? 1 : 0;
				stk.push(n);
				pc++;
				break;
			case AND:
				if (stk.size() < 2) {
					throw new VMException(stk);
				}
				n2 = stk.top();
				stk.pop();
				n1 = stk.top();
				stk.pop();
				n = (n1 == 0 ? 0 : (n2 == 0 ? 0 : 1));
				stk.push(n);
				pc++;
				break;
			case QUIT:
				// if (stk.size() != 1) {
				// throw new VMException(stk, stk.size());
				// }
				// n = stk.top();
				// stk.pop();
				// env.put(com.getVar(), n);
				return env;
			default:
				throw new IllegalStateException("pc1: " + pc + " cl1: " + comList);
			}
		}
	}
}