'''
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

Return the text after replacing the entities by the special characters
'''
class Solution(object):
    def entityParser(self, text):
        translations = {
            '&quot;': '"',
            '&apos;': "'",
            '&amp;': '&',
            '&gt;': '>',
            '&lt;': '<',
            '&frasl;': '/',
        }

        ans = []
        i = 0
        while i < len(text):
            for entity in translations:
                if all(text[i+k] == entity[k] for k in range(len(entity))):
                    ans.append(translations[entity])
                    i += len(entity)
                    break
            else:
                ans.append(text[i])
                i += 1
        return "".join(ans)