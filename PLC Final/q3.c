void expr(void) 
{
	 printf("Enter <expr>\n");

	 term();

	 while (nextToken == ADD_OP || nextToken == SUB_OP) 
   {
		 lex();
		 term();
	 }
	 printf("Exit <expr>\n");
}

void term(void)
{
	 printf("Enter <term>\n");

	 factor();

	 while (nextToken == MULT_OP || nextToken == DIV_OP)
   {
		 lex();
		 factor();
	 }
	 printf("Exit <term>\n");
}

void factor(void) 
{
	 printf("Enter <factor>\n");

	 if (nextToken == IDENT || nextToken == INT_LIT)

		 lex();

	 else { if (nextToken == LEFT_PAREN) 
    {
		 lex();
		 expr();
		 if (nextToken == RIGHT_PAREN)
		 	lex();
		 else
		 	error();
		}

		 else
		 error();
	 }
	 printf("Exit <factor>\n");
}