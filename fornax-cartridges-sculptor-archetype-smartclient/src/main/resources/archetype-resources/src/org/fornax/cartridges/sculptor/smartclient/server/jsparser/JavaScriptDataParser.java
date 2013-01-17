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
// $ANTLR 3.1.2 JavaScriptData.g 2009-08-13 13:00:21

package org.fornax.cartridges.sculptor.smartclient.server.jsparser;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;


import org.antlr.runtime.tree.*;

/**
 * Simplified JavaScript parser
 * 
 * @author Ing. Pavel Tavoda
 */
public class JavaScriptDataParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "OBJECT", "ELEMENT", "ARRAY", "STRING", "INTEGER", "DOUBLE", "BOOLEAN", "DATE", "NULL", "Colon", "Comma", "LBrace", "RBrace", "LBracket", "RBracket", "Dot", "Digit", "HexDigit", "UnicodeChar", "EscapeSequence", "StringChar", "BeginNameChar", "OtherNameChar", "Frac", "Exp", "WhiteSpace", "String", "Integer", "Double", "Boolean", "Date", "Null", "Name"
    };
    public static final int Double=32;
    public static final int INTEGER=8;
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
    public static final int Name=36;
    public static final int ELEMENT=5;
    public static final int Dot=19;
    public static final int DOUBLE=9;
    public static final int StringChar=24;
    public static final int WhiteSpace=29;
    public static final int String=30;
    public static final int LBracket=17;
    public static final int DATE=11;
    public static final int Comma=14;
    public static final int EscapeSequence=23;
    public static final int Integer=31;
    public static final int ARRAY=6;
    public static final int Null=35;
    public static final int STRING=7;
    public static final int RBrace=16;
    public static final int BeginNameChar=25;

    // delegates
    // delegators


        public JavaScriptDataParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public JavaScriptDataParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return JavaScriptDataParser.tokenNames; }
    public String getGrammarFileName() { return "JavaScriptData.g"; }


    	public static void main(String arg[]) {
    		testParser();
    	}

    	public void displayRecognitionError(String[] tokenNames, RecognitionException e) {
    		super.displayRecognitionError(tokenNames, e);
    		throw new RuntimeException(e);
    	}

    	private static final String[] testSamples=new String[] {
    		"{stringVal: \"string\", emptyString: \"\", nullValue: null, intValue: 132132, doubleValue: 123.23, "
    			+"doubleValue2: 132.132e5, doubleValue3: 132.133e-4}"
    		,"{subObject: {subObjStr: \"strVal\", subSubObj: {SubSubString:\"strVal\"}}}"
    		,"{arrayVal: [\"aldsfkj\", 203948, 234.234, 234.23e3, 1212.0e-4]}"
    		,"{combinedVal: {subObj: [ {subObjInArray1: 999, subObjInArray2 : \"2343434\"}, {} , \"skldfj\"]}}"
    		,"{dates: {dates: [ new Date(123123123) , new Date(123123123)], dd: new Date(123123123)}}"
    		,"{address:\"Hore Kopcom 12\",key:\"2dc76aea-4bef-4da9-a8cf-a792e2d5db3b\",id:4,state:\"SK\",number:3204923,currency:1,hibernateLazyInitializer:{},uuid:\"2dc76aea-4bef-4da9-a8cf-a792e2d5db3b\",city:\"Naj\",zip:\"12323\",accountName:\"ADV001XXXX\",bankcode:2020,iban:\"2340920934820498\",bankname:\"QABANK\",swift:\"20349823049/sadkfkj\"}"
    		,"{\"id\":null,\"xxx\":[]}"
    		// Testing some errors
    		,"{unquotedString: sdf, 'wrongFieldName': 20394}"
    		,"{skldfj, 234098 {"
    		,"{\"skldfj\": {\"xx\":234098}}"
    		,"{ccccccxabc: \"xx\"}}"
    		,"{array: [\n {\n name:\"name\", \n width:null \n }\n ]}"
    		,"{array: [{name:\"aggregate\" , type:\"boolean\" , title:\"Aggregate\" , required:true} , {name:\"kind\" , type:\"integer\" , width:"
    		+"\"*\" , icon:\"link.png\" , title:\"Kind\" , required:true , propertiesOnly:true , optionDataSource:\"territoryKindService\" , pickListWidth"
    		+":550 , displayField:\"textRef\" , valueField:\"id\" , pickListFields: [{name: \"level\"}] , startRow:true , endRow:true"
    		+" , colSpan:4 , align:\"left\" , editorType:\"ComboBox"
    		+"Item\"} , {name:\"name\" , type:\"text\" , title:\"Name\" , required:true , length:30} , {name:\"parent\" , type:\"integer\" , width:\"*\" , icon"
    		+":\"link.png\" , title:\"Parent\" , detail:true , propertiesOnly:true , optionDataSource:\"territoryService\" , pickListWidth:550 , display"
    		+"Field:\"textRef\" , valueField:\"id\" , pickListFields: [{name: \"aggregate\"}, {name: \"kind\"}] , foreignKey:\"id\" , sta"
    		+"rtRow:true , endRow:true , colSpan:4 , align:\"left"
    		+"\" , editorType:\"ComboBoxItem\"} , {name:\"relativeSize\" , type:\"integer\" , title:\"Relative Size\" , required:true , textAlign:\"right\"} "
    		+", {name:\"id\" , type:\"integer\" , title:\"Id\" , primaryKey:true , detail:true , canEdit:false , startRow:true} , {name:\"createdBy\" , ty"
    		+"pe:\"text\" , title:\"Created By\" , detail:true , canEdit:false , length:30} , {name:\"createdDate\" , type:\"date\" , title:\"Created Date\""
    		+" , detail:true , canEdit:false , displayFormat:\"toEuropeanShortDateTime\"} , {name:\"lastUpdated\" , type:\"date\" , title:\"Last Updated\""
    		+" , detail:true , canEdit:false , displayFormat:\"toEuropeanShortDateTime\"} , {name:\"lastUpdatedBy\" , type:\"text\" , title:\"Last Update"
    		+"d By\" , detail:true , canEdit:false , length:30} , {name:\"version\" , type:\"integer\" , title:\"Version\" , detail:true , canEdit:false "
    		+", textAlign:\"left\"} , {name:\"textRef\" , type:\"text\" , hidden:true , canEdit:false}]}"
    	};

    	public static void testParser() {
    		for (String testStr : testSamples) {
    			System.out.println("----------------------------------------------------------------------");
    			System.out.println("Parsing: '"+testStr+"'");
    			try {
    				CommonTree parseResult=parseString(testStr);
    				recursivePrint("  ", parseResult);
    			} catch (Exception e) {
    				e.printStackTrace();
    			}
    		}
    	}

    	public static CommonTree parseString(String jsData) throws RecognitionException {
    		CharStream dataStream = new ANTLRStringStream(jsData);
    		JavaScriptDataLexer dataLexer = new JavaScriptDataLexer(dataStream);

    		CommonTokenStream tokens = new CommonTokenStream(dataLexer);
    		JavaScriptDataParser parser = new JavaScriptDataParser(tokens);
    		jsonObject_return jsonObject = parser.jsonObject();

    		return (CommonTree) jsonObject.getTree();
    	}

    	public static void recursivePrint(String prefix, CommonTree ast) {
    		if (ast == null || ast.getChildren() == null) return;
    		for (Object tokenName : ast.getChildren()) {
    			CommonTree ct=(CommonTree) tokenName;
    			System.out.println(prefix+"TokenName="+ct.getText());
    			recursivePrint(prefix+"  ", ct);
    		}
    	}


    public static class jsonObject_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "jsonObject"
    // JavaScriptData.g:149:1: jsonObject : object ;
    public final JavaScriptDataParser.jsonObject_return jsonObject() throws RecognitionException {
        JavaScriptDataParser.jsonObject_return retval = new JavaScriptDataParser.jsonObject_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        JavaScriptDataParser.object_return object1 = null;



        try {
            // JavaScriptData.g:150:2: ( object )
            // JavaScriptData.g:150:4: object
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_object_in_jsonObject468);
            object1=object();

            state._fsp--;

            adaptor.addChild(root_0, object1.getTree());

            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "jsonObject"

    public static class jsonArray_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "jsonArray"
    // JavaScriptData.g:153:1: jsonArray : array ;
    public final JavaScriptDataParser.jsonArray_return jsonArray() throws RecognitionException {
        JavaScriptDataParser.jsonArray_return retval = new JavaScriptDataParser.jsonArray_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        JavaScriptDataParser.array_return array2 = null;



        try {
            // JavaScriptData.g:154:2: ( array )
            // JavaScriptData.g:154:4: array
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_array_in_jsonArray480);
            array2=array();

            state._fsp--;

            adaptor.addChild(root_0, array2.getTree());

            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "jsonArray"

    public static class object_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "object"
    // JavaScriptData.g:158:1: object : LBrace ( objectElement ( Comma objectElement )* )? RBrace -> ^( OBJECT ( objectElement )* ) ;
    public final JavaScriptDataParser.object_return object() throws RecognitionException {
        JavaScriptDataParser.object_return retval = new JavaScriptDataParser.object_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token LBrace3=null;
        Token Comma5=null;
        Token RBrace7=null;
        JavaScriptDataParser.objectElement_return objectElement4 = null;

        JavaScriptDataParser.objectElement_return objectElement6 = null;


        Object LBrace3_tree=null;
        Object Comma5_tree=null;
        Object RBrace7_tree=null;
        RewriteRuleTokenStream stream_LBrace=new RewriteRuleTokenStream(adaptor,"token LBrace");
        RewriteRuleTokenStream stream_Comma=new RewriteRuleTokenStream(adaptor,"token Comma");
        RewriteRuleTokenStream stream_RBrace=new RewriteRuleTokenStream(adaptor,"token RBrace");
        RewriteRuleSubtreeStream stream_objectElement=new RewriteRuleSubtreeStream(adaptor,"rule objectElement");
        try {
            // JavaScriptData.g:159:2: ( LBrace ( objectElement ( Comma objectElement )* )? RBrace -> ^( OBJECT ( objectElement )* ) )
            // JavaScriptData.g:159:4: LBrace ( objectElement ( Comma objectElement )* )? RBrace
            {
            LBrace3=(Token)match(input,LBrace,FOLLOW_LBrace_in_object493);  
            stream_LBrace.add(LBrace3);

            // JavaScriptData.g:159:11: ( objectElement ( Comma objectElement )* )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==String||LA2_0==Name) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // JavaScriptData.g:159:12: objectElement ( Comma objectElement )*
                    {
                    pushFollow(FOLLOW_objectElement_in_object496);
                    objectElement4=objectElement();

                    state._fsp--;

                    stream_objectElement.add(objectElement4.getTree());
                    // JavaScriptData.g:159:26: ( Comma objectElement )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==Comma) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // JavaScriptData.g:159:27: Comma objectElement
                    	    {
                    	    Comma5=(Token)match(input,Comma,FOLLOW_Comma_in_object499);  
                    	    stream_Comma.add(Comma5);

                    	    pushFollow(FOLLOW_objectElement_in_object501);
                    	    objectElement6=objectElement();

                    	    state._fsp--;

                    	    stream_objectElement.add(objectElement6.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop1;
                        }
                    } while (true);


                    }
                    break;

            }

            RBrace7=(Token)match(input,RBrace,FOLLOW_RBrace_in_object507);  
            stream_RBrace.add(RBrace7);



            // AST REWRITE
            // elements: objectElement
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 160:4: -> ^( OBJECT ( objectElement )* )
            {
                // JavaScriptData.g:160:7: ^( OBJECT ( objectElement )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(OBJECT, "OBJECT"), root_1);

                // JavaScriptData.g:160:16: ( objectElement )*
                while ( stream_objectElement.hasNext() ) {
                    adaptor.addChild(root_1, stream_objectElement.nextTree());

                }
                stream_objectElement.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "object"

    public static class objectElement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "objectElement"
    // JavaScriptData.g:163:1: objectElement : attribute Colon value -> ^( ELEMENT attribute value ) ;
    public final JavaScriptDataParser.objectElement_return objectElement() throws RecognitionException {
        JavaScriptDataParser.objectElement_return retval = new JavaScriptDataParser.objectElement_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token Colon9=null;
        JavaScriptDataParser.attribute_return attribute8 = null;

        JavaScriptDataParser.value_return value10 = null;


        Object Colon9_tree=null;
        RewriteRuleTokenStream stream_Colon=new RewriteRuleTokenStream(adaptor,"token Colon");
        RewriteRuleSubtreeStream stream_value=new RewriteRuleSubtreeStream(adaptor,"rule value");
        RewriteRuleSubtreeStream stream_attribute=new RewriteRuleSubtreeStream(adaptor,"rule attribute");
        try {
            // JavaScriptData.g:164:2: ( attribute Colon value -> ^( ELEMENT attribute value ) )
            // JavaScriptData.g:164:4: attribute Colon value
            {
            pushFollow(FOLLOW_attribute_in_objectElement531);
            attribute8=attribute();

            state._fsp--;

            stream_attribute.add(attribute8.getTree());
            Colon9=(Token)match(input,Colon,FOLLOW_Colon_in_objectElement533);  
            stream_Colon.add(Colon9);

            pushFollow(FOLLOW_value_in_objectElement535);
            value10=value();

            state._fsp--;

            stream_value.add(value10.getTree());


            // AST REWRITE
            // elements: attribute, value
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 165:4: -> ^( ELEMENT attribute value )
            {
                // JavaScriptData.g:165:7: ^( ELEMENT attribute value )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ELEMENT, "ELEMENT"), root_1);

                adaptor.addChild(root_1, stream_attribute.nextTree());
                adaptor.addChild(root_1, stream_value.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "objectElement"

    public static class attribute_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "attribute"
    // JavaScriptData.g:168:1: attribute : ( String | Name );
    public final JavaScriptDataParser.attribute_return attribute() throws RecognitionException {
        JavaScriptDataParser.attribute_return retval = new JavaScriptDataParser.attribute_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set11=null;

        Object set11_tree=null;

        try {
            // JavaScriptData.g:169:2: ( String | Name )
            // JavaScriptData.g:
            {
            root_0 = (Object)adaptor.nil();

            set11=(Token)input.LT(1);
            if ( input.LA(1)==String||input.LA(1)==Name ) {
                input.consume();
                adaptor.addChild(root_0, (Object)adaptor.create(set11));
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "attribute"

    public static class array_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "array"
    // JavaScriptData.g:171:1: array : LBracket ( value ( Comma value )* )? RBracket -> ^( ARRAY ( value )* ) ;
    public final JavaScriptDataParser.array_return array() throws RecognitionException {
        JavaScriptDataParser.array_return retval = new JavaScriptDataParser.array_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token LBracket12=null;
        Token Comma14=null;
        Token RBracket16=null;
        JavaScriptDataParser.value_return value13 = null;

        JavaScriptDataParser.value_return value15 = null;


        Object LBracket12_tree=null;
        Object Comma14_tree=null;
        Object RBracket16_tree=null;
        RewriteRuleTokenStream stream_RBracket=new RewriteRuleTokenStream(adaptor,"token RBracket");
        RewriteRuleTokenStream stream_LBracket=new RewriteRuleTokenStream(adaptor,"token LBracket");
        RewriteRuleTokenStream stream_Comma=new RewriteRuleTokenStream(adaptor,"token Comma");
        RewriteRuleSubtreeStream stream_value=new RewriteRuleSubtreeStream(adaptor,"rule value");
        try {
            // JavaScriptData.g:172:2: ( LBracket ( value ( Comma value )* )? RBracket -> ^( ARRAY ( value )* ) )
            // JavaScriptData.g:172:4: LBracket ( value ( Comma value )* )? RBracket
            {
            LBracket12=(Token)match(input,LBracket,FOLLOW_LBracket_in_array576);  
            stream_LBracket.add(LBracket12);

            // JavaScriptData.g:172:13: ( value ( Comma value )* )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==LBrace||LA4_0==LBracket||(LA4_0>=String && LA4_0<=Null)) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // JavaScriptData.g:172:14: value ( Comma value )*
                    {
                    pushFollow(FOLLOW_value_in_array579);
                    value13=value();

                    state._fsp--;

                    stream_value.add(value13.getTree());
                    // JavaScriptData.g:172:20: ( Comma value )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0==Comma) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // JavaScriptData.g:172:21: Comma value
                    	    {
                    	    Comma14=(Token)match(input,Comma,FOLLOW_Comma_in_array582);  
                    	    stream_Comma.add(Comma14);

                    	    pushFollow(FOLLOW_value_in_array584);
                    	    value15=value();

                    	    state._fsp--;

                    	    stream_value.add(value15.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop3;
                        }
                    } while (true);


                    }
                    break;

            }

            RBracket16=(Token)match(input,RBracket,FOLLOW_RBracket_in_array590);  
            stream_RBracket.add(RBracket16);



            // AST REWRITE
            // elements: value
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 173:4: -> ^( ARRAY ( value )* )
            {
                // JavaScriptData.g:173:7: ^( ARRAY ( value )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ARRAY, "ARRAY"), root_1);

                // JavaScriptData.g:173:15: ( value )*
                while ( stream_value.hasNext() ) {
                    adaptor.addChild(root_1, stream_value.nextTree());

                }
                stream_value.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "array"

    public static class value_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "value"
    // JavaScriptData.g:177:1: value : ( String -> ^( STRING String ) | Integer -> ^( INTEGER Integer ) | Double -> ^( DOUBLE Double ) | Boolean -> ^( BOOLEAN Boolean ) | Date -> ^( DATE Date ) | Null -> ^( NULL ) | object | array );
    public final JavaScriptDataParser.value_return value() throws RecognitionException {
        JavaScriptDataParser.value_return retval = new JavaScriptDataParser.value_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token String17=null;
        Token Integer18=null;
        Token Double19=null;
        Token Boolean20=null;
        Token Date21=null;
        Token Null22=null;
        JavaScriptDataParser.object_return object23 = null;

        JavaScriptDataParser.array_return array24 = null;


        Object String17_tree=null;
        Object Integer18_tree=null;
        Object Double19_tree=null;
        Object Boolean20_tree=null;
        Object Date21_tree=null;
        Object Null22_tree=null;
        RewriteRuleTokenStream stream_Double=new RewriteRuleTokenStream(adaptor,"token Double");
        RewriteRuleTokenStream stream_Date=new RewriteRuleTokenStream(adaptor,"token Date");
        RewriteRuleTokenStream stream_String=new RewriteRuleTokenStream(adaptor,"token String");
        RewriteRuleTokenStream stream_Boolean=new RewriteRuleTokenStream(adaptor,"token Boolean");
        RewriteRuleTokenStream stream_Integer=new RewriteRuleTokenStream(adaptor,"token Integer");
        RewriteRuleTokenStream stream_Null=new RewriteRuleTokenStream(adaptor,"token Null");

        try {
            // JavaScriptData.g:178:2: ( String -> ^( STRING String ) | Integer -> ^( INTEGER Integer ) | Double -> ^( DOUBLE Double ) | Boolean -> ^( BOOLEAN Boolean ) | Date -> ^( DATE Date ) | Null -> ^( NULL ) | object | array )
            int alt5=8;
            switch ( input.LA(1) ) {
            case String:
                {
                alt5=1;
                }
                break;
            case Integer:
                {
                alt5=2;
                }
                break;
            case Double:
                {
                alt5=3;
                }
                break;
            case Boolean:
                {
                alt5=4;
                }
                break;
            case Date:
                {
                alt5=5;
                }
                break;
            case Null:
                {
                alt5=6;
                }
                break;
            case LBrace:
                {
                alt5=7;
                }
                break;
            case LBracket:
                {
                alt5=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // JavaScriptData.g:178:4: String
                    {
                    String17=(Token)match(input,String,FOLLOW_String_in_value615);  
                    stream_String.add(String17);



                    // AST REWRITE
                    // elements: String
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 178:11: -> ^( STRING String )
                    {
                        // JavaScriptData.g:178:14: ^( STRING String )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(STRING, "STRING"), root_1);

                        adaptor.addChild(root_1, stream_String.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 2 :
                    // JavaScriptData.g:179:4: Integer
                    {
                    Integer18=(Token)match(input,Integer,FOLLOW_Integer_in_value628);  
                    stream_Integer.add(Integer18);



                    // AST REWRITE
                    // elements: Integer
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 179:12: -> ^( INTEGER Integer )
                    {
                        // JavaScriptData.g:179:15: ^( INTEGER Integer )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(INTEGER, "INTEGER"), root_1);

                        adaptor.addChild(root_1, stream_Integer.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 3 :
                    // JavaScriptData.g:180:4: Double
                    {
                    Double19=(Token)match(input,Double,FOLLOW_Double_in_value641);  
                    stream_Double.add(Double19);



                    // AST REWRITE
                    // elements: Double
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 180:11: -> ^( DOUBLE Double )
                    {
                        // JavaScriptData.g:180:14: ^( DOUBLE Double )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(DOUBLE, "DOUBLE"), root_1);

                        adaptor.addChild(root_1, stream_Double.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 4 :
                    // JavaScriptData.g:181:4: Boolean
                    {
                    Boolean20=(Token)match(input,Boolean,FOLLOW_Boolean_in_value654);  
                    stream_Boolean.add(Boolean20);



                    // AST REWRITE
                    // elements: Boolean
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 181:12: -> ^( BOOLEAN Boolean )
                    {
                        // JavaScriptData.g:181:15: ^( BOOLEAN Boolean )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(BOOLEAN, "BOOLEAN"), root_1);

                        adaptor.addChild(root_1, stream_Boolean.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 5 :
                    // JavaScriptData.g:182:4: Date
                    {
                    Date21=(Token)match(input,Date,FOLLOW_Date_in_value667);  
                    stream_Date.add(Date21);



                    // AST REWRITE
                    // elements: Date
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 182:9: -> ^( DATE Date )
                    {
                        // JavaScriptData.g:182:12: ^( DATE Date )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(DATE, "DATE"), root_1);

                        adaptor.addChild(root_1, stream_Date.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 6 :
                    // JavaScriptData.g:183:4: Null
                    {
                    Null22=(Token)match(input,Null,FOLLOW_Null_in_value680);  
                    stream_Null.add(Null22);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 183:9: -> ^( NULL )
                    {
                        // JavaScriptData.g:183:12: ^( NULL )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(NULL, "NULL"), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;
                    }
                    break;
                case 7 :
                    // JavaScriptData.g:184:4: object
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_object_in_value691);
                    object23=object();

                    state._fsp--;

                    adaptor.addChild(root_0, object23.getTree());

                    }
                    break;
                case 8 :
                    // JavaScriptData.g:185:4: array
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_array_in_value698);
                    array24=array();

                    state._fsp--;

                    adaptor.addChild(root_0, array24.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "value"

    // Delegated rules


 

    public static final BitSet FOLLOW_object_in_jsonObject468 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_array_in_jsonArray480 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBrace_in_object493 = new BitSet(new long[]{0x0000001040010000L});
    public static final BitSet FOLLOW_objectElement_in_object496 = new BitSet(new long[]{0x0000000000014000L});
    public static final BitSet FOLLOW_Comma_in_object499 = new BitSet(new long[]{0x0000001040000000L});
    public static final BitSet FOLLOW_objectElement_in_object501 = new BitSet(new long[]{0x0000000000014000L});
    public static final BitSet FOLLOW_RBrace_in_object507 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_attribute_in_objectElement531 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_Colon_in_objectElement533 = new BitSet(new long[]{0x0000000FC0028000L});
    public static final BitSet FOLLOW_value_in_objectElement535 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_attribute0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBracket_in_array576 = new BitSet(new long[]{0x0000000FC0068000L});
    public static final BitSet FOLLOW_value_in_array579 = new BitSet(new long[]{0x0000000000044000L});
    public static final BitSet FOLLOW_Comma_in_array582 = new BitSet(new long[]{0x0000000FC0028000L});
    public static final BitSet FOLLOW_value_in_array584 = new BitSet(new long[]{0x0000000000044000L});
    public static final BitSet FOLLOW_RBracket_in_array590 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_String_in_value615 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Integer_in_value628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Double_in_value641 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Boolean_in_value654 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Date_in_value667 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Null_in_value680 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_object_in_value691 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_array_in_value698 = new BitSet(new long[]{0x0000000000000002L});

}