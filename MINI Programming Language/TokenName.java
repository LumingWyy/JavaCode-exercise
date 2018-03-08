public enum TokenName
{       SEMC,    // ;
        LPAR,    // (
        RPAR,    // )
        MUL,     // *
        QUO,     // /
        REM,     // %
        PLUS,    // +
        MINUS,   // -
        LT,      // <
        GT,      // >
        EQ,      // =
        NEQ,     // !=
        AND,     // &&
        OR,      // ||
        ASSIGN,  // :=
        IF,      // if
        THEN,    // then
        ELSE,    // else
        FI,      // fi
        WHILE,   // while
        DO,      // do
        OD,      // od
        DEFAULT, // default
        NUM,     // [0-9]+
        VAR,     // [a-zA-Z][a-zA-Z0-9]* except for keywords
        UNDEF,   // undefined tokens
}