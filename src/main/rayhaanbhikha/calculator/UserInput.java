package rayhaanbhikha.calculator;

import java.util.ArrayList;

public class UserInput {
    
    private ArrayList<Object> filteredInput;
    private String input;
    private Boolean verbose;

    public UserInput(String input) {
        this(input, false);
    }

    public UserInput(String input, Boolean verbose) {
        this.input = input;
        this.verbose = verbose;
        this.filterInput(input);
        if(verbose) {
            this.printParsedUserInput();
        }
    }

    public void filterInput(String input) {
        filteredInput = new ArrayList<>();
        String accumulated = "";
        for(int i=0; i<input.length(); i++) {
            char currentInput = input.charAt(i);
            switch(currentInput) {
                case '0': case '1': case '2':
                case '3': case '4': case '5':
                case '6': case '7': case '8':
                case '9':
                    accumulated += currentInput;
                    break;
                case '%':
                    /**
                     * by this point the filteredInput array list should have
                     * string char string
                     * */
                    if(filteredInput.size() > 1 && filteredInput.get(filteredInput.size() - 1) instanceof Character && (Character) filteredInput.get(filteredInput.size() - 1) == '(') {
//                        System.out.println("Bracket exists: "+  filteredInput.get(filteredInput.size() - 1) + accumulated + currentInput);
                        accumulated = Double.toString(Double.parseDouble(accumulated)/100);
                    } else if(filteredInput.size() > 1 && filteredInput.get(filteredInput.size() - 1) instanceof Character && (Character) filteredInput.get(filteredInput.size() - 1) == ')'){
                        // scenario such as '(15+10)%'
                        filteredInput.add(accumulated);
                        accumulated = "";
                        filteredInput.add('/');
                        filteredInput.add("100");
                    }
                    else {
                        accumulated += currentInput;
                    }
                    break;
                case ' ':
                    break;
                default:
                    /* if it's an operand or bracket
                        then add accumulated to filtered input
                        and make accumulated empty.*/
                    filteredInput.add(accumulated);
                    accumulated = "";
                    filteredInput.add(currentInput); // add operand on it's own
                    break;
            }
        }
        filteredInput.add(accumulated);
        filteredInput.removeIf(i -> i.equals("")); // remove all empty string in Arraylist
    }

    public ArrayList<Object> getFilteredInput() {
        return filteredInput;
    }

    public void printParsedUserInput(){
        System.out.print("Parsed User input: ");
        for(Object i: filteredInput) {
            System.out.print(i.toString() + " ");
        }
        System.out.println(" ");
    }


    public void printParsedUserInputAndType(){
        for(Object i: filteredInput) {
            System.out.println(i.toString() + "\t " + i.getClass());
        }
        System.out.println(" ");
    }
}
