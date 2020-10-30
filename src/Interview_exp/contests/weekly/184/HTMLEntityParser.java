/*
LC1410: HTML Entity Parser
HTML entity parser is the parser that
takes HTML code as input and replace all
the entities of the special characters by the characters itself.
The special characters and their entities for HTML are:

Quotation Mark: the entity is &quot; and symbol character is ".
Single Quote Mark: the entity is &apos; and symbol character is '.
Ampersand: the entity is &amp; and symbol character is &.
Greater Than Sign: the entity is &gt; and symbol character is >.
Less Than Sign: the entity is &lt; and symbol character is <.
Slash: the entity is &frasl; and symbol character is /.
Given the input text string to the HTML parser, you have to implement the entity parser.

Return the text after replacing the entities by the special characters*/
class Sln{
    public String entityParser(String text) {
        if(text==null||text.length==0)
            return "";
        Map<String,String> map;
        map.put("&quot;","\"");
        map.put("&amp;", "&");
        map.put("&gt;", ">");
        map.put("&lt;", "<");
        map.put("&frasl;", "/");
        for(String key:map.keySet()){
            text=text.replaceAll(key,map.get(key));
        }
        return text;
    }
}