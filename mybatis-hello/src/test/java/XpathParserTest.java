import org.apache.ibatis.io.Resources;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

/*
xpath常用表达式：
nodename 表示选取此节点的所有子节点
// 表示从当前节点选取直接子节点
/ 表示从当前节点选取子孙节点
. 表示选取当前节点
.. 表示选取当前节点的父节点
@ 表示选取属性
* 表示通配符，选择所有元素节点与元素名
@* 表示选取所有属性
[@attrib] 表示选取具有给定属性的所有元素
[@attrib='value'] 表示选取给定属性具有给定值的所有元素
[tag] 表示选取所有具有指定元素的直接子节点
[tag='text'] 表示选取所有具有指定元素并且文本内容是text节点
@xx 获取属性，如@href,@src,@title
text() 获取文本内容
comment() 获取注释
 */
public class XpathParserTest {

    /*
    查找作者为Neal Stephenson所有书籍的标题
     */
    public static void main(String[] args) throws Exception {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = builderFactory.newDocumentBuilder();
        Document xmlDocument = builder.parse(Resources.getResourceAsStream("inventory.xml"));
        XPath xPath = XPathFactory.newInstance().newXPath();
        String expression = "//book[author=\"Neal Stephenson\"]/title/text()";
        Object evaluate = xPath.compile(expression).evaluate(xmlDocument, XPathConstants.STRING);
        System.out.println(evaluate);
    }
}
