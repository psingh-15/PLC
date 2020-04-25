public class rda {
    void expr(){
        System.out.println("Enter <expr>");
        term();
        while(nextToken == ADD_OP || nextToken == SUB_OP){
            lex();
            Term();
        }
        System.out.println("Exit <expr>");
    }

    void term(){
        System.out.println("Enter <term>");
        factor();
        while(nextToken == MULTI_OP || nextToken == DIV_OP){
            lex();
            factor();
        }
    }

    void factor(){
        System.out.println("Enter <factor>");
        if(nextToken == IDENT || nextToekn == INT_LIT){
            lex();
        }

        else if{
            if(nextToken == LEFT_PAREN){
                    lex();
            }
            else{
                error();
            }
        }
        else {
            error();
        }
    System.out.println("Exit <factor>");

    }
    
}