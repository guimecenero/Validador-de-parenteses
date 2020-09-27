//Guilherme Machado Mecenero
//081180011

import java.util.*;
import static java.lang.System.out;
import static java.lang.System.in;
import static java.lang.System.err;

public class Main {

    public static void main(String args[])
    {
        out.println("a qualquer momento, digite \"sair\" para sair do programa");
        do {
            try {
                Scanner read = new Scanner(in);
                out.println("Digite a seguir a sequencia que deseja analisar e aperte enter");
                out.println("Caracteres validos: (, <, {, [, ), >, }, ]");
                String resultado = read.nextLine();
                if (resultado.toLowerCase().equals("sair")) break;
                char[] validos = {
                        '(',
                        ')',
                        '<',
                        '>',
                        '{',
                        '}',
                        '[',
                        ']'
                };
                for (char leituraChar : resultado.toCharArray()) {
                    boolean valido = false;
                    for (char validoChar : validos) {
                        if (validoChar == leituraChar) {
                            valido = true;
                        }
                    }
                    if (valido) continue;
                    else throw new Exception("Algum carácter não foi valido");
                }
                Stack<Character> pilha = new Stack();
                char[] abertura = {'(','<','{','['};
                char[] fechamento = {')','>','}',']'};
                char[] leitura = resultado.toCharArray();
                for (char leituraChar: leitura) {
                    if (validaCaracter(abertura, leituraChar))
                    {
                        pilha.push(leituraChar);
                    }
                    else if (validaCaracter(fechamento,leituraChar))
                    {
                        char ultimoPilha = pilha.pop();
                        if (ultimoPilha == '(' && leituraChar == ')') {}
                        else if (ultimoPilha == '<' && leituraChar == '>') {}
                        else if (ultimoPilha == '{' && leituraChar == '}') {}
                        else if (ultimoPilha == '[' && leituraChar == ']') {}
                        else
                        {
                            throw new Exception("Sequencia invalida!");
                        }
                    }
                }
                if (pilha.empty())
                {
                    out.println("Sequencia valida!");
                }
                else
                {
                    throw new Exception("Sequencia invalida!");
                }
            }
            catch (EmptyStackException e)
            {
                err.println("java.lang.EmptyStackException: Sequencia invalida!");
            }
            catch (Exception e) {
                err.println(e);
            }
        }
        while (true);
    }

    private static boolean validaCaracter(char[] array, char valor)
    {
        boolean teste = false;
        for (char item : array) {
            if (item == valor) {
                teste = true;
                break;
            }
        }
        return teste;
    }
}
