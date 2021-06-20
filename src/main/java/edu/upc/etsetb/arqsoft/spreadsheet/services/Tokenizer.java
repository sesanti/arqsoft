package edu.upc.etsetb.arqsoft.spreadsheet.services;

import jdk.nashorn.internal.runtime.ParserException;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tokenizer {
    private static final String REGEX_FUNCTIONS = "SUM|MIN|MAX|PROM";
    private static final String REGEX_OPEN_BRACKET = "\\(";
    private static final String REGEX_CLOSE_BRACKET = "\\)";
    private static final String REGEX_PLUS_SUB = "[+-]";
    private static final String REGEX_MULT_DIV = "[*/]";
    //private static final String REGEX_NUMBER = "[0-9]+";
    private static final String REGEX_NUMBER = "(?:\\d+\\.?|\\.\\d)\\d*(?:[Ee][-+]?\\d+)?";
    private static final String REGEX_CELL = "[a-zA-Z][a-zA-Z0-9_]*";
    private static final String REGEX_RAISED = "\\^";

    private LinkedList<TokenInfo> tokenInfos;
    private LinkedList<Token> tokens;

    public Tokenizer() {
        tokenInfos = new LinkedList<TokenInfo>();
        tokens = new LinkedList<Token>();
    }
    public static Tokenizer getInstance(){
        Tokenizer tokenizer  = new Tokenizer();

        tokenizer.add(REGEX_PLUS_SUB, Token.PLUSMINUS);
        tokenizer.add(REGEX_MULT_DIV, Token.MULTDIV);
        tokenizer.add(REGEX_RAISED, Token.RAISED);
        tokenizer.add(REGEX_FUNCTIONS, Token.FUNCTION);
        tokenizer.add(REGEX_OPEN_BRACKET, Token.OPEN_BRACKET);
        tokenizer.add(REGEX_CLOSE_BRACKET, Token.CLOSE_BRACKET);
        tokenizer.add( REGEX_NUMBER, Token.NUMBER);
        tokenizer.add(REGEX_CELL, Token.CELL);

        return tokenizer;
    }

    public void add(String regex, int token) {
        tokenInfos.add(
                new TokenInfo(
                        Pattern.compile("^(" + regex + ")"), token));
    }

    public LinkedList<Token> tokenize(String str) {
        String s = new String(str);
        int totalLength = s.length();
        tokens.clear();
        while (!s.equals("")) {
            int remaining = s.length();
            boolean match = false;
            for (TokenInfo info : tokenInfos) {
                Matcher m = info.regex.matcher(s);
                if (m.find()) {
                    match = true;

                    String tok = m.group().trim();
                    tokens.add(new Token(info.token, tok, totalLength - remaining));

                    s = m.replaceFirst("");
                    break;
                }
            }
            if (!match) throw new ParserException(
                    "Unexpected character in input: " + s);
        }
        return this.tokens;
    }
    public LinkedList<Token> getTokens() {
        return tokens;
    }

    private class TokenInfo {
        public final Pattern regex;
        public final int token;

        public TokenInfo(Pattern regex, int token) {
            super();
            this.regex = regex;
            this.token = token;
        }
    }
}