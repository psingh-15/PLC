#include <stdio.h>
#include <ctype.h>

int charClass;
char lexeme[100];
char nextChar;
int lexLen;
int token;
int nextToken;
FILE *in_file;

int lookup(char ch);
void addChar(void);
void getChar(void);
void getNonBlank(void);
int lex(void);

#define LETTER 0
#define DIGIT 1
#define UNKNOWN 99

#define INT_LIT 10
#define IDENT 11
#define ASSIGN_OP 20
#define ADD_OP 21
#define SUB_OP 22
#define MULT_OP 23
#define DIV_OP 24
#define LEFT_PAREN 25
#define RIGHT_PAREN 26
#define DECIMAL 27

int main(void) 
{

	 if ((in_file = fopen("front.in", "r")) == NULL)
	 	printf("ERROR - cannot open front.in \n");
	 else 
   {
	 	getChar();
	 do 
    {
	 	  lex();
	  }  
    while (nextToken != EOF);
	 }
	 return 0;
}

int lookup(char ch) 
{
	 switch (ch) 
   {
		 case '(':
			 addChar();
			 nextToken = LEFT_PAREN;
			 break;
		 case ')':
			 addChar();
			 nextToken = RIGHT_PAREN;
			 break;
		 case '+':
			 addChar();
			 nextToken = ADD_OP;
			 break;
		 case '-':
			 addChar();
			 nextToken = SUB_OP;
			 break;
		 case '*':
			 addChar();
			 nextToken = MULT_OP;
			 break;
		 case '/':
			 addChar();
			 nextToken = DIV_OP;
			 break;
     case '.':
        addChar();
        nextToken = DECIMAL;
        break;
		 default:
			 addChar();
			 nextToken = EOF;
			 break;
	 }
	 return nextToken;
}

void addChar(void) 
{
	if (lexLen <= 98) 
  {
		lexeme[lexLen++] = nextChar;
		lexeme[lexLen] = '\0';
	} else
	printf("Error: Lexeme is too long \n");
}

void getChar(void) 
{
	 if ((nextChar = getc(in_file)) != EOF) 
   {
		 if (isalpha(nextChar))
		 	charClass = LETTER;
		 else if (isdigit(nextChar))
		 	charClass = DIGIT;
		 else
		 	charClass = UNKNOWN;
	 } else
	 	charClass = EOF;
}

void getNonBlank(void) 
{
	while (isspace(nextChar))
	getChar();
}

int lex(void) 
{
	 lexLen = 0;
	 getNonBlank();
	 switch (charClass) 
   {

		 case LETTER:
			 addChar();
			 getChar();
			 while (charClass == LETTER || charClass == DIGIT) 
       {
				 addChar();
				 getChar();
			 }
			 nextToken = IDENT;
			 break;
		
		 case DIGIT:
			 addChar();
			 getChar();
			 while (charClass == DIGIT) 
       {
				 addChar();
				 getChar();
			 }
			 nextToken = INT_LIT;
		 	break;
	
		 case UNKNOWN:
			 lookup(nextChar);
			 getChar();
			 break;
		
		case EOF:
			 nextToken = EOF;
			 lexeme[0] = 'E';
			 lexeme[1] = 'O';
			 lexeme[2] = 'F';
			 lexeme[3] = '\0';
		 	break;
	 }
	 printf("Next Token is: %d, Next Lexeme is %s\n", nextToken, lexeme);
	 return nextToken;
}