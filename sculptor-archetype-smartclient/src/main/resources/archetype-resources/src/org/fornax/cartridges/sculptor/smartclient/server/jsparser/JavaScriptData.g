// -------------------------------------------------------------------------
// JavaScript data parser
// Author: Pavel Tavoda
// Copyright F4S
// -------------------------------------------------------------------------
grammar JavaScriptData;

options {
	language=Java;
	output=AST;
}

tokens {
	OBJECT;
	ELEMENT;
	ARRAY;
	STRING;
	INTEGER;
	DOUBLE;
	BOOLEAN;
	DATE;
	NULL;
}

@header {
package org.fornax.cartridges.sculptor.smartclient.server.jsparser;
}

@lexer::header {
package org.fornax.cartridges.sculptor.smartclient.server.jsparser;
}

@members {
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
}

// -------------------------------------------------------------------------
// Lexer
// -------------------------------------------------------------------------
Colon: ':';
Comma: ',';
LBrace: '{';
RBrace: '}';
LBracket: '[';
RBracket: ']';
fragment Dot: '.';

fragment Digit: '0' .. '9';
fragment HexDigit: ('0' .. '9' | 'A' .. 'F' | 'a' .. 'f');
fragment UnicodeChar: ~('"'| '\\');
fragment StringChar :  UnicodeChar | EscapeSequence;

fragment BeginNameChar: ('A' .. 'Z' | 'a' .. 'z' | '_');
fragment OtherNameChar: ('0' .. '9' | 'A' .. 'Z' | 'a' .. 'z' | '_');

fragment EscapeSequence
	: '\\' ('\"' | '\\' | '/' | 'b' | 'f' | 'n' | 'r' | 't' | 'u' HexDigit HexDigit HexDigit HexDigit)
	;

fragment Frac: Dot Digit+;
fragment Exp: ('e' | 'E') ('+' | '-')? Digit+;

WhiteSpace: (' ' | '\r' | '\t' | '\u000C' | '\n') { $channel=HIDDEN; };

String: '"' StringChar* '"';
Integer: Digit+;
Double:  Digit+ Frac Exp?;
Boolean: 'true' | 'false';
Date: 'new Date(' Integer ')';
Null: 'null';
Name: BeginNameChar OtherNameChar+;


// -------------------------------------------------------------------------
// Parser
// -------------------------------------------------------------------------
jsonObject
	: object
	;
	
jsonArray
	: array
	;	


object
	: LBrace (objectElement (Comma objectElement)*)? RBrace
	  -> ^(OBJECT objectElement*)
	;
	
objectElement
	: attribute Colon value
	  -> ^(ELEMENT attribute value)
	;	
	
attribute
	: String | Name
	;	
array
	: LBracket (value (Comma value)*)? RBracket
	  -> ^(ARRAY value*)
	;

	
value
	: String -> ^(STRING String)
	| Integer -> ^(INTEGER Integer)
	| Double -> ^(DOUBLE Double)
	| Boolean -> ^(BOOLEAN Boolean)
	| Date -> ^(DATE Date)
	| Null -> ^(NULL)
	| object  
	| array  
	;
