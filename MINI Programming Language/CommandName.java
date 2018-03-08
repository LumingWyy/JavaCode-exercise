public enum CommandName {
	PUSH, // push n (on the stack)
	LOAD, // load x
	STORE, // store x
	MONE, // * (-1)
	MUL, // *
	QUO, // /
	REM, // %
	ADD, // +
	SUB, // -
	EQ, // =
	NEQ, // !=
	LT, // <
	GT, // >
	AND, // &&
	OR, // ||
	JMP, // jump
	CJMP, // conditional jump
	QUIT, // quit
}