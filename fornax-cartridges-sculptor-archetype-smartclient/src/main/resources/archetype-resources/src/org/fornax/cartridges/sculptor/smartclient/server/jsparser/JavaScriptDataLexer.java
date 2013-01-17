/*
 * (C) Copyright Factory4Solutions a.s. 2009
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
// $ANTLR 3.1.2 JavaScriptData.g 2009-08-13 13:00:22

package org.fornax.cartridges.sculptor.smartclient.server.jsparser;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

/**
 * Simplified JavaScript parser
 * 
 * @author Ing. Pavel Tavoda
 */
public class JavaScriptDataLexer extends Lexer {
    public static final int INTEGER=8;
    public static final int Double=32;
    public static final int LBrace=15;
    public static final int Frac=27;
    public static final int NULL=12;
    public static final int Exp=28;
    public static final int RBracket=18;
    public static final int OtherNameChar=26;
    public static final int Colon=13;
    public static final int Date=34;
    public static final int UnicodeChar=22;
    public static final int Digit=20;
    public static final int EOF=-1;
    public static final int HexDigit=21;
    public static final int BOOLEAN=10;
    public static final int OBJECT=4;
    public static final int Boolean=33;
    public static final int Dot=19;
    public static final int ELEMENT=5;
    public static final int Name=36;
    public static final int DOUBLE=9;
    public static final int StringChar=24;
    public static final int WhiteSpace=29;
    public static final int String=30;
    public static final int LBracket=17;
    public static final int DATE=11;
    public static final int Comma=14;
    public static final int EscapeSequence=23;
    public static final int ARRAY=6;
    public static final int Integer=31;
    public static final int RBrace=16;
    public static final int STRING=7;
    public static final int Null=35;
    public static final int BeginNameChar=25;

    // delegates
    // delegators

    public JavaScriptDataLexer() {;} 
    public JavaScriptDataLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public JavaScriptDataLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "JavaScriptData.g"; }

    // $ANTLR start "Colon"
    public final void mColon() throws RecognitionException {
        try {
            int _type = Colon;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // JavaScriptData.g:112:6: ( ':' )
            // JavaScriptData.g:112:8: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Colon"

    // $ANTLR start "Comma"
    public final void mComma() throws RecognitionException {
        try {
            int _type = Comma;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // JavaScriptData.g:113:6: ( ',' )
            // JavaScriptData.g:113:8: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Comma"

    // $ANTLR start "LBrace"
    public final void mLBrace() throws RecognitionException {
        try {
            int _type = LBrace;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // JavaScriptData.g:114:7: ( '{' )
            // JavaScriptData.g:114:9: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LBrace"

    // $ANTLR start "RBrace"
    public final void mRBrace() throws RecognitionException {
        try {
            int _type = RBrace;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // JavaScriptData.g:115:7: ( '}' )
            // JavaScriptData.g:115:9: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RBrace"

    // $ANTLR start "LBracket"
    public final void mLBracket() throws RecognitionException {
        try {
            int _type = LBracket;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // JavaScriptData.g:116:9: ( '[' )
            // JavaScriptData.g:116:11: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LBracket"

    // $ANTLR start "RBracket"
    public final void mRBracket() throws RecognitionException {
        try {
            int _type = RBracket;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // JavaScriptData.g:117:9: ( ']' )
            // JavaScriptData.g:117:11: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RBracket"

    // $ANTLR start "Dot"
    public final void mDot() throws RecognitionException {
        try {
            // JavaScriptData.g:118:13: ( '.' )
            // JavaScriptData.g:118:15: '.'
            {
            match('.'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "Dot"

    // $ANTLR start "Digit"
    public final void mDigit() throws RecognitionException {
        try {
            // JavaScriptData.g:120:15: ( '0' .. '9' )
            // JavaScriptData.g:120:17: '0' .. '9'
            {
            matchRange('0','9'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "Digit"

    // $ANTLR start "HexDigit"
    public final void mHexDigit() throws RecognitionException {
        try {
            // JavaScriptData.g:121:18: ( ( '0' .. '9' | 'A' .. 'F' | 'a' .. 'f' ) )
            // JavaScriptData.g:121:20: ( '0' .. '9' | 'A' .. 'F' | 'a' .. 'f' )
            {
            if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='F')||(input.LA(1)>='a' && input.LA(1)<='f') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "HexDigit"

    // $ANTLR start "UnicodeChar"
    public final void mUnicodeChar() throws RecognitionException {
        try {
            // JavaScriptData.g:122:21: (~ ( '\"' | '\\\\' ) )
            // JavaScriptData.g:122:23: ~ ( '\"' | '\\\\' )
            {
            if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "UnicodeChar"

    // $ANTLR start "StringChar"
    public final void mStringChar() throws RecognitionException {
        try {
            // JavaScriptData.g:123:21: ( UnicodeChar | EscapeSequence )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( ((LA1_0>='\u0000' && LA1_0<='!')||(LA1_0>='#' && LA1_0<='[')||(LA1_0>=']' && LA1_0<='\uFFFF')) ) {
                alt1=1;
            }
            else if ( (LA1_0=='\\') ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // JavaScriptData.g:123:24: UnicodeChar
                    {
                    mUnicodeChar(); 

                    }
                    break;
                case 2 :
                    // JavaScriptData.g:123:38: EscapeSequence
                    {
                    mEscapeSequence(); 

                    }
                    break;

            }
        }
        finally {
        }
    }
    // $ANTLR end "StringChar"

    // $ANTLR start "BeginNameChar"
    public final void mBeginNameChar() throws RecognitionException {
        try {
            // JavaScriptData.g:125:23: ( ( 'A' .. 'Z' | 'a' .. 'z' | '_' ) )
            // JavaScriptData.g:125:25: ( 'A' .. 'Z' | 'a' .. 'z' | '_' )
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "BeginNameChar"

    // $ANTLR start "OtherNameChar"
    public final void mOtherNameChar() throws RecognitionException {
        try {
            // JavaScriptData.g:126:23: ( ( '0' .. '9' | 'A' .. 'Z' | 'a' .. 'z' | '_' ) )
            // JavaScriptData.g:126:25: ( '0' .. '9' | 'A' .. 'Z' | 'a' .. 'z' | '_' )
            {
            if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "OtherNameChar"

    // $ANTLR start "EscapeSequence"
    public final void mEscapeSequence() throws RecognitionException {
        try {
            // JavaScriptData.g:129:2: ( '\\\\' ( '\\\"' | '\\\\' | '/' | 'b' | 'f' | 'n' | 'r' | 't' | 'u' HexDigit HexDigit HexDigit HexDigit ) )
            // JavaScriptData.g:129:4: '\\\\' ( '\\\"' | '\\\\' | '/' | 'b' | 'f' | 'n' | 'r' | 't' | 'u' HexDigit HexDigit HexDigit HexDigit )
            {
            match('\\'); 
            // JavaScriptData.g:129:9: ( '\\\"' | '\\\\' | '/' | 'b' | 'f' | 'n' | 'r' | 't' | 'u' HexDigit HexDigit HexDigit HexDigit )
            int alt2=9;
            switch ( input.LA(1) ) {
            case '\"':
                {
                alt2=1;
                }
                break;
            case '\\':
                {
                alt2=2;
                }
                break;
            case '/':
                {
                alt2=3;
                }
                break;
            case 'b':
                {
                alt2=4;
                }
                break;
            case 'f':
                {
                alt2=5;
                }
                break;
            case 'n':
                {
                alt2=6;
                }
                break;
            case 'r':
                {
                alt2=7;
                }
                break;
            case 't':
                {
                alt2=8;
                }
                break;
            case 'u':
                {
                alt2=9;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // JavaScriptData.g:129:10: '\\\"'
                    {
                    match('\"'); 

                    }
                    break;
                case 2 :
                    // JavaScriptData.g:129:17: '\\\\'
                    {
                    match('\\'); 

                    }
                    break;
                case 3 :
                    // JavaScriptData.g:129:24: '/'
                    {
                    match('/'); 

                    }
                    break;
                case 4 :
                    // JavaScriptData.g:129:30: 'b'
                    {
                    match('b'); 

                    }
                    break;
                case 5 :
                    // JavaScriptData.g:129:36: 'f'
                    {
                    match('f'); 

                    }
                    break;
                case 6 :
                    // JavaScriptData.g:129:42: 'n'
                    {
                    match('n'); 

                    }
                    break;
                case 7 :
                    // JavaScriptData.g:129:48: 'r'
                    {
                    match('r'); 

                    }
                    break;
                case 8 :
                    // JavaScriptData.g:129:54: 't'
                    {
                    match('t'); 

                    }
                    break;
                case 9 :
                    // JavaScriptData.g:129:60: 'u' HexDigit HexDigit HexDigit HexDigit
                    {
                    match('u'); 
                    mHexDigit(); 
                    mHexDigit(); 
                    mHexDigit(); 
                    mHexDigit(); 

                    }
                    break;

            }


            }

        }
        finally {
        }
    }
    // $ANTLR end "EscapeSequence"

    // $ANTLR start "Frac"
    public final void mFrac() throws RecognitionException {
        try {
            // JavaScriptData.g:132:14: ( Dot ( Digit )+ )
            // JavaScriptData.g:132:16: Dot ( Digit )+
            {
            mDot(); 
            // JavaScriptData.g:132:20: ( Digit )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='0' && LA3_0<='9')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // JavaScriptData.g:132:20: Digit
            	    {
            	    mDigit(); 

            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);


            }

        }
        finally {
        }
    }
    // $ANTLR end "Frac"

    // $ANTLR start "Exp"
    public final void mExp() throws RecognitionException {
        try {
            // JavaScriptData.g:133:13: ( ( 'e' | 'E' ) ( '+' | '-' )? ( Digit )+ )
            // JavaScriptData.g:133:15: ( 'e' | 'E' ) ( '+' | '-' )? ( Digit )+
            {
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // JavaScriptData.g:133:27: ( '+' | '-' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='+'||LA4_0=='-') ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // JavaScriptData.g:
                    {
                    if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;

            }

            // JavaScriptData.g:133:40: ( Digit )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>='0' && LA5_0<='9')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // JavaScriptData.g:133:40: Digit
            	    {
            	    mDigit(); 

            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
            } while (true);


            }

        }
        finally {
        }
    }
    // $ANTLR end "Exp"

    // $ANTLR start "WhiteSpace"
    public final void mWhiteSpace() throws RecognitionException {
        try {
            int _type = WhiteSpace;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // JavaScriptData.g:135:11: ( ( ' ' | '\\r' | '\\t' | '\\u000C' | '\\n' ) )
            // JavaScriptData.g:135:13: ( ' ' | '\\r' | '\\t' | '\\u000C' | '\\n' )
            {
            if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||(input.LA(1)>='\f' && input.LA(1)<='\r')||input.LA(1)==' ' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

             _channel=HIDDEN; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WhiteSpace"

    // $ANTLR start "String"
    public final void mString() throws RecognitionException {
        try {
            int _type = String;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // JavaScriptData.g:137:7: ( '\"' ( StringChar )* '\"' )
            // JavaScriptData.g:137:9: '\"' ( StringChar )* '\"'
            {
            match('\"'); 
            // JavaScriptData.g:137:13: ( StringChar )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>='\u0000' && LA6_0<='!')||(LA6_0>='#' && LA6_0<='\uFFFF')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // JavaScriptData.g:137:13: StringChar
            	    {
            	    mStringChar(); 

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            match('\"'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "String"

    // $ANTLR start "Integer"
    public final void mInteger() throws RecognitionException {
        try {
            int _type = Integer;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // JavaScriptData.g:138:8: ( ( Digit )+ )
            // JavaScriptData.g:138:10: ( Digit )+
            {
            // JavaScriptData.g:138:10: ( Digit )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>='0' && LA7_0<='9')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // JavaScriptData.g:138:10: Digit
            	    {
            	    mDigit(); 

            	    }
            	    break;

            	default :
            	    if ( cnt7 >= 1 ) break loop7;
                        EarlyExitException eee =
                            new EarlyExitException(7, input);
                        throw eee;
                }
                cnt7++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Integer"

    // $ANTLR start "Double"
    public final void mDouble() throws RecognitionException {
        try {
            int _type = Double;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // JavaScriptData.g:139:7: ( ( Digit )+ Frac ( Exp )? )
            // JavaScriptData.g:139:10: ( Digit )+ Frac ( Exp )?
            {
            // JavaScriptData.g:139:10: ( Digit )+
            int cnt8=0;
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='0' && LA8_0<='9')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // JavaScriptData.g:139:10: Digit
            	    {
            	    mDigit(); 

            	    }
            	    break;

            	default :
            	    if ( cnt8 >= 1 ) break loop8;
                        EarlyExitException eee =
                            new EarlyExitException(8, input);
                        throw eee;
                }
                cnt8++;
            } while (true);

            mFrac(); 
            // JavaScriptData.g:139:22: ( Exp )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0=='E'||LA9_0=='e') ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // JavaScriptData.g:139:22: Exp
                    {
                    mExp(); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Double"

    // $ANTLR start "Boolean"
    public final void mBoolean() throws RecognitionException {
        try {
            int _type = Boolean;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // JavaScriptData.g:140:8: ( 'true' | 'false' )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='t') ) {
                alt10=1;
            }
            else if ( (LA10_0=='f') ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // JavaScriptData.g:140:10: 'true'
                    {
                    match("true"); 


                    }
                    break;
                case 2 :
                    // JavaScriptData.g:140:19: 'false'
                    {
                    match("false"); 


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Boolean"

    // $ANTLR start "Date"
    public final void mDate() throws RecognitionException {
        try {
            int _type = Date;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // JavaScriptData.g:141:5: ( 'new Date(' Integer ')' )
            // JavaScriptData.g:141:7: 'new Date(' Integer ')'
            {
            match("new Date("); 

            mInteger(); 
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Date"

    // $ANTLR start "Null"
    public final void mNull() throws RecognitionException {
        try {
            int _type = Null;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // JavaScriptData.g:142:5: ( 'null' )
            // JavaScriptData.g:142:7: 'null'
            {
            match("null"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Null"

    // $ANTLR start "Name"
    public final void mName() throws RecognitionException {
        try {
            int _type = Name;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // JavaScriptData.g:143:5: ( BeginNameChar ( OtherNameChar )+ )
            // JavaScriptData.g:143:7: BeginNameChar ( OtherNameChar )+
            {
            mBeginNameChar(); 
            // JavaScriptData.g:143:21: ( OtherNameChar )+
            int cnt11=0;
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>='0' && LA11_0<='9')||(LA11_0>='A' && LA11_0<='Z')||LA11_0=='_'||(LA11_0>='a' && LA11_0<='z')) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // JavaScriptData.g:143:21: OtherNameChar
            	    {
            	    mOtherNameChar(); 

            	    }
            	    break;

            	default :
            	    if ( cnt11 >= 1 ) break loop11;
                        EarlyExitException eee =
                            new EarlyExitException(11, input);
                        throw eee;
                }
                cnt11++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Name"

    public void mTokens() throws RecognitionException {
        // JavaScriptData.g:1:8: ( Colon | Comma | LBrace | RBrace | LBracket | RBracket | WhiteSpace | String | Integer | Double | Boolean | Date | Null | Name )
        int alt12=14;
        alt12 = dfa12.predict(input);
        switch (alt12) {
            case 1 :
                // JavaScriptData.g:1:10: Colon
                {
                mColon(); 

                }
                break;
            case 2 :
                // JavaScriptData.g:1:16: Comma
                {
                mComma(); 

                }
                break;
            case 3 :
                // JavaScriptData.g:1:22: LBrace
                {
                mLBrace(); 

                }
                break;
            case 4 :
                // JavaScriptData.g:1:29: RBrace
                {
                mRBrace(); 

                }
                break;
            case 5 :
                // JavaScriptData.g:1:36: LBracket
                {
                mLBracket(); 

                }
                break;
            case 6 :
                // JavaScriptData.g:1:45: RBracket
                {
                mRBracket(); 

                }
                break;
            case 7 :
                // JavaScriptData.g:1:54: WhiteSpace
                {
                mWhiteSpace(); 

                }
                break;
            case 8 :
                // JavaScriptData.g:1:65: String
                {
                mString(); 

                }
                break;
            case 9 :
                // JavaScriptData.g:1:72: Integer
                {
                mInteger(); 

                }
                break;
            case 10 :
                // JavaScriptData.g:1:80: Double
                {
                mDouble(); 

                }
                break;
            case 11 :
                // JavaScriptData.g:1:87: Boolean
                {
                mBoolean(); 

                }
                break;
            case 12 :
                // JavaScriptData.g:1:95: Date
                {
                mDate(); 

                }
                break;
            case 13 :
                // JavaScriptData.g:1:100: Null
                {
                mNull(); 

                }
                break;
            case 14 :
                // JavaScriptData.g:1:105: Name
                {
                mName(); 

                }
                break;

        }

    }


    protected DFA12 dfa12 = new DFA12(this);
    static final String DFA12_eotS =
        "\11\uffff\1\16\6\uffff\10\15\1\34\1\15\1\uffff\1\36\1\uffff\1\34"+
        "\1\uffff";
    static final String DFA12_eofS =
        "\37\uffff";
    static final String DFA12_minS =
        "\1\11\10\uffff\1\56\3\60\3\uffff\1\165\1\154\1\167\1\154\1\145\1"+
        "\163\1\40\1\154\1\60\1\145\1\uffff\1\60\1\uffff\1\60\1\uffff";
    static final String DFA12_maxS =
        "\1\175\10\uffff\1\71\3\172\3\uffff\1\165\1\154\1\167\1\154\1\145"+
        "\1\163\1\40\1\154\1\172\1\145\1\uffff\1\172\1\uffff\1\172\1\uffff";
    static final String DFA12_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\4\uffff\1\16\1\11\1\12"+
        "\12\uffff\1\14\1\uffff\1\13\1\uffff\1\15";
    static final String DFA12_specialS =
        "\37\uffff}>";
    static final String[] DFA12_transitionS = {
            "\2\7\1\uffff\2\7\22\uffff\1\7\1\uffff\1\10\11\uffff\1\2\3\uffff"+
            "\12\11\1\1\6\uffff\32\15\1\5\1\uffff\1\6\1\uffff\1\15\1\uffff"+
            "\5\15\1\13\7\15\1\14\5\15\1\12\6\15\1\3\1\uffff\1\4",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\17\1\uffff\12\11",
            "\12\15\7\uffff\32\15\4\uffff\1\15\1\uffff\21\15\1\20\10\15",
            "\12\15\7\uffff\32\15\4\uffff\1\15\1\uffff\1\21\31\15",
            "\12\15\7\uffff\32\15\4\uffff\1\15\1\uffff\4\15\1\22\17\15\1"+
            "\23\5\15",
            "",
            "",
            "",
            "\1\24",
            "\1\25",
            "\1\26",
            "\1\27",
            "\1\30",
            "\1\31",
            "\1\32",
            "\1\33",
            "\12\15\7\uffff\32\15\4\uffff\1\15\1\uffff\32\15",
            "\1\35",
            "",
            "\12\15\7\uffff\32\15\4\uffff\1\15\1\uffff\32\15",
            "",
            "\12\15\7\uffff\32\15\4\uffff\1\15\1\uffff\32\15",
            ""
    };

    static final short[] DFA12_eot = DFA.unpackEncodedString(DFA12_eotS);
    static final short[] DFA12_eof = DFA.unpackEncodedString(DFA12_eofS);
    static final char[] DFA12_min = DFA.unpackEncodedStringToUnsignedChars(DFA12_minS);
    static final char[] DFA12_max = DFA.unpackEncodedStringToUnsignedChars(DFA12_maxS);
    static final short[] DFA12_accept = DFA.unpackEncodedString(DFA12_acceptS);
    static final short[] DFA12_special = DFA.unpackEncodedString(DFA12_specialS);
    static final short[][] DFA12_transition;

    static {
        int numStates = DFA12_transitionS.length;
        DFA12_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA12_transition[i] = DFA.unpackEncodedString(DFA12_transitionS[i]);
        }
    }

    class DFA12 extends DFA {

        public DFA12(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 12;
            this.eot = DFA12_eot;
            this.eof = DFA12_eof;
            this.min = DFA12_min;
            this.max = DFA12_max;
            this.accept = DFA12_accept;
            this.special = DFA12_special;
            this.transition = DFA12_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( Colon | Comma | LBrace | RBrace | LBracket | RBracket | WhiteSpace | String | Integer | Double | Boolean | Date | Null | Name );";
        }
    }
 

}