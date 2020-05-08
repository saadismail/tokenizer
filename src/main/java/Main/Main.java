package Main;

import Model.Symbol;

import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {

        String code = FileReader.read("code.txt");
        Tokenizer tokenizer = new Tokenizer();
        tokenizer.tokenize(code);

        CsvWriter.writeTokens("token_list.csv", tokenizer.getTokenList());

        List<Symbol> symbolList = tokenizer.getSymbolTable();
        Set<Symbol> foo = new HashSet<>(symbolList);
        symbolList = new LinkedList<>(foo);

        CsvWriter.writeSymbols("symbol_table.csv", symbolList);
    }

}
