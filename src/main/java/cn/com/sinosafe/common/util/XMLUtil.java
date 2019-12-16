package cn.com.sinosafe.common.util;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.xml.serialize.OutputFormat;
import org.apache.xml.serialize.XMLSerializer;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.tree.DefaultAttribute;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;


public class XmlUtil
{

    /**
     * @Description
     * @Date 2019/9/2 17:06
     * @param obj 消息体
     * @param fragment 是否省略xm头声明信息
     * @return java.lang.String
     */
    public static String convertToXml(Object obj,boolean fragment) {
        try {
            StringWriter sw = new StringWriter();
            JAXBContext context = JAXBContext.newInstance(obj.getClass());
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            m.setProperty(Marshaller.JAXB_FRAGMENT, fragment);// 是否省略xm头声明信息
            m.marshal(obj, sw);
            String xml = sw.toString().replace("standalone=\"yes\"", "");
        //    xml = xml.replaceAll("&amp;", "&");
            return xml;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


    public static String toXML(Object obj)
    {
        try
        {
            JAXBContext context = JAXBContext.newInstance(new Class[] { obj.getClass() });

            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty("jaxb.encoding", "UTF-8");
            marshaller.setProperty("jaxb.formatted.output", Boolean.valueOf(true));
            marshaller.setProperty("jaxb.fragment", Boolean.valueOf(false));
            StringWriter writer = new StringWriter();
            marshaller.marshal(obj, writer);
            return writer.toString();
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }

    public static Map<?, ?> xmlToMap(String xml)
            throws DocumentException
    {
        Document document = DocumentHelper.parseText(xml);
        return domToMap(document);
    }

    public static Map<String, Object> domToMap(Document doc)
    {
        Map<String, Object> map = new HashMap();
        if (doc == null) {
            return map;
        }
        Element root = doc.getRootElement();
        List list = root.elements();
        if (list.size() > 0) {
            map.put(root.getName(), Dom2Map(root));
        } else {
            map.put(root.getName(), root.getText());
        }
        return map;
    }

    public static Map Dom2Map(Element e)
    {
        Map map = new HashMap();
        List list = e.elements();
        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++)
            {
                Element iter = (Element)list.get(i);
                List mapList = new ArrayList();
                if (iter.elements().size() > 0)
                {
                    Map m = Dom2Map(iter);
                    if (map.get(iter.getName()) != null)
                    {
                        Object obj = map.get(iter.getName());
                        if (!obj.getClass().getName().equals("java.util.ArrayList"))
                        {
                            mapList = new ArrayList();
                            mapList.add(obj);
                            mapList.add(m);
                        }
                        if (obj.getClass().getName().equals("java.util.ArrayList"))
                        {
                            mapList = (List)obj;
                            mapList.add(m);
                        }
                        map.put(iter.getName(), mapList);
                    }
                    else
                    {
                        map.put(iter.getName(), m);
                    }
                }
                else if (map.get(iter.getName()) != null)
                {
                    Object obj = map.get(iter.getName());
                    if (!obj.getClass().getName().equals("java.util.ArrayList"))
                    {
                        mapList = new ArrayList();
                        mapList.add(obj);
                        mapList.add(iter.getText());
                    }
                    if (obj.getClass().getName().equals("java.util.ArrayList"))
                    {
                        mapList = (List)obj;
                        mapList.add(iter.getText());
                    }
                    map.put(iter.getName(), mapList);
                }
                else
                {
                    map.put(iter.getName(), iter.getText());
                }
            }
        } else {
            map.put(e.getName(), e.getText());
        }
        return map;
    }

    public static Map xml2mapWithAttr(String xmlStr, boolean needRootKey)
            throws DocumentException
    {
        Document doc = DocumentHelper.parseText(xmlStr);
        Element root = doc.getRootElement();
        Map<String, Object> map = xml2mapWithAttr(root);
        if ((root.elements().size() == 0) && (root.attributes().size() == 0)) {
            return map;
        }
        if (needRootKey)
        {
            Map<String, Object> rootMap = new HashMap();
            rootMap.put(root.getName(), map);
            return rootMap;
        }
        return map;
    }

    private static Map xml2mapWithAttr(Element element)
    {
        Map<String, Object> map = new LinkedHashMap();

        List<Element> list = element.elements();
        List<Attribute> listAttr0 = element.attributes();
        for (Attribute attr : listAttr0) {
            map.put("@" + attr.getName(), attr.getValue());
        }
        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++)
            {
                Element iter = (Element)list.get(i);
                List mapList = new ArrayList();
                if (iter.elements().size() > 0)
                {
                    Map m = xml2mapWithAttr(iter);
                    if (map.get(iter.getName()) != null)
                    {
                        Object obj = map.get(iter.getName());
                        if (!(obj instanceof List))
                        {
                            mapList = new ArrayList();
                            mapList.add(obj);
                            mapList.add(m);
                        }
                        if ((obj instanceof List))
                        {
                            mapList = (List)obj;
                            mapList.add(m);
                        }
                        map.put(iter.getName(), mapList);
                    }
                    else
                    {
                        map.put(iter.getName(), m);
                    }
                }
                else
                {
                    List<Attribute> listAttr = iter.attributes();
                    Map<String, Object> attrMap = null;
                    boolean hasAttributes = false;
                    if (listAttr.size() > 0)
                    {
                        hasAttributes = true;
                        attrMap = new LinkedHashMap();
                        for (Attribute attr : listAttr) {
                            attrMap.put("@" + attr.getName(), attr.getValue());
                        }
                    }
                    if (map.get(iter.getName()) != null)
                    {
                        Object obj = map.get(iter.getName());
                        if (!(obj instanceof List))
                        {
                            mapList = new ArrayList();
                            mapList.add(obj);
                            if (hasAttributes)
                            {
                                attrMap.put("#text", iter.getText());
                                mapList.add(attrMap);
                            }
                            else
                            {
                                mapList.add(iter.getText());
                            }
                        }
                        if ((obj instanceof List))
                        {
                            mapList = (List)obj;
                            if (hasAttributes)
                            {
                                attrMap.put("#text", iter.getText());
                                mapList.add(attrMap);
                            }
                            else
                            {
                                mapList.add(iter.getText());
                            }
                        }
                        map.put(iter.getName(), mapList);
                    }
                    else if (hasAttributes)
                    {
                        attrMap.put("#text", iter.getText());
                        map.put(iter.getName(), attrMap);
                    }
                    else
                    {
                        map.put(iter.getName(), iter.getText());
                    }
                }
            }
        } else if (listAttr0.size() > 0) {
            map.put("#text", element.getText());
        } else {
            map.put(element.getName(), element.getText());
        }
        return map;
    }


    /**
     * @Description 递归遍历节点获取数据
     * @Date 2019/9/12 17:22
     * @param xmlString
     * @return java.lang.String
     */
    public static String getXmlValue(String xmlString) {
        StringBuffer result = new StringBuffer();
        int i = 1;
        try {
            //获取根节点
            Document document = DocumentHelper.parseText(xmlString);
            Element root = document.getRootElement();
            //遍历根节点
            getString(result, root,i);
            return result.toString();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    private static void getString(StringBuffer result, Element root, int i) {
        for (Iterator<Element> rootlter = root.elementIterator(); rootlter.hasNext(); ) {
            if (i >= 6){
                break;
            }
            Element student = rootlter.next();
            boolean textOnly = student.isTextOnly();
            if (textOnly) {
                result.append(student.getTextTrim());
            }else {
               getString(result,student,i++);
            }
        }
    }

    public static Object xml2Object(String xmlStr, Class<?> clazz){
        Object xmlObject = null;
        try {
            JAXBContext context = JAXBContext.newInstance(clazz);
            // 进行将Xml转成对象的核心接口
            Unmarshaller unmarshaller = context.createUnmarshaller();
            StringReader sr = new StringReader(xmlStr);
            xmlObject = unmarshaller.unmarshal(sr);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return xmlObject;
    }
    
    public static String parseDOMSource(DOMSource domsource) {
        try {
                StringWriter writer = new StringWriter();
                StreamResult result = new StreamResult(writer);
                TransformerFactory tf = TransformerFactory.newInstance();
                Transformer transformer = tf.newTransformer();
                transformer.transform(domsource, result);
                return writer.toString();
            }catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return null;
        }
    
    public static Element str2Dom(String xmlString) throws DocumentException{
        Document document = DocumentHelper.parseText(xmlString);
        return document.getRootElement();
    }
    
    public static boolean haveChi(Document dom) throws DocumentException{
    	Element root = dom.getRootElement();
    	List elements = root.elements(); 
    	if(elements.isEmpty()){
    		return false;
    	}
		return true;
    }
    
    
  /**  
   * 递归遍历方法  
   * <功能详细描述> 
   * @param element 
   * @see [类、类#方法、类#成员] 
   */  
  public static void getElementList(Element element, List<Leaf> elemList){  
      List elements = element.elements();  
      // 没有子元素   
      if (elements.isEmpty())  
      {  
    	  String name = element.getName();
          String xpath = element.getPath();  
          String value = element.getText();
        //  value = value.replaceAll("\r\n","\n");
          elemList.add(new Leaf(name, xpath, value));  
      }  
      else  
      {  
          // 有子元素  
          Iterator it = elements.iterator();  
          while (it.hasNext())  
          {  
              Element elem = (Element)it.next();  
              // 递归遍历   
              getElementList(elem,elemList);  
          }  
      }  
  }
  
  /**  
   * 获取节点所有属性值 
   * <功能详细描述> 
   * @param element 
   * @return 
   * @see [类、类#方法、类#成员] 
   */  
  public static String getNoteAttribute(Element element)  
  {  
      String xattribute = "";  
      DefaultAttribute e = null;  
      List list = element.attributes();  
      for (int i = 0; i < list.size(); i++)  
      {  
          e = (DefaultAttribute)list.get(i);  
          xattribute += " [name = " + e.getName() + ", value = " + e.getText() + "]";  
      }  
      return xattribute;  
  }  
  
  public static String format(String unformattedXml) {
      try {
          final org.w3c.dom.Document document = parseXmlFile(unformattedXml);
          OutputFormat format = new OutputFormat(document);
          format.setLineWidth(65);
          format.setIndenting(true);
          format.setIndent(2);
          Writer out = new StringWriter();
          XMLSerializer serializer = new XMLSerializer(out, format);
          serializer.serialize(document);
          return out.toString();
      } catch (IOException e) {
          throw new RuntimeException(e);
      }
  }

  private static  org.w3c.dom.Document parseXmlFile(String in) {
      try {
          DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
          DocumentBuilder db = dbf.newDocumentBuilder();
          InputSource is = new InputSource(new StringReader(in));
          return db.parse(is);
      } catch (ParserConfigurationException e) {
          throw new RuntimeException(e);
      } catch (SAXException e) {
          throw new RuntimeException(e);
      } catch (IOException e) {
          throw new RuntimeException(e);
      }
  }

}
