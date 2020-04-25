import java.io.FileReader;
import jave.io.*;
import sun.misc.CharacterDecoder;

class lexico{
  int charClass;
  char[] lexeme = new char[100];
  char nextChar;
  int lexLen;
  int token;
  int nextToken;

  //Character Classes
  int LETTER = 0;
  int DIGIT = 1;
  int UNKNOWN = 99;
  int NOT_VALID = 100;

  //Token Codes
  int INT_LIT = 0;
  int FLOAT = 12;
  int IDENT = 11;
  int ASSIGN_OP = 20;
  int ADD_OP = 21;
  int SUB_OP = 22;
  int MULT_OP = 23;
  int DIV_OP = 24;
  int LEFT_PAREN = 25;
  int RIGHT_PAREN = 26;
  int FLOAT_POINT = 27;


  int lookup(char ch){
    switch(ch){
      case'(':
        addChar();
        nextToken = LEFT_PAREN;
        break;

      
      case')':
        addChar();
        nextToken = RIGHT_PAREN;
        break;

      case'+':
        addChar();
        nextToken = ADD_OP;
        break;

      case'-':
        addChar();
        nextToken = SUB_OP;
        break;

      case'*':
        addChar();
        nextToken = MULT_OP;
        break;

      case'/':
        addChar();
        nextToken = DIV_OP;
        break;

      case'.':
        addChar();
        nextToken = POINT;
        break;
      

      default:
        addChar();
        nextToken = EOF;
        break;
    }
    return nextToken;
  }

  void addChar(){
    if(lexLen <=98){
      lexeme[lexLen++] = nextChar;
      lexeme[lexLen] = 0;
    }
    else
      System.out.println("Error - lexeme is too long");

  }

  void getChar(){
    if((nextChar = get(in_fp)) != EOF){
      if(isalpha(nextChar))
        charClass = LETTER;
      else if(isdigit(nextChar))
        charClass = DIGIT;
      else
        charClass = UNKNOWN;
    }
    else
      charClass = EOF;
  }

  int lex(){
    lexLen = 0;
    getNonBlank();
    switch(charClass){
      case LETTER:
        addChar();
        getChar();
        while(charClass == LETTER || charClass == DIGIT){
          addChar();
          getChar();
        }
      nextToken = IDENT;
      break;

      case DIGIT:
        addChar();
        getChar();
        while (charClass == Digit){
          addChar();
          getChar();
        }
      
      if(nextChar =='.'){
        getChar();
        while(charCLASS == DIGIT){
          addchar();
          getchar();
        }
        if(charClass == LETTER){
          addChar();
          getChar();
          while(charClass == LETTER || charClass ==Digit){
            addChar();
            getChar();
          }
          nextToken = UNKNOWN;
        }
        else
          nextToaken = FLOAT;
        
      }
      else if(charCLass == LETTER){
        addChar();
        GetChar();
        while(CharClass == LETTER || charClass == DIGIT){
          addChar();
          getChar();
        }
        nextToken = UNKNOWN;
      }
      else NextToken = INT_LIT;
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
        lexeme[3] = '0';
        break;
    }
    System.out.println("Next token is " + nextToken + " , Next Lexeme is " + lexeme);
    return nextToken;

  }

  public static void main(String[] args) throws FileNotFoundException{
    FileReader fr = new FileReader("front.in");
    bufferReader bf = new BufferReader(fr);

    vector<String> chain = new Vector<String>(1,1);
    String add;
    while(add = b.readLing() != null){
      chain.addElement(add);
    }
  }


}
