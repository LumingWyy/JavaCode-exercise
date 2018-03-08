import java.util.*;

class Tmp1 {
    public static void main(String[] args)
        throws SyntaxErrorException, VMException, InterpreterException
    {
        String str = "";
        str += "v0 := 20000; ";
        str += "v1 := 0; ";
        str += "v2 := v0; ";
        str += "while v1 != v2 do ";
        str += "  if (v2-v1)%2 = 0 ";
        str += "    then v3 := v1+(v2-v1)/2; ";
        str += "    else v3 := v1+(v2-v1)/2+1; ";
        str += "  fi ";
        str += "  if v3*v3 > v0 ";
        str += "    then v2 := v3-1; ";
        str += "    else v1 := v3; ";
        str += "  fi ";
        str += "od";
        /*
        str += "v0 := 1; ";
        str += "for v1 1 10 do ";
        str += "  v0 := v1*v0; ";
        str += "od ";
        */
        /*
        str += "v0 := 1234567; ";
        str += "for v1 1 10 do ";
        str += "  v0 := v0%5; ";
        str += "  switch v0 do ";
        str += "    case 0: v0 := v0+1; ";
        str += "    case 1: v0 := v0+3; ";
        str += "    case 2: v0 := v0+2; ";
        str += "    case 3: v0 := v0*3; ";
        str += "    case 4: v0 := v0*4; ";
        str += "    default: v0 := 0; ";
        str += "  od ";
        str += "od ";
        */
        /*
        str += "v0,v1 := 3,4; ";
        str += "v0,v1 := v1,v0; ";
        */
        /*
        str += "v0,v1,v2,v3 := 3,4,5,6; ";
        str += "v0,v1,v2,v3 := v3,v2,v1,v0; ";
        */
        /*
        str += "v0,v1,v2,v3,v4,v5,v6,v7,v8,v9 := 7,4,1,5,9,0,6,3,2,8; ";
        str += "for v100 1 9 do ";
        str += "  if v0>v1 then v0,v1 := v1,v0; else fi ";
        str += "  if v1>v2 then v1,v2 := v2,v1; else fi ";
        str += "  if v2>v3 then v2,v3 := v3,v2; else fi ";
        str += "  if v3>v4 then v3,v4 := v4,v3; else fi ";
        str += "  if v4>v5 then v4,v5 := v5,v4; else fi ";
        str += "  if v5>v6 then v5,v6 := v6,v5; else fi ";
        str += "  if v6>v7 then v6,v7 := v7,v6; else fi ";
        str += "  if v7>v8 then v7,v8 := v8,v7; else fi ";
        str += "  if v8>v9 then v8,v9 := v9,v8; else fi ";
        str += "od ";
        */
        SourceCode sc = new SourceCode(str);
        TokenList tl = sc.scan();
        System.out.println(str);
        System.out.println(tl);
        StmParseTree pt = tl.parse();
        System.out.println(pt);
        List<Command> cl = pt.genCode();
        System.out.println(cl);
        int pc = 0;
        Stack<Integer> stk = new Stack<Integer>();
        HashMap<String,Integer> env = new HashMap<String,Integer>();
        VirtualMachine vm = new VirtualMachine(cl,pc,stk,env);
        System.out.println(vm.run());
        HashMap<String,Integer> env2 = new HashMap<String,Integer>();
        System.out.println(pt.interpret(env2));
        /*
        HashMap<String,Integer> env = new HashMap<String,Integer>();
        List<Command> cl = new ArrayList<Command>();
        int pc = 0;
        Stack<Integer> stk = new Stack<Integer>();
        HashMap<String,Integer> env = new HashMap<String,Integer>();

        cl.add(new Command(CommandName.PUSH,1));
        cl.add(new Command(CommandName.STORE,"v0"));
        cl.add(new Command(CommandName.PUSH,1));
        cl.add(new Command(CommandName.STORE,"v1"));
        cl.add(new Command(CommandName.LOAD,"v1"));
        cl.add(new Command(CommandName.PUSH,10));
        cl.add(new Command(CommandName.LT));
        cl.add(new Command(CommandName.LOAD,"v1"));
        cl.add(new Command(CommandName.PUSH,10));
        cl.add(new Command(CommandName.EQ));
        cl.add(new Command(CommandName.OR));
        cl.add(new Command(CommandName.CJMP,2));
        cl.add(new Command(CommandName.JMP,10));
        cl.add(new Command(CommandName.LOAD,"v0"));
        cl.add(new Command(CommandName.LOAD,"v1"));
        cl.add(new Command(CommandName.MUL));
        cl.add(new Command(CommandName.STORE,"v0"));
        cl.add(new Command(CommandName.LOAD,"v1"));
        cl.add(new Command(CommandName.PUSH,1));
        cl.add(new Command(CommandName.ADD));
        cl.add(new Command(CommandName.STORE,"v1"));
        cl.add(new Command(CommandName.JMP,-17));
        cl.add(new Command(CommandName.QUIT));

        System.out.println(cl);
        VirtualMachine vm = new VirtualMachine(cl,pc,stk,env);
        System.out.println(vm.run());
        */
    }
}
