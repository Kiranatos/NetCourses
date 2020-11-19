package net.kiranatos.stepik.java_basic.third_week;

class Filters {       
    
    public Label checkLabels(TextAnalyzer[] analyzers, String text) {
        for ( TextAnalyzer t: analyzers) {            
            if ( t.processText(text) != Label.OK ) return t.processText(text);
        }
        return Label.OK;
    }
// тесты
    public static void main(String[] args) {        
        // инициализация анализаторов для проверки в порядке данного набора анализаторов
        String[] spamKeywords = {"spam", "bad"};
        int commentMaxLength = 40;        
        TextAnalyzer[] textAnalyzers1 = {
            new SpamAnalyzer(spamKeywords),
            new NegativeTextAnalyzer(),
            new TooLongTextAnalyzer(commentMaxLength)
        };
        
        TextAnalyzer[] textAnalyzers2 = {
            new SpamAnalyzer(spamKeywords),
            new TooLongTextAnalyzer(commentMaxLength),
            new NegativeTextAnalyzer()
        };
        TextAnalyzer[] textAnalyzers3 = {
            new TooLongTextAnalyzer(commentMaxLength),
            new SpamAnalyzer(spamKeywords),
            new NegativeTextAnalyzer()
        };
        TextAnalyzer[] textAnalyzers4 = {
            new TooLongTextAnalyzer(commentMaxLength),
            new NegativeTextAnalyzer(),
            new SpamAnalyzer(spamKeywords)
        };
        TextAnalyzer[] textAnalyzers5 = {
            new NegativeTextAnalyzer(),
            new SpamAnalyzer(spamKeywords),
            new TooLongTextAnalyzer(commentMaxLength)
        };
        TextAnalyzer[] textAnalyzers6 = {
            new NegativeTextAnalyzer(),
            new TooLongTextAnalyzer(commentMaxLength),
            new SpamAnalyzer(spamKeywords)
        };
        // тестовые комментарии
        String[] tests = new String[8];
        tests[0] = "This comment is so good.";                            // OK
        tests[1] = "This comment is so Loooooooooooooooooooooooooooong."; // TOO_LONG
        tests[2] = "Very negative comment !!!!=(!!!!;";                   // NEGATIVE_TEXT
        tests[3] = "Very BAAAAAAAAAAAAAAAAAAAAAAAAD comment with :|;";    // NEGATIVE_TEXT or TOO_LONG
        tests[4] = "This comment is so bad....";                          // SPAM
        tests[5] = "The comment is a spam, maybeeeeeeeeeeeeeeeeeeeeee!";  // SPAM or TOO_LONG
        tests[6] = "Negative bad :( spam.";                               // SPAM or NEGATIVE_TEXT
        tests[7] = "Very bad, very neg =(, very ..................";      // SPAM or NEGATIVE_TEXT or TOO_LONG
        TextAnalyzer[][] textAnalyzers = {textAnalyzers1, textAnalyzers2, textAnalyzers3,
                                          textAnalyzers4, textAnalyzers5, textAnalyzers6};
        Filters testObject = new Filters();
        int numberOfAnalyzer; // номер анализатора, указанный в идентификаторе textAnalyzers{№}
        int numberOfTest = 0; // номер теста, который соответствует индексу тестовых комментариев
        for (String test : tests) {
            numberOfAnalyzer = 1;
            System.out.print("test #" + numberOfTest + ": ");
            System.out.println(test);
            for (TextAnalyzer[] analyzers : textAnalyzers) {
                System.out.print(numberOfAnalyzer + ": ");
                System.out.println(testObject.checkLabels(analyzers, test));
                numberOfAnalyzer++;
            }
            numberOfTest++;
        }
    }
}

interface TextAnalyzer { Label processText(String text); }

enum Label { SPAM, NEGATIVE_TEXT, TOO_LONG, OK }

abstract class KeywordAnalyzer implements TextAnalyzer {
        protected abstract String[] getKeywords();
        protected abstract Label getLabel();
        
        @Override
        public Label processText(String text) {
            
            String[] words = getKeywords();
            for (int i = 0; i < words.length; i++)
                if (text.contains(words[i])) { return getLabel(); }
            
            return Label.OK;
        }            
}
    
    class SpamAnalyzer extends KeywordAnalyzer  {
        private String[] keywords;
        
        public SpamAnalyzer(String[] keywords) { this.keywords = keywords; }
                
        @Override
        protected String[] getKeywords() {
            return keywords;
        }
        
        @Override
        protected Label getLabel() {
            return Label.SPAM;
        }
    }
    
    class NegativeTextAnalyzer extends KeywordAnalyzer {
        
        private String[] neg = {":(", "=(", ":|"};
        
        @Override
        protected String[] getKeywords() {
            return neg;
        }
    
        @Override
        protected Label getLabel() {
            return Label.NEGATIVE_TEXT;
        }
    }

    class TooLongTextAnalyzer implements TextAnalyzer {
        private int maxLength;
        
        public TooLongTextAnalyzer(int maxLength) { this.maxLength = maxLength; }
        
        @Override
        public Label processText(String text) {
            if (text.length() <= maxLength) return Label.OK;
            return Label.TOO_LONG;
        }    
    }


/*
test #0: This comment is so good.
1: OK
2: OK
3: OK
4: OK
5: OK
6: OK
test #1: This comment is so Loooooooooooooooooooooooooooong.
1: TOO_LONG
2: TOO_LONG
3: TOO_LONG
4: TOO_LONG
5: TOO_LONG
6: TOO_LONG
test #2: Very negative comment !!!!=(!!!!;
1: NEGATIVE_TEXT
2: NEGATIVE_TEXT
3: NEGATIVE_TEXT
4: NEGATIVE_TEXT
5: NEGATIVE_TEXT
6: NEGATIVE_TEXT
test #3: Very BAAAAAAAAAAAAAAAAAAAAAAAAD comment with :|;
1: NEGATIVE_TEXT
2: TOO_LONG
3: TOO_LONG
4: TOO_LONG
5: NEGATIVE_TEXT
6: NEGATIVE_TEXT
test #4: This comment is so bad....
1: SPAM
2: SPAM
3: SPAM
4: SPAM
5: SPAM
6: SPAM
test #5: The comment is a spam, maybeeeeeeeeeeeeeeeeeeeeee!
1: SPAM
2: SPAM
3: TOO_LONG
4: TOO_LONG
5: SPAM
6: TOO_LONG
test #6: Negative bad :( spam.
1: SPAM
2: SPAM
3: SPAM
4: NEGATIVE_TEXT
5: NEGATIVE_TEXT
6: NEGATIVE_TEXT
test #7: Very bad, very neg =(, very ..................
1: SPAM
2: SPAM
3: TOO_LONG
4: TOO_LONG
5: NEGATIVE_TEXT
6: NEGATIVE_TEXT
*/