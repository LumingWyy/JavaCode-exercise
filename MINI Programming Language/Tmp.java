import java.util.*;

class Tmp {
    public static void main(String[] args)
        throws SyntaxErrorException, InterpreterException
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
        str += "v0 := 1; ";
        str += "v1 := 1; ";
        str += "while v1 < 10 || v1 = 10 do ";
        str += "  v0 := v0*v1; ";
        str += "  v1 := v1+1; ";
        str += "od ";
        */
        SourceCode sc = new SourceCode(str);
        TokenList tl = sc.scan();
        System.out.println(str);
        System.out.println(tl);
        StmParseTree pt = tl.parse();
        System.out.println(pt);
        HashMap<String,Integer> env = new HashMap<String,Integer>();
        System.out.println(pt.interpret(env));
        /*
        TokenList tl = new TokenList();
        tl.init();
        tl.add(new Token(TokenName.VAR,"v0"));
        tl.add(new Token(TokenName.ASSIGN));
        tl.add(new Token(TokenName.NUM,20000));
        tl.add(new Token(TokenName.SEMC));
        tl.add(new Token(TokenName.VAR,"v1"));
        tl.add(new Token(TokenName.ASSIGN));
        tl.add(new Token(TokenName.NUM,0));
        tl.add(new Token(TokenName.SEMC));
        tl.add(new Token(TokenName.VAR,"v2"));
        tl.add(new Token(TokenName.ASSIGN));
        tl.add(new Token(TokenName.VAR,"v0"));
        tl.add(new Token(TokenName.SEMC));
        tl.add(new Token(TokenName.WHILE));
        tl.add(new Token(TokenName.VAR,"v1"));
        tl.add(new Token(TokenName.NEQ));
        tl.add(new Token(TokenName.VAR,"v2"));
        tl.add(new Token(TokenName.DO));
        tl.add(new Token(TokenName.IF));
        tl.add(new Token(TokenName.LPAR));
        tl.add(new Token(TokenName.LPAR));
        tl.add(new Token(TokenName.VAR,"v2"));
        tl.add(new Token(TokenName.MINUS));
        tl.add(new Token(TokenName.VAR,"v1"));
        tl.add(new Token(TokenName.RPAR));
        tl.add(new Token(TokenName.REM));
        tl.add(new Token(TokenName.NUM,2));
        tl.add(new Token(TokenName.RPAR));
        tl.add(new Token(TokenName.EQ));
        tl.add(new Token(TokenName.NUM,0));
        tl.add(new Token(TokenName.THEN));
        tl.add(new Token(TokenName.VAR,"v3"));
        tl.add(new Token(TokenName.ASSIGN));
        tl.add(new Token(TokenName.VAR,"v1"));
        tl.add(new Token(TokenName.PLUS));
        tl.add(new Token(TokenName.LPAR));
        tl.add(new Token(TokenName.VAR,"v2"));
        tl.add(new Token(TokenName.MINUS));
        tl.add(new Token(TokenName.VAR,"v1"));
        tl.add(new Token(TokenName.RPAR));
        tl.add(new Token(TokenName.QUO));
        tl.add(new Token(TokenName.NUM,2));
        tl.add(new Token(TokenName.SEMC));
        tl.add(new Token(TokenName.ELSE));
        tl.add(new Token(TokenName.VAR,"v3"));
        tl.add(new Token(TokenName.ASSIGN));
        tl.add(new Token(TokenName.VAR,"v1"));
        tl.add(new Token(TokenName.PLUS));
        tl.add(new Token(TokenName.LPAR));
        tl.add(new Token(TokenName.LPAR));
        tl.add(new Token(TokenName.VAR,"v2"));
        tl.add(new Token(TokenName.MINUS));
        tl.add(new Token(TokenName.VAR,"v1"));
        tl.add(new Token(TokenName.RPAR));
        tl.add(new Token(TokenName.QUO));
        tl.add(new Token(TokenName.NUM,2));
        tl.add(new Token(TokenName.RPAR));
        tl.add(new Token(TokenName.PLUS));
        tl.add(new Token(TokenName.NUM,1));
        tl.add(new Token(TokenName.SEMC));
        tl.add(new Token(TokenName.FI));
        tl.add(new Token(TokenName.IF));
        tl.add(new Token(TokenName.VAR,"v3"));
        tl.add(new Token(TokenName.MUL));
        tl.add(new Token(TokenName.VAR,"v3"));
        tl.add(new Token(TokenName.GT));
        tl.add(new Token(TokenName.VAR,"v0"));
        tl.add(new Token(TokenName.THEN));
        tl.add(new Token(TokenName.VAR,"v2"));
        tl.add(new Token(TokenName.ASSIGN));
        tl.add(new Token(TokenName.VAR,"v3"));
        tl.add(new Token(TokenName.MINUS));
        tl.add(new Token(TokenName.NUM,1));
        tl.add(new Token(TokenName.SEMC));
        tl.add(new Token(TokenName.ELSE));
        tl.add(new Token(TokenName.VAR,"v1"));
        tl.add(new Token(TokenName.ASSIGN));
        tl.add(new Token(TokenName.VAR,"v3"));
        tl.add(new Token(TokenName.SEMC));
        tl.add(new Token(TokenName.FI));
        tl.add(new Token(TokenName.OD));
        System.out.println(tl);
        StmParseTree pt = tl.parse();
        System.out.println(pt);
        HashMap<String,Integer> env = new HashMap<String,Integer>();
        System.out.println(pt.interpret(env));
        */
        /*
        NumParseTree zero = new NumParseTree(0);
        NumParseTree one = new NumParseTree(1);
        NumParseTree two = new NumParseTree(2);
        NumParseTree thm = new NumParseTree(20000);
        VarParseTree v0 = new VarParseTree("v0");
        VarParseTree v1 = new VarParseTree("v1");
        VarParseTree v2 = new VarParseTree("v2");
        VarParseTree v3 = new VarParseTree("v3");
        EmptyParseTree es = new EmptyParseTree();
        AssignParseTree a1 = new AssignParseTree(v0,thm);
        AssignParseTree a2 = new AssignParseTree(v1,zero);
        AssignParseTree a3 = new AssignParseTree(v2,v0);
        SubParseTree spt1 = new SubParseTree(v2,v1);
        QuoParseTree qpt1 = new QuoParseTree(spt1,two);
        AddParseTree apt1 = new AddParseTree(v1,qpt1);
        AddParseTree apt2 = new AddParseTree(apt1,one);
        RemParseTree rpt1 = new RemParseTree(spt1,two);
        EqParseTree ept1 = new EqParseTree(rpt1,zero);
        AssignParseTree a4 = new AssignParseTree(v3,apt1);
        AssignParseTree a5 = new AssignParseTree(v3,apt2);
        IfParseTree ipt1 = new IfParseTree(ept1,a4,a5);
        SubParseTree spt2 = new SubParseTree(v3,one);
        MulParseTree mpt1 = new MulParseTree(v3,v3);
        GtParseTree gpt1 = new GtParseTree(mpt1,v0);
        AssignParseTree a6 = new AssignParseTree(v2,spt2);
        AssignParseTree a7 = new AssignParseTree(v1,v3);
        IfParseTree ipt2 = new IfParseTree(gpt1,a6,a7);
        SCompParseTree sc1 = new SCompParseTree(ipt2,es);
        SCompParseTree sc2 = new SCompParseTree(ipt1,sc1);
        NeqParseTree nept1 = new NeqParseTree(v1,v2);
        WhileParseTree wpt1 = new WhileParseTree(nept1,sc2);
        SCompParseTree sc3 = new SCompParseTree(wpt1,es);
        SCompParseTree sc4 = new SCompParseTree(a3,sc3);
        SCompParseTree sc5 = new SCompParseTree(a2,sc4);
        SCompParseTree sc6 = new SCompParseTree(a1,sc5);
        HashMap<String,Integer> env = new HashMap<String,Integer>();
        sc6.interpret(env);
        System.out.println(env);
        System.out.println(sc6);
        */
        /*
        AddParseTree apt
            = new AddParseTree(new AddParseTree(npt,vpt),
                               new AddParseTree(npt,vpt));
        env.put("xyz",23);
        AssignParseTree stm1 = new AssignParseTree(vpt,apt);
        System.out.println(env);
        System.out.println(stm1.interpret(env));
        */
    }
}