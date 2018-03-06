package ru.itis;

import java.util.LinkedHashMap;

public class Analyzer {
    private int state;

    public void analyze(String input){
        state = 0;
        if (input == null)
            return;
        for(int i = 0; i < input.length(); i++){
            char num = input.charAt(i);
            switch (state){
                case (0):{
                    if (num < 'A' || num > 'Z')
                        throw new SyntaxException();
                    state = 1;
                    break;
                }
                case (1):{
                    if ((num >= '0' && num <= '9')){
                        state = 2;
                    } else
                        throw new SyntaxException();
                    break;
                }
                case (2) : {
                    if (num != ':')
                        throw new SyntaxException();
                    state = 3;
                    break;
                }
                case (3):{
                    if (num != '=')
                        throw new SyntaxException();
                    state = 4;
                    break;
                }
                case (4):{
                    if (num >= '0' && num <= '9') {
                        state = 5;
                    } else {
                        if (num >= 'A' && num <= 'Z') {
                            state = 6;
                            break;
                        } else if (num != '-')
                            throw  new SyntaxException();
                    }
                    break;
                }
                case (5):{
                    if (num == ';') {
                        state = 0;
                    } else {
                        if (num < '0' || num > '9')
                            throw new SyntaxException();
                    }
                    break;
                }
                case(6):{
                    if (num >= '0' && num <='9') {
                        state = 7;
                        break;
                    }
                    throw new SyntaxException();
                }
                case(7):{
                    if (num == '+' || num == '-' || num == '*' || num == '/') {
                        state = 4;
                    } else {
                        if (num == ';')
                            state = 0;
                        else
                            throw new SyntaxException();
                    }
                    break;
                }
            }
        }
        if (state != 0)
            throw new SyntaxException();
    }

    LinkedHashMap<String, Integer> process(String input){
        analyze(input);
        LinkedHashMap<String, Integer> result = new LinkedHashMap<>();
        int indexL = -1, indexR = -1;
        while(indexR != input.length() - 1){
            indexL = input.indexOf(':', indexL + 1);
            String num = input.substring((indexR == 0) ? 0 : indexR + 1, indexL);
            indexR = input.indexOf(';', indexR + 1);
            int value = 0;
            if (result.containsKey(num))
                result.remove(num);
            try{
                value = Integer.parseInt(input.substring(indexL + 2, indexR));
            }
            catch (Exception e){
                char operator = ' ';
                StringBuilder part = new StringBuilder();
                boolean minus = false;
                for (int i = indexL + 2; i <= indexR; i++){
                    char current = input.charAt(i);
                    if (current != ';' && current != '+' && current != '-' && current != '*' && current != '/'){
                        part.append(current);
                    } else {
                        if (!result.containsKey(part.toString()) && (!part.toString().equals("") && current != '-'))
                            throw new NotFoundVariableException();
                        int partValue;
                        if (part.toString().equals("") && current == '-')
                            minus = true;
                        if (!part.toString().equals("")) {
                            partValue = (minus) ? -result.get(part.toString()) : result.get(part.toString());
                            minus = false;
                            switch (operator) {
                                case ('-'): {
                                    value -= partValue;
                                    break;
                                }
                                case ('+'): {
                                    value += partValue;
                                    break;
                                }
                                case ('*'): {
                                    value *= partValue;
                                    break;
                                }
                                case ('/'): {
                                    if (result.get(part.toString()) == 0)
                                        throw new RuntimeException();
                                    value /= partValue;
                                    break;
                                }
                                case (' '): {
                                    value = partValue;
                                }
                            }
                            if (current != ';')
                                operator = current;
                            part = new StringBuilder();
                        }
                    }
                }
            }
            result.put(num, value);
        }
        return result;
    }

    public int getState() {
        return state;
    }
}